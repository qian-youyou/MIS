package cn.itcast.MIS.controller;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cn.itcast.MIS.domain.LampItem;
import cn.itcast.MIS.service.AdminService;
import cn.itcast.MIS.view.AbstractAdminDialog;
/*
 * ����Ա���������
 */
@SuppressWarnings("serial")
public class AdminDialogController extends AbstractAdminDialog {
	//��������࣬�ṩ�������ܷ���
	private AdminService adminService = new AdminService();
	//���췽��
	public AdminDialogController() {
		super();
	}
	public AdminDialogController(Frame owner, boolean modal) {
		super(owner, modal);
		//��������ʱչʾ����
		queryLampItem();
	}
	//��ѯ����
	@Override
	public void queryLampItem() {
		//������ͷ
		String[] thead = {"·�Ʊ��", "��������", "ά�޷���", "����״��"};
		//����adminService�Ĳ�ѯ����
		ArrayList<LampItem> dataList = adminService.queryLampItem();
		//����list2Array����������ѯ���ļ���ת��Ϊ���飬����ΪJTalbe��ֵ
		String[][] tbody = list2Array(dataList);
		//����ѯ���Ľ��Ϊtable��ֵ
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}
	//��������ת��Ϊ��ά���鷽��
	public String[][] list2Array(ArrayList<LampItem> list){
		//����LampItem��model�뼯�����ݶ���JTable�����ݶ�ά����
		String[][] tbody = new String[list.size()][4];
		for(int i = 0; i < list.size(); i++) {
			LampItem lampItem = list.get(i);
			tbody[i][0] = lampItem.getNumber();
			tbody[i][1] = lampItem.getName();
			tbody[i][2] = lampItem.getPrice()+"";
			tbody[i][3] = lampItem.getUnit();
		}
		return tbody;
	}
	//��ӷ���
	@Override
	public void addLampItem() {
		//��ȡ����
		String addNumber = addNumberText.getText();
		String addName = addNameText.getText();
		String addPrice = addPriceText.getText();
		String addUnit = addUnitText.getText();
		//����adminService����ӷ���
		boolean addSuccess = adminService.addLampItem(addNumber, addName,
				addPrice, addUnit);
		//�����ӳɹ�
		if(addSuccess) {
			//��Ӻ�ˢ�±��
			queryLampItem();
		}else {
			//û����ӳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "·�Ʊ�Ų����ظ�������������");
		}
	}
	//�޸ķ���
	@Override
	public void updateLampItem() {
		//��ȡ����
		String updateNumber = updateNumberText.getText();
		String updateName = updateNameText.getText();
		String updatePrice = updatePriceText.getText();
		String updateUnit = updateUnitText.getText();
		//����adminService����ӷ���
		boolean updateSuccess = adminService.updateLampItem(updateNumber, updateName,
				updatePrice, updateUnit);
		//�����ӳɹ�
		if(updateSuccess) {
			//��Ӻ�ˢ�±��
			queryLampItem();
		}else {
			//û����ӳɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�д�·��");
		}
	}
	//ɾ������
	@Override
	public void delLampItem() {
		//��ȡ����
		String delNumber = delNumberText.getText();
		//����adminService��ɾ������
		boolean delSuccess = adminService.delLampItem(delNumber);
		//���ɾ���ɹ�
		if(delSuccess) {
			//ɾ����ˢ�±��
			queryLampItem();
		}else {
			//���û��ɾ���ɹ�����������ʾ
			JOptionPane.showMessageDialog(this, "û�и�·��");
		}
	}
}
