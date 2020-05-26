package page;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dbmethod1.CallMethod;
import dbmethod1.JavaList;
import dbmethod1.JavaStore;
import dbmethod1.JavaUser;
import javax.swing.SwingConstants;

public class MyInfoPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	

	/**
	 * Launch the application.
	 * @param jhA 
	 * @param js 
	 */
	public static void main(JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInfoPage frame = new MyInfoPage(jm,js,jhA);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param jm 
	 * @param jhA 
	 * @param js 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MyInfoPage(JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) throws SQLException, ClassNotFoundException {
		//ȸ������ â�� ���� ȸ���� ������ ȸ���� ���״� ���Ŀ� ���� ������ �ʿ��ϴ�.
		//���� ���·δ� ȸ����ü�� �ִٸ� ����ϴ�.
		CallMethod cm=new CallMethod();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(672, 0, 528, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyInfo = new JLabel("\uB0B4\uC815\uBCF4");
		lblMyInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyInfo.setBounds(193, 12, 73, 27);
		contentPane.add(lblMyInfo);
		
		JLabel lblMyId = new JLabel();
		
		lblMyId.setText("ID : "+jm.getId());
		//���̵� ǥ�õǴ� ���� ȣ��� ���ڷι��� ȸ����ü jm�� ���̵�κ��� �̾Ƽ� txt�� ����Ѵ�.
		
		lblMyId.setBounds(14, 48, 62, 18);
		contentPane.add(lblMyId);
		
		JLabel lblPayList = new JLabel("\uC8FC\uBB38\uB0B4\uC5ED");
		lblPayList.setBounds(14, 91, 62, 18);
		contentPane.add(lblPayList);
		
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ȸ������â�� �α׾ƿ� ��ư�� Ŭ����
				int i = JOptionPane.showConfirmDialog(null,"�α׾ƿ� �Ͻðڽ��ϱ�?","�α׾ƿ� Ȯ��â",JOptionPane.YES_NO_OPTION);
				if(i==0) {
					dispose();
					LoginPage.main(null);
					//confirmdailog���� ���� ������ ���� â�� �ݰ� LoginPage�� ����
				}//if-end
			}
		});
		btnLogout.setBounds(358, 58, 116, 51);
		contentPane.add(btnLogout);
		
		
		
		
		
		JButton btn_Back = new JButton("\uCDE8\uC18C");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ȸ������â�� ��� Ŭ����.
				dispose();
				//�׳� ȸ������â�� �ݴ´�.
				MainPage.main(jm, js, jhA);
			}
		});
		btn_Back.setBounds(97, 296, 304, 27);
		contentPane.add(btn_Back);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 135, 474, 136);
		contentPane.add(scrollPane);
		
		
		
		ArrayList<JavaList> alH=cm.getHistory(jm);
		String[] col= {"���Ը�","�޴��̸�","����","�ֹ� ��¥"};
		String[][] data=new String[alH.size()][4];
		for(int i=0;i<alH.size();i++) {
			data[i][0]=alH.get(i).getSname();
			data[i][1]=alH.get(i).getMname();
			data[i][2]=String.valueOf(alH.get(i).getMprice());
			data[i][3]=alH.get(i).getImagefile();
		}
		//col�� �ֹ���¥��� �迭�ϳ��� �߰�
		//2���� �迭 data�� �� ���� 3->4�� ����
		//data[i][3]=alH.get(i).getImagefile();
		//�߰�, vo������ �ʹ������ �׳� �̹������ϸ��� �����̾����� 
		//��¥�� string���� �޾Ƽ� �����ϵ��� ����.
		DefaultTableModel model=new DefaultTableModel(data,col){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
                return false;
             }
        };
		
		table=new JTable(model);
		
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		
		scrollPane.setViewportView(table);
		
	}
}
