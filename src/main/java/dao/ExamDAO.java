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
			pStat = conn.prepareStatement("insert into exam values (?,?,?,?,?)");
			pStat.setInt(1, exam.getCid());
			pStat.setString(2, exam.getStunum());
			pStat.setString(3, exam.getEtime());
			pStat.setDouble(4, exam.getEgrade());
			pStat.setString(5, exam.getEplace());
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
	 * @param cid：课程编号
	 * @param stunum：学号
	 * @return：是否删除成功
	 */
	public boolean deleteExam(int cid,String stunum) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("delete from exam where cid=? and stunum=?");
			pStat.setInt(1, cid);
			pStat.setString(2, stunum);
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
			pStat = conn.prepareStatement("update exam set etime=?, egrade=?, eplace=? where cid=? and stunum=?");
			pStat.setString(1, exam.getEtime());
			pStat.setDouble(2, exam.getEgrade());
			pStat.setString(3, exam.getEplace());
			pStat.setInt(4, exam.getCid());
			pStat.setString(5, exam.getStunum());
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
				exam.setCid(rs.getInt("cid"));
				exam.setStunum(stunum);
				exam.setEgrade(rs.getDouble("egrade"));
				exam.setEplace(rs.getString("eplace"));
				exam.setEtime(rs.getString("etime"));
				list.add(exam);
			}
			return list;
		}catch (Exception e) {
			return null;
		}finally {
			Connsql.close();
		}
	}
	
}
