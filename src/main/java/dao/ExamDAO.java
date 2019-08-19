package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Exam;

public class ExamDAO {

	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;
	
	/**
	 * 添加考试信息
	 * @param exam：考试信息
	 * @return：是否添加成功
	 */
	public boolean addExam(Exam exam) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into exam values (default,?,?,?,?,?,?,?,?,?)");
			pStat.setString(1, exam.getEname());
			pStat.setString(2, exam.getStunum());
			pStat.setDouble(3, exam.getEgrade());
			pStat.setString(4, exam.getEplace());
			pStat.setString(5, exam.getEyear());
			pStat.setString(6, exam.getEmonth());
			pStat.setString(7, exam.getEday());
			pStat.setString(8, exam.getEhour());
			pStat.setString(9, exam.getEminute());
			int cnt = pStat.executeUpdate();
			if(cnt >0)
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
	 * 删除考试信息
	 * @param cid：考試编号
	 * @return：是否删除成功
	 */
	public boolean deleteExam(int id) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("delete from exam where id=?");
			pStat.setInt(1, id);
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
	 * 更新考试信息
	 * @param exam：考试信息
	 * @return：是否更新成功
	 */
	public boolean updateExam(Exam exam) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("update exam set eyear=?,emonth=?,eday=?,ehour=?,eminute=?, egrade=?, eplace=? where id=?");
			pStat.setString(1, exam.getEyear());
			pStat.setString(2, exam.getEmonth());
			pStat.setString(3, exam.getEday());
			pStat.setString(4, exam.getEhour());
			pStat.setString(5, exam.getEminute());
			pStat.setDouble(6, exam.getEgrade());
			pStat.setString(7, exam.getEplace());
			pStat.setInt(8, exam.getId());
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
	 * 根据学号获取学生所有考试信息
	 * @param stunum：学生学号
	 * @return：考试信息列表
	 */
	public List<Exam> getAllExamByStunum(String stunum){
		conn = Connsql.getConnectionn();
		List<Exam> list=new ArrayList<>();
		try {
			pStat = conn.prepareStatement("select * from exam where stunum=?");
			pStat.setString(1, stunum);
			rs = pStat.executeQuery();
			while(rs.next()) {
				Exam exam = new Exam();
				exam.setId(rs.getInt("id"));
				exam.setStunum(stunum);
				exam.setEplace(rs.getString("eplace"));
				exam.setEname(rs.getString("ename"));
				exam.setEyear(rs.getString("eyear"));
				exam.setEmonth(rs.getString("emonth"));
				exam.setEday(rs.getString("eday"));
				exam.setEhour(rs.getString("ehour"));
				exam.setEminute(rs.getString("eminute"));
				list.add(exam);
				System.out.println("xbubc"+exam.getEname());
			}
			return list;
		}catch (Exception e) {
			return null;
		}finally {
			Connsql.close();
		}
	}
	
}
