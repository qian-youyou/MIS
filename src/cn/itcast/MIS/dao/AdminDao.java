package cn.itcast.MIS.dao;
import java.util.ArrayList;
import cn.itcast.MIS.data.DataBase;
import cn.itcast.MIS.domain.LampItem;
/*
 * ����Ա���ݷ�����
 */
public class AdminDao {
	//��ȡ��������
	public ArrayList<LampItem> queryAllData(){
		return DataBase.data;
	}
	//�������
	public void addLampItem(LampItem lampItem) {
		DataBase.data.add(lampItem);
	}
	//ɾ������
	public void delLampItem(String delNumber) {
		//��ѯ����������
		for(int i = 0; i < DataBase.data.size(); i++) {
			LampItem thisLampItem = DataBase.data.get(i);
			//�����ˮ����ı���봫������ͬ����Ӽ�����ɾ��
			if(thisLampItem.getNumber().equals(delNumber)) {
				DataBase.data.remove(i);
			}
		}
	}
}
