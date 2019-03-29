package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Stu_info;
import beans.Stu_login;
import dao.Stu_infoDAO;
import dao.Stu_loginDAO;
import net.sf.json.JSONObject;

/**
 * 添加学生信息
 */
@WebServlet("/addStuinfoServlet")
public class addStuinfoServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
		String stunum = request.getParameter("stunum");
		String stuname = request.getParameter("stuname");
		String stugrade = request.getParameter("stugrade");
		String stucollege = request.getParameter("stucollege");
		String stupsd = request.getParameter("stupsd");

		// 封装
		Stu_info stu_info = new Stu_info(stunum, stuname, stugrade, stucollege);
		Stu_login stu_login = new Stu_login(stunum, stupsd);

		Stu_infoDAO stu_infoDAO = new Stu_infoDAO();
		Stu_loginDAO stu_loginDAO = new Stu_loginDAO();
		JSONObject jsonObject = new JSONObject();

		// 判断学号是否已被注册
		if (!stu_infoDAO.isStunumExit(stunum)) {
			// 将数据添加到数据库
			if (stu_infoDAO.addStuinfo(stu_info)) {
				if (stu_loginDAO.addStulogin(stu_login))
					jsonObject.put("err", "yes");
				else
					jsonObject.put("err", "注册失败，请重试");
			} else {
				jsonObject.put("err", "注册失败，请重试");
			}
		} else {
			jsonObject.put("err", "该学号已被注册，请重新输入");
		}
		response.getWriter().print(jsonObject);
	}

}
