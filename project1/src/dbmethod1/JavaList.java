package dbmethod1;

public class JavaList {
	//�������� �޴��� ������ ������ class�� ArrayList<JavaList>�� ���� ����
	//imagefile�� �޴�â ȣ��� �̹��������� ��θ� �����ϴ� ������ ��������
	//�����ϱ�� �Ѿ�ԵǸ� �޴��� Ŭ���ߴ� ������ �����ϴ� �������� ���̸�
	//������ �ϰԵǸ� ��¥������ �־ �Ѱ��ִ� �������� ���δ�.
	//�Ŀ� ��¥ �߰� ����� �߰��Ǹ鼭 ��¥�������͸� ���� �������ִ°� ���Ұ�����
	//�ڵ� ���������� ������ �Ұ����ϹǷ� ��¥�� string���� �Ѱ��ִ� ������� ä��.
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
