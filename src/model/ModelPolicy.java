package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Policy;


public class ModelPolicy {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public int addItem(Policy objPol){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO policy(name,preview,detail,picture,type) VALUES (?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objPol.getNamePolicy());
			pst.setString(2, objPol.getPreviewPolicy());
			pst.setString(3, objPol.getDetailPolicy());
			pst.setString(4, objPol.getPicture());
			pst.setBoolean(5, true);
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
	
	public int delItem(int pid){
		int result = 0;
		String sql = "DELETE FROM policy WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
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
	
	public Policy getItem(int pid){
		Policy objPolicy = null;
		String sql = "SELECT * FROM policy WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idPolicy = rs.getInt("Id");
				String namePolicy = rs.getString("Name");
				String previewPolicy = rs.getString("Preview");
				String detailPolicy = rs.getString("detail");
				String picture = rs.getString("picture");
				objPolicy = new Policy(idPolicy, namePolicy, previewPolicy, detailPolicy,picture);
				
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
		return objPolicy;
	}
	public int editItem(Policy objPol){
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(objPol.getPicture().isEmpty()){
				String sql ="UPDATE policy SET Name = ?, Preview = ? ,Detail =  ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objPol.getNamePolicy());
				pst.setString(2, objPol.getPreviewPolicy());
				pst.setString(3, objPol.getDetailPolicy());
				pst.setInt(4, objPol.getIdPolicy());
			}else{
				String sql ="UPDATE policy SET Name = ?, Preview = ? ,Detail =  ?, Picture = ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objPol.getNamePolicy());
				pst.setString(2, objPol.getPreviewPolicy());
				pst.setString(3, objPol.getDetailPolicy());
				pst.setString(4, objPol.getPicture());
				pst.setInt(5, objPol.getIdPolicy());
			}
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
		String sql ="SELECT COUNT(Id) AS sodong FROM policy ";
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
	
	public ArrayList<Policy> getListForSearch(String item){
		ArrayList<Policy> alPol = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM policy WHERE Name LIKE '%"+item+"%' OR Preview LIKE '%"+item+"%' OR Detail LIKE '%"+item+"%'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idPolicy = rs.getInt("Id");
				String namePolicy = rs.getString("Name");
				String previewPolicy = rs.getString("Preview");
				String detailPolicy = rs.getString("detail");
				String picture = rs.getString("picture");
				boolean  typePolicy = rs.getBoolean("Type");
				Policy objPol = new Policy(idPolicy, namePolicy, previewPolicy, detailPolicy, picture, typePolicy);
				alPol.add(objPol);
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
		return alPol;
	}
	
	public ArrayList<Policy> getListForPagination(int offset, int rowCount){
		ArrayList<Policy> alPol = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM policy  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idPolicy = rs.getInt("Id");
				String namePolicy = rs.getString("Name");
				String previewPolicy = rs.getString("Preview");
				String detailPolicy = rs.getString("detail");
				String picture = rs.getString("picture");
				boolean  typePolicy = rs.getBoolean("Type");
				Policy objPol = new Policy(idPolicy, namePolicy, previewPolicy, detailPolicy, picture, typePolicy);
				alPol.add(objPol);
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
		return alPol;
	}
	public ArrayList<Policy> getListForPagination1(int offset, int rowCount){
		ArrayList<Policy> alPol = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM policy WHERE type = true LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idPolicy = rs.getInt("Id");
				String namePolicy = rs.getString("Name");
				String previewPolicy = rs.getString("Preview");
				String detailPolicy = rs.getString("detail");
				String picture = rs.getString("picture");
				boolean  typePolicy = rs.getBoolean("Type");
				Policy objPol = new Policy(idPolicy, namePolicy, previewPolicy, detailPolicy, picture, typePolicy);
				alPol.add(objPol);
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
		return alPol;
	}
	public String getPicture(int pid){
		String picture = "";
		conn = mConnect.getConnectSQL();
		String sql = "SELECT Picture FROM policy WHERE Id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			if(rs.next()){
				picture = rs.getString("Picture");
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
		return picture;
	}
	
	public int setActive(int pid, int active) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(active == 0){	// không sửa hình
				String sql = "UPDATE policy SET Type = 1 WHERE Id =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, pid);
			}else{ // có sửa hình
				String sql = "UPDATE policy SET Type = 0 WHERE Id =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, pid);
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
}
