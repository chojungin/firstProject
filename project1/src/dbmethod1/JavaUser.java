package dbmethod1;

public class JavaUser {
	//사용자의 정보를 저장할 class로 전화번호등에 관련된 추가기능이 없는상태이짐나
	//초기 계획당시 후에 추가할 수 있으므로 정보들을 최대한 저장을 해보았다.
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String tel;
	private String cardNum;
	private Integer cardPw;
	
	public JavaUser(String id, String pw, String name, String address, String tel, String cardNum, Integer cardPw) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = address;
		this.tel = tel;
		this.cardNum = cardNum;
		this.cardPw = cardPw;
	}
	public JavaUser() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return addr;
	}
	public void setAddress(String address) {
		this.addr = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Integer getCardPw() {
		return cardPw;
	}
	public void setCardPw(Integer cardPw) {
		this.cardPw = cardPw;
	}
	
	
	
}
