package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ListProductDAO {
	// return list of product by product name
	public List<Product> search(String characters) throws Exception {
		String sql = "select * from Products where product_name like ?";
		ResultSet rs = null;
		List<Product> resultList = new ArrayList<Product>();
		try (Connection conn = new DBContext().OpenConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setNString(1, "%" + characters + "%");
			rs = stmt.executeQuery();
		 while (rs.next()) {
			 Product resultItem = new Product();
			 resultItem.setId(rs.getInt("product_id"));
			 resultItem.setName(rs.getString("product_name"));
			 resultItem.setDescription(rs.getString("product_des"));
			 resultItem.setPrice(rs.getFloat("product_price"));
			 resultItem.setType(rs.getString("product_type"));
			 resultItem.setBrand(rs.getString("product_brand"));
			 resultItem.setSrc(rs.getString("product_img_source"));
			 resultList.add(resultItem);
		 }
		}
		return resultList;
	}
	
	public Product getProduct(String id) throws Exception {
		String sql = "select * from Products where product_id = ?";
		ResultSet rs = null;
		Product resultItem = new Product();
		try (Connection conn = new DBContext().OpenConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setNString(1, id);
			rs = stmt.executeQuery();
		 while (rs.next()) {
			 resultItem.setId(rs.getInt("product_id"));
			 resultItem.setName(rs.getString("product_name"));
			 resultItem.setDescription(rs.getString("product_des"));
			 resultItem.setPrice(rs.getFloat("product_price"));
			 resultItem.setType(rs.getString("product_type"));
			 resultItem.setBrand(rs.getString("product_brand"));
			 resultItem.setSrc(rs.getString("product_img_source"));
		 }
		}
		return resultItem;
	}
}
