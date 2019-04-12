package cn.itcast.MIS.data;

import java.util.ArrayList;
import java.sql.*;
import cn.itcast.MIS.domain.LampItem;

/**
 * �洢����
 */
public class DataBase {
	static Connection con;
	static Statement st;
	static ResultSet rs;
	public static ArrayList<LampItem> data = new ArrayList<LampItem>();

	public void addToDatabase(String number, String name, double price, String unit) throws SQLException {
		String sql = "insert into road_light (·�Ʊ��, ��������, ά�޷���, ����״��)" + "values (?, ?, ?, ?)";
		PreparedStatement prep = (PreparedStatement)con.prepareStatement(sql);
		prep.setString(1, number);
		prep.setString(2, name);
		prep.setDouble(3, price);
		prep.setString(4, unit);
		prep.executeUpdate();
	}
	public void deleteFromDatabase(String number) throws SQLException {
		String sql = "delete from road_light where ·�Ʊ�� = " + number;
		Statement prep = (Statement)con.createStatement();
		prep.executeUpdate(sql);
	}
	public void updateFromDatabase(String number, String name, double price, String unit) throws SQLException {
		String sql = "update road_light set �������� = ?, ά�޷��� = ?, ����״�� = ? where ·�Ʊ�� = ?";
		PreparedStatement prep = (PreparedStatement)con.prepareStatement(sql);
		prep.setString(1, name);
		prep.setDouble(2, price);
		prep.setString(3, unit);
		prep.setString(4, number);
		prep.executeUpdate();
		prep.executeUpdate(sql);
	}
	
	// ��ʼ����
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/road_light";
			String user = "root";
			String password = "mysql";
			con = DriverManager.getConnection(url, user, password);
			st =con.createStatement();
			String sql = "select * from road_light";
			rs = st.executeQuery(sql);
			while(rs.next()) {
			      data.add(new LampItem(rs.getString("·�Ʊ��"), 
			    		  				rs.getString("��������"),
			    		  				rs.getDouble("ά�޷���"),
			    		  				rs.getString("����״��")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		finally {
//			if(rs !=null)
//			{
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(st != null)
//			{
//				try {
//					st.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(con !=null)
//			{
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
}