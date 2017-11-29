package bean;

import java.io.Serializable;

public class Policy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPolicy;
	private String namePolicy;
	private String previewPolicy;
	private String detailPolicy;
	private int pricePolicy;
	private int number;
/*	private int priceBuy;*/
	private String picture;
	private boolean typePolicy;
	
	public Policy(int idPolicy, String namePolicy, String previewPolicy, String detailPolicy, String picture) {
		super();
		this.idPolicy = idPolicy;
		this.namePolicy = namePolicy;
		this.previewPolicy = previewPolicy;
		this.detailPolicy = detailPolicy;
		this.picture = picture;
	}
	public Policy(int idPolicy, String namePolicy, String previewPolicy, String detailPolicy, String picture,
			boolean typePolicy) {
		super();
		this.idPolicy = idPolicy;
		this.namePolicy = namePolicy;
		this.previewPolicy = previewPolicy;
		this.detailPolicy = detailPolicy;
		this.picture = picture;
		this.typePolicy = typePolicy;
	}
	public int getIdPolicy() {
		return idPolicy;
	}
	public void setIdPolicy(int idPolicy) {
		this.idPolicy = idPolicy;
	}
	public String getNamePolicy() {
		return namePolicy;
	}
	public void setNamePolicy(String namePolicy) {
		this.namePolicy = namePolicy;
	}
	public String getPreviewPolicy() {
		return previewPolicy;
	}
	public void setPreviewPolicy(String previewPolicy) {
		this.previewPolicy = previewPolicy;
	}
	public String getDetailPolicy() {
		return detailPolicy;
	}
	public void setDetailPolicy(String detailPolicy) {
		this.detailPolicy = detailPolicy;
	}
	public int getPricePolicy() {
		return pricePolicy;
	}
	public void setPricePolicy(int pricePolicy) {
		this.pricePolicy = pricePolicy;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public boolean isTypePolicy() {
		return typePolicy;
	}
	public void setTypePolicy(boolean typePolicy) {
		this.typePolicy = typePolicy;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	/*public int getPriceBuy() {
		return priceBuy;
	}
	public void setPriceBuy(int priceBuy) {
		this.priceBuy = priceBuy;
	}*/
	public Policy(int idPolicy, String namePolicy, String previewPolicy,
			String detailPolicy, int pricePolicy, String picture,
			boolean typePolicy) {
		super();
		this.idPolicy = idPolicy;
		this.namePolicy = namePolicy;
		this.previewPolicy = previewPolicy;
		this.detailPolicy = detailPolicy;
		this.pricePolicy = pricePolicy;
		this.picture = picture;
		this.typePolicy = typePolicy;
	}
	
	public Policy(int idPolicy, String namePolicy, String previewPolicy,
			String detailPolicy, int pricePolicy, String picture) {
		super();
		this.idPolicy = idPolicy;
		this.namePolicy = namePolicy;
		this.previewPolicy = previewPolicy;
		this.detailPolicy = detailPolicy;
		this.pricePolicy = pricePolicy;
		this.picture = picture;
	}
	
	
/*	public Policy(int idPolicy, String namePolicy, int pricePolicy,
			int number, int priceBuy, String picture) {
		super();
		this.idPolicy = idPolicy;
		this.namePolicy = namePolicy;
		this.pricePolicy = pricePolicy;
		this.number = number;
		this.priceBuy = priceBuy;
		this.picture = picture;
	}*/
		
	public Policy(int idPolicy) {
		super();
		this.idPolicy = idPolicy;
	}
	public Policy(String namePolicy) {
		super();
		this.namePolicy = namePolicy;
	}
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
