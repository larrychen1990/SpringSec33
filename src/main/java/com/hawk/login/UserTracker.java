package com.hawk.login;

import java.util.Date;

public class UserTracker {
	private static Date loginTime;
	private static Date logoutTime;
	
	public static Date getLoginTime() {
		return loginTime;
	}
	public static void setLoginTime(Date loginTime) {
		UserTracker.loginTime = new Date();
	}
	public static Date getLogoutTime() {
		return logoutTime;
	}
	public static void setLogoutTime(Date logoutTime) {
		UserTracker.logoutTime = new Date();
	}
}
