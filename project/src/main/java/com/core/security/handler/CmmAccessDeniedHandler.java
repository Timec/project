package com.core.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CmmAccessDeniedHandler implements AccessDeniedHandler {

	private String errorPage;
	
	@Override
	public void handle(HttpServletRequest request,	HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String ajaxHeader = request.getHeader("X-Ajax-call");
		String result = "";
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setCharacterEncoding("UTF-8");
			if(ajaxHeader == null){		
				try {
					Authentication auth = SecurityContextHolder.getContext().getAuthentication();
					Object principal = auth.getPrincipal();
					if (principal instanceof UserDetails) {
						String username = ((UserDetails) principal).getUsername();
						request.setAttribute("username", username);
					}
				} catch (NullPointerException e){
					setErrorPage("/login");
				}
				request.setAttribute("errormsg", accessDeniedException);
				
				request.getRequestDispatcher(errorPage).forward(request, response);
				
			}else{
				if("true".equals(ajaxHeader)){		
					result = "{\"result\" : \"fail\", \"message\" : \"" + accessDeniedException.getMessage() + "\"}";
				}else{								
					result = "{\"result\" : \"fail\", \"message\" : \"Access Denied(Header Value Mismatch)\"}";
				}
				response.getWriter().print(result);
				response.getWriter().flush();
			}
	}
	
	public void setErrorPage(String errorPage) {
        if ((errorPage != null) && !errorPage.startsWith("/")) {
            throw new IllegalArgumentException("errorPage must begin with '/'");
        }

        this.errorPage = errorPage;
    }
}
