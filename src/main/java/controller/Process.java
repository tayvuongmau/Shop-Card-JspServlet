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
 * Servlet implementation class Process
 */
@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Process() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// phần này làm giống như servlet BuyProduct => gọi ra session của giỏ hàng để
		// thao tác với dữ liệu trong giỏ ( ở đây là xoá sản phẩm)
		HttpSession session = request.getSession();
		Cart cart = null;
		Object object = session.getAttribute("cart");
		// nếu giỏ hàng (object) đã tồn tại thì gán object = cart
		if (object != null) {
			cart = (Cart) object;
		} else {
			// nếu object chưa tồn tại thì tạo giỏ hàng mới
			cart = new Cart();
		}
		String id = request.getParameter("product_id");
		//đặc biệt chú ý khi lấy tham số kiểu string nhưng value là số cần thêm method trim() 
		//để bỏ đi khoảng trắng thừa sau đó mới chuyển nó thành dạng số int
		String num = request.getParameter("quantity").trim();
		int product_id = Integer.parseInt(id);
		int quantity = Integer.parseInt(num);
		//nếu tham số quantity = -1 thì remove sản phẩm
		if((quantity == -1) && (cart.getQuantityById(product_id) <= 1)) {
			cart.removeItem(product_id);
		//ngược lại sẽ thêm mới sản phẩm
		}else {
			ProductsDAOImpl productsDAOImpl = new ProductsDAOImpl();
			Products products = productsDAOImpl.getProductById(product_id);
			Item item = new Item(products, products.getNumber(), products.getProduct_price());
			cart.addItem(item);
		}
		
		//update lại list sản phẩm trong giỏ hàng
		List<Item> list = cart.getItems();
		int money = cart.getTotalMoney();
		session.setAttribute("money", money);
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size());
		request.getRequestDispatcher("/template/web/mycart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// phần này làm giống như servlet BuyProduct => gọi ra session của giỏ hàng để
		// thao tác với dữ liệu trong giỏ ( ở đây là xoá sản phẩm)
		HttpSession session = request.getSession();
		Cart cart = null;
		Object object = session.getAttribute("cart");
		// nếu giỏ hàng (object) đã tồn tại thì gán object = cart
		if (object != null) {
			cart = (Cart) object;
		} else {
			// nếu object chưa tồn tại thì tạo giỏ hàng mới
			cart = new Cart();
		}
		// lấy ra id sản phẩm
		String id = request.getParameter("product_id");
		int product_id = Integer.parseInt(id);
		// xoá sản phẩm khỏi giỏ
		cart.removeItem(product_id);
		// load lại giỏ hàng và đưa lại vào session
		List<Item> list = cart.getItems();
		int money = cart.getTotalMoney();
		session.setAttribute("money", money);
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size());
		request.getRequestDispatcher("/template/web/mycart.jsp").forward(request, response);
	}

}
