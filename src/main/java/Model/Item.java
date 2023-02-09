package Model;

//sản phẩm được ng dùng click chọn và ném vào giỏ hàng Cart
public class Item {
	private Products products;		//sản phẩm sẽ được chọn mua
	private int quantity;			//số lượng được chọn mua
	private int price;				//giá sản phẩm người dùng sẽ mua (thực tế giá này và giá trong bảng sản phẩm sẽ khác nhau vì còn sale và khuyến mại các thứ)
	
	public Item() {
	}

	public Item(Products products, int quantity, int price) {
		this.products = products;
		this.quantity = quantity;
		this.price = price;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
