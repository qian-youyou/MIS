package cn.itcast.MIS.view;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import cn.itcast.MIS.tools.GUITools;
/**
 * ��������
 */
@SuppressWarnings("serial")
public abstract class AbstractAdminDialog extends JDialog {
	//�������ʹ�õ��������Ϊ��Ա����
	private JLabel tableLabel = new JLabel("·���б�");//·���б����
	private JScrollPane tablePane = new JScrollPane();	//�����ӿ�
	protected JTable table = new JTable();	//·���б�
	private JLabel numberLabel = new JLabel("·�Ʊ��");//��ű���
	private JLabel nameLabel = new JLabel("����·��");//·�α���
	private JLabel priceLabel = new JLabel("ά�޷���");//���ñ���
	private JLabel unitLabel = new JLabel("����״��");//״̬����
	//��ӹ������
	protected JTextField addNumberText = new JTextField(6);//��ӱ���ı���
	protected JTextField addNameText = new JTextField(6);//���·���ı���
	protected JTextField addPriceText = new JTextField(6);//��ӷ����ı���
	protected JTextField addUnitText = new JTextField(6);//���״̬�ı���
	private JButton addBtn = new JButton("���·��");//��Ӱ�ť
	//�޸Ĺ������
	protected JTextField updateNumberText = new JTextField(6);//�޸ı���ı���
	protected JTextField updateNameText = new JTextField(6);//�޸�·���ı���
	protected JTextField updatePriceText = new JTextField(6);//�޸ķ����ı���
	protected JTextField updateUnitText = new JTextField(6);//�޸�״̬�ı���
	private JButton updateBtn = new JButton("�޸�·��");//�޸İ�ť
	//ɾ���������
	protected JTextField delNumberText = new JTextField(6);//��ӱ���ı�
	private JButton delBtn = new JButton("ɾ��·��");//ɾ����ť
	//���췽��
	public AbstractAdminDialog() {
		this(null, true);
	}
	public AbstractAdminDialog(Frame owner, boolean modal) {
		super(owner, modal);
		this.init();//��ʼ������
		this.addComponent();//������
		this.addListener();//��Ӽ�����
	}
	//��ʼ������
	private void init() {
		this.setTitle("·�ƹ���  ~made by �ܾ���������κ��");//����
		this.setSize(600, 400);//�����С����
		GUITools.center(this);//���ô�������Ļ�ϵ�λ��
		this.setResizable(false);//���ڴ�С�̶�
	}
	//������
	private void addComponent() {
		//ȡ������
		this.setLayout(null);
		//������
		tableLabel.setBounds(265, 20, 70, 25);
		this.add(tableLabel);
		//���
		table.getTableHeader().setReorderingAllowed(false);//�в����ƶ�
		table.getTableHeader().setResizingAllowed(false);//�����ƶ����
		table.setEnabled(false);	//���ɸ�������
		tablePane.setBounds(50, 50, 500, 200);
		tablePane.setViewportView(table);	//�ӿ�װ����
		this.add(tablePane);
		//�ֶα���
		numberLabel.setBounds(50, 250, 70, 25);
		nameLabel.setBounds(150, 250, 70, 25);
		priceLabel.setBounds(250, 250, 70, 25);
		unitLabel.setBounds(350, 250, 70, 25);
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(priceLabel);
		this.add(unitLabel);
		//�������
		addNumberText.setBounds(50, 280, 80, 25);
		addNameText.setBounds(150, 280, 80, 25);
		addPriceText.setBounds(250, 280, 80, 25);
		addUnitText.setBounds(350, 280, 80, 25);
		this.add(addNumberText);
		this.add(addNameText);
		this.add(addPriceText);
		this.add(addUnitText);
		addBtn.setBounds(460,  280,  90,  25);
		this.add(addBtn);
		//�޸����
		updateNumberText.setBounds(50, 310, 80, 25);
		updateNameText.setBounds(150, 310, 80, 25);
		updatePriceText.setBounds(250, 310, 80, 25);
		updateUnitText.setBounds(350, 310, 80, 25);
		this.add(updateNumberText);
		this.add(updateNameText);
		this.add(updatePriceText);
		this.add(updateUnitText);
		updateBtn.setBounds(460,  310,  90,  25);
		this.add(updateBtn);
		//ɾ�����
		delNumberText.setBounds(50, 340, 80, 25);
		this.add(delNumberText);
		delBtn.setBounds(460,  340,  90,  25);
		this.add(delBtn);
	}
	//��Ӽ�����
	private void addListener() {
		//��Ӱ�ť����
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ӷ���
				addLampItem();
			}
		});
		//�޸İ�ť����
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ӷ���
				updateLampItem();
			}
		});
		//ɾ����ť����
		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ӷ���
				delLampItem();
			}
		});
	}
	//��ѯ����
	public abstract void queryLampItem();
	//��ӷ���
	public abstract void addLampItem();
	//�޸ķ���
	public abstract void updateLampItem();
	//ɾ������
	public abstract void delLampItem();
}
