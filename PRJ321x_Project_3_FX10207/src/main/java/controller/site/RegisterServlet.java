package controller.site;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLTransactionRollbackException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.PageInfo;
import controller.common.PageType;
import dao.UsersDAO;
import model.Account;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.prepareAndForward(request, response, PageType.SIGN_UP);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Account newAcc = new Account(email, pwd, 5, username, address, phone, 0);
		try {
			UsersDAO dao = new UsersDAO();
			dao.insert(newAcc);
			request.setAttribute("message", "Account Created!");
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
//		request.setAttribute("username", username);
//		request.setAttribute("email", email);
//		request.setAttribute("phone", phone);
//		request.setAttribute("address", address);
//		request.setAttribute("message", message);
		PageInfo.prepareAndForward(request, response, PageType.SIGN_UP);
	}
	
//	protected void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("pageTitle", "Dang ky");
//		request.setAttribute("pageView", "register.jsp");
//		RequestDispatcher rd = request.getRequestDispatcher("/layout.jsp");
//		rd.forward(request, response);
//	}

}
