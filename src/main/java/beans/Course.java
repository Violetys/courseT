package beans;

import java.util.List;

public class Course {

	private int id; // 课程编号
	private String name; // 课程名称
	private String time; // 上课时间
	private String room; // 上课教师
	private String teacher; // 任课教师
	private int start; // 开始上课节次
	private int step; // 上课节数
	private int day; // 周几上
	private String term; // 上课学期
	private List<Integer> weeklist; // 第几周至第几周上
	private int colorRandom; // 随机数，用于对应课程的颜色

	public Course() {
		super();
	}

	public Course(int id, String name, String time, String room, String teacher, int start, int step, int day,
			String term, List<Integer> weeklist, int colorRandom) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.room = room;
		this.teacher = teacher;
		this.start = start;
		this.step = step;
		this.day = day;
		this.term = term;
		this.weeklist = weeklist;
		this.colorRandom = colorRandom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public List<Integer> getWeeklist() {
		return weeklist;
	}

	public void setWeeklist(List<Integer> weeklist) {
		this.weeklist = weeklist;
	}

	public int getColorRandom() {
		return colorRandom;
	}

	public void setColorRandom(int colorRandom) {
		this.colorRandom = colorRandom;
	}

}
