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
 * 管理员界面操作类
 */
@SuppressWarnings("serial")
public class AdminDialogController extends AbstractAdminDialog {
	//定义服务类，提供完整功能服务
	private AdminService adminService = new AdminService();
	//构造方法
	public AdminDialogController() {
		super();
	}
	public AdminDialogController(Frame owner, boolean modal) {
		super(owner, modal);
		//创建对象时展示数据
		queryLampItem();
	}
	//查询方法
	@Override
	public void queryLampItem() {
		//定义表格头
		String[] thead = {"路灯编号", "所属街区", "维修费用", "质量状况"};
		//调用adminService的查询服务
		ArrayList<LampItem> dataList = adminService.queryLampItem();
		//调用list2Array方法，将查询到的集合转化为数组，方便为JTalbe赋值
		String[][] tbody = list2Array(dataList);
		//将查询到的结果为table赋值
		TableModel dataModel = new DefaultTableModel(tbody, thead);
		table.setModel(dataModel);
	}
	//集合数据转化为二维数组方法
	public String[][] list2Array(ArrayList<LampItem> list){
		//根据LampItem的model与集合数据定义JTable的数据二维数组
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
	//添加方法
	@Override
	public void addLampItem() {
		//获取数据
		String addNumber = addNumberText.getText();
		String addName = addNameText.getText();
		String addPrice = addPriceText.getText();
		String addUnit = addUnitText.getText();
		//调用adminService的添加服务
		boolean addSuccess = adminService.addLampItem(addNumber, addName,
				addPrice, addUnit);
		//如果添加成功
		if(addSuccess) {
			//添加后刷新表格
			queryLampItem();
		}else {
			//没有添加成功弹窗错误显示
			JOptionPane.showMessageDialog(this, "路灯编号不能重复，请重新输入");
		}
	}
	//修改方法
	@Override
	public void updateLampItem() {
		//获取数据
		String updateNumber = updateNumberText.getText();
		String updateName = updateNameText.getText();
		String updatePrice = updatePriceText.getText();
		String updateUnit = updateUnitText.getText();
		//调用adminService的添加服务
		boolean updateSuccess = adminService.updateLampItem(updateNumber, updateName,
				updatePrice, updateUnit);
		//如果添加成功
		if(updateSuccess) {
			//添加后刷新表格
			queryLampItem();
		}else {
			//没有添加成功弹窗错误显示
			JOptionPane.showMessageDialog(this, "没有此路灯");
		}
	}
	//删除方法
	@Override
	public void delLampItem() {
		//获取数据
		String delNumber = delNumberText.getText();
		//调用adminService的删除服务
		boolean delSuccess = adminService.delLampItem(delNumber);
		//如果删除成功
		if(delSuccess) {
			//删除后刷新表格
			queryLampItem();
		}else {
			//如果没有删除成功弹窗错误提示
			JOptionPane.showMessageDialog(this, "没有该路灯");
		}
	}
}
