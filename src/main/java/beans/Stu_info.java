package beans;

public class Stu_info {

	private String stunum; // 学号
	private String stuname; // 学生姓名
	private String stugrade; // 学生年级
	private String stucollege; // 学生专业

	public Stu_info() {
		super();
	}

	public Stu_info(String stunum, String stuname, String stugrade, String stucollege) {
		super();
		this.stunum = stunum;
		this.stuname = stuname;
		this.stugrade = stugrade;
		this.stucollege = stucollege;
	}

	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStugrade() {
		return stugrade;
	}

	public void setStugrade(String stugrade) {
		this.stugrade = stugrade;
	}

	public String getStucollege() {
		return stucollege;
	}

	public void setStucollege(String stucollege) {
		this.stucollege = stucollege;
	}

}
