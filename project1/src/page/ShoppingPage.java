package page;


import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbmethod1.JavaList;
import dbmethod1.JavaStore;
import dbmethod1.JavaUser;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShoppingPage extends JFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private String[][] data;
	private JLabel lbl_pay;
	private int sum=0;
	private ArrayList<JavaList> jhAS =new ArrayList<JavaList>();

	public static void main(JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingPage frame = new ShoppingPage(jm,js,jhA);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShoppingPage(JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) {
		for(int i=0;i<jhA.size();i++)
		{
			jhAS.add(new JavaList(jhA.get(i).getSid(),jhA.get(i).getSname(),jhA.get(i).getMname(),
					jhA.get(i).getMprice(),jhA.get(i).getImagefile()));
		}
		//table������ �����̺�Ʈ�� �Ͼ�� ���� ��Ҹ� ������ ������ ������ �����Ͱ� ���̺� �����ְԵ�
		//�̺�Ʈ�� �Ͼ�� ���̺� ���� �������� jhA�� ��� �ٲ��ָ� ���� ������ ������������.
		//���� ���� jhAS�� �������� �����ؼ� jhA�� �������ְ�
		//�����ϱ� ��ư Ŭ���� jhAS�� �־ ó���ϴ� ������� .....
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_user = new JButton("\uB0B4 \uC815\uBCF4");
		//----------------�������߰�-------------------
		btn_user.setIcon(new ImageIcon("C:\\images\\������\\myinfo.jpg"));
		//----------------�������߰�-------------------
		btn_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//������ ��ư Ŭ����
				dispose();
				MyInfoPage.main(jm, js, jhA);
			}
		});
		btn_user.setBounds(468, 34, 100, 100);
		contentPane.add(btn_user);
		
		JLabel lbl_sum = new JLabel("\uACB0\uC81C\uAE08\uC561");
		lbl_sum.setBounds(311, 392, 79, 58);
		contentPane.add(lbl_sum);
		
		JButton btn_back = new JButton("\uCDE8\uC18C");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��� ��ư Ŭ����
				dispose();
				MainPage.main(jm, js, jhA);
			}
		});
		btn_back.setBounds(311, 501, 257, 27);
		contentPane.add(btn_back);
		
		JButton btn_con = new JButton("\uACB0\uC81C\uD558\uAE30");
		btn_con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�����ϱ� ��ư Ŭ��
				dispose();
				//------------------------------------------------
				PaymentPage.main(lbl_pay.getText(),jm, js, jhA, jhAS);
				//--------------------��ٱ����� ���̺��� ���������� ����� jhAS�� �־ ������.
				
			}
		});
		btn_con.setBounds(311, 462, 257, 27);
		contentPane.add(btn_con);
		
		JButton btn_sitename = new JButton("\uC0AC\uC774\uD2B8\uBA85");
		btn_sitename.setIcon(new ImageIcon("C:\\images\\������\\sitename.jpg"));
		btn_sitename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_sitename.setBounds(14, 34, 400, 100);
		contentPane.add(btn_sitename);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 168, 554, 200);
		contentPane.add(scrollPane);
		
		
		String[] colname = { "no.", "�����̸�", "�޴��̸�", "-", "����", "+", "����" };
		data = new String[jhA.size()][7];
		for (int i = 0; i < jhA.size(); i++) {

			data[i][0] = "no." + i;
			data[i][1] = jhA.get(i).getSname();
			data[i][2] = jhA.get(i).getMname();

			data[i][3] = "-";
			data[i][4] = jhA.get(i).getImagefile();

			data[i][5] = "+";
			data[i][6] = Integer.toString(jhA.get(i).getMprice());

		}//table�� ���� �����͸� ����.
		model = new DefaultTableModel(data, colname) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//����ڰ� ���̺��� ������ �� ���� ��.
		table=new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		int sum=0;
		for(int i=0;i<table.getRowCount();i++) {
			sum+=Integer.parseInt((String) table.getValueAt(i, 6));
		}
		
		lbl_pay = new JLabel(Integer.toString(sum));
		lbl_pay.setBounds(404, 392, 164, 58);
		contentPane.add(lbl_pay);
		
		
	}

	@Override
	//cell�� �����Ͽ� ���콺 �̺�Ʈ Ŭ�� �κ��� override����.
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();

		int col = table.getSelectedColumn();

		if (col == 3) {// ���� -�� ����
			int count = Integer.parseInt((String) table.getValueAt(row, 4));
			model.setValueAt(Integer.toString(Integer.parseInt((String) table.getValueAt(row, 4)) - 1), row, 4);
			model.setValueAt(Integer.toString(Integer.parseInt((String) table.getValueAt(row, 6)) / count * (count - 1)), row,6);
			table.setModel(model);
			
			jhAS.get(row).setImagefile(Integer.toString(Integer.parseInt(jhAS.get(row).getImagefile())-1));
			jhAS.get(row).setMprice(jhAS.get(row).getMprice()/count*(count-1));
			//���⼭ imagefile�� ��θ��� �������� ������.
			//----------------------------------------
			//���������� �� ������ ���� ������ ������ jhA�� ��Ƶ� jhAS���� ���ϴ� �������� �����Ѵ�.
			sum=0;
			for(int i=0;i<table.getRowCount();i++) {
				sum+=Integer.parseInt((String) table.getValueAt(i, 6));
			}
			lbl_pay.setText(Integer.toString(sum));
			//���� �Ѱ��� �󺧿� ������ �ٲ��ִ°�
			int ea=Integer.parseInt((String) table.getValueAt(row, 4));
			if(ea==0) {//-��ư�� ����ٰ� ������ 0�� �Ǹ�
				int j=JOptionPane.showConfirmDialog(null, "�޴��� ���� �Ͻðڽ��ϱ�?", "�޴� ���� Ȯ��â", JOptionPane.YES_NO_OPTION);
				if(j==0) {
					//���̺� ���� ����
					model.removeRow(row);
					table.setModel(model);
					//��ٱ����� �޴��� ������� jhAS������ ����� �Ѵ�.
					jhAS.remove(row);
				}
				else {
					//�ٽ� ������ 0���� 1�� ����. ��Ҹ� ������ ������ 1�� �ٽ� ������ִ� ���̹Ƿ� jhAS�� ������ �ʿ����.
					int reprice=Integer.parseInt(data[row][6])/Integer.parseInt(data[row][4]);
					model.setValueAt(Integer.toString(1), row, 4);
					model.setValueAt(Integer.toString(reprice), row, 6);
					table.setModel(model);
					
					sum=0;
					for(int i=0;i<table.getRowCount();i++) {
						sum+=Integer.parseInt((String) table.getValueAt(i, 6));
						//sum=sum+Integer.parseInt((String) table.getValueAt(i, 6));
					}
					lbl_pay.setText(Integer.toString(sum));
				}
				
			}
		}
		if (col == 5) {//���� +�� ����
			int count = Integer.parseInt((String) table.getValueAt(row, 4));
			model.setValueAt(Integer.toString(Integer.parseInt((String) table.getValueAt(row, 4)) + 1), row, 4);
			model.setValueAt(Integer.toString(Integer.parseInt((String) table.getValueAt(row, 6)) / count * (count + 1)), row,6);
			table.setModel(model);
			
			jhAS.get(row).setImagefile(Integer.toString(Integer.parseInt(jhAS.get(row).getImagefile())+1));
			jhAS.get(row).setMprice(jhAS.get(row).getMprice()/count*(count+1));
			//���⼭ imagefile�� ��θ��� �������� ������.
			//----------------------------------------
			//���������� �� ������ ���� ������ ������ jhA�� ��Ƶ� jhAS���� ���ϴ� �������� �����Ѵ�.
			sum=0;
			for(int i=0;i<table.getRowCount();i++) {
				sum+=Integer.parseInt((String) table.getValueAt(i, 6));
			}
			lbl_pay.setText(Integer.toString(sum));
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
