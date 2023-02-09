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

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product_name = request.getParameter("product_name");
		
		boolean bl = new ProductsDAOImpl().deleteProduct(product_name);
		if(bl) {
			request.setAttribute("success", "Xoá thành công !");
		}else {
			request.setAttribute("err", "Xoá thất bại !");
		}
		
		//lấy lại cái ruột của servlet loadProductAdmin để nó load lại trang
				String indexPage = request.getParameter("index");
				if (indexPage == null) {
					indexPage = "1";
				}
				int index = Integer.parseInt(indexPage);
				ProductsDAOImpl productsDAOImpl = new ProductsDAOImpl();
				List<Products> product = new ProductsDAOImpl().pagingProducts(index);
				int count = productsDAOImpl.getTotalProduct();
				int endPage = count / 8;
				if (count % 8 != 0) {
					endPage++;
				}
				request.setAttribute("endPage", endPage);
				request.setAttribute("list", product);
				request.getRequestDispatcher("/template/admin/tables.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
