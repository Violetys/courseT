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
 * 添加考试信息
 */
@WebServlet("/addExamServlet")
public class addExamServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
		int cid = Integer.parseInt(request.getParameter("cid"));
		String stunum = request.getParameter("stunum");
		String etime = request.getParameter("etime");
		Double egrade = Double.parseDouble(request.getParameter("egrade"));
		String eplace = request.getParameter("eplace");

		// 封装
		Exam exam = new Exam(cid, stunum, etime, egrade, eplace);
		JSONObject jsonObject = new JSONObject();
		ExamDAO examDAO = new ExamDAO();

		// 将数据添加到数据库
		if (examDAO.addExam(exam)) {
			jsonObject.put("err", "yes");
		} else {
			jsonObject.put("err", "添加失败，请重试");
		}
		response.getWriter().print(jsonObject);
	}

}
