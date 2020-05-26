package page;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbmethod1.CallMethod;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MembershipPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_pw;
	private JTextField txt_pw2;
	private JTextField txt_name;
	private JTextField txt_addr;
	private JTextField txt_tel;
	private JTextField txt_card;
	private JTextField txt_cardpw;
	private JButton btn_site;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembershipPage frame = new MembershipPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MembershipPage() throws ClassNotFoundException, SQLException {
		CallMethod cm=new CallMethod();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 150, 500, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_id = new JTextField();
		txt_id.setBounds(148, 190, 179, 24);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setBounds(148, 226, 179, 24);
		txt_pw.setColumns(10);
		contentPane.add(txt_pw);
		
		txt_name = new JTextField();
		txt_name.setBounds(148, 300, 179, 24);
		txt_name.setColumns(10);
		contentPane.add(txt_name);
		
		txt_addr = new JTextField();
		txt_addr.setBounds(148, 336, 179, 24);
		txt_addr.setColumns(10);
		contentPane.add(txt_addr);
		
		txt_tel = new JTextField();
		txt_tel.setBounds(148, 372, 179, 24);
		txt_tel.setColumns(10);
		contentPane.add(txt_tel);
		
		txt_card = new JTextField();
		txt_card.setBounds(148, 408, 179, 24);
		txt_card.setColumns(10);
		contentPane.add(txt_card);
		
		txt_cardpw = new JTextField();
		txt_cardpw.setBounds(148, 444, 179, 24);
		txt_cardpw.setColumns(10);
		contentPane.add(txt_cardpw);
		
		lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(41, 193, 90, 18);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label.setBounds(41, 229, 90, 18);
		contentPane.add(label);
		
		label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_1.setBounds(41, 265, 90, 18);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\uC774\uB984");
		label_2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_2.setBounds(41, 303, 90, 18);
		contentPane.add(label_2);
		
		label_3 = new JLabel("\uC8FC\uC18C");
		label_3.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_3.setBounds(41, 339, 90, 18);
		contentPane.add(label_3);
		
		label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_4.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_4.setBounds(41, 375, 90, 18);
		contentPane.add(label_4);
		
		label_5 = new JLabel("\uCE74\uB4DC\uBC88\uD638");
		label_5.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_5.setBounds(41, 411, 90, 18);
		contentPane.add(label_5);
		
		label_6 = new JLabel("\uCE74\uB4DC\uBE44\uBC00\uBC88\uD638");
		label_6.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		label_6.setBounds(41, 447, 90, 18);
		contentPane.add(label_6);
		
		txt_pw2 = new JTextField();
		txt_pw2.setBounds(148, 262, 179, 24);
		txt_pw2.setColumns(10);
		contentPane.add(txt_pw2);
		
		JButton btn_idcon = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_idcon.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_idcon.setBounds(351, 187, 90, 30);
		btn_idcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//아이디 중복확인 클릭!
				try {
					int i=cm.idOverlap(txt_id.getText());
					switch(i) {
					case 1:
						JOptionPane.showMessageDialog(null, "사용하실 id를 적고 중복체크해주세요!");
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "중복된 아이디입니다.\n다른 아이디를 입력해주세요.");
						txt_id.setText("");
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btn_idcon);
		
		JButton btn_back = new JButton("\uCDE8\uC18C");
		btn_back.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_back.setBounds(41, 530, 400, 30);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//취소 버튼 클릭시 
				dispose();
				LoginPage.main(null);
			}
		});
		contentPane.add(btn_back);
		
		JButton btn_front = new JButton("\uAC00\uC785\uD558\uAE30");
		btn_front.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		btn_front.setBounds(41, 491, 400, 30);
		btn_front.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            //가입하기 클릭시 ....
	            //아이디가 중복인데도 가입하기를 하는 사람이 잇을 수 있음...
	            //아이디 중복체크를 한번더 콜해야할듯
	            
	               try {
	                  int i = cm.idOverlap(txt_id.getText());// id중복체크 메소드콜
	                  switch (i) {
	                  case 1:
	                     JOptionPane.showMessageDialog(null, "사용하실 id를 적고 중복체크해주세요!");
	                     break;
	                  case 2:
	                     JOptionPane.showMessageDialog(null, "중복된 아이디입니다.\n다른 아이디를 입력해주세요.");
	                     txt_id.setText("");
	                     break;
	                  case 3:
	                     int j = cm.membershipCheck(txt_id.getText(), txt_pw.getText(), txt_pw2.getText(),
	                           txt_name.getText(), txt_addr.getText(), txt_tel.getText(), txt_card.getText(),
	                           txt_cardpw.getText());
	                     // 회원가입 메소드 호출! int값 return메소드 i에 return값 저장.
	                     switch (j) {
	                     case 5:
	                        JOptionPane.showMessageDialog(null, "회원가입이 성공하였습니다.");
	                        dispose();
	                        LoginPage.main(null);
	                        
	                        break;
	                     case 1:
	                        JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해주시기바랍니다.");
	                        break;
	                     case 2:
	                        JOptionPane.showMessageDialog(null, "회원정보를 모두 입력해주시기바랍니다.");
	                        break;
	                    case 3:
	                        JOptionPane.showMessageDialog(null, "카드번호를 제대로 입력하세요!");
	                        break;
	                    case 4:
	                    	JOptionPane.showMessageDialog(null, "카드비밀번호는 숫자에요!!!!");
	                     }
	                    
	                     /*
	                      * dispose();s LoginPage.main(null); // 창 닫고 다시 로그인 페이지로....
	                      */
	                     
	                  }
	               } catch (NumberFormatException | SQLException e1) {
	                  // TODO Auto-generated catch block
	                  e1.printStackTrace();
	               }
	         }
	               
	            
	         
	      });
		contentPane.add(btn_front);
		
		btn_site = new JButton("\uC0AC\uC774\uD2B8\uBA85");
		btn_site.setIcon(new ImageIcon("C:\\images\\아이콘\\sitename.jpg"));
		btn_site.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_site.setBounds(41, 51, 400, 100);
		contentPane.add(btn_site);
	
		
	}
}
