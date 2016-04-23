package com.chincook.common.login;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class CmmUserService implements UserDetailsService{

	@Autowired
	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Override
	public UserInfo loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginDAO mapper = session.getMapper(LoginDAO.class);
		UserInfo user = mapper.userInfo(username);
		
		if(user == null)
            throw new UsernameNotFoundException("User not found: " + username);
		
		List<? extends Role> roles = mapper.authList(username);
		
		user.setAuth(roles);
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		user.setUser_ip(request.getRemoteHost());
		
		return user;
	}

}
