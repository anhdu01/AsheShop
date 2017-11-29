package bean;

public class Order {
	private int idorder;
	private int idUsers;
	private String fullName;
	private String cmt;
	private String email;
	private String address;
	private String phoneNumber;
	private String link;
	private String notes;
	private float price;
	private boolean type;
	
	public Order(int idorder, int idUsers, String fullName, String cmt, String email, String address,
			String phoneNumber, String link, String notes, float price, boolean type) {
		super();
		this.idorder = idorder;
		this.idUsers = idUsers;
		this.fullName = fullName;
		this.cmt = cmt;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.link = link;
		this.notes = notes;
		this.price = price;
		this.type = type;
	}
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	public Order(int idorder, String fullName, String cmt, String email, String address, String phoneNumber,
			String link, String notes, float price) {
		super();
		this.idorder = idorder;
		this.fullName = fullName;
		this.cmt = cmt;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.link = link;
		this.notes = notes;
		this.price = price;
	}
	public Order(int idorder, String fullName, String cmt, String email, String address, String phoneNumber,
			String link, String notes, float price, boolean type) {
		super();
		this.idorder = idorder;
		this.fullName = fullName;
		this.cmt = cmt;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.link = link;
		this.notes = notes;
		this.price = price;
		this.type = type;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public int getIdorder() {
		return idorder;
	}
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
