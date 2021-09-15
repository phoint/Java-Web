package controller.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	public static String get(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie retriveCookie : cookies) {
				if (retriveCookie.getName().equalsIgnoreCase(name)) {
					return retriveCookie.getValue();
				}
			}
		}		
		return "";
	}
	
	public static Cookie add(String name, String value, int hours, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60*60*hours);
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
	}
}
