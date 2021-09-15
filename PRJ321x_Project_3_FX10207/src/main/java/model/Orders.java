package model;

import java.util.Date;
import java.util.List;

public class Orders {
	private int orderID;
	private float total; // total amount of order
	private int status;
	private Date orderDate;
	private String address; // buyer's address
	private String phoneNumber;
	private List<ProductOrders> productList;
	private String userMail;
	private Date receivedDate;
	private String discount;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderID, float total, int status, Date orderDate, String address, String phoneNumber,
			List<ProductOrders> productList, String userMail, Date receivedDate, String discount) {
		super();
		this.orderID = orderID;
		this.total = total;
		this.status = status;
		this.orderDate = orderDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.productList = productList;
		this.userMail = userMail;
		this.receivedDate = receivedDate;
		this.discount = discount;
	}

	public Orders(int status, String address, String phoneNumber, String userMail, Date receivedDate, String discount) {
		super();
		this.status = status;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userMail = userMail;
		this.receivedDate = receivedDate;
		this.discount = discount;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<ProductOrders> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductOrders> productList) {
		this.productList = productList;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

}
