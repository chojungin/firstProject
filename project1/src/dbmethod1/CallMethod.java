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
   //db연결을 담당하는 패키지와 연결할 연결 객체 참조변수 con선언
   
   public CallMethod() throws ClassNotFoundException, SQLException {
      con=new DbConn().getConnection();
   }
   //dbconn패키지의 DbConn클래스의 getConnection메소드를 호출해서 DbConn클래스에 정의된 연결객체를 가져옴.
   
   PreparedStatement pstm=null;
   ResultSet rs=null;
   //쿼리를 실행할 statement선언과 쿼리 결과를 담을 resultset선언 및 초기화
   //test(회원객체)

   //sid, sname, saddress, smenuCg 음식점테이블 col명
   
   public ArrayList<JavaStore> addrStoreShowList(JavaUser jm) throws SQLException {
      //mainPage에서 사용자 주소의 음식점들을 뽑아서 리턴해주는 메소드
      
      ArrayList<JavaStore> jsA=new ArrayList<JavaStore>();
      //return할 JavaStore객체를 담을 arraylist
      String sql="select * from store where saddress=?";
      
      pstm=con.prepareStatement(sql);
      pstm.setString(1, jm.getAddress());
      rs=pstm.executeQuery();
      while(rs.next()) {
         jsA.add(new JavaStore(rs.getString("sid"),rs.getString("sname"),
               rs.getString("saddress"),rs.getString("smenuCg"),rs.getString("explain"),rs.getString("imagefile")));
         //기존대로라면 JavaStore객체를 만들고 rs값의 각각의 데이터를 JavaStore객체의 속성에 넣어주고 JavaStore객체를
         //다시 jsA에 넣어줘야지만...한줄로 깔끔히
      }//while-end
      return jsA;
   }//addrStoreShowList-end
   
   public ArrayList<String> userAddresses(JavaUser jm) throws SQLException {
      //사용자 위치설정시 저장된 위치들의 리스트를 뽑아줄 메소드
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
      //mainPage 카테고리 클릭시 StorePage가 열리고 StorePage의 음식점 리스트에 넣을 데이터를 가져올 메소드
      
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
      //음식점 선택시 메뉴페이지가 콜 그때 메뉴페이지에 메뉴리스트들의 정보가 필요함
      //그때 콜되서 음식점에 대한 메뉴들의 정보를 리턴 
      
      ArrayList<JavaList> jl = new ArrayList<JavaList>();
      String sql = " select * from menu where sid=?";
      pstm = con.prepareStatement(sql);
      pstm.setString(1, js1.getSid());
      rs = pstm.executeQuery();
      while (rs.next()) { // sid에 해당하는 mname
         jl.add(new JavaList(rs.getString("sid"), js1.getSname(), rs.getString("mname"), rs.getInt("mprice"),rs.getString("imagefile")));
      }//while-end
      return jl; // jl리스트에 sid, sname,mname,mprice return
      

   }

   public ArrayList<JavaList> pwcheck(int cardpw, JavaUser jm, ArrayList<JavaList> jhA) throws SQLException {
	   
		// 결제완료시 현제 jhA에 저장된 정보를 db에 넣고 jhA의 내용을 지우는게필요. 인자cardpw는 결제창에서받아온것.
		// db검색시 회원의 id가 필요하므로 jm이 필요, 메소드 안에서 jhA의 db저장 및 jhA가 삭제가 필요하므로 jhA필요.
		//

		// 오늘 날짜를 찍어주기위해서 날짜형 변수를 선언
		SimpleDateFormat d1 = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		//날짜부분은 결제창에서 jhA의 image에 받아오는데 이는 메뉴창을 부를 때를 제외하고는 imagefile데이터부분이
		//쓰이지않으므로 재활용하는 것으로 정함.

		if (jhA.size() == 0) {
			JOptionPane.showMessageDialog(null, "고르신 음식이 없어요!!!!");
			return jhA;
		}

		String sql = "select cardpw from usertable where id =?"; // id에 해당하느 cardpw 검색
		String sql1 = "insert into paymenthistory values(?,?,?,?,?,?)"; // 결재가 완료되면 결재내역 history테이블에 insert
		// sql1에 ?하나 추가
		pstm = con.prepareStatement(sql);
		pstm.setString(1, jm.getId());
		rs = pstm.executeQuery();

		while (rs.next()) {

			if (rs.getInt("cardpw") == cardpw) {// 결제가 완료 된 경우 for문

				for (int i = 0; i < jhA.size(); i++) {
					pstm = con.prepareStatement(sql1);
					pstm.setString(1, jhA.get(i).getSid());
					pstm.setString(2, jhA.get(i).getMname());
					pstm.setInt(3, jhA.get(i).getMprice());
					pstm.setString(4, jhA.get(i).getImagefile());
					pstm.setString(5, jm.getId());
					// 날짜를 추가해보겠음.
					pstm.setString(6, d1.format(new Date()));
					// 심플데이트포멧형 변수의 format메서드는 인자의 날짜를 스트링으로 바꿔준다.
					pstm.executeUpdate();
				}

				int j = jhA.size();
				for (int i = 0; i < j; i++) {
					jhA.remove(0);
				} // 결재완료하고 데이터 저장후 장바구니 목록 제거
				JOptionPane.showMessageDialog(null, "결제 완료 입니다!!!!");
				// paymentPage 수정으로 요기에서 메시지출력
			} // if-end
		} // while-end

		return jhA;

	}

//-------------------------------성윤씨---------------------------------------
	public int memberCheck(String id, String pw) throws SQLException {
		// 로그인 페이지의 로그인 버튼 클릭시. 텍필 2개의 id, pw로 비교하는 메소드
		
		String sql = "select id, pw from usertable where id =?";

		// 로그인시 입력되는 id와 pw가 usertable에 있는지 select로 확인

		pstm = con.prepareStatement(sql);
		pstm.setString(1, id); // 사용자가 입력한 id

		rs = pstm.executeQuery();

		while (rs.next()) {

			String getPw = rs.getString("pw");

			if (getPw.equals(pw)) { // id가 같다면 pw도 같은지?
				return 1; // id와 pw가 모두 일치하므로 로그인 성공
			} else {
				return 2; //pw가 틀림.
			}

		} // while-end

		return 3;
	}

	public int idOverlap(String id) throws SQLException {
		// 회원가입페이지에서 아이디의 중복을 확인하는 메소드, 아이디중복체크 버튼 클릭.

		if (id.equals("")) {
			// JOptionPane.showMessageDialog(null, "사용하실 id를 적고 중복체크해주세요!");
			return 1;
		}

		String sql = "select id from usertable where id =?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, id); // 사용자가 입력한 id
		rs = pstm.executeQuery();

		if (rs.next()) {
			
			return 2; // 사용자가 입력한 아이디가 중복되므로 showMessageDialog후에 사용자가 입력한 아이디값삭제
		}
		
		return 3; // 사용자가 입력한 아이디가 중복되지않으므로 사용가능

	}

	public int membershipCheck(String id, String pw, String cmpPw, String name, String addr, String tel, String cardNum,
			String cardPw) throws NumberFormatException, SQLException {
		// 회원가입페이지에서 비밀번호,비밀번호 확인 입력필드의 내용이 같고, 회원정보 입력필드에 내용을 모두 입력했을때 DB usertable에 해당
		// 회원가입 버튼 누르면 콜!
		// 정보를 insert해주는 메소드

		if (!cmpPw.equals(pw)) { // 비밀번호확인 입력필드의 내용과 비밀번호 입력필드의 내용이 같지않다면
			
			return 1; // 비밀번호확인과 비밀번호 입력필드의 내용이 같지않음, 회원가입 실패
		}

		String sql = "insert into usertable values(?,?,?,?,?,?,?)";
		// 회원가입시 입력된 내용을 DB에 insert

		if (id.equals("") || pw.equals("") || cmpPw.equals("") || name.equals("") || addr.equals("") || tel.equals("")
				|| cardNum.equals("") || cardPw.equals("")) {
			// 회원가입 입력필드가 하나라도 비어있는지?
			
			return 2; // 모든 정보가 입력되지않았으므로 아무런 변동이 없음
		}

		if (cardNum.length() != 16) {
			return 3; 
		}
		try {

			Long.parseLong(cardNum);
		} catch (Exception e) {
			
			return 3;
		}
		//카드 비밀번호는 16자리 숫자로 이루어진다 이를위해서 길이 체크와 숫자형으로 바꿧을 떄 오류가 나는지를 체크했다.Long
		try {
			Integer.parseInt(cardPw);
		} catch (Exception e) {
			return 4;
		}
		//카드 비밀는 숫자로 정했기에 형변환시 오류가 나지않는지로 체크했다.
		
		pstm = con.prepareStatement(sql);
		pstm.setString(1, id); // 사용자가 입력한 id
		pstm.setString(2, pw); // 사용자가 입력한 pw
		pstm.setString(3, name); // 사용자가 입력한 name
		pstm.setString(4, addr); // 사용자가 입력한 addr
		pstm.setString(5, tel); // 사용자가 입력한 tel
		String str = cardNum.substring(0, 4) + "-" + cardNum.substring(4, 8) + "-" + cardNum.substring(8, 12) + "-"
				+ cardNum.substring(12, 16);
		pstm.setString(6, str); // 사용자가 입력한 cardNum
		pstm.setInt(7, Integer.parseInt(cardPw)); // 사용자가 입력한 cardPw

		pstm.executeUpdate();

		String sql2 = "insert into useraddress values(?,?)";
		pstm = con.prepareStatement(sql2);
		pstm.setString(1, id);
		pstm.setString(2, addr);
		pstm.executeUpdate();

		return 5; // 회원가입에 성공하여 로그인페이지로 이동
	}

//----------------------------정인씨--------------------------------------------
	public ArrayList<JavaList> mapAddress(JavaUser ju) throws SQLException {
		// 사용자 정보창 클릭시 나오는 여태 먹은 음식들의 정보들을 받기 위한 메소드
		// 가게의 이름 메뉴,가격이 필요하다.
		
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

	// 추가필요 메소드 - MapPage에서 완료 버튼이 눌러지면 그 주소를 db의 useraddress테이블에 저장이 되어야한다.
	public void addUserAddr(JavaUser ju, ArrayList<String> alInAddr) throws SQLException {
		String sql = "insert into useraddress values(?,?)";
		
		for (int i = 0; i < alInAddr.size(); i++) {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, ju.getId());
			pstm.setString(2, alInAddr.get(i).toString());
			pstm.executeUpdate();
		} // for-end

	}//

	// 추가필요 메소드2 - 신규 page MyInfoPage를 불러올떄 db(paymenthistory테이블)에서 자신이 시켜먹었던 음식들의
	// 정보를 가져와야한다.
	// 필요한 정보는 회원객체의 id만 있으면 가능하므로 회원객체 jm만 가져온다.
	public ArrayList<JavaList> getHistory(JavaUser jm) throws SQLException {
		ArrayList<JavaList> alH = new ArrayList<JavaList>();
		String sql = "select p.pid as pid,s.sname as sname,p.pmname as pmname,p.pmprice as pmprice,p.pdate as pdate "
				+ "from paymenthistory p, store s where p.pstoreid=s.sid and p.pid=?";
		// 현재 회원정보인 회원객체 jm에서 id를 뽑아서 sql문에 넣어서 paymenthistory테이블과 store테이블조인해서 회원이 먹은
		// 메뉴들을 뽑아낸다.
		pstm = con.prepareStatement(sql);
		pstm.setString(1, jm.getId());
		rs = pstm.executeQuery();
		while (rs.next()) {
			alH.add(new JavaList(rs.getString("pid"), rs.getString("sname"), rs.getString("pmname"),
					(Integer) rs.getInt("pmprice"), rs.getString("pdate")));
			// 디비에서 number로 저장된 가격값을 Integer로 받아온다.
		} // while-end
		return alH;
		// 리턴된 alH에서 가게이름 메뉴이름 가격이 쓰인다.
	}// getHistory-end

	// 추가필요 메소드3 - MapPage에서 주소추가 버튼을 클릭시 입력한 주소가 존재하는 주소라면 저장하지 않아야함.
	// 고로 비교할 메소드가 필요함.
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

	// 로그인 성공시 회원 객체를 가져와서 저장할 메소드
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
