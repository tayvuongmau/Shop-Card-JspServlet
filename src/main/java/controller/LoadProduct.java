package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.impl.ProductsDAOImpl;
import Model.Products;


@WebServlet("/LoadProduct")
public class LoadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoadProduct() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//lấy về tham số trang sẽ in ra sản phẩm tương ứng
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		//ép kiểu dữ liệu
		int index = Integer.parseInt(indexPage);
		//tạo đối tượng lấy ra số lượng sản phẩm trong bảng Products
		ProductsDAOImpl productsDAOImpl	= new ProductsDAOImpl();
		//lấy ra tất cả sản phẩm để load lên trang chủ dựa theo số trang giới hạn số lượng sản phẩm từ câu truy vấn
		List<Products> product = new ProductsDAOImpl().pagingProducts(index);
		//khai báo biến nhận dữ liệu là số lượng sản phẩm có trong data
		int count = productsDAOImpl.getTotalProduct();
		//tính số trang sẽ được tạo ra dựa trên số lượng sản phẩm và số sản phẩm muốn hiển thị
		//khai báo 1 biến số trang = cổng sản phẩm / số sản phẩm hiển thị
		int endPage = count/8;
		//nếu chia bị dư sẽ tăng thêm 1 trang
		if(count % 8 != 0) {
			endPage++;
		}
		//gửi req chứa dữ liệu là các ô phân trang
		request.setAttribute("endPage", endPage);	
		//gửi req là dữ liệu chứa các sản phẩm để load lên trang chủ
		request.setAttribute("list", product);
		//chuyển trang kèm theo dữ liệu từ request
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
