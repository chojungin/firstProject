package page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dbmethod1.CallMethod;
import dbmethod1.JavaList;
import dbmethod1.JavaStore;
import dbmethod1.JavaUser;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginPage extends JFrame {
	//최초 시작되는 페이지로

	/*
	 * 
	 * Serialzable을 구현하는 몇몇의 클래스의 경우 private static final long serialVersionUID =
	 * 1L; Eclipse로 warning부분에 갖다대고 클릭해서 위 처럼 선언해주면 된다. 디스크에서 다시 읽을때, 내가 갖고 있는 클래스의
	 * 시그니쳐와 파일에 기록된 클래스 시그니처를 비교하며 serialVersionUID가 달라 deserialize 실패가 된다. 이전의
	 * 버전넘버를 강제로 되돌릴 수 있지만, 몇개의 serialzable에서 동일한 버전넘버로 디스크에 새겨져 있다면 큰 문제가 될 수 있다.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_pw;
	private JLabel lblId;
	private JLabel lblPw;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public LoginPage() throws ClassNotFoundException, SQLException {
		CallMethod cm=new CallMethod();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 250, 400, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		txt_id = new JTextField();
		txt_id.setBounds(68, 204, 165, 35);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setBounds(67, 252, 165, 35);
		contentPane.add(txt_pw);
		txt_pw.setColumns(10);
		
		JButton btn_member = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_member.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//회원가입하기 버튼 클릭시
				dispose();
				MembershipPage.main(null);
				
			}
		});
		
		btn_member.setBounds(250, 298, 108, 27);
		contentPane.add(btn_member);
		
		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		
		
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인 버튼 클릭시.
				//메소드를 통해서 id존재유무/pw가 맞는지를 알아본다.
				try {
					int i = cm.memberCheck(txt_id.getText(), txt_pw.getText());

					switch (i) {
					case 1:
						JavaUser jm = new JavaUser();
						JavaStore js = new JavaStore();
						ArrayList<JavaList> jhA = new ArrayList<JavaList>();
						jm = cm.userInfo(txt_id.getText());
						dispose();
						MainPage.main(jm, js, jhA);
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "PW를 확인해주세요");
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "등록되지않은 회원입니다.");

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btn_login.setBounds(252, 202, 105, 84);
		contentPane.add(btn_login);

		JLabel lbl_sitename = new JLabel("\uC0AC\uC774\uD2B8\uBA85");
		lbl_sitename.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sitename.setIcon(new ImageIcon("C:\\images\\아이콘\\sitename2.jpg"));
		lbl_sitename.setBackground(Color.GREEN);
		lbl_sitename.setBounds(21, 71, 350, 100);
		contentPane.add(lbl_sitename);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblId.setBounds(21, 215, 38, 18);
		contentPane.add(lblId);

		lblPw = new JLabel("PW");
		lblPw.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblPw.setBounds(20, 259, 38, 27);
		contentPane.add(lblPw);

		JLabel lblNewLabel = new JLabel("\uC544\uC9C1 \uD68C\uC6D0\uC774 \uC544\uB2C8\uC2E0\uAC00\uC694?");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(14, 302, 222, 26);
		contentPane.add(lblNewLabel);
	}
}
