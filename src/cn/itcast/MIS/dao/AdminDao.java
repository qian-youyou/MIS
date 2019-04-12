package cn.itcast.MIS.dao;
import java.util.ArrayList;
import cn.itcast.MIS.data.DataBase;
import cn.itcast.MIS.domain.LampItem;
/*
 * 管理员数据访问类
 */
public class AdminDao {
	//获取所有数据
	public ArrayList<LampItem> queryAllData(){
		return DataBase.data;
	}
	//添加数据
	public void addLampItem(LampItem lampItem) {
		DataBase.data.add(lampItem);
	}
	//删除数据
	public void delLampItem(String delNumber) {
		//查询集合中数据
		for(int i = 0; i < DataBase.data.size(); i++) {
			LampItem thisLampItem = DataBase.data.get(i);
			//如果有水果项的编号与传入编号相同，则从集合中删除
			if(thisLampItem.getNumber().equals(delNumber)) {
				DataBase.data.remove(i);
			}
		}
	}
}
