package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.PageInfo;
import controller.common.PageType;
import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/index.jsp")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String searchKey = null;
		// Truy van danh sach san pham trong database theo tu khoa
		// Neu khong co tu khoa tim kiem, tra ve toan bo san pham
		try {
			searchKey = request.getParameter("searchKey");
			if (searchKey == null) {
				searchKey = "";
			} 
			List<Product> ls = new ListProductDAO().search(searchKey);
			request.setAttribute("products", ls);
			PageInfo.prepareAndForward(request, response, PageType.HOME_PAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", "Error: " + e.getMessage());
			PageInfo.prepareAndForward(request, response, PageType.HOME_PAGE);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
