package bean;

import java.sql.Date;

public class Status {
	private int idstatus;
	private int idorder;
	private String status;
	private Date date;
	public int getIdstatus() {
		return idstatus;
	}
	public void setIdstatus(int idstatus) {
		this.idstatus = idstatus;
	}
	public int getIdorder() {
		return idorder;
	}
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Status(int idstatus, int idorder, String status, Date date) {
		super();
		this.idstatus = idstatus;
		this.idorder = idorder;
		this.status = status;
		this.date = date;
	}
	public Status() {
		super();
	}
	public Status(int idstatus, int idorder, String status) {
		super();
		this.idstatus = idstatus;
		this.idorder = idorder;
		this.status = status;
	}
	public Status(int idorder, String status, Date date) {
		super();
		this.idorder = idorder;
		this.status = status;
		this.date = date;
	}
	
	
	
}
