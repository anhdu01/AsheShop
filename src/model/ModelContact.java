package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Contact;
import library.LibraryString;


public class ModelContact {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public int getLienHe(){
		int lienhe = 0;
		String sql ="SELECT Count(idContact) AS lienhe FROM contact ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				lienhe = rs.getInt("lienhe");
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
		return lienhe;
	}
	public int addItem(Contact objContact){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO contact(fullname,email,address,phone,job,notes) VALUES (?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objContact.getFullname());
			pst.setString(2, objContact.getEmail());
			pst.setString(3, objContact.getAddress());
			pst.setString(4, objContact.getPhone());
			pst.setString(5, objContact.getJob());
			pst.setString(6, objContact.getNotes());
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
	
	public int delItem(int id){
		int result = 0;
		String sql = "DELETE FROM contact WHERE idContact = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
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
	
	public Contact getItem(int id){
		Contact objContact = null;
		String sql = "SELECT * FROM contact WHERE idContact = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				int idContact = rs.getInt("idContact");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String job = rs.getString("job");
				String notes = rs.getString("notes");
				objContact = new Contact(idContact, fullname, email, address, phone, job, notes);
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
		return objContact;
	}
	
	public int editItem(Contact objContact){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE contact SET fullname = ?, email = ?, address = ?, phone = ?, job = ?, notes = ?   WHERE idContact = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objContact.getFullname());
			pst.setString(2, objContact.getEmail());
			pst.setString(3, objContact.getAddress());
			pst.setString(4, objContact.getPhone());
			pst.setString(5, objContact.getJob());
			pst.setString(6, objContact.getNotes());
			pst.setInt(7, objContact.getIdContact());
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
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(idContact) AS sodong FROM contact ";
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
	
	public ArrayList<Contact> getListForSearch(String item){
		ArrayList<Contact> alContact = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM contact WHERE fullname LIKE '%"+item+"%' OR email LIKE '%"+item+"%'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idContact = rs.getInt("idContact");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String job = rs.getString("job");
				String notes = rs.getString("notes");
				Contact objContact = new Contact(idContact, fullname, email, address, phone, job, notes);
				alContact.add(objContact);
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
		return alContact;
	}
	
	
	public ArrayList<Contact> getListForSearch1(String item){
		ArrayList<Contact> alContact = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM contact WHERE phone = "+item+"";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idContact = rs.getInt("idContact");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String job = rs.getString("job");
				String notes = rs.getString("notes");
				Contact objContact = new Contact(idContact, fullname, email, address, phone, job, notes);
				alContact.add(objContact);
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
		return alContact;
	}
	
	public ArrayList<Contact> getListForPagination(int offset, int rowCount){
		ArrayList<Contact> alContact = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM contact LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idContact = rs.getInt("idContact");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String job = rs.getString("job");
				String notes = rs.getString("notes");
				Contact objContact = new Contact(idContact, fullname, email, address, phone, job, notes);
				alContact.add(objContact);
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
		return alContact;
	}
}
