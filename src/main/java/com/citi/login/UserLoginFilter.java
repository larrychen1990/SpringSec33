package com.citi.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
    
    
    private Log logger=LogFactory.getLog(getClass());
    		
    
    public void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response) {
    	Authentication au = super.attemptAuthentication(request, response);
    	if (au.isAuthenticated()) {
    		System.out.println("Tracking start....");
    	}
    }
    
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//    		
//    	logger.info(new StringBuilder("request=")
//    							.append(request)
//    							.append("\n response=")
//    							.append(response));
//        String username = obtainUsername(request);
//        String password = obtainPassword(request);
//        logger.info(String.format("username=%s \n password=%s", username,password));
//
//        if (username == null) {
//            username = "";
//        }
//        
//        if (password == null) {
//            password = "";
//        }
//
//        username = username.trim();
//
//        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
//
//        // Allow subclasses to set the "details" property
//        setDetails(request, authRequest);
//        System.out.println(this.getAuthenticationManager().authenticate(authRequest).isAuthenticated());
//        return this.getAuthenticationManager().authenticate(authRequest);
//    }
    
//    protected String obtainPassword(HttpServletRequest request) {
//    	logger.info(new StringBuilder("request=")
//    	.append(request));
//        return request.getParameter(passwordParameter);
//    }
//    
//    protected String obtainUsername(HttpServletRequest request) {
//    	logger.info(String.format("request=%s", request));
//        return request.getParameter(usernameParameter);
//    }
//    
//    public void setUsernameParameter(String usernameParameter) {
//    	logger.info(String.format("usernameParameter=%s", usernameParameter));
//        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
//        this.usernameParameter = usernameParameter;
//    }
//
//    public void setPasswordParameter(String passwordParameter) {
//    	logger.info(String.format("passwordParameter=%s", passwordParameter));
//        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
//        this.passwordParameter = passwordParameter;
//    }
}
