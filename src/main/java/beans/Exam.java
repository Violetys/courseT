package beans;

public class Exam {

	private int cid; // 课程编号
	private String stunum; // 学号
	private String etime; // 考试时间
	private double egrade; // 成绩
	private String eplace; // 考试地点

	public Exam() {
		super();
	}

	public Exam(int cid, String stunum, String etime, double egrade, String eplace) {
		super();
		this.cid = cid;
		this.stunum = stunum;
		this.etime = etime;
		this.egrade = egrade;
		this.eplace = eplace;
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

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
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
