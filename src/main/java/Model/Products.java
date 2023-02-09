package Model;


//chứa thông tin của một sản phẩm trên website
public class Products {
	private int product_id;				//id sản phẩm
	private String product_name;		//tên
	private String product_des; 		//mô tả
	private int product_price;			//giá bán
	private String product_src;			//nguồn
	private String product_type;		//kiểu dữ liệu
	private int number;					//số lượng
	
	public Products() {
	}
	
	public Products(String product_name, String product_des, int product_price,
			String product_src, String product_type, int number) {
		super();
		this.product_name = product_name;
		this.product_des = product_des;
		this.product_price = product_price;
		this.product_src = product_src;
		this.product_type = product_type;
		this.number = number;
	}

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_des() {
		return product_des;
	}
	public void setProduct_des(String product_des) {
		this.product_des = product_des;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_src() {
		return product_src;
	}
	public void setProduct_src(String product_src) {
		this.product_src = product_src;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
