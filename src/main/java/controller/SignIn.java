package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.impl.UsernameDAOImpl;
import Model.Account;


@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignIn() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//lay ra tham so action de yeu cau chuyen trang
		String action = request.getParameter("action");
		if(action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			if(action.equals("signin")) {
				request.setAttribute("newname", "");
				request.setAttribute("newpassword", "");
				request.setAttribute("newmail", "");
				request.setAttribute("newtel", "");
				request.setAttribute("newbirthday", "");
				request.getRequestDispatcher("/template/web/signin.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//lấy dữ liệu ra từ input
		String username = request.getParameter("newname");
		String password = request.getParameter("newpassword");
		String email = request.getParameter("newmail");
		String phone = request.getParameter("newtel");
		String birth = request.getParameter("newbirthday");
		//convert dữ liệu nhập vào của birth từ String sang Date
		Date birthday = null;
		if(birth == null || birth == "") {
			request.setAttribute("validateErr", "nhap lai ngay sinh");
		}else {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			try {
				birthday = sd.parse(birth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}	
		//set đối tượng để lưu dữ liệu những ô nhập đúng khi đăng kí có 1 ô bị fail
		request.setAttribute("newname", username);
		request.setAttribute("newpassword", password);
		request.setAttribute("newmail", email);
		request.setAttribute("newtel", phone);
		request.setAttribute("newbirthday", birthday);
		//tạo đối tượng từ Account để lưu dữ liệu nhận vào
		Account acc = new Account(username, password, email, birthday, phone);
		//validate đối tượng
		if(acc.validate()) {
			//kiểm tra tài khoản đã tồn tại hay chưa
			boolean exist = new UsernameDAOImpl().exists(username, password);		
			if(exist) {
				request.setAttribute("validateErr", "Tài khoản đã tồn tại");
				request.getRequestDispatcher("/template/web/signin.jsp").forward(request, response);
			}else {
				//lưu tài khoản xuống database
				boolean bl = new UsernameDAOImpl().insertUsername(acc);
				if(bl) {
					response.sendRedirect("/PRJ321x_Assignment3/index.jsp");
				}
			}
		}
		
		else {
			request.setAttribute("validateErr", acc.getMessage());
			request.getRequestDispatcher("/template/web/signin.jsp").forward(request, response);
		}
	}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		