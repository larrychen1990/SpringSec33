package com.citi.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	private String sessionId;

	public void sessionCreated(HttpSessionEvent evt) {
		System.out.println("session created");
		Date date = new Date();
		HttpSession session = evt.getSession();
		session.setAttribute("loginDate", date);
		System.out.println("set date to session:" + date);
		sessionId = session.getId();
		System.out.println(sessionId);
	}

	public void sessionDestroyed(HttpSessionEvent evt) {
		HttpSession session = evt.getSession();
		Date date = (Date) session.getAttribute("loginDate");
		System.out.println(session.getSessionContext());
		System.out.println(session.getId());
		System.out.println("get date from session:" + date);
		System.out.println("session destroyed");
	}

}
