package dbmethod1;

public class JavaStore {
	//가게들의 정보를 담을 class
	//imagefile은 가게 이미지파일의 위치를 저장한다.
	private String sid;
	private String sname;
	private String saddress;
	private String smenuCg;
	private String explain;
	private String imagefile;

	
	public JavaStore() {
		
	}
	public JavaStore(String sid,String sname,String saddress,String smenuCg,String explain,String imagefile ) {
		this.sid=sid;
		this.sname=sname;
		this.saddress=saddress;
		this.smenuCg=smenuCg;
		this.explain=explain;
		this.imagefile=imagefile;
	
	}
	
	public String getImageFile() {
		return imagefile;
	}
	public void setImageFile(String imageFile) {
		this.imagefile = imageFile;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
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
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSmenuCg() {
		return smenuCg;
	}
	public void setSmenuCg(String smenuCg) {
		this.smenuCg = smenuCg;
	}


	
	

}
