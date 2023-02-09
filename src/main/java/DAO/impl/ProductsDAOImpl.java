package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ProductsDAO;
import DBContext.Connect;
import Model.Products;

public class ProductsDAOImpl implements ProductsDAO {

	@Override
	public List<Products> getProducts() {
		List<Products> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// conn = Connect.openConnection();
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement("select * from Products");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products = new Products();
				products.setProduct_id(resultSet.getInt("product_id"));
				products.setProduct_name(resultSet.getString("product_name"));
				products.setProduct_des(resultSet.getString("product_des"));
				products.setProduct_price(resultSet.getInt("product_price"));
				products.setProduct_src(resultSet.getString("product_src"));
				products.setProduct_type(resultSet.getString("product_type"));
				products.setNumber(resultSet.getInt("number"));
				list.add(products);
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

	@Override
	public int getTotalProduct() {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select count(*) from Products";
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt(1); // vì truy vấn dữ liệu lên chỉ có 1 dòng => return ra giá trị của dòng đó
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return 0;
	}

	@Override
	public List<Products> pagingProducts(int index) {
		List<Products> list = new ArrayList<>();
		String sql = "SELECT * FROM products LIMIT ?, 8"; // câu truy vấn mỗi lần chỉ truy vấn lên tối đa 8 dòng bắt đầu
															// từ dòng có index = ?
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, (index - 1) * 8); // sét tham số cho dấu ? sẽ là dòng bắt đầu được truy vấn lên
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products = new Products();
				products.setProduct_id(resultSet.getInt("product_id"));
				products.setProduct_name(resultSet.getString("product_name"));
				products.setProduct_des(resultSet.getString("product_des"));
				products.setProduct_price(resultSet.getInt("product_price"));
				products.setProduct_src(resultSet.getString("product_src"));
				products.setProduct_type(resultSet.getString("product_type"));
				products.setNumber(resultSet.getInt("number"));
				list.add(products);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return list;
	}

	public static void main(String[] args) {
		ProductsDAOImpl i = new ProductsDAOImpl();
		List<Products> e = i.pagingProducts(1);
		System.out.println(e);
	}

	@Override
	public List<Products> getProductByName(String productName) {
		List<Products> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// conn = Connect.openConnection();
		try {
			conn = Connect.openConnection();
			// nếu tham số ở ô tìm kiếm = null hoặc độ dài = 0 thì lấy hết dữ liệu lên
			if (productName == null || productName.length() == 0)
				productName = "%";
			else
				productName = "%" + productName + "%";
			statement = conn.prepareStatement("select * from Products where product_name like ?");
			statement.setString(1, productName);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products = new Products();
				products.setProduct_id(resultSet.getInt("product_id"));
				products.setProduct_name(resultSet.getString("product_name"));
				products.setProduct_des(resultSet.getString("product_des"));
				products.setProduct_price(resultSet.getInt("product_price"));
				products.setProduct_src(resultSet.getString("product_src"));
				products.setProduct_type(resultSet.getString("product_type"));
				products.setNumber(resultSet.getInt("number"));
				list.add(products);
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

	@Override
	public List<Products> getProductsByStreng() {
		List<Products> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM products where product_des = ?";
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, "Hero Streng");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products = new Products();
				products.setProduct_id(resultSet.getInt("product_id"));
				products.setProduct_name(resultSet.getString("product_name"));
				products.setProduct_des(resultSet.getString("product_des"));
				products.setProduct_price(resultSet.getInt("product_price"));
				products.setProduct_src(resultSet.getString("product_src"));
				products.setProduct_type(resultSet.getString("product_type"));
				products.setNumber(resultSet.getInt("number"));
				list.add(products);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return list;
	}

	@Override
	public List<Products> getProductsByIntelligent() {
		List<Products> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM products where product_des = ?";
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, "Hero Intelligent");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products = new Products();
				products.setProduct_id(resultSet.getInt("product_id"));
				products.setProduct_name(resultSet.getString("product_name"));
				products.setProduct_des(resultSet.getString("product_des"));
				products.setProduct_price(resultSet.getInt("product_price"));
				products.setProduct_src(resultSet.getString("product_src"));
				products.setProduct_type(resultSet.getString("product_type"));
				products.setNumber(resultSet.getInt("number"));
				list.add(products);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return list;
	}

	@Override
	public List<Products> getProductsByAgility() {
		List<Products> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM products where product_des = ?";
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, "Hero Agility");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Products products = new Products();
				products.setProduct_id(resultSet.getInt("product_id"));
				products.setProduct_name(resultSet.getString("product_name"));
				products.setProduct_des(resultSet.getString("product_des"));
				products.setProduct_price(resultSet.getInt("product_price"));
				products.setProduct_src(resultSet.getString("product_src"));
				products.setProduct_type(resultSet.getString("product_type"));
				products.setNumber(resultSet.getInt("number"));
				list.add(products);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return list;
	}

	@Override
	public Products productByName(String product_name) {
		Products products = null;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement("SELECT * FROM products where product_name = ?");
			statement.setString(1, product_name);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				products = new Products();
				products.setProduct_id(resultSet.getInt("product_id"));
				products.setProduct_name(resultSet.getString("product_name"));
				products.setProduct_des(resultSet.getString("product_des"));
				products.setProduct_price(resultSet.getInt("product_price"));
				products.setProduct_src(resultSet.getString("product_src"));
				products.setProduct_type(resultSet.getString("product_type"));
				products.setNumber(resultSet.getInt("number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return products;
	}

	@Override
	public boolean insertProduct(Products products) {
		boolean bl = false;

		Connection conn; // tạo kết nối
		PreparedStatement statement = null; // tạo truy vấn
		ResultSet resultSet = null; // chứa kết quả
		// mở kết nối
		conn = Connect.openConnection();
		// tắt auto commit
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		// tạo truy vấn
		try {
			statement = conn.prepareStatement(
					"insert into Products(product_name,product_des,product_price,product_src,product_type,number) values (?,?,?,?,?,?)");
			statement.setString(1, products.getProduct_name());
			statement.setString(2, products.getProduct_des());
			statement.setInt(3, products.getProduct_price());
			statement.setString(4, products.getProduct_src());
			statement.setString(5, products.getProduct_type());
			statement.setInt(6, products.getNumber());
			int i = statement.executeUpdate();
			if (i > 0) {
				bl = true;
				conn.commit();
			} else {
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

	@Override
	public boolean updateProduct(Products products) {
		boolean bl = false;

		Connection conn; // tạo kết nối
		PreparedStatement statement = null; // tạo truy vấn
		ResultSet resultSet = null; // chứa kết quả
		// mở kết nối
		conn = Connect.openConnection();
		// tắt auto commit
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		// tạo truy vấn
		try {
			statement = conn.prepareStatement(
					"update Products set product_des=?,product_price=?,product_src=?,product_type=?,number=? where product_name=?");
			statement.setString(1, products.getProduct_des());
			statement.setInt(2, products.getProduct_price());
			statement.setString(3, products.getProduct_src());
			statement.setString(4, products.getProduct_type());
			statement.setInt(5, products.getNumber());
			statement.setString(6, products.getProduct_name());
			int i = statement.executeUpdate();
			if (i > 0) {
				bl = true;
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		} finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}
		return bl;
	}

	@Override
	public boolean deleteProduct(String product_name) {
		boolean bl = false;

		Connection conn; // tạo kết nối
		PreparedStatement statement = null; // tạo truy vấn
		ResultSet resultSet = null; // chứa kết quả
		// mở kết nối
		conn = Connect.openConnection();
		// tắt auto commit
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		// tạo truy vấn
		try {
			statement = conn.prepareStatement("delete from Products where product_name=?");
			statement.setString(1, product_name);
			int i = statement.executeUpdate();
			if (i > 0) {
				bl = true;
				conn.commit();
			} else {
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

	@Override
	public Products getProductById(int product_id) {
		Products products = new Products();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = Connect.openConnection();
			statement = conn.prepareStatement("select * from Products where product_id = ?");
			statement.setInt(1, product_id);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				products.setProduct_id(product_id);
				products.setProduct_name(resultSet.getString("product_name"));
				products.setProduct_des(resultSet.getString("product_des"));
				products.setProduct_price(resultSet.getInt("product_price"));
				products.setProduct_src(resultSet.getString("product_src"));
				products.setProduct_type(resultSet.getString("product_type"));
				products.setNumber(resultSet.getInt("number"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Connect.closeConnection(conn);
			Connect.closeStatement(statement);
			Connect.closeResultSet(resultSet);
		}	
		return products;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
