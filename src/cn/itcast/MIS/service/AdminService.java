package cn.itcast.MIS.service;
import java.sql.SQLException;
import java.util.ArrayList;
import cn.itcast.MIS.dao.AdminDao;
import cn.itcast.MIS.data.DataBase;
import cn.itcast.MIS.domain.LampItem;
/*
 * ����Ա������
 */
public class AdminService {
	private AdminDao adminDao = new AdminDao();
	//��ѯ����
	public ArrayList<LampItem> queryLampItem(){
		//����DAO��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<LampItem> data = adminDao.queryAllData();
		//��������
		return data;
	}
	//��ӷ���
	public boolean addLampItem(String number, String name, String price, String unit) {
		//����DAO��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<LampItem> data = queryLampItem();
		//ʹ������ı�����������ݶԱ�
		for(int i = 0; i < data.size(); i++) {
			LampItem lampItem = data.get(i);
			//��������ظ�������ݣ�����Ӳ��ɹ�
			if(number.equals(lampItem.getNumber())) {
				return false;
			}
		}
		//���û���ظ���ţ������ݷ�װΪLampItem����
		LampItem thisLampItem = new LampItem(number, name, Double.parseDouble(price), unit);
		//����DAO���������ݷ���
		adminDao.addLampItem(thisLampItem);
		//��������ݺ󣬷�����ӳɹ�
		
		
		// ��ӵ����ݿ���
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
	
	
	//�޸ķ���
	public boolean updateLampItem(String number, String name, String price, String unit) {
		//����DAO��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<LampItem> data = queryLampItem();
		//ʹ������ı�����������ݶԱ�
		for(int i = 0; i < data.size(); i++) {
			LampItem lampItem = data.get(i);
			//���������ͬ�ı�����ݣ�����Ը���
			if(number.equals(lampItem.getNumber())) {
				//����DAO���ɾ��ָ��������ݷ���
				adminDao.delLampItem(number);
				//���û���ظ���ţ������ݷ�װΪLampItem����
				LampItem thisLampItem = new LampItem(number, name, Double.parseDouble(price), unit);
				//����DAO���������ݷ���
				adminDao.addLampItem(thisLampItem);
				
				//�޸����ݿ�����Ϣ
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
		//�����������ͬ������ݣ��򲻿��Ը���
		return false;
	}
	
	
	//ɾ������
	public boolean delLampItem(String delNumber) {
		//����DAO��Ļ�ȡ�������ݷ�����ȡ��������
		ArrayList<LampItem> data = queryLampItem();
		//ʹ������ı�����������ݶԱ�
		for(int i = 0; i < data.size(); i++) {
			LampItem lampItem = data.get(i);
			//���������ͬ������ݣ������ɾ��
			if(delNumber.equals(lampItem.getNumber())) {
				//����DAO���ɾ��ָ��������ݷ���
				adminDao.delLampItem(delNumber);
				//��ɾ�����ݺ󣬷�����ӳɹ�
				
				// ɾ�����ݿ�������
				try {
					new DataBase().deleteFromDatabase(delNumber);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		//�����������ͬ������ݣ��򲻿���ɾ��
		return false;
	}
}
