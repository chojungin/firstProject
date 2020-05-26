package page;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import dbmethod1.CallMethod;
import dbmethod1.JavaList;
import dbmethod1.JavaStore;
import dbmethod1.JavaUser;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MainPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<JavaStore> arjs=new ArrayList<JavaStore>();
	//사용자 주소로 검색해서 받아올 가게를 담을 arraylist
	
	public static void main(JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage(jm,js,jhA);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public MainPage(JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) throws ClassNotFoundException, SQLException {
		CallMethod cm = new CallMethod();
		//메소드 콜을 위한 클래스변수
		
		arjs=cm.addrStoreShowList(jm);
		//사용자 주소로 같은 주소의 가게를 검색해서 리턴해주는 메소드 콜
		Collections.shuffle(arjs);
		//리턴된 가게정보의 순서를 섞어준다. 이로인해 페이지가 열릴떄 마다 다른 가게들이 나오게된다.
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 0, 800, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(14, 140, 754, 76);
		toolBar.addSeparator(new Dimension(50, 50));
		contentPane.add(toolBar);
		
		JButton btn_cg1 = new JButton("\uD55C\uC2DD");
		btn_cg1.setFont(new Font("굴림", Font.PLAIN, 25));
		btn_cg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//한식 카테고리를 클릭.
				dispose();
				StorePage.main(btn_cg1.getText(), jm, js, jhA);
				//카테고리를 클릭하면 카테고리에 맞고 jm의 사용자 정보에서 주소에 있는
				//가게들을 뽑아야하므로 버튼내에 지정된 카테고리관련 text를 함꼐 보내준다.
			}
		});
		toolBar.add(btn_cg1);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_cg2 = new JButton("\uC911\uC2DD");
		btn_cg2.setFont(new Font("굴림", Font.PLAIN, 25));
		btn_cg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//중식 카테고리를 클릭.
				dispose();
				StorePage.main(btn_cg2.getText(), jm, js, jhA);
			}
		});
		toolBar.add(btn_cg2);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_cg3 = new JButton("\uC77C\uC2DD");
		btn_cg3.setFont(new Font("굴림", Font.PLAIN, 25));
		btn_cg3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//일식 카테고리를 클릭.
				dispose();
				StorePage.main(btn_cg3.getText(), jm, js, jhA);
			}
		});
		toolBar.add(btn_cg3);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_cg4 = new JButton("\uC591\uC2DD");
		btn_cg4.setFont(new Font("굴림", Font.PLAIN, 25));
		btn_cg4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//양식 카테고리를 클릭.
				dispose();
				StorePage.main(btn_cg4.getText(), jm, js, jhA);
			}
		});
		toolBar.add(btn_cg4);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_cg5 = new JButton("\uAE30\uD0C0");
		btn_cg5.setFont(new Font("굴림", Font.PLAIN, 25));
		btn_cg5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//기타 카테고리를 클릭.
				dispose();
				StorePage.main(btn_cg5.getText(), jm, js, jhA);
			}
		});
		toolBar.add(btn_cg5);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_map = new JButton("\uC704\uCE58\uC815\uBCF4");
		btn_map.setBounds(440, 12, 100, 100);
		//----------------아이콘추가-------------------
		btn_map.setIcon(new ImageIcon("C:\\images\\아이콘\\map.jpg"));
		//----------------아이콘추가-------------------
		btn_map.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MapPage.main(jm, js, jhA);
				//위치정보페이지부분 클릭.
				
			}
		});
		contentPane.add(btn_map);
		
		JButton btn_shop = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		btn_shop.setBounds(554, 12, 100, 100);
		//----------------아이콘추가-------------------
		btn_shop.setIcon(new ImageIcon("C:\\images\\아이콘\\shopping.jpg"));
		//----------------아이콘추가-------------------
		btn_shop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShoppingPage.main(jm, js, jhA);
				//장바구니 부분을 클릭.
			}
		});
		contentPane.add(btn_shop);
		
		JButton btn_user = new JButton("\uB0B4 \uC815\uBCF4");
		btn_user.setBounds(668, 12, 100, 100);
		//----------------아이콘추가-------------------
		btn_user.setIcon(new ImageIcon("C:\\images\\아이콘\\myinfo.jpg"));
		//----------------아이콘추가-------------------
		btn_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyInfoPage.main(jm,js,jhA);
				//내정보 부분을 클릭.
			}
		});
		contentPane.add(btn_user);
		
		
		
		
		JButton btn_store1 = new JButton("");
		btn_store1.setBounds(42, 306, 320, 100);
		btn_store1.setHorizontalAlignment(SwingConstants.LEFT);
		
		btn_store1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//가게버튼 1번째 클릭
				dispose();
				MenuPage.main(jm, arjs.get(0), jhA);
				//사용자의 주소에 맞는 가게들이 담긴 ArrayList인 arjs에서 가게정보를 보내준다.
				//즉 가게의 id가 넘어가서 MenuPage가 열릴때 가게 id로 그가게의 메뉴를 찾게해준다.
			}
		});
		
		contentPane.add(btn_store1);
		
		JButton btn_store2 = new JButton("");
		btn_store2.setBounds(40, 457, 320, 100);
		btn_store2.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//가게버튼 2번째 클릭
				dispose();
				MenuPage.main(jm, arjs.get(1), jhA);
				
			}
		});
		contentPane.add(btn_store2);
		
		JButton btn_store3 = new JButton("");
		btn_store3.setBounds(42, 584, 320, 100);
		btn_store3.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//가게버튼 3번째 클릭
				dispose();
				MenuPage.main(jm, arjs.get(2), jhA);
			}
		});
		contentPane.add(btn_store3);
		
		JButton btn_store4 = new JButton("");
		btn_store4.setBounds(40, 711, 320, 100);
		btn_store4.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//가게버튼 4번째 클릭
				dispose();
				MenuPage.main(jm, arjs.get(3), jhA);
			}
		});
		contentPane.add(btn_store4);
		
		JButton btn_store5 = new JButton("");
		btn_store5.setBounds(42, 838, 320, 100);
		btn_store5.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//가게버튼 5번째 클릭
				dispose();
				MenuPage.main(jm, arjs.get(4), jhA);
			}
		});
		contentPane.add(btn_store5);
		
		JButton btn_sitename = new JButton("\uC0AC\uC774\uD2B8\uBA85");
		btn_sitename.setBounds(14, 12, 400, 100);
		btn_sitename.setIcon(new ImageIcon("C:\\images\\아이콘\\sitename.jpg"));
		btn_sitename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btn_sitename);
		
		JLabel lbl_explain1 = new JLabel("");
		lbl_explain1.setBounds(364, 306, 320, 100);
		lbl_explain1.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl_explain1);
		
		JLabel lbl_explain2 = new JLabel("");
		lbl_explain2.setBounds(364, 457, 320, 100);
		lbl_explain2.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl_explain2);
		
		JLabel lbl_explain3 = new JLabel("");
		lbl_explain3.setBounds(364, 584, 320, 100);
		lbl_explain3.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl_explain3);
		
		JLabel lbl_explain4 = new JLabel("");
		lbl_explain4.setBounds(364, 711, 320, 100);
		lbl_explain4.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl_explain4);
		
		JLabel lbl_explain5 = new JLabel("");
		lbl_explain5.setBounds(364, 838, 320, 100);
		lbl_explain5.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbl_explain5);
		
		
		//페이지 콜될때 버튼이름 이미지 가게설명라벨에 데이터를 넣기.
		for(int i=0;i<5;i++) {
			switch(i) {
			case 0:
				btn_store1.setIcon(new ImageIcon(arjs.get(i).getImageFile()));
				btn_store1.setText(arjs.get(i).getSname());
				lbl_explain1.setText(arjs.get(i).getExplain());
				break;
			case 1:
				btn_store2.setIcon(new ImageIcon(arjs.get(i).getImageFile()));
				btn_store2.setText(arjs.get(i).getSname());
				lbl_explain2.setText(arjs.get(i).getExplain());
				break;
			case 2:
				btn_store3.setIcon(new ImageIcon(arjs.get(i).getImageFile()));
				btn_store3.setText(arjs.get(i).getSname());
				lbl_explain3.setText(arjs.get(i).getExplain());
				break;
			case 3:
				btn_store4.setIcon(new ImageIcon(arjs.get(i).getImageFile()));
				btn_store4.setText(arjs.get(i).getSname());
				lbl_explain4.setText(arjs.get(i).getExplain());
				break;
			case 4:
				btn_store5.setIcon(new ImageIcon(arjs.get(i).getImageFile()));
				btn_store5.setText(arjs.get(i).getSname());
				lbl_explain5.setText(arjs.get(i).getExplain());
			}
		}
		
	}
}
