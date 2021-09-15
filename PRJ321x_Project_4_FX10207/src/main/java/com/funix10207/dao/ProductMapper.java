package com.funix10207.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.funix10207.model.Product;

public class ProductMapper implements RowMapper<Product> {
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getInt("product_id"));
		product.setProductName(rs.getNString("product_name"));
		product.setProductDesc(rs.getNString("product_des"));
		product.setProductPrice(rs.getFloat("product_price"));
		product.setProductBrand(rs.getString("product_brand"));
		product.setProductType(rs.getString("product_type"));
		product.setProductImg(rs.getString("product_img_source"));
		
		return product;
	}
}
