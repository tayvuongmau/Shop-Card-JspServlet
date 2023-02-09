package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.OrderDAO;
import DBContext.Connect;
import Model.Account;
import Model.Cart;
import Model.Item;

public class OrderDAOImpl implements OrderDAO {
	
	//thêm mới 1 Order
	@Override
	public void addOrder(Account account, Cart cart) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = Connect.openConnection();
			conn.setAutoCommit(false);
			//thêm mới 1 Order
			statement = conn.prepareStatement("insert into orders(name_product, totalmoney) values (?,?)");
			statement.setString(1, account.getUsername());
			statement.setDouble(2, cart.getTotalMoney());
			statement.executeUpdate();
			//close statement sau khi thực hiện xong truy vấn tránh rò rỉ dữ liệu
			//Connect.closeStatement(statement);
			//lấy ra order_id của Order vừa add vào bảng
			statement = conn.prepareStatement("select order_id from orders order by order_id desc limit 1");
			resultSet = statement.executeQuery();
			//từ order_id lấy được thêm toàn bộ thông tin chi tiết đơn hàng vào orders_detail
			if(resultSet.next()) {
				int order_id = resultSet.getInt(1);
				//dùng vòng lặp chạy qua từng sản phẩm (Item) trong giỏ hàng cart để lấy ra thông tin từng sản phẩm add vào bảng orders_detail
				for(Item i : cart.getItems()) {
					statement = conn.prepareStatement("insert into orders_detail values (?,?,?,?)");
					statement.setInt(1, order_id);
					statement.setInt(2, i.getProducts().getProduct_id());
					statement.setInt(3, i.getQuantity());
					statement.setInt(4, i.getPrice());
					statement.executeUpdate();
				}
			}
			conn.commit();
		}
		catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
