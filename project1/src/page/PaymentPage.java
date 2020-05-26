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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dbmethod1.CallMethod;
import dbmethod1.JavaList;
import dbmethod1.JavaStore;
import dbmethod1.JavaUser;

public class PaymentPage extends JFrame {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	   private JTextField text_CardPw;
	   ArrayList<JavaList> card=new ArrayList<JavaList>();

	   public static void main(String sumPrice, JavaUser jm, JavaStore js, ArrayList<JavaList> jhA, ArrayList<JavaList> jhAS) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	               PaymentPage frame = new PaymentPage(sumPrice,jm,js,jhA,jhAS);
	               frame.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      });
	   }
	   
	public PaymentPage(String sumPrice, JavaUser jm, JavaStore js, ArrayList<JavaList> jhA, ArrayList<JavaList> jhAS)
			throws ClassNotFoundException, SQLException {

		CallMethod cm = new CallMethod();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(900, 0, 350, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_Payment = new JLabel("\uACB0\uC81C\uCC3D");
		lbl_Payment.setBounds(134, 10, 62, 18);
		contentPane.add(lbl_Payment);

		JLabel lbl_SumPrice = new JLabel("\uCD5C\uC885\uACB0\uC81C\uAE08\uC561");
		lbl_SumPrice.setBounds(14, 44, 120, 35);
		contentPane.add(lbl_SumPrice);

		JLabel lbl_InSumPrice = new JLabel("");
		lbl_InSumPrice.setBounds(166, 44, 150, 35);
		lbl_InSumPrice.setText(sumPrice);
		contentPane.add(lbl_InSumPrice);

		JLabel lbl_CardNum = new JLabel("\uCE74\uB4DC \uBC88\uD638");
		lbl_CardNum.setBounds(14, 88, 120, 35);
		contentPane.add(lbl_CardNum);

		JLabel lbl_InCardNum = new JLabel("");
		lbl_InCardNum.setBounds(166, 89, 150, 35);
		
		// ������� ī���ȣ�� �ҷ��ͼ� star��� String��ü�� �־��ش�.
		// �׸��� �� ��ü�� 15~19��° �ڸ��� �ִ� ���ڸ� ****�� �ٲپ��ش�.
		lbl_InCardNum.setText(jm.getCardNum().substring(0, 15) + "****");
		

		contentPane.add(lbl_InCardNum);

		JLabel lbl_CardPw = new JLabel("\uCE74\uB4DC \uBE44\uBC00\uBC88\uD638");
		lbl_CardPw.setBounds(14, 130, 120, 35);
		contentPane.add(lbl_CardPw);
		this.setVisible(true);

		text_CardPw = new JTextField();
		text_CardPw.setBounds(160, 132, 158, 32);
		contentPane.add(text_CardPw);
		text_CardPw.setColumns(10);

		JButton btn_Payment = new JButton("\uACB0\uC81C\uD558\uAE30"); // �����ϱ�
		btn_Payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�����ϱ� ��ư Ŭ����.
				try {
					card = cm.pwcheck(Integer.parseInt(text_CardPw.getText()), jm, jhAS);

					if (card.size() == 0) {
						int i = JOptionPane.showConfirmDialog(null, "������������ �̵� �Ͻðڽ��ϱ�?", "����â �ݱ�",
								JOptionPane.YES_NO_OPTION);
						// ������ �����Ϸ��� �������־����� ��ٱ��Ͽ� ����̾������� card.size�� 0�̵Ǿ �޼ҵ峻���� �����Ϸ�κ��̳�����
						// ������������ �̵��Ͻðڽ��ϱ�?��� ��������� �������� ����
						if (i == 0) {
							dispose();
							MainPage.main(jm, js, card);
						} else if (i == 1) {
							dispose();
							ShoppingPage.main(jm, js, card);
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���."); // false
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ٷ� �Է����ּ���.");
					System.out.println(e1);
				}
			}
		});
		btn_Payment.setBounds(14, 176, 304, 38);
		contentPane.add(btn_Payment);

		JButton btn_Back = new JButton("\uCDE8\uC18C"); // ���
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShoppingPage.main(jm, js, jhA); // ��ҹ�ư Ŭ����, �������� ���� ������������ �ٽ� �ҷ���������.
			}
		});
		btn_Back.setBounds(14, 226, 304, 35);
		contentPane.add(btn_Back);

	}
}
