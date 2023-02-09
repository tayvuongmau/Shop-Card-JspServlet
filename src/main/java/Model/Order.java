package Model;

//chứa thông tin của một sản phẩm trong đơn hàng
public class Order {
	private int order_id;			//id order
	private String name_product;	//tên sản phẩm
	private double totalMoney;		//tổng tiền của giỏ hàng
	
	public Order() {
	}

	public Order(int order_id, String name_product, double totalMoney) {
		super();
		this.order_id = order_id;
		this.name_product = name_product;
		this.totalMoney = totalMoney;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	
}
