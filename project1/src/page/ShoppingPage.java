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
		//table내에서 수량이벤트가 일어나도 현재 취소를 누르고 들어오면 기존의 데이터가 테이블에 남아있게됨
		//이벤트가 일어날때 테이블에 들어가는 데이터인 jhA를 계속 바꿔주면 위의 사항이 유지되지않음.
		//같은 형인 jhAS를 전역변수 선언해서 jhA를 대입해주고
		//결제하기 버튼 클릭시 jhAS를 넣어서 처리하는 방식으로 .....
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_user = new JButton("\uB0B4 \uC815\uBCF4");
		//----------------아이콘추가-------------------
		btn_user.setIcon(new ImageIcon("C:\\images\\아이콘\\myinfo.jpg"));
		//----------------아이콘추가-------------------
		btn_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//내정보 버튼 클릭시
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
				//취소 버튼 클릭시
				dispose();
				MainPage.main(jm, js, jhA);
			}
		});
		btn_back.setBounds(311, 501, 257, 27);
		contentPane.add(btn_back);
		
		JButton btn_con = new JButton("\uACB0\uC81C\uD558\uAE30");
		btn_con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//결제하기 버튼 클릭
				dispose();
				//------------------------------------------------
				PaymentPage.main(lbl_pay.getText(),jm, js, jhA, jhAS);
				//--------------------장바구니의 테이블의 수량변경이 저장된 jhAS를 넣어서 보낸다.
				
			}
		});
		btn_con.setBounds(311, 462, 257, 27);
		contentPane.add(btn_con);
		
		JButton btn_sitename = new JButton("\uC0AC\uC774\uD2B8\uBA85");
		btn_sitename.setIcon(new ImageIcon("C:\\images\\아이콘\\sitename.jpg"));
		btn_sitename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_sitename.setBounds(14, 34, 400, 100);
		contentPane.add(btn_sitename);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 168, 554, 200);
		contentPane.add(scrollPane);
		
		
		String[] colname = { "no.", "가게이름", "메뉴이름", "-", "수량", "+", "가격" };
		data = new String[jhA.size()][7];
		for (int i = 0; i < jhA.size(); i++) {

			data[i][0] = "no." + i;
			data[i][1] = jhA.get(i).getSname();
			data[i][2] = jhA.get(i).getMname();

			data[i][3] = "-";
			data[i][4] = jhA.get(i).getImagefile();

			data[i][5] = "+";
			data[i][6] = Integer.toString(jhA.get(i).getMprice());

		}//table에 넣을 데이터를 저장.
		model = new DefaultTableModel(data, colname) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//사용자가 테이블을 수정할 수 없게 함.
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
	//cell을 선택하여 마우스 이벤트 클릭 부분을 override해줌.
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();

		int col = table.getSelectedColumn();

		if (col == 3) {// 수량 -가 선택
			int count = Integer.parseInt((String) table.getValueAt(row, 4));
			model.setValueAt(Integer.toString(Integer.parseInt((String) table.getValueAt(row, 4)) - 1), row, 4);
			model.setValueAt(Integer.toString(Integer.parseInt((String) table.getValueAt(row, 6)) / count * (count - 1)), row,6);
			table.setModel(model);
			
			jhAS.get(row).setImagefile(Integer.toString(Integer.parseInt(jhAS.get(row).getImagefile())-1));
			jhAS.get(row).setMprice(jhAS.get(row).getMprice()/count*(count-1));
			//여기서 imagefile인 경로명은 수량으로 쓰였다.
			//----------------------------------------
			//수량조절이 될 때마다 전역 변수로 선언한 jhA를 담아둘 jhAS에서 변하는 수량들을 저장한다.
			sum=0;
			for(int i=0;i<table.getRowCount();i++) {
				sum+=Integer.parseInt((String) table.getValueAt(i, 6));
			}
			lbl_pay.setText(Integer.toString(sum));
			//위는 총가격 라벨에 가격을 바꿔주는것
			int ea=Integer.parseInt((String) table.getValueAt(row, 4));
			if(ea==0) {//-버튼을 누루다가 수량이 0이 되면
				int j=JOptionPane.showConfirmDialog(null, "메뉴를 삭제 하시겠습니까?", "메뉴 삭제 확인창", JOptionPane.YES_NO_OPTION);
				if(j==0) {
					//테이블 그행 삭제
					model.removeRow(row);
					table.setModel(model);
					//장바구니의 메뉴가 사라지면 jhAS에서도 빼줘야 한다.
					jhAS.remove(row);
				}
				else {
					//다시 수량을 0에서 1로 수정. 취소를 눌러서 수량을 1로 다시 만들어주는 것이므로 jhAS의 변경은 필요없다.
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
		if (col == 5) {//수량 +가 선택
			int count = Integer.parseInt((String) table.getValueAt(row, 4));
			model.setValueAt(Integer.toString(Integer.parseInt((String) table.getValueAt(row, 4)) + 1), row, 4);
			model.setValueAt(Integer.toString(Integer.parseInt((String) table.getValueAt(row, 6)) / count * (count + 1)), row,6);
			table.setModel(model);
			
			jhAS.get(row).setImagefile(Integer.toString(Integer.parseInt(jhAS.get(row).getImagefile())+1));
			jhAS.get(row).setMprice(jhAS.get(row).getMprice()/count*(count+1));
			//여기서 imagefile인 경로명은 수량으로 쓰였다.
			//----------------------------------------
			//수량조절이 될 때마다 전역 변수로 선언한 jhA를 담아둘 jhAS에서 변하는 수량들을 저장한다.
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
