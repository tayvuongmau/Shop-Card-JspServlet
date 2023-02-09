package DAO;

import Model.Account;
import Model.Cart;

public interface OrderDAO {
	//thêm mới 1 order
	public void addOrder(Account account, Cart cart);
}
