package com.core.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.chincook.common.login.UserInfo;
import com.core.common.vo.GenericVO;

public class CmmUserUtil {
	public static UserInfo getUserInfo(){
		UserInfo user = (UserInfo)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		return user;
	}
	
	public static void setDefaultUserInfo(GenericVO vo){
		UserInfo user = (UserInfo)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		vo.setUsername(user.getUsername());
		vo.setUser_ip(user.getUser_ip());
	}
}
