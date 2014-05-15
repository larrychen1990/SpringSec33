package com.citi.securityInterceptor;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * get  the resource mapping role info
 * 
 * @author access the resource mapping role info,weather user has or not
 *
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


	/**
	 * string -> resource
	 * Collection<ConfigAttribute> -> role
	 */
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public void updateResource() {
		synchronized (resourceMap) {
			resourceMap.clear();
			loadMap();
		}
	}

	private void loadMap() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();  
		ConfigAttribute ca = new SecurityConfig("ROLE_USER");  
		atts.add(ca);
		resourceMap.put("/index.jsp", atts);
		resourceMap.put("/login.jsp", atts);
		resourceMap.put("/j_spring_security_check", atts);

	}

	/**
	 * return  the resource mapping roles that all users can access
	 */
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		if (resourceMap == null) {
			loadMap();
		}
		String url = ((FilterInvocation) object).getRequestUrl();
		return resourceMap.get(url);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

}