package controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	// Them thuoc tinh vao session
	public static void add(HttpServletRequest request, String name, Object value) {
		HttpSession session = request.getSession(true);
		session.setAttribute(name, value);
	}
	
	// Xoa thuoc tinh khoi session
	public static void remove(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		session.removeAttribute(name);
	}

	// Lay gia tri cua thuoc tinh tu session
	public static Object get(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(true);
		return session.getAttribute(name);
	}
	
	// Huy session
	public static void invalidate(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("loginMail");
		session.invalidate();
	}
	
	// Kiem tra session co user dang nhap
	public static boolean isLogin(HttpServletRequest request) {
		return get(request, "loginMail") != null;
	}
	
	// Tra ve ten cua user dang nhap
	public static String getLoginedUserName(HttpServletRequest request) {
		Object username = get(request, "loginMail");
		return username == null ? null : username.toString();
	}
}
