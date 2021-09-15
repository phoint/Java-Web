package model;

public class ProductOrders {
	private int orderID;
	private int productID;
	private int amountProduct; // quantity of selected in order
	private String nameProduct;

	public ProductOrders(int orderID, int productID, int amountProduct, String nameProduct) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.amountProduct = amountProduct;
		this.nameProduct = nameProduct;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

}
