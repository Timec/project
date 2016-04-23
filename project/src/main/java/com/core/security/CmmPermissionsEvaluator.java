package com.core.security;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.chincook.common.login.UserInfo;

public class CmmPermissionsEvaluator implements PermissionEvaluator {

	private static final Logger logger = LoggerFactory.getLogger(CmmPermissionsEvaluator.class);
	
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
    	HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	String controlId = (String)req.getHeader("Referer");
    	UserInfo user = (UserInfo)authentication.getPrincipal();
        System.out.println("hasPermission - "+targetDomainObject);
        System.out.println("controlId : " + controlId);
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
    	throw new UnsupportedOperationException();
    }
}
