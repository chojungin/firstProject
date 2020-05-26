package dbmethod1;

public class JavaUser {
	//������� ������ ������ class�� ��ȭ��ȣ� ���õ� �߰������ ���»���������
	//�ʱ� ��ȹ��� �Ŀ� �߰��� �� �����Ƿ� �������� �ִ��� ������ �غ��Ҵ�.
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
