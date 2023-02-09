package DAO;

import java.util.List;

import Model.Products;

public interface ProductsDAO {
	// hiển thị danh sách tất cả sản phẩm
	public List<Products> getProducts();

	// hiển thị danh sách sản phẩm theo trang
	public List<Products> pagingProducts(int index);

	// đếm số sản phẩm trong bảng để thực hiện phân trang
	public int getTotalProduct();

	// tìm kiếm sản phẩm theo tên
	public List<Products> getProductByName(String productName);

	// hiển thị danh sách hero Streng
	public List<Products> getProductsByStreng();

	// hiển thị danh sách hero Streng
	public List<Products> getProductsByIntelligent();

	// hiển thị danh sách hero Streng
	public List<Products> getProductsByAgility();
	
	//lấy ra sản phẩm theo tên để thực hiện chức năng update
	public Products productByName(String product_name);
	
	//lấy ra sản phẩm theo id => phục vụ các thao tác với giỏ hàng
	public Products getProductById(int product_id);
	
	//tạo mới sản phẩm
	public boolean insertProduct(Products products);
	
	//update sản phẩm
	public boolean updateProduct(Products products);
	
	//xoá sản phẩm
	public boolean deleteProduct(String product_name);
}
