package org.chen2lei.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class DeviceUtils {
	private static Logger LOGGER = Logger.getLogger(DeviceUtils.class);

	private static String DEVICE_AWARED = "device_awared";
	private static String OS_DEVICE = "device_os";
	private static String TYPE_DEVICE = "device_type";

	private static void DeviceAware(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(DEVICE_AWARED, Boolean.TRUE);
		String userAgent = request.getHeader("User-Agent");
		if (userAgent == null) {
			LOGGER.error("NO user agent");
		} else {
			userAgent = userAgent.toLowerCase();
			
			//@TO DO:
			if (userAgent.indexOf("pad") > 0) {
				session.setAttribute(TYPE_DEVICE, DeviceType.PAD);
			} else if (userAgent.indexOf("mobile") > 0) {
				session.setAttribute(TYPE_DEVICE, DeviceType.MOBILE);
			} else {
				session.setAttribute(TYPE_DEVICE, DeviceType.PC);
			}
			
			if (userAgent.indexOf("android") > 0) {
				session.setAttribute(OS_DEVICE, OS.ANDORID);
			} else {
				session.setAttribute(OS_DEVICE, OS.WINDOWS);
			}
		}
	}

	public static boolean isPC(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(DEVICE_AWARED) == null){
			DeviceAware(request);
		}
		return DeviceType.PC.equals(session.getAttribute(TYPE_DEVICE));
	}

	public static boolean isPad(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(DEVICE_AWARED) == null){
			DeviceAware(request);
		}
		return DeviceType.PAD.equals(session.getAttribute(TYPE_DEVICE));
	}

	public static boolean isMobile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(DEVICE_AWARED) == null){
			DeviceAware(request);
		}
		return DeviceType.MOBILE.equals(session.getAttribute(TYPE_DEVICE));
	}

	public enum DeviceType {
		PC("PC"), MOBILE("Mobile"), PAD("Pad");

		private String value;

		private DeviceType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum OS {
		WINDOWS("Windows"), ANDORID("Android"), IOS("iOS"), LINUX("Linux");

		private String value;

		private OS(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum Browser {
		IE, FIRE_FOX, CHROME,
	}

}
