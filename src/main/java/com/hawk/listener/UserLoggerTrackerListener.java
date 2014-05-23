package com.hawk.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LoggerListener;

public class UserLoggerTrackerListener extends LoggerListener{

	private static final Log logger = LogFactory.getLog(UserLoggerTrackerListener.class);
	private boolean logInteractiveAuthenticationSuccessEvents;

	public UserLoggerTrackerListener() {
		logInteractiveAuthenticationSuccessEvents = true;
	}

	public void onApplicationEvent(AbstractAuthenticationEvent event) {
		if (!logInteractiveAuthenticationSuccessEvents)
			return;
		
		if (logger.isWarnEnabled()) {
			if (event instanceof AbstractAuthenticationFailureEvent) {
				logger.warn("authenticate failure!");
			}
			
			if (event instanceof InteractiveAuthenticationSuccessEvent) {
				logger.warn("authenticate success!");
			}
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
