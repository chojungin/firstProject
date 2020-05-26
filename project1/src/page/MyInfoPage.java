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
		//회원정보 창은 현재 회원의 정보와 회원이 시켰던 음식에 대한 정보가 필요하다.
		//현재 상태로는 회원객체만 있다면 충분하다.
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
		//아이디가 표시되는 곳에 호출시 인자로받은 회원객체 jm의 아이디부분을 뽑아서 txt로 사용한다.
		
		lblMyId.setBounds(14, 48, 62, 18);
		contentPane.add(lblMyId);
		
		JLabel lblPayList = new JLabel("\uC8FC\uBB38\uB0B4\uC5ED");
		lblPayList.setBounds(14, 91, 62, 18);
		contentPane.add(lblPayList);
		
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//회원정보창의 로그아웃 버튼을 클릭시
				int i = JOptionPane.showConfirmDialog(null,"로그아웃 하시겠습니까?","로그아웃 확인창",JOptionPane.YES_NO_OPTION);
				if(i==0) {
					dispose();
					LoginPage.main(null);
					//confirmdailog에서 예를 누르면 현재 창을 닫고 LoginPage를 연다
				}//if-end
			}
		});
		btnLogout.setBounds(358, 58, 116, 51);
		contentPane.add(btnLogout);
		
		
		
		
		
		JButton btn_Back = new JButton("\uCDE8\uC18C");
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//회원정보창의 취소 클릭시.
				dispose();
				//그냥 회원정보창만 닫는다.
				MainPage.main(jm, js, jhA);
			}
		});
		btn_Back.setBounds(97, 296, 304, 27);
		contentPane.add(btn_Back);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 135, 474, 136);
		contentPane.add(scrollPane);
		
		
		
		ArrayList<JavaList> alH=cm.getHistory(jm);
		String[] col= {"가게명","메뉴이름","가격","주문 날짜"};
		String[][] data=new String[alH.size()][4];
		for(int i=0;i<alH.size();i++) {
			data[i][0]=alH.get(i).getSname();
			data[i][1]=alH.get(i).getMname();
			data[i][2]=String.valueOf(alH.get(i).getMprice());
			data[i][3]=alH.get(i).getImagefile();
		}
		//col에 주문날짜라는 배열하나더 추가
		//2차원 배열 data에 열 개수 3->4로 증가
		//data[i][3]=alH.get(i).getImagefile();
		//추가, vo수정은 너무힘드니 그냥 이미지파일명을 쓸곳이없으니 
		//날짜를 string으로 받아서 저장하도록 구현.
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
