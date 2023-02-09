package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.impl.UsernameDAOImpl;
import Model.Account;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//lấy ra tham số của action để quyết định chuyển tới trang nào
		String action = request.getParameter("action");
		if(action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else 
			if(action.equals("login")) {
				request.getRequestDispatcher("/template/web/login.jsp").forward(request, response);
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//lấy ra tham số của action
		String action = request.getParameter("action");
		if(action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else 
			if(action.equals("dologin")) {
				
				//lấy dữ liệu về từ input nhập vào
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String savepass = request.getParameter("savepass");
				
				//kiểm tra tài khoản đã tồn tại hay chưa
				boolean exist = new UsernameDAOImpl().exists(username ,password);
				
				//tạo đối tượng từ Acount để lấy biến ra nhận dữ liệu từ input sau còn lấy ra message khi có lỗi liên quan tới đăng nhập
				//thực ra cái này làm hơi sai sách
				Account acc = new Account();
				acc.setUsername(username);
				acc.setPassword(password);
				
				//tạo đối tượng session để đưa biến đi muôn nơi
				HttpSession session = request.getSession();
				
				//lấy tài khoản được thiết lập mặc định trong web.xml
				String id = getServletContext().getInitParameter("username");
				String pass = getServletContext().getInitParameter("password");
				
				//so sánh tài khoản để đăng nhập
				if(username != null &&
				   password != null	&&
				   username.equalsIgnoreCase(id) &&
				   password.equalsIgnoreCase(pass)) {
					//set session 
					session.setAttribute("username", username);
					
					//khi chọn ô lưu mật khẩu => thêm username, password vào cookie để lưu mật khẩu
					if(savepass != null && savepass.equals("save")) {
						//tạo đối tượng cookie để lưu giá trị username , password
						Cookie cUser = new Cookie("username", username);
						Cookie cPass = new Cookie("password", password);
						Cookie cSave = new Cookie("save", "true");
						//thêm đối tượng vào cookie
						response.addCookie(cUser);
						response.addCookie(cPass);
						response.addCookie(cSave);
						//set thời gian tồn tại của đối tượng lưu trong cookie
						cUser.setMaxAge(24*60*60);
						cPass.setMaxAge(24*60*60);
						cPass.setMaxAge(24*60*60);
						
						//chuyển trang bằng response		
						response.sendRedirect("/PRJ321x_Assignment3/template/admin/admin.jsp");
					}else {
						Cookie cUser = new Cookie("username", "");
						Cookie cPass = new Cookie("password", "");
						Cookie cSave = new Cookie("save", "");
						response.addCookie(cUser);
						response.addCookie(cPass);
						response.addCookie(cSave);	
						request.getRequestDispatcher("/template/admin/admin.jsp").forward(request, response);
					}			
				}else 
					if(exist) {
						
						//dùng username để truy vấn lên tài khoản dưới database để đưa vào session
						UsernameDAOImpl usernameDAOImpl = new UsernameDAOImpl();
						Account account = usernameDAOImpl.getAccountSession(username);
						
						//set session 
						session.setAttribute("account", account);
						
						if(savepass != null && savepass.equals("save")) {
							//tạo đối tượng cookie để lưu giá trị username , password
						Cookie cUser = new Cookie("username", username);
						Cookie cPass = new Cookie("password", password);
						Cookie cSave = new Cookie("save", "true");
						//thêm đối tượng vào cookie
						response.addCookie(cUser);
						response.addCookie(cPass);
						response.addCookie(cSave);
						//set thời gian tồn tại của đối tượng lưu trong cookie
						cUser.setMaxAge(24*60*60);
						cPass.setMaxAge(24*60*60);
						cPass.setMaxAge(24*60*60);
						request.getRequestDispatcher("/index.jsp").forward(request, response);
						}
						else {
							Cookie cUser = new Cookie("username", "");
							Cookie cPass = new Cookie("password", "");
							Cookie cSave = new Cookie("save", "");
							response.addCookie(cUser);
							response.addCookie(cPass);
							response.addCookie(cSave);	
							request.getRequestDispatcher("/index.jsp").forward(request, response);
						}
						
						
					}
					else {
					request.setAttribute("Err", acc.getMessage());
					request.getRequestDispatcher("/template/web/login.jsp").forward(request, response);
					}
		
			}else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
