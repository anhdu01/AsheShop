package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.News;


public class ModelNews {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public int addItem(News objNews){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO news(name,preview,detail,picture) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNews.getNameNews());
			pst.setString(2, objNews.getPreviewNews());
			pst.setString(3, objNews.getDetailNews());
			pst.setString(4, objNews.getPicture());
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
	
	public int delItem(int nid){
		int result = 0;
		String sql = "DELETE FROM news WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, nid);
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
	
	public News getItem(int nid){
		News objNews = null;
		String sql = "SELECT * FROM news WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, nid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idNews = rs.getInt("Id");
				String nameNews = rs.getString("Name");
				String previewNews = rs.getString("Preview");
				String detailNews = rs.getString("detail");
				String picture = rs.getString("picture");
				objNews = new News(idNews, nameNews, previewNews, detailNews, picture);
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
		return objNews;
	}
	public int editItem(News objNews){
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(objNews.getPicture().isEmpty()){
				String sql ="UPDATE news SET Name = ?, Preview = ? ,Detail =  ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objNews.getNameNews());
				pst.setString(2, objNews.getPreviewNews());
				pst.setString(3, objNews.getDetailNews());
				pst.setInt(4, objNews.getIdNews());
			}else{
				String sql ="UPDATE news SET Name = ?, Preview = ? ,Detail =  ?, Picture = ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objNews.getNameNews());
				pst.setString(2, objNews.getPreviewNews());
				pst.setString(3, objNews.getDetailNews());
				pst.setString(4, objNews.getPicture());
				pst.setInt(5, objNews.getIdNews());
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
		String sql ="SELECT COUNT(Id) AS sodong FROM news ";
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
	public ArrayList<News> getListForPagination(int offset, int rowCount){
		ArrayList<News> alNews = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM news  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idNews = rs.getInt("Id");
				String nameNews = rs.getString("Name");
				String previewNews = rs.getString("Preview");
				String detailNews = rs.getString("detail");
				String picture = rs.getString("picture");
				News objNews = new News(idNews, nameNews, previewNews, detailNews, picture);
				alNews.add(objNews);
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
		return alNews;
	}
	public String getPicture(int nid){
		String picture = "";
		conn = mConnect.getConnectSQL();
		String sql = "SELECT Picture FROM news WHERE Id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, nid);
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
	public ArrayList<News> getListForSearch(String item){
		ArrayList<News> alNews = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM news WHERE Name LIKE '%"+item+"%' OR Preview LIKE '%"+item+"%' OR Detail LIKE '%"+item+"%'";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idNews = rs.getInt("Id");
				String nameNews = rs.getString("Name");
				String previewNews = rs.getString("Preview");
				String detailNews = rs.getString("detail");
				String picture = rs.getString("picture");
				News objNews = new News(idNews, nameNews, previewNews, detailNews, picture);
				alNews.add(objNews);
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
		return alNews;
	}
}
