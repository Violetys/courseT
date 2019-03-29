package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Stu_info;

public class Stu_infoDAO {

	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;
	
	/**
	 * 添加学生信息
	 * @param stu_info：学生信息
	 * @return：是否添加成功
	 */
	public boolean addStuinfo(Stu_info stu_info) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into stu_info values (?,?,?,?)");
			pStat.setString(1, stu_info.getStunum());
			pStat.setString(2, stu_info.getStuname());
			pStat.setString(3, stu_info.getStugrade());
			pStat.setString(4, stu_info.getStucollege());
			int cnt = pStat.executeUpdate();
			if(cnt>0)
				return true;
			else
				return false;
		}catch (Exception e) {
			return false;
		}finally {
			Connsql.close();
		}
	}
	
	/***
	 * 更新学生信息
	 * @param stu_info：学生信息
	 * @return：是否更新成功
	 */
	public boolean updateStuinfo(Stu_info stu_info) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("update stu_info set stugrade=? , stucollege=? where stunum=?");
			pStat.setString(1, stu_info.getStugrade());
			pStat.setString(2, stu_info.getStucollege());
			pStat.setString(3, stu_info.getStunum());
			int cnt = pStat.executeUpdate();
			if(cnt>0)
				return true;
			else
				return false;
		}catch (Exception e) {
			return false;
		}finally {
			Connsql.close();
		}
	}
	
	/**
	 * 根据学号获取学生信息
	 * @param stunum：学号
	 * @return：学生信息
	 */
	public Stu_info getStuinfo(String stunum) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("select * from stu_info where stunum=?");
			pStat.setString(1, stunum);
			rs = pStat.executeQuery();
			if(rs.next()) {
				String name = rs.getString("stuname");
				String grade = rs.getString("stugrade");
				String college = rs.getString("stucollege");
				Stu_info stu_info = new Stu_info(stunum, name, grade, college);
				return stu_info;
			}
			else
				return null;
		}catch (Exception e) {
			return null;
		}finally {
			Connsql.close();
		}
	}
	
	public boolean isStunumExit(String stunum) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("select * from stu_info where stunum=?");
			pStat.setString(1, stunum);
			rs = pStat.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		}catch (Exception e) {
			return false;
		}finally {
			Connsql.close();
		}
	}
}
