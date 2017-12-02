package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Order;
import library.LibraryString;


public class ModelOrder {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public int getId(String cmt, String link){
		int idorder=0;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM order1 WHERE cmt = ? AND link = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cmt);
			pst.setString(2, link);
			rs = pst.executeQuery();
			if(rs.next()){
				idorder = rs.getInt("idorder");
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
		return idorder;
	}
		public int addItem(Order objOrder){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql = "INSERT INTO order1(name,cmt,email,address,phone,link,notes,price,type) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objOrder.getFullName());
			pst.setString(2, objOrder.getCmt());
			pst.setString(3, objOrder.getEmail());
			pst.setString(4, objOrder.getAddress());
			pst.setString(5, objOrder.getPhoneNumber());
			pst.setString(6, objOrder.getLink());
			pst.setString(7, objOrder.getNotes());
			pst.setFloat(8, objOrder.getPrice());
			pst.setBoolean(9, false);
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
	
	public int delItem(int rid){
		ModelStatus mStatus = new ModelStatus();
		mStatus.delList(rid);
		int result = 0;
		String sql = "DELETE FROM order1 WHERE idorder = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rid);
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
	
	public Order getItem(int rid){
		Order objOrder = null;
		String sql = "SELECT * FROM order1 WHERE idorder = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idorder = rs.getInt("idorder");
				String name = rs.getString("name");
				String cmt = rs.getString("cmt");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String link = rs.getString("link");
				String notes = rs.getString("notes");
				Float price = rs.getFloat("price");
				objOrder = new Order(idorder, name, cmt, email, address, phone, link, notes, price);
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
		return objOrder;
	}
	public int editItem(Order objOrder){
		int result = 0;
		String sql ="UPDATE order1 SET name = ?, cmt = ?, email = ?, address = ?, phone = ?, link = ?, notes = ?, price = ? WHERE idorder = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objOrder.getFullName());
			pst.setString(2, objOrder.getCmt());
			pst.setString(3, objOrder.getEmail());
			pst.setString(4, objOrder.getAddress());
			pst.setString(5, objOrder.getPhoneNumber());
			pst.setString(6, objOrder.getLink());
			pst.setString(7, objOrder.getNotes());
			pst.setFloat(8, objOrder.getPrice());
			pst.setInt(9, objOrder.getIdorder());
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
		String sql ="SELECT COUNT(idorder) AS sodong FROM order1";
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
	public int setActive(int nid, int active) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(active == 0){	
				String sql = "UPDATE order1 SET type = 1 WHERE idorder =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}else{ 
				String sql = "UPDATE order1 SET type = 0 WHERE idorder =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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
	public int getSoDon(){
		int sodon = 0;
		String sql ="SELECT COUNT(idorder) AS sodon FROM order1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				sodon = rs.getInt("sodon");
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
		return sodon;
	}
	
	public ArrayList<Order> getListForSearch(String item){
		ArrayList<Order> alOrder = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM order1 WHERE name LIKE '%"+item+"%' OR email LIKE '%"+item+"%'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idOrder = rs.getInt("idorder");
				String name = rs.getString("name");
				String cmt = rs.getString("cmt");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				String link = rs.getString("link");
				String notes = rs.getString("notes");
				int price = rs.getInt("price");
				boolean  typeProduct = rs.getBoolean("type");
				Order objPro = new Order(idOrder, name, cmt, email, address, phoneNumber, link, notes, price, typeProduct);
				alOrder.add(objPro);
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
		return alOrder;
	}
	
	
	public ArrayList<Order> getListForSearch1(String item){
		ArrayList<Order> alOrder = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM order1 WHERE idorder = "+item+" OR phone = "+item+"";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idOrder = rs.getInt("idorder");
				String name = rs.getString("name");
				String cmt = rs.getString("cmt");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				String link = rs.getString("link");
				String notes = rs.getString("notes");
				int price = rs.getInt("price");
				boolean  typeProduct = rs.getBoolean("type");
				Order objPro = new Order(idOrder, name, cmt, email, address, phoneNumber, link, notes, price, typeProduct);
				alOrder.add(objPro);
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
		return alOrder;
	}
	public ArrayList<Order> getListForPagination(int offset, int rowCount){
		ArrayList<Order> alOr = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM order1 LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idOrder = rs.getInt("idorder");
				String name = rs.getString("name");
				String cmt = rs.getString("cmt");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phone");
				String link = rs.getString("link");
				String notes = rs.getString("notes");
				int price = rs.getInt("price");
				boolean  typeProduct = rs.getBoolean("type");
				Order objOr = new Order(idOrder, name, cmt, email, address, phoneNumber, link, notes, price, typeProduct);
				alOr.add(objOr);
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
		return alOr;
	}
	public int checkLink(String link) {
		int result=0;
		if (link.contains("taobao.com") == true) {
			result=1;
		} else {
			if (link.contains("ebay.com")== true) {
				result=2;
			}
		}
		return result;
	}
}
