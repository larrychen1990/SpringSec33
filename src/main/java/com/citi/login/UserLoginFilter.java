package com.citi.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.Assert;


public class UserLoginFilter extends UsernamePasswordAuthenticationFilter {

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "userName";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";

    private String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
    private String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;
    
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    	System.out.println("in UserLoginFilter attemptAuthentication"+request+"::::"+response);
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }
        
        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
    
    protected String obtainPassword(HttpServletRequest request) {
    	System.out.println("in UserLoginFilter obtainPassword"+request);
        return request.getParameter(passwordParameter);
    }
    
    protected String obtainUsername(HttpServletRequest request) {
    	System.out.println("in UserLoginFilter obtainUsername"+request);
        return request.getParameter(usernameParameter);
    }
    
    public void setUsernameParameter(String usernameParameter) {
    	System.out.println("in UserLoginFilter setUsernameParameter"+usernameParameter);
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
    	System.out.println("in UserLoginFilter setPasswordParameter:"+passwordParameter);
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }
}
