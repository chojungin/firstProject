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
	//����� �ּҷ� �˻��ؼ� �޾ƿ� ���Ը� ���� arraylist
	
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
		//�޼ҵ� ���� ���� Ŭ��������
		
		arjs=cm.addrStoreShowList(jm);
		//����� �ּҷ� ���� �ּ��� ���Ը� �˻��ؼ� �������ִ� �޼ҵ� ��
		Collections.shuffle(arjs);
		//���ϵ� ���������� ������ �����ش�. �̷����� �������� ������ ���� �ٸ� ���Ե��� �����Եȴ�.
		
		
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
		btn_cg1.setFont(new Font("����", Font.PLAIN, 25));
		btn_cg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ѽ� ī�װ��� Ŭ��.
				dispose();
				StorePage.main(btn_cg1.getText(), jm, js, jhA);
				//ī�װ��� Ŭ���ϸ� ī�װ��� �°� jm�� ����� �������� �ּҿ� �ִ�
				//���Ե��� �̾ƾ��ϹǷ� ��ư���� ������ ī�װ����� text�� �Բ� �����ش�.
			}
		});
		toolBar.add(btn_cg1);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_cg2 = new JButton("\uC911\uC2DD");
		btn_cg2.setFont(new Font("����", Font.PLAIN, 25));
		btn_cg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�߽� ī�װ��� Ŭ��.
				dispose();
				StorePage.main(btn_cg2.getText(), jm, js, jhA);
			}
		});
		toolBar.add(btn_cg2);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_cg3 = new JButton("\uC77C\uC2DD");
		btn_cg3.setFont(new Font("����", Font.PLAIN, 25));
		btn_cg3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�Ͻ� ī�װ��� Ŭ��.
				dispose();
				StorePage.main(btn_cg3.getText(), jm, js, jhA);
			}
		});
		toolBar.add(btn_cg3);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_cg4 = new JButton("\uC591\uC2DD");
		btn_cg4.setFont(new Font("����", Font.PLAIN, 25));
		btn_cg4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��� ī�װ��� Ŭ��.
				dispose();
				StorePage.main(btn_cg4.getText(), jm, js, jhA);
			}
		});
		toolBar.add(btn_cg4);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_cg5 = new JButton("\uAE30\uD0C0");
		btn_cg5.setFont(new Font("����", Font.PLAIN, 25));
		btn_cg5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//��Ÿ ī�װ��� Ŭ��.
				dispose();
				StorePage.main(btn_cg5.getText(), jm, js, jhA);
			}
		});
		toolBar.add(btn_cg5);
		toolBar.addSeparator( new Dimension(50,50));
		
		JButton btn_map = new JButton("\uC704\uCE58\uC815\uBCF4");
		btn_map.setBounds(440, 12, 100, 100);
		//----------------�������߰�-------------------
		btn_map.setIcon(new ImageIcon("C:\\images\\������\\map.jpg"));
		//----------------�������߰�-------------------
		btn_map.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MapPage.main(jm, js, jhA);
				//��ġ�����������κ� Ŭ��.
				
			}
		});
		contentPane.add(btn_map);
		
		JButton btn_shop = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		btn_shop.setBounds(554, 12, 100, 100);
		//----------------�������߰�-------------------
		btn_shop.setIcon(new ImageIcon("C:\\images\\������\\shopping.jpg"));
		//----------------�������߰�-------------------
		btn_shop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShoppingPage.main(jm, js, jhA);
				//��ٱ��� �κ��� Ŭ��.
			}
		});
		contentPane.add(btn_shop);
		
		JButton btn_user = new JButton("\uB0B4 \uC815\uBCF4");
		btn_user.setBounds(668, 12, 100, 100);
		//----------------�������߰�-------------------
		btn_user.setIcon(new ImageIcon("C:\\images\\������\\myinfo.jpg"));
		//----------------�������߰�-------------------
		btn_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyInfoPage.main(jm,js,jhA);
				//������ �κ��� Ŭ��.
			}
		});
		contentPane.add(btn_user);
		
		
		
		
		JButton btn_store1 = new JButton("");
		btn_store1.setBounds(42, 306, 320, 100);
		btn_store1.setHorizontalAlignment(SwingConstants.LEFT);
		
		btn_store1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���Թ�ư 1��° Ŭ��
				dispose();
				MenuPage.main(jm, arjs.get(0), jhA);
				//������� �ּҿ� �´� ���Ե��� ��� ArrayList�� arjs���� ���������� �����ش�.
				//�� ������ id�� �Ѿ�� MenuPage�� ������ ���� id�� �װ����� �޴��� ã�����ش�.
			}
		});
		
		contentPane.add(btn_store1);
		
		JButton btn_store2 = new JButton("");
		btn_store2.setBounds(40, 457, 320, 100);
		btn_store2.setHorizontalAlignment(SwingConstants.LEFT);
		btn_store2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���Թ�ư 2��° Ŭ��
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
				//���Թ�ư 3��° Ŭ��
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
				//���Թ�ư 4��° Ŭ��
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
				//���Թ�ư 5��° Ŭ��
				dispose();
				MenuPage.main(jm, arjs.get(4), jhA);
			}
		});
		contentPane.add(btn_store5);
		
		JButton btn_sitename = new JButton("\uC0AC\uC774\uD2B8\uBA85");
		btn_sitename.setBounds(14, 12, 400, 100);
		btn_sitename.setIcon(new ImageIcon("C:\\images\\������\\sitename.jpg"));
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
		
		
		//������ �ݵɶ� ��ư�̸� �̹��� ���Լ���󺧿� �����͸� �ֱ�.
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
