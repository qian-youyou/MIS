package cn.itcast.MIS.test;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cn.itcast.MIS.view.AbstractAdminDialog;
/*
 * ������������
 */
@SuppressWarnings("serial")
public class AbstractAdminDialogTest extends AbstractAdminDialog {
	//���캯����ʼ��
	public AbstractAdminDialogTest() {
		super();
		queryLampItem();	//��������
	}
	//�������table����
	@Override
	public void queryLampItem() {
		String[] thead = new String[] {"·�Ʊ��", "����·��", "ά�޼۸�",
				"����״��"};
		String[][] tbody = new String[][] {
			{"001", "�����·", "100.0", "����"},
			{"002", "�����·", "200.0", "����"},
			{"003", "�����·", "200.0", "����"},
			{"004", "��ǰ�·", "150.0", "����"}
		};
		TableModel data = new DefaultTableModel(tbody, thead);
		table.setModel(data);
	}
	@Override
	public void addLampItem() {
	}
	@Override
	public void updateLampItem() {
	}
	@Override
	public void delLampItem() {	
	}
	//�������������г���
	public static void main(String[] args) {
		//�������沢��ʾ
		new AbstractAdminDialogTest().setVisible(true);
	}
}
