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
	//���� ���۵Ǵ� ��������

	/*
	 * 
	 * Serialzable�� �����ϴ� ����� Ŭ������ ��� private static final long serialVersionUID =
	 * 1L; Eclipse�� warning�κп� ���ٴ�� Ŭ���ؼ� �� ó�� �������ָ� �ȴ�. ��ũ���� �ٽ� ������, ���� ���� �ִ� Ŭ������
	 * �ñ״��Ŀ� ���Ͽ� ��ϵ� Ŭ���� �ñ״�ó�� ���ϸ� serialVersionUID�� �޶� deserialize ���а� �ȴ�. ������
	 * �����ѹ��� ������ �ǵ��� �� ������, ��� serialzable���� ������ �����ѹ��� ��ũ�� ������ �ִٸ� ū ������ �� �� �ִ�.
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
		btn_member.setFont(new Font("�������", Font.PLAIN, 15));
		btn_member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ȸ�������ϱ� ��ư Ŭ����
				dispose();
				MembershipPage.main(null);
				
			}
		});
		
		btn_member.setBounds(250, 298, 108, 27);
		contentPane.add(btn_member);
		
		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.setFont(new Font("�������", Font.PLAIN, 15));
		
		
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�α��� ��ư Ŭ����.
				//�޼ҵ带 ���ؼ� id��������/pw�� �´����� �˾ƺ���.
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
						JOptionPane.showMessageDialog(null, "PW�� Ȯ�����ּ���");
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "��ϵ������� ȸ���Դϴ�.");

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
		lbl_sitename.setIcon(new ImageIcon("C:\\images\\������\\sitename2.jpg"));
		lbl_sitename.setBackground(Color.GREEN);
		lbl_sitename.setBounds(21, 71, 350, 100);
		contentPane.add(lbl_sitename);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("�������", Font.PLAIN, 15));
		lblId.setBounds(21, 215, 38, 18);
		contentPane.add(lblId);

		lblPw = new JLabel("PW");
		lblPw.setFont(new Font("�������", Font.PLAIN, 15));
		lblPw.setBounds(20, 259, 38, 27);
		contentPane.add(lblPw);

		JLabel lblNewLabel = new JLabel("\uC544\uC9C1 \uD68C\uC6D0\uC774 \uC544\uB2C8\uC2E0\uAC00\uC694?");
		lblNewLabel.setFont(new Font("�������", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(14, 302, 222, 26);
		contentPane.add(lblNewLabel);
	}
}
