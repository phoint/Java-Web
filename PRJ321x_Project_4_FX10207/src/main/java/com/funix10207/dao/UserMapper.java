package com.funix10207.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.funix10207.model.User;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserMail(rs.getString("user_mail"));
		user.setUserName(rs.getNString("user_name"));
		user.setUserPwd(rs.getString("password"));
		user.setUserAddress(rs.getNString("user_address"));
		user.setUserPhone(rs.getString("user_phone"));
		user.setUserRole(rs.getInt("account_role"));
		
		return user;
	}
}
