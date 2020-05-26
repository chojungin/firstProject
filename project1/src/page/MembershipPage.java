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
		lblNewLabel.setFont(new Font("�������", Font.PLAIN, 15));
		lblNewLabel.setBounds(41, 193, 90, 18);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setFont(new Font("�������", Font.PLAIN, 15));
		label.setBounds(41, 229, 90, 18);
		contentPane.add(label);
		
		label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_1.setFont(new Font("�������", Font.PLAIN, 15));
		label_1.setBounds(41, 265, 90, 18);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\uC774\uB984");
		label_2.setFont(new Font("�������", Font.PLAIN, 15));
		label_2.setBounds(41, 303, 90, 18);
		contentPane.add(label_2);
		
		label_3 = new JLabel("\uC8FC\uC18C");
		label_3.setFont(new Font("�������", Font.PLAIN, 15));
		label_3.setBounds(41, 339, 90, 18);
		contentPane.add(label_3);
		
		label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_4.setFont(new Font("�������", Font.PLAIN, 15));
		label_4.setBounds(41, 375, 90, 18);
		contentPane.add(label_4);
		
		label_5 = new JLabel("\uCE74\uB4DC\uBC88\uD638");
		label_5.setFont(new Font("�������", Font.PLAIN, 15));
		label_5.setBounds(41, 411, 90, 18);
		contentPane.add(label_5);
		
		label_6 = new JLabel("\uCE74\uB4DC\uBE44\uBC00\uBC88\uD638");
		label_6.setFont(new Font("�������", Font.PLAIN, 15));
		label_6.setBounds(41, 447, 90, 18);
		contentPane.add(label_6);
		
		txt_pw2 = new JTextField();
		txt_pw2.setBounds(148, 262, 179, 24);
		txt_pw2.setColumns(10);
		contentPane.add(txt_pw2);
		
		JButton btn_idcon = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_idcon.setFont(new Font("�������", Font.PLAIN, 15));
		btn_idcon.setBounds(351, 187, 90, 30);
		btn_idcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���̵� �ߺ�Ȯ�� Ŭ��!
				try {
					int i=cm.idOverlap(txt_id.getText());
					switch(i) {
					case 1:
						JOptionPane.showMessageDialog(null, "����Ͻ� id�� ���� �ߺ�üũ���ּ���!");
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.\n�ٸ� ���̵� �Է����ּ���.");
						txt_id.setText("");
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "��밡���� ���̵��Դϴ�.");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btn_idcon);
		
		JButton btn_back = new JButton("\uCDE8\uC18C");
		btn_back.setFont(new Font("�������", Font.PLAIN, 15));
		btn_back.setBounds(41, 530, 400, 30);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��� ��ư Ŭ���� 
				dispose();
				LoginPage.main(null);
			}
		});
		contentPane.add(btn_back);
		
		JButton btn_front = new JButton("\uAC00\uC785\uD558\uAE30");
		btn_front.setFont(new Font("�������", Font.PLAIN, 15));
		btn_front.setBounds(41, 491, 400, 30);
		btn_front.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            //�����ϱ� Ŭ���� ....
	            //���̵� �ߺ��ε��� �����ϱ⸦ �ϴ� ����� ���� �� ����...
	            //���̵� �ߺ�üũ�� �ѹ��� ���ؾ��ҵ�
	            
	               try {
	                  int i = cm.idOverlap(txt_id.getText());// id�ߺ�üũ �޼ҵ���
	                  switch (i) {
	                  case 1:
	                     JOptionPane.showMessageDialog(null, "����Ͻ� id�� ���� �ߺ�üũ���ּ���!");
	                     break;
	                  case 2:
	                     JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.\n�ٸ� ���̵� �Է����ּ���.");
	                     txt_id.setText("");
	                     break;
	                  case 3:
	                     int j = cm.membershipCheck(txt_id.getText(), txt_pw.getText(), txt_pw2.getText(),
	                           txt_name.getText(), txt_addr.getText(), txt_tel.getText(), txt_card.getText(),
	                           txt_cardpw.getText());
	                     // ȸ������ �޼ҵ� ȣ��! int�� return�޼ҵ� i�� return�� ����.
	                     switch (j) {
	                     case 5:
	                        JOptionPane.showMessageDialog(null, "ȸ�������� �����Ͽ����ϴ�.");
	                        dispose();
	                        LoginPage.main(null);
	                        
	                        break;
	                     case 1:
	                        JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٽ� Ȯ�����ֽñ�ٶ��ϴ�.");
	                        break;
	                     case 2:
	                        JOptionPane.showMessageDialog(null, "ȸ�������� ��� �Է����ֽñ�ٶ��ϴ�.");
	                        break;
	                    case 3:
	                        JOptionPane.showMessageDialog(null, "ī���ȣ�� ����� �Է��ϼ���!");
	                        break;
	                    case 4:
	                    	JOptionPane.showMessageDialog(null, "ī���й�ȣ�� ���ڿ���!!!!");
	                     }
	                    
	                     /*
	                      * dispose();s LoginPage.main(null); // â �ݰ� �ٽ� �α��� ��������....
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
		btn_site.setIcon(new ImageIcon("C:\\images\\������\\sitename.jpg"));
		btn_site.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_site.setBounds(41, 51, 400, 100);
		contentPane.add(btn_site);
	
		
	}
}
