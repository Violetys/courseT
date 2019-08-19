package beans;

public class Card {

	private String stunum; // 学号
	private int dateyear; // 打卡日期（年）
	private int datemonth; // 打卡日期（月）
	private int dateday; // 打卡日期（日）

	public Card() {
		super();
	}

	public Card(String stunum, int dateyear, int datemonth, int dateday) {
		super();
		this.stunum = stunum;
		this.dateyear = dateyear;
		this.datemonth = datemonth;
		this.dateday = dateday;
	}

	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public int getDateyear() {
		return dateyear;
	}

	public void setDateyear(int dateyear) {
		this.dateyear = dateyear;
	}

	public int getDatemonth() {
		return datemonth;
	}

	public void setDatemonth(int datemonth) {
		this.datemonth = datemonth;
	}

	public int getDateday() {
		return dateday;
	}

	public void setDateday(int dateday) {
		this.dateday = dateday;
	}

}
