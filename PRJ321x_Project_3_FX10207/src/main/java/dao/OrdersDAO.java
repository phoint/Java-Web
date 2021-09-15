package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDAO {
	public void insertOrder(Orders o, Cart c) throws Exception {
		String sqlOrder = "insert Orders (user_mail, order_status, order_date, order_address, order_discount_code) values (?,?,?,?,?)";
		String sqlGetOrder = "select top(1)* from Orders order by order_id desc";
		String sqlOrderDetail = "insert Orders_detail (order_id,product_id,amount_product,price_product) values (?,?,?,?)";
		ResultSet rs = null;
		
		Date orderDate = new Date(Calendar.getInstance().getTimeInMillis());
		
		try (Connection conn = new DBContext().OpenConnection()) {
			try (PreparedStatement orderstmt = conn.prepareStatement(sqlOrder);
					Statement getorderstmt = conn.createStatement();
					PreparedStatement orderDetailstmt = conn.prepareStatement(sqlOrderDetail)) {
				conn.setAutoCommit(false);
				orderstmt.setString(1, o.getUserMail());
				orderstmt.setInt(2, o.getStatus());
				orderstmt.setDate(3, orderDate);
				orderstmt.setNString(4, o.getAddress());
				orderstmt.setString(5, o.getDiscount());
				orderstmt.executeUpdate();

				rs = getorderstmt.executeQuery(sqlGetOrder);
				if (rs.next()) {
					o.setOrderID(rs.getInt("order_id"));
				}

				orderDetailstmt.setInt(1, o.getOrderID());
				for (Product x : c.getItems()) {
					orderDetailstmt.setInt(2, x.getId());
					orderDetailstmt.setInt(3, x.getNumber());
					orderDetailstmt.setDouble(4, x.getPrice());
					orderDetailstmt.executeUpdate();
				}
				conn.commit();
			} catch (Exception ex) {
				conn.rollback();
			} finally {
				conn.setAutoCommit(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
