package DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.UsernameDAO;
import DBContext.Connect;
import Model.Account;

public class UsernameDAOImpl implements UsernameDAO{
	
	//hiển thị username
	@Override
	public List<Account> getAccount() {
		List<Account> list = new ArrayList<>();
		Connection conn;					//tạo kết nối
		PreparedStatement statement = null;	//tạo truy vấn
		ResultSet resultSet = null;			//chứa kết quả
		//mở kết nối
		conn = Connect.openConnection();
		//tạo truy vấn
		try {
			statement = conn.prepareStatement("select * from Account");
			//thực thi truy vấn
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setUsername(resultSet.getString("username"));
				account.setPassword(resultSet.getString("password"));
				account.setEmail(resultSet.getString("email"));
				account.setPhone(resultSet.getString("phone"));
				account.setBirthday(resultSet.getDate("birthday"));
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return list;
	}
	
	//tạo username
	@Override
	public boolean insertUsername(Account acc) {
		boolean bl = false;
		Connection conn;					//tạo kết nối
		PreparedStatement statement = null;	//tạo truy vấn
		ResultSet resultSet = null;			//chứa kết quả
		//mở kết nối
		conn = Connect.openConnection();
		//tắt auto commit
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		//tạo truy vấn
		try {
			statement = conn.prepareStatement("insert into Account values (?,?,?,?,?)");
			statement.setString(1, acc.getUsername());
			statement.setString(2, acc.getPassword());
			statement.setString(3, acc.getEmail());
			statement.setString(4, acc.getPhone());
			statement.setDate(5, new Date(acc.getBirthday().getTime()));
			int i = statement.executeUpdate();
			if(i>0) {
				bl = true;
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return bl;
	}

	//kiểm tra tài khoản đã tồn tại chưa
	@Override
	public boolean exists(String username, String password) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			String sql = "select count(*) as count from Account where username=? and password=?";
			conn = Connect.openConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			count = 0;
			if(resultSet.next()) {
				count = resultSet.getInt("count");
			}
		}catch(SQLException e){	
			e.printStackTrace();
		}finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		
		if(count == 0) {
			return false;
		}else {
			return true;
		}
	}

	//lấy danh sách 10 tài khoản cho mỗi trang hiển thị
	@Override
	public List<Account> pagingAccount(int index) {
		List<Account> list = new ArrayList<>();
		Connection conn;					//tạo kết nối
		PreparedStatement statement = null;	//tạo truy vấn
		ResultSet resultSet = null;			//chứa kết quả
		//mở kết nối
		conn = Connect.openConnection();
		//tạo truy vấn
		try {
			statement = conn.prepareStatement("select * from Account LIMIT ?, 10");
			statement.setInt(1, (index - 1)*10);
			//thực thi truy vấn
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setUsername(resultSet.getString("username"));
				account.setPassword(resultSet.getString("password"));
				account.setEmail(resultSet.getString("email"));
				account.setPhone(resultSet.getString("phone"));
				account.setBirthday(resultSet.getDate("birthday"));
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return list;
	}

	//lấy ra số tài khoản đã đăng kí
	@Override
	public int getTotalAccount() {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select count(*) from Account";
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				return resultSet.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UsernameDAOImpl i = new UsernameDAOImpl();
		System.out.println(i.getTotalAccount());
	}

	//lấy lên account thông qua username để truyền vào session => chuyển nó sang trang chủ để thực hiện mua hàng
	@Override
	public Account getAccountSession(String username) {
		Account account = null;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select * from Account where username =?";
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				account = new Account();
				account.setUsername(resultSet.getString("username"));
				account.setPassword(resultSet.getString("password"));
				account.setEmail(resultSet.getString("email"));
				account.setPhone(resultSet.getString("phone"));
				account.setBirthday(resultSet.getDate("birthday"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return account;
	}
	
}
