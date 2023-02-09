package Model;

//chứa thông tin về một đơn hàng, bao gồm danh sách sản phẩm của đơn hàng, thông tin người mua hàng
public class Orders_detail {
	private int order_id;			//id của order
	private int product_id;			//id sản phẩm
	private int amount_product;		//số lượng sản phẩm mua
	private int order_price;		//giá bán sản phẩm
	
	public Orders_detail() {
	}

	public Orders_detail(int order_id, int product_id, int amount_product, int order_price) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.amount_product = amount_product;
		this.order_price = order_price;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getAmount_product() {
		return amount_product;
	}

	public void setAmount_product(int amount_product) {
		this.amount_product = amount_product;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
}
