package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.impl.ProductsDAOImpl;
import Model.Products;

/**
 * Servlet implementation class InsertProduct
 */
@WebServlet("/InsertProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String product_name = request.getParameter("product_name");
		String product_des = request.getParameter("product_des");
		int product_price = Integer.parseInt(request.getParameter("product_price")) ;
		String product_src = request.getParameter("product_src");
		String product_type = request.getParameter("product_type");
		int number = Integer.parseInt(request.getParameter("number"));
		Products products = new Products(product_name, product_des, product_price, product_src, product_type, number);
		boolean bl = new ProductsDAOImpl().insertProduct(products);
		if(bl) {
			response.sendRedirect("/PRJ321x_Assignment3/LoadProductAdmin");
		}else {
			request.setAttribute("Err", "Insert false!");
			request.getRequestDispatcher("/template/admin/insertProduct.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
