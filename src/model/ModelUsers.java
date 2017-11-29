package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Users;
import library.LibraryString;


public class ModelUsers {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public int addItem(Users objUsers){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO users(Username,Password,Fullname,Birthday,Address,Phone,Isadmin,Isregister) VALUES (?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUsers.getUserName());
			pst.setString(2,lib.md5(objUsers.getPassWord()));
			pst.setString(3, objUsers.getFullName());
			pst.setDate(4, objUsers.getBirthDay());
			pst.setString(5, objUsers.getAddDress());
			pst.setString(6, objUsers.getPhoneNumber());
			pst.setBoolean(7, false);
			pst.setBoolean(8, false);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int addItem1(Users objUsers){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO users(Username,Password,Fullname,Birthday,Address,Phone,Isadmin,Isregister) VALUES (?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUsers.getUserName());
			pst.setString(2,lib.md5(objUsers.getPassWord()));
			pst.setString(3, objUsers.getFullName());
			pst.setDate(4, objUsers.getBirthDay());
			pst.setString(5, objUsers.getAddDress());
			pst.setString(6, objUsers.getPhoneNumber());
			pst.setBoolean(7, false);
			pst.setBoolean(8, true);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int delItem(int uid){
		int result = 0;
		String sql = "DELETE FROM users WHERE Idusers = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return result;
	}
	
	public Users getItem(int uid){
		Users objUser = null;
		String sql = "SELECT * FROM users WHERE Idusers = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idUser = rs.getInt("Idusers");
				String userName = rs.getString("Username");
				String passWord = rs.getString("Password");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String addDress = rs.getString("Address");
				String phoneNumber = rs.getString("Phone");
				objUser = new Users(idUser, userName, passWord, fullName, birthDay, addDress, phoneNumber);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objUser;
	}
	
	public int editItem(Users objUsers){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE users SET Username = ?,Password = ?, Fullname = ?, Birthday = ?,Address = ?,Phone = ? WHERE Idusers = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUsers.getUserName());
			pst.setString(2,lib.md5(objUsers.getPassWord()));
			pst.setString(3, objUsers.getFullName());
			pst.setDate(4, objUsers.getBirthDay());
			pst.setString(5, objUsers.getAddDress());
			pst.setString(6, objUsers.getPhoneNumber());
			pst.setInt(7, objUsers.getIdUser());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				result = 0;
				e.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<Users> getListForSearch(String item){
		ArrayList<Users> alUsers = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM users WHERE Fullname LIKE '%"+item+"%' OR Username LIKE '%"+item+"%'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idUser = rs.getInt("Idusers");
				String userName = rs.getString("Username");
				String passWord = rs.getString("Password");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String addDress = rs.getString("Address");
				String phoneNumber = rs.getString("Phone");
				boolean isAdmin = rs.getBoolean("Isadmin");
				boolean isRegister = rs.getBoolean("isRegister");
				Users objUser = new Users(idUser, userName, passWord, fullName, birthDay, addDress, phoneNumber, isAdmin, isRegister);
				alUsers.add(objUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alUsers;
	}
	
	public ArrayList<Users> getListForSearch1(String item){
		ArrayList<Users> alUsers = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM users WHERE Phone = "+item+"";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idUser = rs.getInt("Idusers");
				String userName = rs.getString("Username");
				String passWord = rs.getString("Password");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String addDress = rs.getString("Address");
				String phoneNumber = rs.getString("Phone");
				boolean isAdmin = rs.getBoolean("Isadmin");
				boolean isRegister = rs.getBoolean("isRegister");
				Users objUser = new Users(idUser, userName, passWord, fullName, birthDay, addDress, phoneNumber, isAdmin, isRegister);
				alUsers.add(objUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alUsers;
	}
	
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(Idusers) AS sodong FROM users ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				sodong = rs.getInt("sodong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sodong;
	}
	public ArrayList<Users> getListForPagination(int offset, int rowCount){
		ArrayList<Users> alUsers = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM users LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idUser = rs.getInt("Idusers");
				String userName = rs.getString("Username");
				String passWord = rs.getString("Password");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String addDress = rs.getString("Address");
				String phoneNumber = rs.getString("Phone");
				boolean isAdmin = rs.getBoolean("Isadmin");
				boolean isRegister = rs.getBoolean("isRegister");
				Users objUser = new Users(idUser, userName, passWord, fullName, birthDay, addDress, phoneNumber, isAdmin, isRegister);
				alUsers.add(objUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alUsers;
	}
	public Users getUserByUserPass(String username, String password) {
		Users objUsers = null;
		String sql = "SELECT * FROM users WHERE username = ? && password = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, LibraryString.md5(password));
			rs = pst.executeQuery();
			if(rs.next()){
				int idUser = rs.getInt("Idusers");
				String userName = rs.getString("Username");
				String passWord = rs.getString("Password");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String addDress = rs.getString("Address");
				String phoneNumber = rs.getString("Phone");
				boolean isAdmin = rs.getBoolean("Isadmin");
				boolean isRegister = rs.getBoolean("isRegister");
				objUsers = new Users(idUser, userName, passWord, fullName, birthDay, addDress, phoneNumber, isAdmin, isRegister);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objUsers;
		
	}
	public int checkUser(String username){
		int tontai = 0;
		String sql ="SELECT COUNT(*) AS tontai FROM users Where username = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()){
				tontai = rs.getInt("tontai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tontai;
	}
}
