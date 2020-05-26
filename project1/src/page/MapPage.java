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
		CallMethod cm=new CallMethod(); //메소드사용을 위한 추가
		
		ArrayList<String> alInAddr=new ArrayList<String>();
		//mapPage에서 주소 추가버튼을 클릭시 한번이면 필요가 없지만 여러번 클릭해서 주소 여러개가 한번에 들어올떄는
		//그저 텍스트 부분만 가져갈 것이 아니라 저장할 공간이 필요하다. 갯수가 정해져 있지않으므로
		//ArrayList로 저장을 해둬야 할듯.
	
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
				//완료 버튼이 눌러졌을때 비로소 이용자의 주소가 바뀜.
				jm.setAddress(lbl_addr2.getText());
				
				//회원객체내의 주소가 설정주소로 바뀜.
			try {
					cm.addUserAddr(jm,alInAddr);
					//유저가 추가한 주소가 db의 useraddress에 저장
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
				//주소 리스트에서 주소 하나 선택시.
				lbl_selectedAddr.setText(list_addr.getSelectedValue());
				//리스트에서 선택시 밑에lbl_SelectedAddr가 변하는 부분 
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
				//주소 추가 버튼 클릭시 리스트에만 하나 추가하면 됨.
				//문제는 리스트에 넣는 법을 모르겠음....
				
				//여러번 추가를 할 수 있음....추가할 때 마다 넣을 주소를 저장해야할듯.
				//db에 저장된 주소를 중복해서 저장할 위험이 있음.
				//결국 이벤트리스트쪽에서 끝낼꼐아니라 db와 연동되서 처리를 해야 할 듯 함.
				//현재 완료 버튼시 db에 저장하고 추가버튼만 클릭시는 리스트에만 추가되는 것으로 해뒀음.
				
				try {
					if(txt_addr.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "주소창에 주소를 입력하세요!");
					}
					//빈칸 입력안되게 수정
					else if(cm.cmpAddr(txt_addr.getText(),alInAddr,jm.getId())) {
						alInAddr.add(txt_addr.getText());
						model.addElement(txt_addr.getText());
						list_addr.setModel(model);
					}
					else{
						JOptionPane.showMessageDialog(null, "저장 되어있는 주소입니다");
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
				//주소 저장 버튼 클릭시.- 라벨만 바뀜.
				if(!lbl_selectedAddr.getText().equals(""))
					//만약 선택된 주소가 나오는 라벨에 값이 존재하면 바꿔줌.
					lbl_addr2.setText(lbl_selectedAddr.getText());
				else
					JOptionPane.showMessageDialog(null, "선택된 주소 값이 없어요!!");
			}
		});
		btnsaveAddr.setBounds(227, 270, 91, 32);
		contentPane.add(btnsaveAddr);
		
		JLabel lbl_addr = new JLabel("\uC8FC\uC18C\uC785\uB825 :");
		lbl_addr.setBounds(14, 115, 76, 18);
		contentPane.add(lbl_addr);
	}
}
