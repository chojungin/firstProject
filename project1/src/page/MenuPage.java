package page;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbmethod1.CallMethod;
import dbmethod1.JavaList;
import dbmethod1.JavaStore;
import dbmethod1.JavaUser;

public class MenuPage extends JFrame {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	   public static void main(JavaUser jm, JavaStore js2, ArrayList<JavaList> jhA) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	               MenuPage frame = new MenuPage(jm, js2, jhA);
	               frame.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();	            }
	         }
	      });
	   }

	public MenuPage(JavaUser jm, JavaStore js1, ArrayList<JavaList> jhA) throws ClassNotFoundException, SQLException {

		CallMethod cm = new CallMethod();

		ArrayList<JavaList> aljl = new ArrayList<JavaList>();
		aljl = cm.menulist(js1);
		// menuPage 호출시 메뉴들의 정보를 가져올 menulist메소드콜 alj1에 저장.

		Collections.shuffle(aljl);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 0, 800, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_map = new JButton("\uC704\uCE58\uC815\uBCF4");
		// ----------------아이콘추가-------------------
		btn_map.setIcon(new ImageIcon("C:\\images\\아이콘\\map.jpg"));
		// ----------------아이콘추가-------------------
		btn_map.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MapPage.main(jm, js1, jhA);
			}
		});
		btn_map.setBounds(464, 29, 100, 100);
		contentPane.add(btn_map);

		JButton btn_shop = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		// ----------------아이콘추가-------------------
		btn_shop.setIcon(new ImageIcon("C:\\images\\아이콘\\shopping.jpg"));
		// ----------------아이콘추가-------------------
		btn_shop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShoppingPage.main(jm, js1, jhA);
			}
		});
		btn_shop.setBounds(565, 29, 100, 100);
		contentPane.add(btn_shop);

		JButton btn_user = new JButton("\uB0B4 \uC815\uBCF4");
		// ----------------아이콘추가-------------------
		btn_user.setIcon(new ImageIcon("C:\\images\\아이콘\\myinfo.jpg"));
		// ----------------아이콘추가-------------------
		btn_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//사용자 아이콘 클릭시
				dispose();
				MyInfoPage.main(jm, js1, jhA);
			}
		});
		btn_user.setBounds(668, 29, 100, 100);
		contentPane.add(btn_user);

		JButton btn_foodpic1 = new JButton("");
		btn_foodpic1.setIcon(new ImageIcon(aljl.get(0).getImagefile()));
		btn_foodpic1.setBounds(50, 337, 180, 180);
		contentPane.add(btn_foodpic1);

		JLabel lbl_foodname1 = new JLabel("\uC74C\uC2DD\uC774\uB984");
		lbl_foodname1.setBounds(95, 542, 107, 21);
		lbl_foodname1.setText(aljl.get(0).getMname());
		contentPane.add(lbl_foodname1);

		JButton btn_foodpic2 = new JButton("");
		btn_foodpic2.setIcon(new ImageIcon(aljl.get(1).getImagefile()));
		btn_foodpic2.setBounds(300, 337, 180, 180);
		contentPane.add(btn_foodpic2);

		JLabel lbl_foodname2 = new JLabel("\uC74C\uC2DD\uC774\uB984");
		lbl_foodname2.setBounds(353, 539, 107, 18);
		lbl_foodname2.setText(aljl.get(1).getMname());
		contentPane.add(lbl_foodname2);

		JButton btn_foodpic3 = new JButton("");
		btn_foodpic3.setIcon(new ImageIcon(aljl.get(2).getImagefile()));
		btn_foodpic3.setBounds(565, 337, 180, 180);
		contentPane.add(btn_foodpic3);

		JLabel lbl_foodname3 = new JLabel("\uC74C\uC2DD\uC774\uB984");
		lbl_foodname3.setBounds(590, 539, 107, 21);
		lbl_foodname3.setText(aljl.get(2).getMname());
		contentPane.add(lbl_foodname3);

		JButton btn_foodpic4 = new JButton("");
		btn_foodpic4.setIcon(new ImageIcon(aljl.get(3).getImagefile()));
		btn_foodpic4.setBounds(50, 644, 180, 180);
		contentPane.add(btn_foodpic4);

		JLabel lbl_foodname4 = new JLabel("\uC74C\uC2DD\uC774\uB984");
		lbl_foodname4.setBounds(95, 854, 107, 16);
		lbl_foodname4.setText(aljl.get(3).getMname());
		contentPane.add(lbl_foodname4);

		JButton btn_foodpic5 = new JButton("");
		btn_foodpic5.setIcon(new ImageIcon(aljl.get(4).getImagefile()));
		btn_foodpic5.setBounds(300, 644, 180, 180);
		contentPane.add(btn_foodpic5);

		JLabel lbl_foodname5 = new JLabel("\uC74C\uC2DD\uC774\uB984");
		lbl_foodname5.setBounds(338, 851, 107, 18);
		lbl_foodname5.setText(aljl.get(4).getMname());
		contentPane.add(lbl_foodname5);

		JButton btn_foodpic6 = new JButton("");
		btn_foodpic6.setIcon(new ImageIcon(aljl.get(5).getImagefile()));
		btn_foodpic6.setBounds(560, 644, 180, 180);
		contentPane.add(btn_foodpic6);

		JLabel lbl_foodname6 = new JLabel("\uC74C\uC2DD\uC774\uB984");
		lbl_foodname6.setBounds(590, 851, 107, 18);
		lbl_foodname6.setText(aljl.get(5).getMname());
		contentPane.add(lbl_foodname6);

		JButton btn_sitename = new JButton("\uC0AC\uC774\uD2B8\uBA85");
		btn_sitename.setIcon(new ImageIcon("C:\\images\\아이콘\\sitename.jpg"));
		btn_sitename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//왼쪽 상단 사이트를 클릭시 메인페이지로 이동한다.
				dispose();
				MainPage.main(jm, js1, jhA);
			}
		});
		btn_sitename.setBounds(50, 29, 400, 100);
		contentPane.add(btn_sitename);

		JButton btn_back = new JButton("\uB4A4\uB85C");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//뒤로가기 버튼 클릭시 메인페이지로 이동한다.
				dispose();
				MainPage.main(jm, js1, jhA);
			}
		});
		btn_back.setBounds(14, 911, 110, 30);
		contentPane.add(btn_back);

		JLabel lbl_storeName = new JLabel("");
		lbl_storeName.setBounds(53, 162, 320, 100);
		lbl_storeName.setIcon(new ImageIcon(js1.getImageFile()));
		lbl_storeName.setText(js1.getSname());
		contentPane.add(lbl_storeName);

		JLabel lbl_storeExplain = new JLabel("");
		lbl_storeExplain.setBounds(53, 275, 700, 50);
		lbl_storeExplain.setText(js1.getExplain());
		contentPane.add(lbl_storeExplain);

		JLabel lbl_foodprice1 = new JLabel("");
		lbl_foodprice1.setBounds(99, 569, 57, 15);
		String sPrice0 = Integer.toString(aljl.get(0).getMprice());
		lbl_foodprice1.setText(sPrice0);
		contentPane.add(lbl_foodprice1);

		JLabel lbl_foodprice2 = new JLabel("");
		lbl_foodprice2.setBounds(355, 569, 57, 15);
		String sPrice1 = Integer.toString(aljl.get(1).getMprice());
		lbl_foodprice2.setText(sPrice1);
		contentPane.add(lbl_foodprice2);

		JLabel lbl_foodprice3 = new JLabel("");
		lbl_foodprice3.setBounds(593, 571, 57, 15);
		String sPrice2 = Integer.toString(aljl.get(2).getMprice());
		lbl_foodprice3.setText(sPrice2);
		contentPane.add(lbl_foodprice3);

		JLabel lbl_foodprice4 = new JLabel("");
		lbl_foodprice4.setBounds(98, 884, 57, 15);
		String sPrice3 = Integer.toString(aljl.get(3).getMprice());
		lbl_foodprice4.setText(sPrice3);
		contentPane.add(lbl_foodprice4);

		JLabel lbl_foodprice5 = new JLabel("");
		lbl_foodprice5.setBounds(341, 882, 57, 15);
		String sPrice4 = Integer.toString(aljl.get(4).getMprice());
		lbl_foodprice5.setText(sPrice4);
		contentPane.add(lbl_foodprice5);

		JLabel lbl_foodprice6 = new JLabel("");
		lbl_foodprice6.setBounds(592, 883, 57, 15);
		String sPrice5 = Integer.toString(aljl.get(5).getMprice());
		lbl_foodprice6.setText(sPrice5);
		contentPane.add(lbl_foodprice6);

		btn_foodpic1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// menu버튼1 클릭
				int flag = -1;
				for (int i = 0; i < jhA.size(); i++) {
					if (jhA.get(i).getSid().equals(js1.getSid())
							&& jhA.get(i).getMname().equals(lbl_foodname1.getText())) {
						flag = i;
						//flag식으로 구현하여 밑에 if문으로 조건을 구현한다.
						//중복된 가게와 메뉴가 들어오는 것을 체크
					} // if-end
				} // for-end
				if (flag != -1) {
					int j = Integer.parseInt(jhA.get(flag).getImagefile()) + 1;
					jhA.get(flag).setImagefile(Integer.toString(j));
					jhA.get(flag).setMprice(jhA.get(flag).getMprice() / (j - 1) * j);
					//중복되었다면 수량과 가격만 중복된 부분에 증가시킨다.
				} else {
					jhA.add(new JavaList(js1.getSid(), js1.getSname(), lbl_foodname1.getText(),
							Integer.parseInt(lbl_foodprice1.getText()), "1"));
					//중복되지않으면 jhA에 그냥 저장한다.
					//이떄 jhA의 JavaList의 imagefile은 수량으로 이용된다.

				}

			}// actionPerformed-end
		});
		btn_foodpic2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메뉴버튼2 클릭
				int flag = -1;
				for (int i = 0; i < jhA.size(); i++) {
					if (jhA.get(i).getSid().equals(js1.getSid())
							&& jhA.get(i).getMname().equals(lbl_foodname2.getText())) {
						
						flag = i;
					} // if-end
				} // for-end
				if (flag != -1) {
					int j = Integer.parseInt(jhA.get(flag).getImagefile()) + 1;
					jhA.get(flag).setImagefile(Integer.toString(j));
					jhA.get(flag).setMprice(jhA.get(flag).getMprice() / (j - 1) * j);
				} else {
					jhA.add(new JavaList(js1.getSid(), js1.getSname(), lbl_foodname2.getText(),
							Integer.parseInt(lbl_foodprice2.getText()), "1"));

				}

			}
		});
		btn_foodpic3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메뉴버튼 3 클릭
				int flag = -1;
				for (int i = 0; i < jhA.size(); i++) {
					if (jhA.get(i).getSid().equals(js1.getSid())
							&& jhA.get(i).getMname().equals(lbl_foodname3.getText())) {
						
						flag = i;
					} // if-end
				} // for-end
				if (flag != -1) {
					int j = Integer.parseInt(jhA.get(flag).getImagefile()) + 1;
					jhA.get(flag).setImagefile(Integer.toString(j));
					jhA.get(flag).setMprice(jhA.get(flag).getMprice() / (j - 1) * j);
				} else {
					jhA.add(new JavaList(js1.getSid(), js1.getSname(), lbl_foodname3.getText(),
							Integer.parseInt(lbl_foodprice3.getText()), "1"));

				}
			}
		});
		btn_foodpic4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메뉴 버튼 4 클릭
				int flag = -1;
				for (int i = 0; i < jhA.size(); i++) {
					if (jhA.get(i).getSid().equals(js1.getSid())
							&& jhA.get(i).getMname().equals(lbl_foodname4.getText())) {
						
						flag = i;
					} // if-end
				} // for-end
				if (flag != -1) {
					int j = Integer.parseInt(jhA.get(flag).getImagefile()) + 1;
					jhA.get(flag).setImagefile(Integer.toString(j));
					jhA.get(flag).setMprice(jhA.get(flag).getMprice() / (j - 1) * j);
				} else {
					jhA.add(new JavaList(js1.getSid(), js1.getSname(), lbl_foodname4.getText(),
							Integer.parseInt(lbl_foodprice4.getText()), "1"));

				}
			}
		});
		btn_foodpic5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메뉴버튼 5 클릭
				int flag = -1;
				for (int i = 0; i < jhA.size(); i++) {
					if (jhA.get(i).getSid().equals(js1.getSid())
							&& jhA.get(i).getMname().equals(lbl_foodname5.getText())) {
						
						flag = i;
					} // if-end
				} // for-end
				if (flag != -1) {
					int j = Integer.parseInt(jhA.get(flag).getImagefile()) + 1;
					jhA.get(flag).setImagefile(Integer.toString(j));
					jhA.get(flag).setMprice(jhA.get(flag).getMprice() / (j - 1) * j);
				} else {
					jhA.add(new JavaList(js1.getSid(), js1.getSname(), lbl_foodname5.getText(),
							Integer.parseInt(lbl_foodprice5.getText()), "1"));

				}
			}
		});
		btn_foodpic6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메뉴 버튼 6 클릭.
				int flag = -1;
				for (int i = 0; i < jhA.size(); i++) {
					if (jhA.get(i).getSid().equals(js1.getSid())
							&& jhA.get(i).getMname().equals(lbl_foodname6.getText())) {
						
						flag = i;
					} // if-end
				} // for-end
				if (flag != -1) {
					int j = Integer.parseInt(jhA.get(flag).getImagefile()) + 1;
					jhA.get(flag).setImagefile(Integer.toString(j));
					jhA.get(flag).setMprice(jhA.get(flag).getMprice() / (j - 1) * j);
				} else {
					jhA.add(new JavaList(js1.getSid(), js1.getSname(), lbl_foodname6.getText(),
							Integer.parseInt(lbl_foodprice6.getText()), "1"));

				}
			}
		});

	}
}