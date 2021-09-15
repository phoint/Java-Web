package controller.site;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.CookieUtils;
import controller.common.PageInfo;
import controller.common.PageType;
import controller.common.SessionUtils;
import dao.UsersDAO;
import model.Account;
import model.LoginForm;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginMail = CookieUtils.get("loginMail", request);
		
		if (loginMail == null || loginMail.equals("")) {
			PageInfo.prepareAndForward(request, response, PageType.LOGIN_PAGE);
			return;
		} 
		SessionUtils.add(request, "loginMail", loginMail);
		PageInfo.prepareAndForward(request, response, PageType.HOME_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// make user the input email is valid
		String regrexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regrex = "[a-zA-Z0-9_!@#$%^&*]+";
		// collect data from login form
		try {
			LoginForm form = new LoginForm();
			form.setEmail(request.getParameter("username"));
			form.setPwd(request.getParameter("password"));
			form.setRemember(Boolean.getBoolean(request.getParameter("remember")));
			
			UsersDAO dao = new UsersDAO();
			Account acc = dao.search(form.getEmail());

			if (!form.getEmail().matches(regrexMail) || ! form.getPwd().matches(regrex)) {
				request.setAttribute("error", "invalid syntax");
				PageInfo.prepareAndForward(request, response, PageType.LOGIN_PAGE);
				return;
			} else if (acc != null && acc.getPwd().equals(form.getPwd())) {
				if (form.isRemember()) {
					CookieUtils.add("loginMail", form.getEmail(), 24, response);
				} else {
					CookieUtils.add("loginMail", form.getEmail(), 0, response);
				}
				
				SessionUtils.add(request, "user", acc);
				if (acc.getRole() == 1) {
					SessionUtils.add(request, "role", "isAdmin");
					response.sendRedirect(request.getContextPath() + "/UserServlet");
				} else {
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				}
				return;
			} else {
			request.setAttribute("error", "Invalid email or password");
			}
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.LOGIN_PAGE);
	}

}
