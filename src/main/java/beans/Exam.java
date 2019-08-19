package beans;

public class Exam {

	private int id;//考试编号
	private String ename;//考试名称
	private String stunum; // 学号
	private String eyear; // 考试时间:年
	private String emonth;// 考试时间:月
	private String eday;// 考试时间:日
	private String ehour;// 考试时间:时
	private String eminute;// 考试时间:分
	private double egrade; // 成绩
	private String eplace; // 考试地点

	public Exam() {
		super();
	}

	public Exam(int id, String ename, String stunum, String eyear, String emonth, String eday, String ehour,
			String eminute, double egrade, String eplace) {
		super();
		this.id = id;
		this.ename = ename;
		this.stunum = stunum;
		this.eyear = eyear;
		this.emonth = emonth;
		this.eday = eday;
		this.ehour = ehour;
		this.eminute = eminute;
		this.egrade = egrade;
		this.eplace = eplace;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getEyear() {
		return eyear;
	}

	public void setEyear(String eyear) {
		this.eyear = eyear;
	}

	public String getEmonth() {
		return emonth;
	}

	public void setEmonth(String emonth) {
		this.emonth = emonth;
	}

	public String getEday() {
		return eday;
	}

	public void setEday(String eday) {
		this.eday = eday;
	}

	public String getEhour() {
		return ehour;
	}

	public void setEhour(String ehour) {
		this.ehour = ehour;
	}

	public String getEminute() {
		return eminute;
	}

	public void setEminute(String eminute) {
		this.eminute = eminute;
	}

	public double getEgrade() {
		return egrade;
	}

	public void setEgrade(double egrade) {
		this.egrade = egrade;
	}

	public String getEplace() {
		return eplace;
	}

	public void setEplace(String eplace) {
		this.eplace = eplace;
	}

	

}
