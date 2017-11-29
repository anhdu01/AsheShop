package bean;

public class rate {
	private int idrate;
	private String money;
	private float rate;
	public int getIdrate() {
		return idrate;
	}
	public void setIdrate(int idrate) {
		this.idrate = idrate;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public rate(int idrate, String money, float rate) {
		super();
		this.idrate = idrate;
		this.money = money;
		this.rate = rate;
	}
	public rate() {
		super();
	}
	public rate(String money, float rate) {
		super();
		this.money = money;
		this.rate = rate;
	}
		
	
}
