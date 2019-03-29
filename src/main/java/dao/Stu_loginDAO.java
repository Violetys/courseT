package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Stu_login;

public class Stu_loginDAO {

	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;

	/**
	 * 添加学生登陆信息
	 * 
	 * @param stu_login：登陆信息
	 * @return：是否添加成功
	 */
	public boolean addStulogin(Stu_login stu_login) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into stu_login values (?,?)");
			pStat.setString(1, stu_login.getStunum());
			pStat.setString(2, stu_login.getStupsd());
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
	 * 更新登陆信息（修改密码）
	 * 
	 * @param stu_login：登陆信息
	 * @return：是否修改成功
	 */
	public boolean updateStulogin(Stu_login stu_login) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("update stu_login set stupsd=? where stunum=?");
			pStat.setString(1, stu_login.getStupsd());
			pStat.setString(2, stu_login.getStunum());
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
	 * 登陆检测
	 * @param num：学号
	 * @param psd：登陆密码
	 * @return：是否登录成功
	 */
	public boolean logincheck(String num, String psd) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("select * from stu_login where stunum=? and stupsd=?");
			pStat.setString(1, num);
			pStat.setString(2, psd);
			rs = pStat.executeQuery();
			if (rs.next())
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
