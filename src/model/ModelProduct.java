package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Product;
import library.LibraryString;
import sun.security.util.Length;


public class ModelProduct {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public int addItem(Product obj){
		int result = 0;
			conn = mConnect.getConnectSQL();
			String sql ="INSERT INTO product(idorder,name,price,url,image,weight,cost,costLocal,paid) VALUES (0,?,?,?,?,0,0,0,0)";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, obj.getName());
				pst.setString(2, obj.getPrice());
				pst.setString(3, obj.getUrl());
				pst.setString(4, obj.getImage());
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
	public int addId(String link, int id){
		int result = 0;
			conn = mConnect.getConnectSQL();
			String sql ="UPDATE product SET idorder= ? WHERE url LIKE '%"+link+"%' AND idorder=0 LIMIT 1";
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
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
	public int addId1(String link, int id){
		int result = 0;
			conn = mConnect.getConnectSQL();
			String sql ="UPDATE product SET idorder= ? WHERE url = '' AND idorder=0 AND image = '' LIMIT 1";
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
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
	public Product getItem(int id, String link){
		Product objPro = null;
		String sql = "SELECT * FROM product WHERE idorder = ? AND url LIKE '%"+link+"%'";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				int idpro =rs.getInt("idproduct");
				int idor =rs.getInt("idorder");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String url = rs.getString("url");
				String image = rs.getString("image");
				float weight = rs.getFloat("weight");
				float cost = rs.getFloat("cost");
				float costLocal = rs.getFloat("costLocal");
				float paid = rs.getFloat("paid");
				objPro = new Product(idpro, idor, name, price, url, image, weight, cost, costLocal, paid);
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
		return objPro;
	}
	
	public Product getItem1(int id){
		Product objPro = null;
		String sql = "SELECT * FROM product WHERE idorder = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				int idpro =rs.getInt("idproduct");
				int idor = rs.getInt("idorder");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String url = rs.getString("url");
				String image = rs.getString("image");
				float weight = rs.getFloat("weight");
				float cost = rs.getFloat("cost");
				float costLocal = rs.getFloat("costLocal");
				float paid = rs.getFloat("paid");
				objPro = new Product(idpro,idor, name, price, url, image, weight, cost, costLocal, paid);
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
		return objPro;
	}
	public Product getItem2(int id){
		Product objPro = null;
		String sql = "SELECT * FROM product WHERE idproduct = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				int idpro =rs.getInt("idproduct");
				int idor = rs.getInt("idorder");
				String name = rs.getString("name");
				String price = rs.getString("price");
				String url = rs.getString("url");
				String image = rs.getString("image");
				float weight = rs.getFloat("weight");
				float cost = rs.getFloat("cost");
				float costLocal = rs.getFloat("costLocal");
				float paid = rs.getFloat("paid");
				objPro = new Product(idpro,idor, name, price, url, image, weight, cost, costLocal, paid);
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
		return objPro;
	}
	public int editItem(Product objPro){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE product SET weight = ?,cost = ?, costLocal = ?, paid = ? WHERE idproduct = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setFloat(1, objPro.getWeight());
			pst.setFloat(2,objPro.getCost());
			pst.setFloat(3,objPro.getCostLocal());
			pst.setFloat(4, objPro.getPaid());
			pst.setInt(5, objPro.getIdproduct());
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
	public float getSum(int id) {
		ModelProduct mPro = new ModelProduct();
		ModelOrder mOr = new ModelOrder();
		return (mPro.getItem1(id).getCost() + mPro.getItem1(id).getCostLocal() + mOr.getItem(id).getPrice());
	}
	public float getSum1(int id) {
		ModelProduct mPro = new ModelProduct();
		return (mPro.getSum(id) - mPro.getItem1(id).getPaid());
	}
	public int editpay(int id,float pay) {
		int result=0;
		ModelProduct mPro = new ModelProduct();
		pay += mPro.getItem1(id).getPaid();
		LibraryString lib = new LibraryString();
		String sql ="UPDATE product SET paid = ? WHERE idorder = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setFloat(1, pay);
			pst.setFloat(2,id);
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
