package Model;

import java.util.Date;

public class Account {
	private String username;
	private String password;
	private String email;
	private String phone;
	private Date birthday;
	private String message = "Sai tên đăng nhập hoặc sai mật khẩu";

	public Account() {

	}

	public Account(String username, String password, String email, Date birthday, String phone) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.birthday = birthday;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMessage() {
		return message;
	}

	public boolean validate() {
		if(username == null || username.length() == 0) {
			message ="Tên đăng nhập không hợp lệ";
			return false;
		}
		if(password == null || password.length() < 5 || password.matches("\\w*\\s+\\w*")) {
			message = "Password không hợp lệ";
			return false;
		}
		if(email == null || !email.matches("\\w+@\\w+\\.+\\w+")) {
			message = "Email không hợp lệ";
			return false;
		}
		if(birthday == null) {
			message ="Ngày sinh không được bỏ trống";
			return false;
		}
		if(phone == null || phone.length() != 10 || phone.matches("[0-9]")) {
			message = "Số điện thoại không hợp lệ";
			return false;
		}
		return true;	
	}
}
