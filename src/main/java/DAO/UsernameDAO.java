package DAO;

import java.util.List;

import Model.Account;

public interface UsernameDAO {
	
	//hiển thị bảng user người dùng trong trang admin
	public List<Account> getAccount();
	
	//tạo username
	public boolean insertUsername(Account acc);
	
	//kiểm tra tài khoản đã tồn tại chưa
	public boolean exists(String username, String password);
	
	//hiển thị bảng user người dùng theo số lượng nhất định
	public List<Account> pagingAccount(int index);
	
	//hiển thị thanh danh sách trang người dùng
	public int getTotalAccount();
	
	//lấy lên tài khoản người dùng để set vào session
	public Account getAccountSession(String username);
}
