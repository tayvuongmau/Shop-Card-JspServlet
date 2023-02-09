package Model;

import java.util.ArrayList;
import java.util.List;

//thông tin về đơn hàng hiện tại
public class Cart {
	private List<Item> items;

	public Cart() {
		items = new ArrayList<>();
	}
	
	public Cart(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	//lấy ra sản phẩm theo id sau này phục vụ việc thêm vào giỏ hàng (thêm mới hoặc thêm số lượng) hoặc phục vụ việc xoá sản phẩm theo id
	public Item getItemById	(int product_id) {
		//dùng vòng lặp kiểm tra xem có sản phẩm nào có id giống id tham số truyền vào không
		for(Item i : items) {
			if(i.getProducts().getProduct_id() == product_id) {
				return i;
			}
		}	
		return null;
	}
	
	//trả về số lượng sản phẩm trong giỏ hàng khi biết id
	public int getQuantityById(int product_id) {
		return getItemById(product_id).getQuantity();
	}
	
	//thêm sản phẩm vào giỏ
	public void addItem(Item t) {
		//đã có mặt hàng này trong giỏ rồi => cộng dồn số lượng
		//điều kiện trong if, lấy product_id trong sản phẩm t đưa vào method gọi sản phẩm qua id xem có ra cái gì không
		if(getItemById(t.getProducts().getProduct_id()) != null) {
			//tạo 1 đối tượng sản phẩm cũ là i bằng cách đưa id sản phẩm người dùng chọn vào method getItemById()
			Item i = getItemById(t.getProducts().getProduct_id());
			//đặt lại số lượng sản phẩm i = số lượng sản phẩm cũ có trong giỏ + số lượng sản phẩm mua mới
			i.setQuantity(i.getQuantity() + t.getQuantity());
		}else {
			//sản phẩm chưa có trong giỏ => add vào giỏ
			items.add(t);
		}
	}
	
	//xoá sản phẩm khỏi giỏ dựa vào product_id
	public void removeItem(int product_id) {
		if(getItemById(product_id) != null) {
			items.remove(getItemById(product_id));
		}
	}
	
	//tính tổng tiền tất cả sản phẩm trong giỏ hàng
	public int getTotalMoney() {
		int t = 0;
		//dùng vòng lặp chạy qua mỗi sản phẩm trong giỏ hàng => giá bán 1 sp = số lượng x giá bán
		//tổng tiền t sẽ cộng dồn giá bán mỗi sản phẩm thứ i đó
		for(Item i : items) {
			t += i.getQuantity()*i.getProducts().getProduct_price();
		}
		return t;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
