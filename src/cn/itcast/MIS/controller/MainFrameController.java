package cn.itcast.MIS.controller;
import cn.itcast.MIS.view.AbstractMainFrame;
/*
 * �����������
 */
@SuppressWarnings("serial")
public class MainFrameController extends AbstractMainFrame {
	@Override
	public void showAdminDialog() {
		//�ڸ÷����д�������Ա���沢��ʾ
		//thisΪ������(������)true:����Ϊģ̬������ʾ
		new AdminDialogController(this, true).setVisible(true);
	}
}
