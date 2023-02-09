package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.impl.ProductsDAOImpl;
import Model.Cart;
import Model.Item;
import Model.Products;

/**
 * Servlet implementation class BuyProduct
 */
@WebServlet("/BuyProduct")
public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = null;
		Object object = session.getAttribute("cart");
		//nếu giỏ hàng (object) đã tồn tại thì gán object = cart
		if(object != null) {
			cart = (Cart) object;
		}else {
			//nếu object chưa tồn tại thì tạo giỏ hàng mới
			cart = new Cart();
		}
		//gọi ra sản phẩm chọn mua thông qua id
		String product_Id = request.getParameter("product_id");
		int product_id = Integer.parseInt(product_Id);
		ProductsDAOImpl productsDAOImpl = new ProductsDAOImpl();
		Products products = productsDAOImpl.getProductById(product_id);
		//tạo đối tượng là sản phẩm chọn mua và đưa tham số là thông in về sản phẩm vào
		Item item = new Item(products, products.getNumber(), products.getProduct_price());
		//thêm sản phẩm vào giỏ
		cart.addItem(item);
		int money = cart.getTotalMoney();
		//tạo 1 list sản phẩm để thêm sản phẩm đc chọn mua vào thông qua cart
		List<Item> list = cart.getItems();
		//đưa money vào session
		session.setAttribute("money", money);
		//đưa cart vào session
		session.setAttribute("cart", cart);
		//đưa số lượng sản phẩm trong list sản phẩm chọn mua vào session để hiện số lượng sản phẩm đã chọn ra trang chủ
		session.setAttribute("size", list.size());
		//chuyển trang về trang chủ
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
