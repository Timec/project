package com.core.security.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
//import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//import com.syaku.rest.commons.ResponseResult;

@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    private String loginFormUrl;

    public String getLoginFormUrl() {
        return loginFormUrl;
    }

    public void setLoginFormUrl(String loginFormUrl) {
        this.loginFormUrl = loginFormUrl;
    }

    public UnauthorizedEntryPoint() {

    }

    public UnauthorizedEntryPoint(String loginFormUrl) {
        this.loginFormUrl = loginFormUrl;
    }


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String accept = request.getHeader("accept");
        String data = "";
        if( StringUtils.indexOf(accept, "html") > -1 ) {
            response.sendRedirect(loginFormUrl);
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Authentication token was either missing or invalid.");
        } else {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            //ResponseResult responseError = new ResponseResult();

            if( StringUtils.indexOf(accept, "json") > -1 ) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                //responseError.setMessage("Unauthorized");
                //responseError.setStatus_code("401");
                data = "{Message : 401 Unauthorized}";
            } else {
                response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                //responseError.setMessage("415 Unsupported Media Type");
                data = "{Message : 415 Unsupported Media Type}";
            }

            //ObjectMapper objectMapper = new ObjectMapper();
            //String data = objectMapper.writeValueAsString(responseError);
            PrintWriter out = response.getWriter();
            out.print(data);
            out.flush();
            out.close();
        }
    }

}