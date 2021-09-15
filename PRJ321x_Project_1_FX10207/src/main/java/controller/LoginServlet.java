package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = "/LoginServlet")
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
		String action = request.getParameter("action");

		
		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (action.equals("login")) {
			request.setAttribute("username", "");
			request.setAttribute("password", "");
			request.setAttribute("invalidMessage", "");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		ServletContext context = getServletContext();
		String aName = context.getInitParameter("adminuser");
		String aPass = context.getInitParameter("adminpassword");
		
		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (action.equals("dologin")){
			String uName = request.getParameter("username");
			String uPass = request.getParameter("password");
			
			request.setAttribute("username", uName);
			
			User loginUser = new User(uName,uPass);
			
			if (loginUser.validate(aName, aPass)) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				request.setAttribute("invalidMessage",loginUser.getMessage());
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}
	}

}
