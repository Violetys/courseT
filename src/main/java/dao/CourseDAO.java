package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import beans.Course;

public class CourseDAO {

	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;

	/**
	 * 添加课程信息
	 * 
	 * @param course：课程信息
	 * @param stunum：学生学号
	 * @return：是否添加成功
	 */
	public boolean addCourse(Course course, String stunum) {
		Random r = new Random();
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into course values (default,?,?,?,?,?,?,?,?,?,?)");
			pStat.setString(1, stunum);
			pStat.setString(2, course.getName());
			pStat.setString(3, course.getTime());
			pStat.setString(4, course.getRoom());
			pStat.setString(5, course.getTeacher());
			pStat.setInt(6, course.getStart());
			pStat.setInt(7, course.getStep());
			pStat.setInt(8, course.getDay());
			pStat.setString(9, course.getTerm());
			pStat.setInt(10, r.nextInt(50));
			int cnt = pStat.executeUpdate();
			if (cnt > 0) {
				pStat = conn.prepareStatement("select last_insert_id()");
				rs = pStat.executeQuery();
				int num = 0;
				if (rs.next())
					num = rs.getInt("last_insert_id()");
				for (int i = 0; i < course.getWeeklist().size(); i++) {
					pStat = conn.prepareStatement("insert into weeklist values (?,?,?)");
					pStat.setString(1, stunum);
					pStat.setInt(2, num);
					pStat.setInt(3, course.getWeeklist().get(i));
					int cnt1 = pStat.executeUpdate();
					if (cnt1 > 0)
						continue;
					else
						return false;
				}
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			Connsql.close();
		}
	}

	/**
	 * 更新课程信息
	 * 
	 * @param course：课程信息
	 * @param stunum：学号
	 * @return：是否更新成功
	 */
	public boolean updateCourse(Course course, String stunum) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement(
					"update course set name=?, time=?, room=?, teacher=?, start=?, step=?, day=?, term=? where id=? and stunum=?");
			pStat.setString(1, course.getName());
			pStat.setString(2, course.getTime());
			pStat.setString(3, course.getRoom());
			pStat.setString(4, course.getTeacher());
			pStat.setInt(5, course.getStart());
			pStat.setInt(6, course.getStep());
			pStat.setInt(7, course.getDay());
			pStat.setString(8, course.getTerm());
			pStat.setInt(9, course.getId());
			pStat.setString(10, stunum);
			int cnt = pStat.executeUpdate();
			if (cnt > 0) {
				pStat = conn.prepareStatement("delete from weeklist where stunum=? and cid=?");
				pStat.setString(1, stunum);
				pStat.setInt(2, course.getId());
				int cnt3 = pStat.executeUpdate();
				for (int i = 0; i < course.getWeeklist().size(); i++) {
					pStat = conn.prepareStatement("insert into weeklist values (?,?,?)");
					pStat.setString(1, stunum);
					pStat.setInt(2, course.getId());
					pStat.setInt(3, course.getWeeklist().get(i));
					int cnt2 = pStat.executeUpdate();
					if (cnt2 > 0)
						continue;
					else
						return false;
				}
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			Connsql.close();
		}
	}

	/**
	 * 根据学号获取该学生的所有课程
	 * 
	 * @param stunum：学号
	 * @return：课程列表
	 */
	public List<Course> getAllCourse(String stunum) {
		conn = Connsql.getConnectionn();
		List<Course> list = new ArrayList<>();
		try {
			pStat = conn.prepareStatement("select * from course where stunum=?");
			pStat.setString(1, stunum);

			rs = pStat.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setDay(rs.getInt("day"));
				course.setId(rs.getInt("id"));
				int id = rs.getInt("id");
				course.setName(rs.getString("name"));
				course.setRoom(rs.getString("room"));
				course.setStart(rs.getInt("start"));
				course.setStep(rs.getInt("step"));
				course.setTeacher(rs.getString("teacher"));
				course.setTerm(rs.getString("term"));
				course.setTime(rs.getString("time"));
				course.setColorRandom(rs.getInt("colorRandom"));
				List<Integer> weeklist = new ArrayList<>();
				pStat = conn.prepareStatement("select * from weeklist where stunum=? and cid=?");
				pStat.setString(1, stunum);
				pStat.setInt(2, id);
				ResultSet rs2 = pStat.executeQuery();
				while (rs2.next()) {
					weeklist.add(rs2.getInt("week"));
				}
				course.setWeeklist(weeklist);
				list.add(course);
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 删除课程
	 * 
	 * @param id：课程编号
	 * @return：是否删除成功
	 */
	public boolean deleteCourse(int id) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("delete from course where id=?");
			pStat.setInt(1, id);
			int cnt = pStat.executeUpdate();
			if (cnt > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		} finally {
			Connsql.close();
		}
	}

}
