package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items; // list of item in cart
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	// add a new product to cart
	public void add(Product cartItem) {
		for (Product x : items) {
			if (cartItem.getId() == x.getId()) {
				x.setNumber(x.getNumber() + 1);
				return;
			}
		}
		items.add(cartItem);
	}
	
	// remove a product from cart
	public void remove(int productID) {
		for (Product x : items) {
			if (x.getId() == productID) {
				items.remove(x);
				return;
			}
		}
	}
	
	// return total amount of cart
	public double getAmount() {
		double sum = 0;
		for (Product x : items) {
			sum += x.getPrice() * x.getNumber();
		}
		return Math.round(sum * 100.0) / 100.0;
	}
	
	public int getTotalItems() {
		int totalItem = 0;
		for (Product x: items) {
			totalItem += x.getNumber(); 
		}
		return totalItem;
	}
	
	// return list of product in cart
	public List<Product> getItems() {
		return items;
	}
	
}
