package bean;

public class Product {
	private int idproduct;
	private int idorder;
	private String name;
	private String price;
	private String url;
	private String image;
	private float weight;
	private float cost;
	private float costLocal;
	private float paid;
	public int getIdorder() {
		return idorder;
	}
	
	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getCostLocal() {
		return costLocal;
	}

	public void setCostLocal(float costLocal) {
		this.costLocal = costLocal;
	}
	
	public float getPaid() {
		return paid;
	}

	public void setPaid(float paid) {
		this.paid = paid;
	}

	public Product(int idorder, String name, String price, String url, String image, float weight, float cost, float costLocal, float paid) {
		super();
		this.idorder = idorder;
		this.name = name;
		this.price = price;
		this.url = url;
		this.image = image;
		this.weight = weight;
		this.cost = cost;
		this.costLocal = costLocal;
		this.paid = paid;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String price, String url, String image) {
		super();
		this.name = name;
		this.price = price;
		this.url = url;
		this.image = image;
	}
	
	public Product(int idproduct, int idorder, String name, String price, String url, String image) {
		super();
		this.idproduct = idproduct;
		this.idorder = idorder;
		this.name = name;
		this.price = price;
		this.url = url;
		this.image = image;
	}

	public Product(int idproduct, int idorder, String name, String price, String url, String image, float weight) {
		super();
		this.idproduct = idproduct;
		this.idorder = idorder;
		this.name = name;
		this.price = price;
		this.url = url;
		this.image = image;
		this.weight = weight;
	}

	public Product(int idproduct, int idorder, String name, String price, String url, String image, float weight, float cost, float costLocal, float paid) {
		super();
		this.idproduct = idproduct;
		this.idorder = idorder;
		this.name = name;
		this.price = price;
		this.url = url;
		this.image = image;
		this.weight = weight;
		this.cost = cost;
		this.costLocal = costLocal;
		this.paid = paid;
	}

	public Product(int idproduct, float weight, float cost, float costLocal,float paid) {
		super();
		this.idproduct = idproduct;
		this.weight = weight;
		this.cost = cost;
		this.costLocal = costLocal;
		this.paid = paid;
	}
	
	
}