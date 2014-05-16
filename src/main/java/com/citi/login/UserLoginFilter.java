package com.citi.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    		
    	System.out.println(new StringBuilder("in UserLoginFilter attemptAuthentication ")
    							.append("\n request=")
    							.append(request)
    							.append("\n response=")
    							.append(response)
    							.append("\n"));
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        System.out.println(String.format("in UserLoginFilter attemptAuthentication \n username=%s password=%s \n", username,password));

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
    	System.out.println(new StringBuilder("in UserLoginFilter obtainPassword ")
    	.append("\n request=")
    	.append(request)
    	.append("\n"));
        return request.getParameter(passwordParameter);
    }
    
    protected String obtainUsername(HttpServletRequest request) {
    	System.out.println(String.format("in UserLoginFilter obtainUsername \n request=%s \n", request));
        return request.getParameter(usernameParameter);
    }
    
    public void setUsernameParameter(String usernameParameter) {
    	System.out.println(String.format("in UserLoginFilter setUsernameParameter \n usernameParameter=%s \n", usernameParameter));
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
    	System.out.println(String.format("in UserLoginFilter setPasswordParameter \n passwordParameter=%s \n", passwordParameter));
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }
}
