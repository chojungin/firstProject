package dbmethod1;

public class JavaList {
	//음식점의 메뉴의 정보를 저장할 class로 ArrayList<JavaList>로 쓰일 예정
	//imagefile은 메뉴창 호출시 이미지파일의 경로를 저장하는 곳으로 쓰이지만
	//결제하기로 넘어가게되면 메뉴를 클릭했던 정보를 저장하는 공간으로 쓰이며
	//결제를 하게되면 날짜정보를 넣어서 넘겨주는 공간으로 쓰인다.
	//후에 날짜 추가 기능이 추가되면서 날짜형데이터를 따로 선언해주는게 좋았겠지만
	//코드 전반적으로 수정이 불가피하므로 날짜를 string으로 넘겨주는 방식으로 채택.
	private String sid;
	private String sname;
	private String mname;
	private int mprice;
	private String imagefile;
	
	public JavaList() {
		
	}
	
	public JavaList(String sid,String sname,String mname,int mprice,String imagefile){
		this.sid=sid;
		this.sname=sname;
		this.mname=mname;
		this.mprice=mprice;
		this.imagefile=imagefile;
	}
 public String getImagefile() {
		return imagefile;
	}

	public void setImagefile(String imagefile) {
		this.imagefile = imagefile;
	}

public String getSid() {
		return sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}
	


	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public int getMprice() {
		return mprice;
	}


	public void setMprice(int mprice) {
		this.mprice = mprice;
	}



}
