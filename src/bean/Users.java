package bean;

import java.sql.Date;


public class Users {
	private int idUser;
	private String userName;
	private String passWord;
	private String fullName;
	private Date birthDay;
	private String addDress;
	private String phoneNumber;
	private boolean isAdmin;
	private boolean isRegister;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddDress() {
		return addDress;
	}
	public void setAddDress(String addDress) {
		this.addDress = addDress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isRegister() {
		return isRegister;
	}
	public void setRegister(boolean isRegister) {
		this.isRegister = isRegister;
	}
	public Users(int idUser, String userName, String passWord, String fullName,
			Date birthDay, String addDress, String phoneNumber,
			boolean isAdmin, boolean isRegister) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.addDress = addDress;
		this.phoneNumber = phoneNumber;
		this.isAdmin = isAdmin;
		this.isRegister = isRegister;
	}
	
	public Users(int idUser, String userName, String passWord, String fullName,
			Date birthDay, String addDress, String phoneNumber) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.addDress = addDress;
		this.phoneNumber = phoneNumber;
	}
	
	public Users(int idUser) {
		super();
		this.idUser = idUser;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isAdmin1(){
        if(userName.equals("admin"))
        {
            return true;
        }        
        return false;
    }

}
