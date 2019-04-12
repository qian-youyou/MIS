package cn.itcast.MIS.service;
import java.sql.SQLException;
import java.util.ArrayList;
import cn.itcast.MIS.dao.AdminDao;
import cn.itcast.MIS.data.DataBase;
import cn.itcast.MIS.domain.LampItem;
/*
 * 管理员服务类
 */
public class AdminService {
	private AdminDao adminDao = new AdminDao();
	//查询服务
	public ArrayList<LampItem> queryLampItem(){
		//调用DAO层的获取所有数据方法获取所有数据
		ArrayList<LampItem> data = adminDao.queryAllData();
		//返回数据
		return data;
	}
	//添加服务
	public boolean addLampItem(String number, String name, String price, String unit) {
		//调用DAO层的获取所有数据方法获取所有数据
		ArrayList<LampItem> data = queryLampItem();
		//使用输入的编号与所有数据对比
		for(int i = 0; i < data.size(); i++) {
			LampItem lampItem = data.get(i);
			//如果存在重复编号数据，则添加不成功
			if(number.equals(lampItem.getNumber())) {
				return false;
			}
		}
		//如果没有重复编号，将数据封装为LampItem对象
		LampItem thisLampItem = new LampItem(number, name, Double.parseDouble(price), unit);
		//调用DAO层的添加数据方法
		adminDao.addLampItem(thisLampItem);
		//在添加数据后，返回添加成功
		
		
		// 添加到数据库中
		try {
			new DataBase().addToDatabase(number, name, Double.parseDouble(price), unit);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	//修改服务
	public boolean updateLampItem(String number, String name, String price, String unit) {
		//调用DAO层的获取所有数据方法获取所有数据
		ArrayList<LampItem> data = queryLampItem();
		//使用输入的编号与所有数据对比
		for(int i = 0; i < data.size(); i++) {
			LampItem lampItem = data.get(i);
			//如果存在相同的编号数据，则可以更新
			if(number.equals(lampItem.getNumber())) {
				//调用DAO层的删除指定编号数据方法
				adminDao.delLampItem(number);
				//如果没有重复编号，将数据封装为LampItem对象
				LampItem thisLampItem = new LampItem(number, name, Double.parseDouble(price), unit);
				//调用DAO层的添加数据方法
				adminDao.addLampItem(thisLampItem);
				
				//修改数据库中信息
				try {
					new DataBase().updateFromDatabase(number, name, Double.parseDouble(price), unit);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		//如果不存在相同编号数据，则不可以更新
		return false;
	}
	
	
	//删除服务
	public boolean delLampItem(String delNumber) {
		//调用DAO层的获取所有数据方法获取所有数据
		ArrayList<LampItem> data = queryLampItem();
		//使用输入的编号与所有数据对比
		for(int i = 0; i < data.size(); i++) {
			LampItem lampItem = data.get(i);
			//如果存在相同编号数据，则可以删除
			if(delNumber.equals(lampItem.getNumber())) {
				//调用DAO层的删除指定编号数据方法
				adminDao.delLampItem(delNumber);
				//在删除数据后，返回添加成功
				
				// 删除数据库中内容
				try {
					new DataBase().deleteFromDatabase(delNumber);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		//如果不存在相同编号数据，则不可以删除
		return false;
	}
}
