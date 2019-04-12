package cn.itcast.MIS.domain;
/*
 * 路灯项数据模型
 */
public class LampItem {
	//属性
	private String number;	//编号
	private String name;	//所属路段
	private double price;	//维修价格
	private String unit;	//质量情况
	//构造方法
	public LampItem() {
	}
	public LampItem(String number, String name, double price, String unit) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.unit = unit;
	}
	//get/set方法
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
