package cn.itcast.MIS.test;
import cn.itcast.MIS.view.AbstractMainFrame;
/**
 * �����ڲ�����
 */
@SuppressWarnings("serial")
public class AbstractMainFrameTest extends AbstractMainFrame {
	//����������
	public static void main(String[] args) {
		new AbstractMainFrameTest().setVisible(true);
	}
	//���Ǹ�����չʾ����Ա����ķ���
	@Override
	public void showAdminDialog() {
		System.out.println("����������");
	}
}
