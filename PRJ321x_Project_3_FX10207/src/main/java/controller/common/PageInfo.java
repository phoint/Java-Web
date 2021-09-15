package controller.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashMap<PageType, PageInfo>();
	
	static {
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management", "/userManagement.jsp", null));
		pageRoute.put(PageType.LOGIN_PAGE, new PageInfo("Login page", "/login.jsp", null));
		pageRoute.put(PageType.HOME_PAGE, new PageInfo("Trang chu", "/home.jsp", null));
		pageRoute.put(PageType.PRODUCT_INFO, new PageInfo("Thong tin san pham", "productInfo.jsp", null));
		pageRoute.put(PageType.CART_PAGE, new PageInfo("View Cart", "cart.jsp", null));
		pageRoute.put(PageType.SIGN_UP, new PageInfo("Dang ky", "register.jsp", null));
	}
	
	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/layout.jsp").forward(request, response);
	}

	private String title;
	private String contentUrl;
	private String scriptUrl;

	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getScriptUrl() {
		return scriptUrl;
	}

	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}

}
