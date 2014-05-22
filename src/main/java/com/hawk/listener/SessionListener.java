package com.hawk.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hawk.login.UserTracker;

public class SessionListener implements HttpSessionListener {


	public void sessionCreated(HttpSessionEvent evt) {
		System.out.println("session created");
	}

	public void sessionDestroyed(HttpSessionEvent evt) {
		System.out.println("session destroyed");
		long now = new Date().getTime();
		long creationTime = evt.getSession().getCreationTime();
		System.out.println("Duration:"+(now-creationTime)+"ms");
		
		System.out.println(UserTracker.getLogoutTime());
	}

}
