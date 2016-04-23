package com.chincook.common.login;

import java.security.MessageDigest;
import java.util.Collection;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class LoginProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginProvider.class);
	
	@Autowired
	@Resource(name="cmmUserService")
	private CmmUserService cmmUserService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SaltSource saltSource;
	
	public LoginProvider(){
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String user_id = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserInfo user;
		Collection<? extends Role> authorities = null;
		
		try{
			user = cmmUserService.loadUserByUsername(user_id);
			System.out.println("-----------------salt------------------"+user.getSalt());
			byte[] saltByte = Base64Utils.decodeFromString(user.getSalt());
			String saltStr = new String(saltByte);

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String strNewPassword = user_id + password + saltStr;
			
			byte[] bNewPassword = strNewPassword.getBytes("UTF-8");
			digest.update(bNewPassword);
			
			byte[] bOutput = digest.digest();
			
			String comPassword = Base64Utils.encodeToString(bOutput);
			
//			String hashedPassword = passwordEncoder.encodePassword(user_id+password, saltStr);
			
			
			logger.info("username : " + user_id + " / password : " + password + " / hash password : " + comPassword+" / salt : "+saltStr);
	        logger.info("username : " + user.getUsername() + " / password : " + user.getPassword());
			
			if(!comPassword.equals(user.getPassword())){
				throw new BadCredentialsException("Bad Credential");
			}
			
			authorities = user.getAuthorities();
			
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user_id, password, null);
			token.setDetails(user);
						
			return token;
		}catch(UsernameNotFoundException e){
			logger.info(e.toString());
			throw new UsernameNotFoundException(e.getMessage());
		}catch(BadCredentialsException e){
			logger.info(e.toString());
			throw new BadCredentialsException(e.getMessage());
		}catch(Exception e){
			logger.info(e.toString());
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		if(authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class)){
			return true;
		}
		return false;
	}
	
}
