package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Card;
import dao.CardDao;
import net.sf.json.JSONObject;

/**
 * 添加打卡记录
 */
@WebServlet("/addCardServlet")
public class addCardServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
		String stunum = request.getParameter("stunum");
		String date = request.getParameter("date");

		// 封装
		Card card = new Card(stunum, date);

		JSONObject jsonObject = new JSONObject();
		CardDao cardDao = new CardDao();
		
		//将数据添加到数据库中
		if (cardDao.addCard(card)) {
			jsonObject.put("err", "yes");
		} else {
			jsonObject.put("err", "打卡失败，请重试");
		}
		response.getWriter().print(jsonObject);
	}

}
