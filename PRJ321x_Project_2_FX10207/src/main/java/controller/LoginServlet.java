package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtils.get("username", request);
		String action = request.getParameter("action");
		request.getSession(true).invalidate();
		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (action.equals("login")) {
			if (username != null) {
			request.setAttribute("username", username);
			}
			request.getRequestDispatcher("/login.jsp").forward(request, response);	
		} else if (action.equals("logout")) {
			request.getSession(true).invalidate();
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		request.getSession(true).invalidate();
		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (action.equals("dologin")) {
			// make user the input email is valid
			String regrexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regrex = "[a-zA-Z0-9_!@#$%^&*]+";
			// collect data from login form
			String uLogin = request.getParameter("username");
			String pLogin = request.getParameter("password");
			Account acc = new Account();
			acc.setUsr(uLogin);
			acc.setPwd(pLogin);
			// read information of account in web.xml
			String uAdmin = getServletContext().getInitParameter("username");
			String pAdmin = getServletContext().getInitParameter("password");
			HttpSession session = request.getSession(true);
			if (!uLogin.matches(regrexMail) || !pLogin.matches(regrex)) {
				session.setAttribute("error", "invalid syntax");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (acc.getPwd().equals(pAdmin) && acc.getUsr().equals(uAdmin)) {
				session.setAttribute("user", uLogin);
				session.setAttribute("login", "true");
				if (request.getParameter("remember") != null && request.getParameter("remember").equals("yes")) {
					CookieUtils.add("username", uLogin, 24, response);
				} else {
					CookieUtils.add("username", uLogin, 0, response);
				}
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				session.setAttribute("error", "invalid username or password");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}

}
