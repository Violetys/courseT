package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Exam;
import dao.ExamDAO;
import net.sf.json.JSONObject;

/**
 * 修改考试信息
 */
@WebServlet("/updateExamServlet")
public class updateExamServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
		int id = Integer.parseInt(request.getParameter("id"));
		String ename = request.getParameter("ename");
		String stunum = request.getParameter("stunum");
		Double egrade = Double.parseDouble(request.getParameter("egrade"));
		String eplace = request.getParameter("eplace");
		String eyear = request.getParameter("eyear");
		String ehour = request.getParameter("ehour");
		String emonth = request.getParameter("emonth");
		String eday = request.getParameter("eday");
		String eminute = request.getParameter("eminute");

		// 封装
		Exam exam = new Exam(id, ename, stunum, eyear, emonth, eday, ehour, eminute, egrade, eplace);
		JSONObject jsonObject = new JSONObject();
		ExamDAO examDAO = new ExamDAO();

		// 修改数据库内容
		if (examDAO.updateExam(exam)) {
			jsonObject.put("err", "yes");
		} else {
			jsonObject.put("err", "修改失败，请重试！");
		}
		response.getWriter().print(jsonObject);
	}

}
