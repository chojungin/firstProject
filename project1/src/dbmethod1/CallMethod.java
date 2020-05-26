package dbmethod1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import dbconn.DbConn;

public class CallMethod {
   private Connection con;
   //db������ ����ϴ� ��Ű���� ������ ���� ��ü �������� con����
   
   public CallMethod() throws ClassNotFoundException, SQLException {
      con=new DbConn().getConnection();
   }
   //dbconn��Ű���� DbConnŬ������ getConnection�޼ҵ带 ȣ���ؼ� DbConnŬ������ ���ǵ� ���ᰴü�� ������.
   
   PreparedStatement pstm=null;
   ResultSet rs=null;
   //������ ������ statement����� ���� ����� ���� resultset���� �� �ʱ�ȭ
   //test(ȸ����ü)

   //sid, sname, saddress, smenuCg ���������̺� col��
   
   public ArrayList<JavaStore> addrStoreShowList(JavaUser jm) throws SQLException {
      //mainPage���� ����� �ּ��� ���������� �̾Ƽ� �������ִ� �޼ҵ�
      
      ArrayList<JavaStore> jsA=new ArrayList<JavaStore>();
      //return�� JavaStore��ü�� ���� arraylist
      String sql="select * from store where saddress=?";
      
      pstm=con.prepareStatement(sql);
      pstm.setString(1, jm.getAddress());
      rs=pstm.executeQuery();
      while(rs.next()) {
         jsA.add(new JavaStore(rs.getString("sid"),rs.getString("sname"),
               rs.getString("saddress"),rs.getString("smenuCg"),rs.getString("explain"),rs.getString("imagefile")));
         //������ζ�� JavaStore��ü�� ����� rs���� ������ �����͸� JavaStore��ü�� �Ӽ��� �־��ְ� JavaStore��ü��
         //�ٽ� jsA�� �־��������...���ٷ� �����
      }//while-end
      return jsA;
   }//addrStoreShowList-end
   
   public ArrayList<String> userAddresses(JavaUser jm) throws SQLException {
      //����� ��ġ������ ����� ��ġ���� ����Ʈ�� �̾��� �޼ҵ�
      ArrayList<String> alAddr=new ArrayList<String>();
      String sql="select address from useraddress where id=?";
      pstm=con.prepareStatement(sql);
      pstm.setString(1, jm.getId());
      rs=pstm.executeQuery();
      while(rs.next()) {
         alAddr.add(rs.getString("address"));
      }//while-end
      
      return alAddr;
   }//userAddresses-end
   
   
   public ArrayList<JavaStore> cgStoreShowList(String cgText,JavaUser jm) throws SQLException {
      ArrayList<JavaStore> alStore=new ArrayList<JavaStore>();
      //mainPage ī�װ� Ŭ���� StorePage�� ������ StorePage�� ������ ����Ʈ�� ���� �����͸� ������ �޼ҵ�
      
      String sql="select * from store where smenuCg=? and saddress=?";
      pstm=con.prepareStatement(sql);
      pstm.setString(1, cgText);
      pstm.setString(2, jm.getAddress());
      rs=pstm.executeQuery();
      while(rs.next()) {
         alStore.add(new JavaStore(rs.getString("sid"),rs.getString("sname"),
               rs.getString("saddress"),rs.getString("smenuCg"),rs.getString("explain"),rs.getString("imagefile")));
      }//while-ends

      return alStore;
   }//cgStoreShowList-end


   public ArrayList<JavaList> menulist(JavaStore js1) throws SQLException { 
      //������ ���ý� �޴��������� �� �׶� �޴��������� �޴�����Ʈ���� ������ �ʿ���
      //�׶� �ݵǼ� �������� ���� �޴����� ������ ���� 
      
      ArrayList<JavaList> jl = new ArrayList<JavaList>();
      String sql = " select * from menu where sid=?";
      pstm = con.prepareStatement(sql);
      pstm.setString(1, js1.getSid());
      rs = pstm.executeQuery();
      while (rs.next()) { // sid�� �ش��ϴ� mname
         jl.add(new JavaList(rs.getString("sid"), js1.getSname(), rs.getString("mname"), rs.getInt("mprice"),rs.getString("imagefile")));
      }//while-end
      return jl; // jl����Ʈ�� sid, sname,mname,mprice return
      

   }

   public ArrayList<JavaList> pwcheck(int cardpw, JavaUser jm, ArrayList<JavaList> jhA) throws SQLException {
	   
		// �����Ϸ�� ���� jhA�� ����� ������ db�� �ְ� jhA�� ������ ����°��ʿ�. ����cardpw�� ����â�����޾ƿ°�.
		// db�˻��� ȸ���� id�� �ʿ��ϹǷ� jm�� �ʿ�, �޼ҵ� �ȿ��� jhA�� db���� �� jhA�� ������ �ʿ��ϹǷ� jhA�ʿ�.
		//

		// ���� ��¥�� ����ֱ����ؼ� ��¥�� ������ ����
		SimpleDateFormat d1 = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		//��¥�κ��� ����â���� jhA�� image�� �޾ƿ��µ� �̴� �޴�â�� �θ� ���� �����ϰ�� imagefile�����ͺκ���
		//�����������Ƿ� ��Ȱ���ϴ� ������ ����.

		if (jhA.size() == 0) {
			JOptionPane.showMessageDialog(null, "���� ������ �����!!!!");
			return jhA;
		}

		String sql = "select cardpw from usertable where id =?"; // id�� �ش��ϴ� cardpw �˻�
		String sql1 = "insert into paymenthistory values(?,?,?,?,?,?)"; // ���簡 �Ϸ�Ǹ� ���系�� history���̺� insert
		// sql1�� ?�ϳ� �߰�
		pstm = con.prepareStatement(sql);
		pstm.setString(1, jm.getId());
		rs = pstm.executeQuery();

		while (rs.next()) {

			if (rs.getInt("cardpw") == cardpw) {// ������ �Ϸ� �� ��� for��

				for (int i = 0; i < jhA.size(); i++) {
					pstm = con.prepareStatement(sql1);
					pstm.setString(1, jhA.get(i).getSid());
					pstm.setString(2, jhA.get(i).getMname());
					pstm.setInt(3, jhA.get(i).getMprice());
					pstm.setString(4, jhA.get(i).getImagefile());
					pstm.setString(5, jm.getId());
					// ��¥�� �߰��غ�����.
					pstm.setString(6, d1.format(new Date()));
					// ���õ���Ʈ������ ������ format�޼���� ������ ��¥�� ��Ʈ������ �ٲ��ش�.
					pstm.executeUpdate();
				}

				int j = jhA.size();
				for (int i = 0; i < j; i++) {
					jhA.remove(0);
				} // ����Ϸ��ϰ� ������ ������ ��ٱ��� ��� ����
				JOptionPane.showMessageDialog(null, "���� �Ϸ� �Դϴ�!!!!");
				// paymentPage �������� ��⿡�� �޽������
			} // if-end
		} // while-end

		return jhA;

	}

//-------------------------------������---------------------------------------
	public int memberCheck(String id, String pw) throws SQLException {
		// �α��� �������� �α��� ��ư Ŭ����. ���� 2���� id, pw�� ���ϴ� �޼ҵ�
		
		String sql = "select id, pw from usertable where id =?";

		// �α��ν� �ԷµǴ� id�� pw�� usertable�� �ִ��� select�� Ȯ��

		pstm = con.prepareStatement(sql);
		pstm.setString(1, id); // ����ڰ� �Է��� id

		rs = pstm.executeQuery();

		while (rs.next()) {

			String getPw = rs.getString("pw");

			if (getPw.equals(pw)) { // id�� ���ٸ� pw�� ������?
				return 1; // id�� pw�� ��� ��ġ�ϹǷ� �α��� ����
			} else {
				return 2; //pw�� Ʋ��.
			}

		} // while-end

		return 3;
	}

	public int idOverlap(String id) throws SQLException {
		// ȸ���������������� ���̵��� �ߺ��� Ȯ���ϴ� �޼ҵ�, ���̵��ߺ�üũ ��ư Ŭ��.

		if (id.equals("")) {
			// JOptionPane.showMessageDialog(null, "����Ͻ� id�� ���� �ߺ�üũ���ּ���!");
			return 1;
		}

		String sql = "select id from usertable where id =?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, id); // ����ڰ� �Է��� id
		rs = pstm.executeQuery();

		if (rs.next()) {
			
			return 2; // ����ڰ� �Է��� ���̵� �ߺ��ǹǷ� showMessageDialog�Ŀ� ����ڰ� �Է��� ���̵𰪻���
		}
		
		return 3; // ����ڰ� �Է��� ���̵� �ߺ����������Ƿ� ��밡��

	}

	public int membershipCheck(String id, String pw, String cmpPw, String name, String addr, String tel, String cardNum,
			String cardPw) throws NumberFormatException, SQLException {
		// ȸ���������������� ��й�ȣ,��й�ȣ Ȯ�� �Է��ʵ��� ������ ����, ȸ������ �Է��ʵ忡 ������ ��� �Է������� DB usertable�� �ش�
		// ȸ������ ��ư ������ ��!
		// ������ insert���ִ� �޼ҵ�

		if (!cmpPw.equals(pw)) { // ��й�ȣȮ�� �Է��ʵ��� ����� ��й�ȣ �Է��ʵ��� ������ �����ʴٸ�
			
			return 1; // ��й�ȣȮ�ΰ� ��й�ȣ �Է��ʵ��� ������ ��������, ȸ������ ����
		}

		String sql = "insert into usertable values(?,?,?,?,?,?,?)";
		// ȸ�����Խ� �Էµ� ������ DB�� insert

		if (id.equals("") || pw.equals("") || cmpPw.equals("") || name.equals("") || addr.equals("") || tel.equals("")
				|| cardNum.equals("") || cardPw.equals("")) {
			// ȸ������ �Է��ʵ尡 �ϳ��� ����ִ���?
			
			return 2; // ��� ������ �Էµ����ʾ����Ƿ� �ƹ��� ������ ����
		}

		if (cardNum.length() != 16) {
			return 3; 
		}
		try {

			Long.parseLong(cardNum);
		} catch (Exception e) {
			
			return 3;
		}
		//ī�� ��й�ȣ�� 16�ڸ� ���ڷ� �̷������ �̸����ؼ� ���� üũ�� ���������� �مf�� �� ������ �������� üũ�ߴ�.Long
		try {
			Integer.parseInt(cardPw);
		} catch (Exception e) {
			return 4;
		}
		//ī�� ��д� ���ڷ� ���߱⿡ ����ȯ�� ������ �����ʴ����� üũ�ߴ�.
		
		pstm = con.prepareStatement(sql);
		pstm.setString(1, id); // ����ڰ� �Է��� id
		pstm.setString(2, pw); // ����ڰ� �Է��� pw
		pstm.setString(3, name); // ����ڰ� �Է��� name
		pstm.setString(4, addr); // ����ڰ� �Է��� addr
		pstm.setString(5, tel); // ����ڰ� �Է��� tel
		String str = cardNum.substring(0, 4) + "-" + cardNum.substring(4, 8) + "-" + cardNum.substring(8, 12) + "-"
				+ cardNum.substring(12, 16);
		pstm.setString(6, str); // ����ڰ� �Է��� cardNum
		pstm.setInt(7, Integer.parseInt(cardPw)); // ����ڰ� �Է��� cardPw

		pstm.executeUpdate();

		String sql2 = "insert into useraddress values(?,?)";
		pstm = con.prepareStatement(sql2);
		pstm.setString(1, id);
		pstm.setString(2, addr);
		pstm.executeUpdate();

		return 5; // ȸ�����Կ� �����Ͽ� �α����������� �̵�
	}

//----------------------------���ξ�--------------------------------------------
	public ArrayList<JavaList> mapAddress(JavaUser ju) throws SQLException {
		// ����� ����â Ŭ���� ������ ���� ���� ���ĵ��� �������� �ޱ� ���� �޼ҵ�
		// ������ �̸� �޴�,������ �ʿ��ϴ�.
		
		ArrayList<JavaList> checkAddress = new ArrayList<JavaList>();

		String sql = " select p.pid as pid, s.sname as sname, p.pmname as pmname, p.pmprice as pmprice,"
				+ "s.imagefile as imagefile from paymenthistory p,store s where p.pstoreid = s.sid and p.pid=?";

		pstm = con.prepareStatement(sql);
		pstm.setString(1, ju.getId());
		rs = pstm.executeQuery();

		while (rs.next()) {
			checkAddress.add(new JavaList(rs.getString("pid"), rs.getString("sname"), rs.getString("pmname"),
					rs.getInt("pmprice"), rs.getString("imagefile")));
		}//while-end

		return checkAddress;

	}

	// �߰��ʿ� �޼ҵ� - MapPage���� �Ϸ� ��ư�� �������� �� �ּҸ� db�� useraddress���̺� ������ �Ǿ���Ѵ�.
	public void addUserAddr(JavaUser ju, ArrayList<String> alInAddr) throws SQLException {
		String sql = "insert into useraddress values(?,?)";
		
		for (int i = 0; i < alInAddr.size(); i++) {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, ju.getId());
			pstm.setString(2, alInAddr.get(i).toString());
			pstm.executeUpdate();
		} // for-end

	}//

	// �߰��ʿ� �޼ҵ�2 - �ű� page MyInfoPage�� �ҷ��Ë� db(paymenthistory���̺�)���� �ڽ��� ���ѸԾ��� ���ĵ���
	// ������ �����;��Ѵ�.
	// �ʿ��� ������ ȸ����ü�� id�� ������ �����ϹǷ� ȸ����ü jm�� �����´�.
	public ArrayList<JavaList> getHistory(JavaUser jm) throws SQLException {
		ArrayList<JavaList> alH = new ArrayList<JavaList>();
		String sql = "select p.pid as pid,s.sname as sname,p.pmname as pmname,p.pmprice as pmprice,p.pdate as pdate "
				+ "from paymenthistory p, store s where p.pstoreid=s.sid and p.pid=?";
		// ���� ȸ�������� ȸ����ü jm���� id�� �̾Ƽ� sql���� �־ paymenthistory���̺�� store���̺������ؼ� ȸ���� ����
		// �޴����� �̾Ƴ���.
		pstm = con.prepareStatement(sql);
		pstm.setString(1, jm.getId());
		rs = pstm.executeQuery();
		while (rs.next()) {
			alH.add(new JavaList(rs.getString("pid"), rs.getString("sname"), rs.getString("pmname"),
					(Integer) rs.getInt("pmprice"), rs.getString("pdate")));
			// ��񿡼� number�� ����� ���ݰ��� Integer�� �޾ƿ´�.
		} // while-end
		return alH;
		// ���ϵ� alH���� �����̸� �޴��̸� ������ ���δ�.
	}// getHistory-end

	// �߰��ʿ� �޼ҵ�3 - MapPage���� �ּ��߰� ��ư�� Ŭ���� �Է��� �ּҰ� �����ϴ� �ּҶ�� �������� �ʾƾ���.
	// ��� ���� �޼ҵ尡 �ʿ���.
	public boolean cmpAddr(String addr, ArrayList<String> alInAddr, String jm) throws SQLException {
		for (int i = 0; i < alInAddr.size(); i++) {
			if (alInAddr.get(i).toString().equals(addr))
				return false;
		}
		String sql = "select * from useraddress where id=? and address =?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, jm);
		pstm.setString(2, addr);
		rs = pstm.executeQuery();

		while (rs.next()) {
			if (rs.getString("id").equals(jm) && rs.getString("address").equals(addr))

				return false;
		}

		return true;

	}

	// �α��� ������ ȸ�� ��ü�� �����ͼ� ������ �޼ҵ�
	public JavaUser userInfo(String id) throws SQLException {
		JavaUser ju = new JavaUser();
		String sql = "select * from usertable where id=?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, id);
		rs = pstm.executeQuery();
		while (rs.next()) {
			ju.setId(rs.getString("id"));
			ju.setPw(rs.getString("pw"));
			ju.setName(rs.getString("name"));
			ju.setAddress(rs.getString("address"));
			ju.setTel(rs.getString("tel"));
			ju.setCardNum(rs.getString("cardnum"));
			ju.setCardPw(rs.getInt("cardpw"));
		}//while-end
		return ju;
	}

}// class CallMethod-end
