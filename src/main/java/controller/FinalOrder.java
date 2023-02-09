package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.impl.OrderDAOImpl;
import Model.Account;
import Model.Cart;

/**
 * Servlet implementation class FinalOrder
 */
@WebServlet("/FinalOrder")
public class FinalOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FinalOrder() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = null;
		Object object = session.getAttribute("cart");
		int money = (int) session.getAttribute("money");
		if (object != null) {
			cart = (Cart) object;
		} else {
			cart = new Cart();
		}
		Account account = null;
		Object a = session.getAttribute("account");
		if(a != null) {
			account = (Account) a;
			OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
			//lưu thông tin đơn hàng xuống database
			orderDAOImpl.addOrder(account, cart);
			//sau khi chốt lưu xong đơn hàng trước tiến hành xoá session đơn hàng cũ
			session.removeAttribute("cart");
			session.setAttribute("size", 0);
			session.setAttribute("money", 0);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("/PRJ321x_Assignment3/Login?action=login");
		}	
	}

}
