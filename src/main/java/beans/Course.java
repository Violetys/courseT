package beans;

public class Course {

	private int cid; // 课程编号
	private String stunum; // 学号
	private String cname; // 课程名称
	private int cweekstart; // 课程开始周数
	private int cweekend; // 课程结束周数
	private int cweek; // 上课时间：星期
	private int cnum; // 上课时间：节数
	private String cteacher; // 任课教师
	private String cintro; // 课程简介
	private String cplace; // 上课地点

	public Course() {
		super();
	}

	public Course(int cid, String stunum, String cname, int cweekstart, int cweekend, int cweek, int cnum,
			String cteacher, String cintro, String cplace) {
		super();
		this.cid = cid;
		this.stunum = stunum;
		this.cname = cname;
		this.cweekstart = cweekstart;
		this.cweekend = cweekend;
		this.cweek = cweek;
		this.cnum = cnum;
		this.cteacher = cteacher;
		this.cintro = cintro;
		this.cplace = cplace;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCweekstart() {
		return cweekstart;
	}

	public void setCweekstart(int cweekstart) {
		this.cweekstart = cweekstart;
	}

	public int getCweekend() {
		return cweekend;
	}

	public void setCweekend(int cweekend) {
		this.cweekend = cweekend;
	}

	public int getCweek() {
		return cweek;
	}

	public void setCweek(int cweek) {
		this.cweek = cweek;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public String getCteacher() {
		return cteacher;
	}

	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}

	public String getCintro() {
		return cintro;
	}

	public void setCintro(String cintro) {
		this.cintro = cintro;
	}

	public String getCplace() {
		return cplace;
	}

	public void setCplace(String cplace) {
		this.cplace = cplace;
	}

}
