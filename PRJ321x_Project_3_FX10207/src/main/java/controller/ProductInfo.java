package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.PageInfo;
import controller.common.PageType;
import controller.common.SessionUtils;
import dao.ListProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class productInfo
 */
@WebServlet("/product")
public class ProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// Thong qua lop ListProductDAO, truy van san pham theo id
		String idd = request.getParameter("id");
		int id = Integer.parseInt(idd);
		Product p = new Product();
		try {
			p = new ListProductDAO().getProduct("" + id);
			p.setNumber(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Thuc hien them san pham vao gio hang (add to cart)
		// Goi tham so 'action' tu request, neu bang 'add' thi set thuoc tinh 'cart' cho session
		String action = request.getParameter("action");
		if (action != null && action.equalsIgnoreCase("add")) {
			Cart c = (Cart) SessionUtils.get(request, "cart");
			if (c == null) {
				c = new Cart();
			}

			c.add(p);
			SessionUtils.add(request, "cart", c);
		}
		
		// Hien thi chi tiet san pham
		request.setAttribute("product", p);
		PageInfo.prepareAndForward(request, response, PageType.PRODUCT_INFO);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
