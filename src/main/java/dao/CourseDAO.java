package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Course;

public class CourseDAO {

	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;

	/**
	 * 添加课程
	 * 
	 * @param course：课程信息
	 * @return：是否添加成功
	 */
	public boolean addCourse(Course course) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into course values (default,?,?,?,?,?,?,?,?,?)");
			pStat.setString(1, course.getStunum());
			pStat.setString(2, course.getCname());
			pStat.setInt(3, course.getCweekstart());
			pStat.setInt(4, course.getCweekend());
			pStat.setInt(5, course.getCweek());
			pStat.setInt(6, course.getCnum());
			pStat.setString(7, course.getCteacher());
			pStat.setString(8, course.getCintro());
			pStat.setString(9, course.getCplace());
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

	/**
	 * 删除课程信息
	 * 
	 * @param id：课程编号
	 * @return：是否删除成功
	 */
	public boolean deleteCourse(int id) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("delete from course where cid=?");
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

	/**
	 * 更新课程信息
	 * 
	 * @param course：课程信息
	 * @return：是否更新成功
	 */
	public boolean updateCourse(Course course) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement(
					"update course set cname=?, cweekstart=?,cweekend=?,cweek=?,cnum=?,cteacher=?,cintro=?,cplace=? where id=? and stunum=?");
			pStat.setString(1, course.getCname());
			pStat.setInt(2, course.getCweekstart());
			pStat.setInt(3, course.getCweekend());
			pStat.setInt(4, course.getCweek());
			pStat.setInt(5, course.getCnum());
			pStat.setString(6, course.getCteacher());
			pStat.setString(7, course.getCintro());
			pStat.setString(8, course.getCplace());
			pStat.setInt(9, course.getCid());
			pStat.setString(10, course.getStunum());
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

	/**
	 * 根据学号获取该学生所有的课程信息
	 * 
	 * @param stunum：学号
	 * @return：课程信息列表
	 */
	public List<Course> getAllCourseByStunum(String stunum) {
		conn = Connsql.getConnectionn();
		List<Course> list = new ArrayList<>();
		try {
			pStat = conn.prepareStatement("select * from course where stunum=?");
			rs = pStat.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCid(rs.getInt("cid"));
				course.setCintro(rs.getString("cintro"));
				course.setCname(rs.getString("cname"));
				course.setCnum(rs.getInt("cnum"));
				course.setCplace(rs.getString("cplace"));
				course.setCteacher(rs.getString("cteacher"));
				course.setCweek(rs.getInt("cweek"));
				course.setCweekend(rs.getInt("cweekend"));
				course.setCweekstart(rs.getInt("cweekstart"));
				course.setStunum(rs.getString("stunum"));
				list.add(course);
			}
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			Connsql.close();
		}
	}

}
