package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserServlet
 */
@WebServlet({"/UserServlet", "/UserServlet/create", "/UserServlet/update", "/UserServlet/delete", "/UserServlet/edit", "/UserServlet/reset"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		
		Account acc = null;
		// Thuc hien cac chuc nang delete, edit, reset gui bang phuong thuc GET
		if (url.contains("delete")) {
			delete(request, response);
			acc = new Account();
			request.setAttribute("user", acc);
		} else if (url.contains("reset")) {
			acc = new Account();
			request.setAttribute("user", acc);
		} else if (url.contains("edit")) {
			edit(request, response);
		}
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		
		// Thuc hien cac chuc nang create, update, delete, reset gui bang phuong thuc POST
		if (url.contains("create")) {
			insert(request,response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
			request.setAttribute("user", new Account());
		} else if (url.contains("reset")) {
			Account acc = new Account();
			request.setAttribute("user", acc);
		}
		findAll(request, response);
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}
	
	// Them nguoi dung moi vao database
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Account acc = new Account();
			acc.setUsr(request.getParameter("email"));
			acc.setName(request.getParameter("userName"));
			acc.setPwd(request.getParameter("password"));
			acc.setAddress(request.getParameter("address"));
			acc.setPhone(request.getParameter("phone"));
			acc.setRole(Integer.parseInt(request.getParameter("admin")));
			
			UsersDAO dao = new UsersDAO();
			dao.insert(acc);
			request.setAttribute("message", "User inserted!");
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	// Cap nhat nguoi dung trong database
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Account acc = new Account();
			acc.setUsr(request.getParameter("email"));
			acc.setName(request.getParameter("userName"));
			acc.setPwd(request.getParameter("password"));
			acc.setAddress(request.getParameter("address"));
			acc.setPhone(request.getParameter("phone"));
			acc.setRole(Integer.parseInt(request.getParameter("admin")));
			
			UsersDAO dao = new UsersDAO();
			dao.update(acc);
			
			request.setAttribute("user", acc);
			request.setAttribute("message", "User updated!");
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	// Truy van toan bo nguoi dung trong database
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			UsersDAO dao = new UsersDAO();
			List<Account> accList = dao.findAll();
			request.setAttribute("list", accList);
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	// Xoa trang form
	protected void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Account acc = new Account();
			acc.setUsr(request.getParameter("email"));
			acc.setName(request.getParameter("fullname"));
			acc.setPwd(request.getParameter("password"));
			acc.setRole(Integer.parseInt(request.getParameter("admin")));
			
			UsersDAO dao = new UsersDAO();
			dao.insert(acc);
			request.setAttribute("message", "User inserted!");
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	// Truy van nguoi dung theo email de hien thi thong tin len form 
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String user_mail = request.getParameter("email");
			UsersDAO dao = new UsersDAO();
			Account acc = dao.search(user_mail);
			request.setAttribute("user", acc);
			
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	// Xoa nguoi dung trong database theo email
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userMail = request.getParameter("email");
			
			UsersDAO dao = new UsersDAO();
			dao.delete(userMail);

			request.setAttribute("message", "User deleted!");
		} catch (Exception e) {
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
