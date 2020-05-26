package page;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dbmethod1.CallMethod;
import dbmethod1.JavaList;
import dbmethod1.JavaStore;
import dbmethod1.JavaUser;
import javax.swing.SwingConstants;

public class MapPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_addr;
	
	

	/**
	 * Launch the application.
	 * @return 
	 * @return 
	 */
	public static void main(JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapPage frame = new MapPage(jm,js,jhA);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 * @param jhA 
	 * @param js 
	 * @param jm 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MapPage(JavaUser jm, JavaStore js, ArrayList<JavaList> jhA) throws ClassNotFoundException, SQLException {
		CallMethod cm=new CallMethod(); //�޼ҵ����� ���� �߰�
		
		ArrayList<String> alInAddr=new ArrayList<String>();
		//mapPage���� �ּ� �߰���ư�� Ŭ���� �ѹ��̸� �ʿ䰡 ������ ������ Ŭ���ؼ� �ּ� �������� �ѹ��� ���Ë���
		//���� �ؽ�Ʈ �κи� ������ ���� �ƴ϶� ������ ������ �ʿ��ϴ�. ������ ������ ���������Ƿ�
		//ArrayList�� ������ �ص־� �ҵ�.
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(850, 0, 350, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_map = new JLabel("\uC704\uCE58\uC124\uC815");
		lbl_map.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_map.setBounds(134, 12, 68, 28);
		contentPane.add(lbl_map);
		
		JLabel lbl_addr1 = new JLabel("\uD604\uC7AC \uC8FC\uC18C");
		lbl_addr1.setBounds(14, 52, 62, 28);
		contentPane.add(lbl_addr1);
		
		JLabel lbl_addr2 = new JLabel("New label");
		lbl_addr2.setBounds(198, 52, 120, 28);
		//-------------------------------------------------------
		lbl_addr2.setText(jm.getAddress());
		
		contentPane.add(lbl_addr2);
		
		JButton btn_back = new JButton("\uCDE8\uC18C");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage.main(jm, js, jhA);
			}
		});
		btn_back.setBounds(14, 314, 117, 27);
		contentPane.add(btn_back);
		
		JButton btn_front = new JButton("\uC644 \uB8CC");
		
		btn_front.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�Ϸ� ��ư�� ���������� ��μ� �̿����� �ּҰ� �ٲ�.
				jm.setAddress(lbl_addr2.getText());
				
				//ȸ����ü���� �ּҰ� �����ּҷ� �ٲ�.
			try {
					cm.addUserAddr(jm,alInAddr);
					//������ �߰��� �ּҰ� db�� useraddress�� ����
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			MainPage.main(jm, js, jhA);
			dispose();


			}
		});
		btn_front.setBounds(213, 314, 105, 27);
		contentPane.add(btn_front);
		
		JScrollPane sc_addr = new JScrollPane();
		sc_addr.setBounds(14, 148, 304, 110);
		contentPane.add(sc_addr);
		
		JLabel lbl_selectedAddr = new JLabel("");
		lbl_selectedAddr.setBounds(14, 270, 199, 27);
		contentPane.add(lbl_selectedAddr);
	
		
		JList<String> list_addr;
		ArrayList<String> alAddr=cm.userAddresses(jm);
		
		//-----------------------------!!!!!!!!!!!!!!!!!!!!!--------
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(int i=0;i<alAddr.size();i++) {
			model.add(i, alAddr.get(i).toString());
		}
		list_addr=new JList<String>(model);
		
		list_addr.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				//�ּ� ����Ʈ���� �ּ� �ϳ� ���ý�.
				lbl_selectedAddr.setText(list_addr.getSelectedValue());
				//����Ʈ���� ���ý� �ؿ�lbl_SelectedAddr�� ���ϴ� �κ� 
			}
		});
		list_addr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sc_addr.setViewportView(list_addr);
		
		txt_addr = new JTextField();
		txt_addr.setBounds(93, 112, 120, 24);
		contentPane.add(txt_addr);
		txt_addr.setColumns(10);
		
		JButton btn_addAddr = new JButton("\uCD94\uAC00\uD558\uAE30");
		btn_addAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ּ� �߰� ��ư Ŭ���� ����Ʈ���� �ϳ� �߰��ϸ� ��.
				//������ ����Ʈ�� �ִ� ���� �𸣰���....
				
				//������ �߰��� �� �� ����....�߰��� �� ���� ���� �ּҸ� �����ؾ��ҵ�.
				//db�� ����� �ּҸ� �ߺ��ؼ� ������ ������ ����.
				//�ᱹ �̺�Ʈ����Ʈ�ʿ��� �������ƴ϶� db�� �����Ǽ� ó���� �ؾ� �� �� ��.
				//���� �Ϸ� ��ư�� db�� �����ϰ� �߰���ư�� Ŭ���ô� ����Ʈ���� �߰��Ǵ� ������ �ص���.
				
				try {
					if(txt_addr.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "�ּ�â�� �ּҸ� �Է��ϼ���!");
					}
					//��ĭ �Է¾ȵǰ� ����
					else if(cm.cmpAddr(txt_addr.getText(),alInAddr,jm.getId())) {
						alInAddr.add(txt_addr.getText());
						model.addElement(txt_addr.getText());
						list_addr.setModel(model);
					}
					else{
						JOptionPane.showMessageDialog(null, "���� �Ǿ��ִ� �ּ��Դϴ�");
					}//if-end
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}//actionPerformed-end
		});//addActionListener-end
		
		btn_addAddr.setBounds(227, 112, 91, 24);
		contentPane.add(btn_addAddr);
		
		
		JButton btnsaveAddr = new JButton("\uC8FC\uC18C\uC800\uC7A5");
		btnsaveAddr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ּ� ���� ��ư Ŭ����.- �󺧸� �ٲ�.
				if(!lbl_selectedAddr.getText().equals(""))
					//���� ���õ� �ּҰ� ������ �󺧿� ���� �����ϸ� �ٲ���.
					lbl_addr2.setText(lbl_selectedAddr.getText());
				else
					JOptionPane.showMessageDialog(null, "���õ� �ּ� ���� �����!!");
			}
		});
		btnsaveAddr.setBounds(227, 270, 91, 32);
		contentPane.add(btnsaveAddr);
		
		JLabel lbl_addr = new JLabel("\uC8FC\uC18C\uC785\uB825 :");
		lbl_addr.setBounds(14, 115, 76, 18);
		contentPane.add(lbl_addr);
	}
}
