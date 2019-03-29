package beans;

public class Card {

	private String stunum; // 学号
	private String date; // 打卡日期

	public Card() {
		super();
	}

	public Card(String stunum, String date) {
		super();
		this.stunum = stunum;
		this.date = date;
	}

	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
