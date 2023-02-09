package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.impl.UsernameDAOImpl;
import Model.Account;

@WebServlet("/LoadUsername")
public class LoadUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoadUsername() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		UsernameDAOImpl usernameDAOImpl = new UsernameDAOImpl();
		int count = usernameDAOImpl.getTotalAccount();
		List<Account> accounts = usernameDAOImpl.pagingAccount(index);
		
		int endPage = count/10;
		if(count % 10 != 0) {
			endPage++;
		}
		request.setAttribute("account", accounts);
		request.setAttribute("endPage", endPage);
		request.getRequestDispatcher("/template/admin/charts.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
