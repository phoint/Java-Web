package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.PageInfo;
import controller.common.PageType;
import controller.common.SessionUtils;
import dao.OrdersDAO;
import model.Cart;
import model.Orders;

/**
 * Servlet implementation class addToCartController
 */
@WebServlet("/cart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String idd = request.getParameter("id");
		String action = request.getParameter("action");

		try {
			// Xoa san pham trong gio hang
			if (action != null && action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(idd);
				Cart c = (Cart) SessionUtils.get(request, "cart");
				c.remove(id);
				SessionUtils.add(request, "cart", c);
			// Thanh toan don hang
			// Kiem tra don hang va thong tin khach hang, neu trong tra ve thong bao loi
			} else if (action != null && action.equalsIgnoreCase("checkout")) {
				if (SessionUtils.get(request,"cart") != null && (!((Cart) SessionUtils.get(request, "cart")).getItems().isEmpty())) {
					String cName = request.getParameter("customer");
					String cMail = request.getParameter("email");
					String cPhone = request.getParameter("phone");
					String cAdd = request.getParameter("address");
					String code = request.getParameter("discount");
					if (cName.equals("") || cAdd.equals("")) {
						request.setAttribute("error", "Name and Address must not be empty!");
					} else {
						Cart c = (Cart) SessionUtils.get(request, "cart");
						Orders newOrder = new Orders(0, cAdd, cPhone, cMail, null, code);
						new OrdersDAO().insertOrder(newOrder, c);
						SessionUtils.add(request, "cart", null);
						request.setAttribute("message", "Order is submited!");
						PageInfo.prepareAndForward(request, response, PageType.CART_PAGE);
						return;
					}
				} else {
					request.setAttribute("error", "Cart is empty!");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageInfo.prepareAndForward(request, response, PageType.CART_PAGE);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
