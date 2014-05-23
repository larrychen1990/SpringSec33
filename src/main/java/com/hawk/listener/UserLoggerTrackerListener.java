package com.hawk.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LoggerListener;
import org.springframework.util.ClassUtils;

public class UserLoggerTrackerListener extends LoggerListener{

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
				logger.warn("authenticate failure!");
			}
			if (event instanceof InteractiveAuthenticationSuccessEvent) {
				logger.warn("authenticate success!");
				
			}
			logger.warn(builder.toString());
		}
	}

	public boolean isLogInteractiveAuthenticationSuccessEvents() {
		return logInteractiveAuthenticationSuccessEvents;
	}

	public void setLogInteractiveAuthenticationSuccessEvents(
			boolean logInteractiveAuthenticationSuccessEvents) {
		this.logInteractiveAuthenticationSuccessEvents = logInteractiveAuthenticationSuccessEvents;
	}

}
