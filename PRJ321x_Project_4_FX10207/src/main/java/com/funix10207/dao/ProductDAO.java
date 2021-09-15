package com.funix10207.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.funix10207.model.Product;

public class ProductDAO {
	private DataSource dataSource;
	private JdbcTemplate productTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.productTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Product> listProduct(String searchKey) {
		String sql = "select * from Products where product_name like ?";
		List<Product> products = productTemplate.query(sql, new ProductMapper(), "%" + searchKey + "%");
		return products;
	}
	
	public Product getProduct(int id) {
		String sql = "select * from Products where product_id = ?";
		Product product = productTemplate.queryForObject(sql, new ProductMapper(), id);
		
		return product;
	}
}
