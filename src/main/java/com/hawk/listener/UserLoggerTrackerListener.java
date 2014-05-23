package com.hawk.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.util.ClassUtils;

public class UserLoggerTrackerListener implements ApplicationListener{

	private static final Log logger = LogFactory.getLog(UserLoggerTrackerListener.class);
	private boolean logInteractiveAuthenticationSuccessEvents;

	public UserLoggerTrackerListener() {
		logInteractiveAuthenticationSuccessEvents = true;
	}

	public void onApplicationEvent(AbstractAuthenticationEvent event) {
		if (!logInteractiveAuthenticationSuccessEvents
				&& (event instanceof InteractiveAuthenticationSuccessEvent))
			return;
		if (logger.isWarnEnabled()) {
			StringBuilder builder = new StringBuilder();
			builder.append("Authentication event ");
			builder.append(ClassUtils.getShortName(event.getClass()));
			builder.append(": ");
			builder.append(event.getAuthentication().getName());
			builder.append("; details: ");
			builder.append(event.getAuthentication().getDetails());
			if (event instanceof AbstractAuthenticationFailureEvent) {
				builder.append("; exception: ");
				builder.append(((AbstractAuthenticationFailureEvent) event)
						.getException().getMessage());
			}
			logger.warn(builder.toString());
			logger.warn("heelelooo");
		}
	}

	public boolean isLogInteractiveAuthenticationSuccessEvents() {
		return logInteractiveAuthenticationSuccessEvents;
	}

	public void setLogInteractiveAuthenticationSuccessEvents(
			boolean logInteractiveAuthenticationSuccessEvents) {
		this.logInteractiveAuthenticationSuccessEvents = logInteractiveAuthenticationSuccessEvents;
	}

	public void onApplicationEvent(ApplicationEvent x0) {
		onApplicationEvent( x0);
		
	}

}
