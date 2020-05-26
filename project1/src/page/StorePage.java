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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbmethod1.CallMethod;
import dbmethod1.JavaList;
import dbmethod1.JavaStore;
import dbmethod1.JavaUser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StorePage extends JFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<JavaStore> alStores = new ArrayList<JavaStore>();
	// stord db의 값이 담길 객체 alStores 생성

	public static void main(String cgText, JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StorePage frame = new StorePage(cgText, jm, js, jhA);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StorePage(String cgText, JavaUser jm, JavaStore js, ArrayList<JavaList> jhA)
			throws ClassNotFoundException, SQLException {

		CallMethod cm = new CallMethod();

		alStores = cm.cgStoreShowList(cgText, jm); 
		// 여기에 메소드의 cgStoreShowList()메소드를 불러서 해당 카테고리에 해당하는 해당 음식점리스트를 가져와서
		// 객체 alStores에 뿌려줌
		Collections.shuffle(alStores); 
		// 셔플할것이므로 모든 버튼안의 필드값이 채워져있어야 null 에러가 안나겠지?

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
				// 위치정보 버튼 클릭
				dispose();
				MapPage.main(jm, js, jhA);
			}
		});
		btn_map.setBounds(430, 12, 100, 100);
		contentPane.add(btn_map);

		JButton btn_shop = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		// ----------------아이콘추가-------------------
		btn_shop.setIcon(new ImageIcon("C:\\images\\아이콘\\shopping.jpg"));
		// ----------------아이콘추가-------------------
		btn_shop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 장바구니 버튼 클릭
				dispose();
				ShoppingPage.main(jm, js, jhA);
			}
		});
		btn_shop.setBounds(534, 12, 100, 100);
		contentPane.add(btn_shop);

		JButton btn_user = new JButton("\uB0B4 \uC815\uBCF4");
		// ----------------아이콘추가-------------------
		btn_user.setIcon(new ImageIcon("C:\\images\\아이콘\\myinfo.jpg"));
		// ----------------아이콘추가-------------------
		btn_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 내정보 클릭
				dispose();
				MyInfoPage.main(jm, js, jhA);
			}
		});
		btn_user.setBounds(637, 12, 100, 100);
		contentPane.add(btn_user);

		JButton btn_store1 = new JButton("");
		btn_store1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JavaStore js2 = cm.saveStore(sid[0]); // 버튼 가게1을 눌렀을때 메소드의 saveStore(sid[0])에
				dispose();
				MenuPage.main(jm, alStores.get(0), jhA);
			}
		});
		btn_store1.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store1.setBounds(17, 127, 320, 100);
		btn_store1.setIcon(new ImageIcon(alStores.get(0).getImageFile()));
		btn_store1.setText(alStores.get(0).getSname());
		contentPane.add(btn_store1);

		JLabel lbl_explain1 = new JLabel("");
		lbl_explain1.setBounds(351, 124, 320, 100);
		lbl_explain1.setText(alStores.get(0).getExplain());
		contentPane.add(lbl_explain1);

		JButton btn_store2 = new JButton((String) null);
		btn_store2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MenuPage.main(jm, alStores.get(1), jhA);
			}
		});
		btn_store2.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store2.setBounds(16, 276, 320, 100);

		btn_store2.setIcon(new ImageIcon(alStores.get(1).getImageFile()));
		btn_store2.setText(alStores.get(1).getSname());
		contentPane.add(btn_store2);

		JLabel lbl_explain2 = new JLabel("");
		lbl_explain2.setBounds(351, 276, 320, 100);
		lbl_explain2.setText(alStores.get(1).getExplain());
		contentPane.add(lbl_explain2);

		JButton btn_store3 = new JButton((String) null);
		btn_store3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MenuPage.main(jm, alStores.get(2), jhA);
			}
		});
		btn_store3.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store3.setBounds(16, 423, 320, 100);
		btn_store3.setIcon(new ImageIcon(alStores.get(2).getImageFile()));
		btn_store3.setText(alStores.get(2).getSname());
		contentPane.add(btn_store3);

		JLabel lbl_explain3 = new JLabel("");
		lbl_explain3.setBounds(351, 423, 320, 100);
		lbl_explain3.setText(alStores.get(2).getExplain());
		contentPane.add(lbl_explain3);

		JButton btn_store4 = new JButton((String) null);
		btn_store4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MenuPage.main(jm, alStores.get(3), jhA);
			}
		});
		btn_store4.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store4.setBounds(16, 577, 320, 100);
		btn_store4.setIcon(new ImageIcon(alStores.get(3).getImageFile()));
		btn_store4.setText(alStores.get(3).getSname());
		contentPane.add(btn_store4);

		JLabel lbl_explain4 = new JLabel("");
		lbl_explain4.setBounds(351, 577, 320, 100);
		lbl_explain4.setText(alStores.get(3).getExplain());
		contentPane.add(lbl_explain4);
		JButton btn_store5 = new JButton((String) null);
		btn_store5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				MenuPage.main(jm, alStores.get(4), jhA);
			}
		});
		btn_store5.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store5.setBounds(16, 733, 320, 100);
		btn_store5.setIcon(new ImageIcon(alStores.get(4).getImageFile()));
		btn_store5.setText(alStores.get(4).getSname());
		contentPane.add(btn_store5);

		JLabel lbl_explain5 = new JLabel("");
		lbl_explain5.setBounds(351, 733, 320, 100);
		lbl_explain5.setText(alStores.get(4).getExplain());
		contentPane.add(lbl_explain5);
		this.setVisible(true);

		JButton btn_sitename = new JButton("\uC0AC\uC774\uD2B8\uBA85");
		btn_sitename.setIcon(new ImageIcon("C:\\images\\아이콘\\sitename.jpg"));
		btn_sitename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage.main(jm, js, jhA);
			}
		});
		btn_sitename.setBounds(16, 12, 400, 100);
		contentPane.add(btn_sitename);

		JButton btn_back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage.main(jm, js, jhA);
			}
		});
		btn_back.setBounds(17, 907, 110, 30);
		contentPane.add(btn_back);
	}
}
