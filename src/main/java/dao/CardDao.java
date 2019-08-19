package dao;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Card;

public class CardDao {

	private Connection conn = null;
	private PreparedStatement pStat = null;
	private ResultSet rs = null;
	
	/**
	 * 添加打卡记录
	 * @param card：打卡记录
	 * @return：是否添加成功
	 */
	public boolean addCard(Card card) {
		conn = Connsql.getConnectionn();
		try {
			pStat = conn.prepareStatement("insert into card values (?,?,?,?)");
			pStat.setString(1, card.getStunum());
			pStat.setInt(2, card.getDateyear());
			pStat.setInt(3, card.getDatemonth());
			pStat.setInt(4, card.getDateday());
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
	 * 根据学号获取所有的打卡记录
	 * @param stunum：学号
	 * @return：打卡记录
	 */
	public List<Card> getAllCardByStunum(String stunum){
		conn = Connsql.getConnectionn();
		List<Card> list = new ArrayList<>();
		try {
			pStat = conn.prepareStatement("select * from card where stunum=?");
			pStat.setString(1, stunum);
			rs = pStat.executeQuery();
			while(rs.next()) {
				Card card = new Card();
				card.setDateday(rs.getInt("dateday"));
				card.setDatemonth(rs.getInt("datemonth"));
				card.setDateyear(rs.getInt("dateyear"));
				card.setStunum(rs.getString("stunum"));
				list.add(card);
			}
			return list;
		}catch (Exception e) {
			return null;
		}finally {
			Connsql.close();
		}
	}
	
}
