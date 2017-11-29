package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.rate;
import library.LibraryString;


public class ModelRate {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;	
	public float getRate(String name) {
		float rate = 0;
		conn = mConnect.getConnectSQL();
		String sql = "SELECT rate FROM rate WHERE money = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()){
				rate = rs.getFloat("rate");
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
		return rate;
	}
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(idrate) AS sodong FROM rate ";
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
	
	public ArrayList<rate> getListForPagination(int offset, int rowCount){
		ArrayList<rate> alRate = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM rate LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idrate = rs.getInt("Idrate");
				String money = rs.getString("money");
				Float rate = rs.getFloat("rate");
				rate objRate = new rate(idrate, money, rate);
				alRate.add(objRate);
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
		return alRate;
	}
	public int addItem(rate objRate){
		int result = 0;
		ModelRate mRate = new ModelRate();
		if (mRate.checkItem(objRate) != 0) {
			return result;
		} else {
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO rate(money,rate) VALUES (?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,objRate.getMoney());
			pst.setFloat(2, objRate.getRate());
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
	public int checkItem(rate objRate){
		int tontai = 0;
		String sql ="SELECT COUNT(*) AS tontai FROM rate Where money = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,objRate.getMoney());
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
	
	public int editItem(rate objRate){
		int result = 0;
		ModelRate mRate = new ModelRate();
		LibraryString lib = new LibraryString();
		String sql ="UPDATE rate SET money = ?, rate = ? WHERE idrate = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objRate.getMoney());
			pst.setFloat(2, objRate.getRate());
			pst.setInt(3, objRate.getIdrate());
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
	public rate getItem(int rid){
		rate objRate = new rate();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM rate WHERE idrate = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idrate = rs.getInt("idrate");
				String money = rs.getString("money");
				Float rate = rs.getFloat("rate");
				objRate = new rate(idrate, money, rate);
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
		return objRate;
	}
	public int delItem(int rid){
		int result = 0;
		String sql = "DELETE FROM rate WHERE idrate = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rid);
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
