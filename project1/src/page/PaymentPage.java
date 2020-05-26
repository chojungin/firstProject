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
		
		// 사용자의 카드번호를 불러와서 star라는 String객체에 넣어준다.
		// 그리고 그 객체의 15~19번째 자리에 있는 글자를 ****로 바꾸어준다.
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

		JButton btn_Payment = new JButton("\uACB0\uC81C\uD558\uAE30"); // 결제하기
		btn_Payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//결제하기 버튼 클릭시.
				try {
					card = cm.pwcheck(Integer.parseInt(text_CardPw.getText()), jm, jhAS);

					if (card.size() == 0) {
						int i = JOptionPane.showConfirmDialog(null, "메인페이지로 이동 하시겠습니까?", "결제창 닫기",
								JOptionPane.YES_NO_OPTION);
						// 기존에 결제완료라는 문장이있었지만 장바구니에 목록이없을때도 card.size가 0이되어서 메소드내에서 결제완료부분이나오고
						// 메인페이지로 이동하시겠습니까?라는 문장까지만 나오도록 수정
						if (i == 0) {
							dispose();
							MainPage.main(jm, js, card);
						} else if (i == 1) {
							dispose();
							ShoppingPage.main(jm, js, card);
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다. 다시 입력해주세요."); // false
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "비밀번호를 바로 입력해주세요.");
					System.out.println(e1);
				}
			}
		});
		btn_Payment.setBounds(14, 176, 304, 38);
		contentPane.add(btn_Payment);

		JButton btn_Back = new JButton("\uCDE8\uC18C"); // 취소
		btn_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShoppingPage.main(jm, js, jhA); // 취소버튼 클릭시, 변동사항 없이 쇼핑페이지가 다시 불러와져야함.
			}
		});
		btn_Back.setBounds(14, 226, 304, 35);
		contentPane.add(btn_Back);

	}
}
