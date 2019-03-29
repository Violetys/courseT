package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Card;
import beans.Course;
import beans.Exam;
import beans.Stu_info;
import beans.Stu_login;
import dao.CardDao;
import dao.CourseDAO;
import dao.ExamDAO;
import dao.Stu_infoDAO;
import dao.Stu_loginDAO;
import net.sf.json.JSONObject;

/**
 * 登陆检测
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
		String stunum = request.getParameter("stunum");
		String stupsd = request.getParameter("stupsd");

		// 创建对象
		Stu_loginDAO stu_loginDAO = new Stu_loginDAO();
		CardDao cardDao = new CardDao();
		CourseDAO courseDAO = new CourseDAO();
		ExamDAO examDAO = new ExamDAO();
		Stu_infoDAO stu_infoDAO = new Stu_infoDAO();
		JSONObject jsonObject = new JSONObject();

		// 判断学号是否存在
		if (stu_infoDAO.isStunumExit(stunum)) {
			// 判断密码是否正确
			if (stu_loginDAO.logincheck(stunum, stupsd)) {
				// 获取该用户的所有信息
				List<Card> cardlist = cardDao.getAllCardByStunum(stunum);
				List<Course> courselist = courseDAO.getAllCourseByStunum(stunum);
				List<Exam> examlist = examDAO.getAllExamByStunum(stunum);
				Stu_info stu_info = stu_infoDAO.getStuinfo(stunum);
				// 将信息传递到前端
				jsonObject.put("err", "yes");
				jsonObject.put("cardlist", cardlist);
				jsonObject.put("courselist", courselist);
				jsonObject.put("examlist", examlist);
				jsonObject.put("stuinfo", stu_info);
			} else {
				jsonObject.put("err", "密码错误，请重新输入");
			}
		} else {
			jsonObject.put("err", "该学号不存在，请重新输入");
		}
		response.getWriter().print(jsonObject);
	}

}
