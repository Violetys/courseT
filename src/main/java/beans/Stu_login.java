package beans;

public class Stu_login {

	private String stunum; // 学号
	private String stupsd; // 密码

	public Stu_login() {
		super();
	}

	public Stu_login(String stunum, String stupsd) {
		super();
		this.stunum = stunum;
		this.stupsd = stupsd;
	}

	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getStupsd() {
		return stupsd;
	}

	public void setStupsd(String stupsd) {
		this.stupsd = stupsd;
	}

}
