package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;

public class UsersDAO {
	public List<Account> findAll() throws Exception {
		String sql = "select * from Account";
		List<Account> accList = new ArrayList<Account>();
		try (Connection conn = new DBContext().OpenConnection(); Statement stmt = conn.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Account user = new Account();
				user.setUsr(rs.getString("user_mail"));
				user.setName(rs.getNString("user_name"));
				user.setPwd(rs.getString("password"));
				user.setPhone(rs.getString("user_phone"));
				user.setAddress(rs.getNString("user_address"));
				user.setRole(rs.getInt("account_role"));
				accList.add(user);
			}
		}
		return accList;
	}
	
	public Account search(String userMail) throws Exception {
		String sql = "select * from Account where user_mail = ?";
		Account acc = null;
		try (Connection conn = new DBContext().OpenConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, userMail);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				acc = new Account();
				acc.setUsr(userMail);
				acc.setName(rs.getNString("user_name"));
				acc.setPwd(rs.getString("password"));
				acc.setPhone(rs.getString("user_phone"));
				acc.setAddress(rs.getNString("user_address"));
				acc.setRole(rs.getInt("account_role"));
			}
		}
		return acc;
	}

	public void insert(Account acc) throws Exception {
		String insertSql = "insert into Account (user_mail,user_name,password,user_phone,user_address,account_role) values (?,?,?,?,?,?)";
		try (Connection conn = new DBContext().OpenConnection()) {
			PreparedStatement stmt = conn.prepareStatement(insertSql);
			stmt.setString(1, acc.getUsr());
			stmt.setNString(2, acc.getName());
			stmt.setString(3, acc.getPwd());
			stmt.setString(4, acc.getPhone());
			stmt.setNString(5, acc.getAddress());
			stmt.setInt(6, acc.getRole());
			stmt.executeUpdate();
		}
	}
	
	public void update(Account acc) throws Exception {
		String sql = "update Account set password = ?,"
				+ "user_name = ?,"
				+ "user_address = ?,"
				+ "user_phone = ?,"
				+ "account_role = ? where user_mail = ?";
		try (Connection conn = new DBContext().OpenConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(6, acc.getUsr());
			stmt.setString(1, acc.getPwd());
			stmt.setNString(2, acc.getName());
			stmt.setNString(3, acc.getAddress());
			stmt.setString(4, acc.getPhone());
			stmt.setInt(5, acc.getRole());
			stmt.executeUpdate();
		}
	}
	
	public void delete(String user_mail) throws Exception {
		String sql = "delete from Account where user_mail = ?";
		try (Connection conn = new DBContext().OpenConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, user_mail);
			stmt.executeUpdate();
		}
	}
}
