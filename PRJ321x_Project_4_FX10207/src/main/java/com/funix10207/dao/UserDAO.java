package com.funix10207.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.funix10207.model.User;

public class UserDAO {
	private DataSource dataSource;
	private JdbcTemplate userTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.userTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(User user) {
		String sql = "insert into Account(user_mail, user_name, password, account_role, user_address, user_phone) value (?,?,?,?,?,?)";
		userTemplate.update(sql, user.getUserMail(),user.getUserName(),user.getUserPwd(),user.getUserRole(),user.getUserAddress(),user.getUserPhone());
		return;
	}
	
	public User getUser(String email) {
		String sql = "select * from Account where user_mail = ?";
		User user;
		try {
			user = userTemplate.queryForObject(sql, new UserMapper(), email);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			user = null;
		}
		return user;
	}
	
	public List<User> listUser() {
		String sql = "select * from Account";
		List<User> users = userTemplate.query(sql, new UserMapper());
		return users;
	}
	
	public void delete(String email) {
		String sql = "delete from Account where user_mail = ?";
		userTemplate.update(sql, email);
		return;
	}
	
	public void update(User user) {
		String sql = "update Account set user_name = ?, "
				+ "password = ?,"
				+ "user_address = ?,"
				+ "user_phone = ?,"
				+ "account_role = ?"
				+ "where user_mail = ?";
		userTemplate.update(sql, user.getUserName(), user.getUserPwd(), user.getUserAddress(), user.getUserPhone(), user.getUserRole(), user.getUserMail());
		return;
	}
}
