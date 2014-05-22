package com.hawk.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {


	public void sessionCreated(HttpSessionEvent evt) {
		System.out.println("session created");
	}

	public void sessionDestroyed(HttpSessionEvent evt) {
		System.out.println("session destroyed");
	}

}
