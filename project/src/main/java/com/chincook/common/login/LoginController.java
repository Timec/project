package com.chincook.common.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	public LoginController(){
	}
	
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
    	logger.info("login");
    	
    	return "/common/login/login";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
    
    @RequestMapping("/login_success")
    public void login_success(HttpSession session){
    	UserInfo user = (UserInfo)SecurityContextHolder.getContext().getAuthentication().getDetails();
    	session.setAttribute("userInfo", user);
    	logger.info("success");
    }
    
    @RequestMapping("/access_denied")
    public String access_denied(HttpSession session){
    	logger.info("access_denied");
    	return "/common/login/login";
    }

    @RequestMapping("/login_duplicate")
    public String login_duplicate(HttpSession session){
    	logger.info("login_duplicate");
    	return "/common/login/login";
    }
}
