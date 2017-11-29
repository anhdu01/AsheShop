package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Status;
import library.LibraryString;


public class ModelStatus {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<Status> getList(int id){
		ArrayList<Status> alStatus = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM status WHERE idorder = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				int idstatus = rs.getInt("idstatus");
				int idorder = rs.getInt("idorder");
				String status = rs.getString("status");
				Date date = rs.getDate("date");
				Status obj = new Status(idstatus, idorder, status, date);
				alStatus.add(obj);
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
		return alStatus;
	}
	
	public Status getItem(int id){
		Status objStatus = new Status();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM status WHERE idstatus = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				int idstatus = rs.getInt("idstatus");
				int idorder = rs.getInt("idorder");
				String status = rs.getString("status");
				Date date = rs.getDate("date");
				objStatus = new Status(idstatus, idorder, status, date);
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
		return objStatus;
	}
	
	public int addItem(Status objStatus){
		int result = 0;
		ModelStatus mStatus = new ModelStatus();
		if (mStatus.checkItem(objStatus) != 0) {
			return result;
		} else {
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO status(idorder,status,date) VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objStatus.getIdorder());
			pst.setString(2,objStatus.getStatus());
			pst.setDate(3,objStatus.getDate());
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
	}
	public int checkItem(Status objStatus){
		int tontai = 0;
		String sql ="SELECT COUNT(*) AS tontai FROM status Where idorder = ? and status = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objStatus.getIdorder());
			pst.setString(2, objStatus.getStatus());
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
	public int editItem(Status objStatus){
		int result = 0;
		ModelStatus mStatus = new ModelStatus();
		if (mStatus.checkItem(objStatus) != 0) {
			return result;
		} else {
		LibraryString lib = new LibraryString();
		String sql ="UPDATE status SET status = ?, date = ? WHERE idstatus = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objStatus.getStatus());
			pst.setDate(2, objStatus.getDate());
			pst.setInt(3, objStatus.getIdstatus());
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
	}

	public int delItem(int id){
		int result = 0;
		String sql = "DELETE FROM status WHERE idstatus = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			result =1;
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
}
