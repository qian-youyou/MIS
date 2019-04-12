package cn.itcast.MIS.test;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cn.itcast.MIS.view.AbstractAdminDialog;
/*
 * 管理界面测试类
 */
@SuppressWarnings("serial")
public class AbstractAdminDialogTest extends AbstractAdminDialog {
	//构造函数初始化
	public AbstractAdminDialogTest() {
		super();
		queryLampItem();	//测试数据
	}
	//加入测试table数据
	@Override
	public void queryLampItem() {
		String[] thead = new String[] {"路灯编号", "所属路段", "维修价格",
				"质量状况"};
		String[][] tbody = new String[][] {
			{"001", "凤城五路", "100.0", "良好"},
			{"002", "凤城六路", "200.0", "优秀"},
			{"003", "凤城七路", "200.0", "故障"},
			{"004", "凤城八路", "150.0", "良好"}
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
	//定义主函数运行程序
	public static void main(String[] args) {
		//创建界面并显示
		new AbstractAdminDialogTest().setVisible(true);
	}
}
