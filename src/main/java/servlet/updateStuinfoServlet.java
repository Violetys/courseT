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
 * 修改学生信息
 */
@WebServlet("/updateStuinfoServlet")
public class updateStuinfoServlet extends HttpServlet {

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

		// 封装
		Stu_info stu_info = new Stu_info(stunum, stuname, stugrade, stucollege);

		Stu_infoDAO stu_infoDAO = new Stu_infoDAO();
		JSONObject jsonObject = new JSONObject();
		
		//修改数据库内信息
		if(stu_infoDAO.updateStuinfo(stu_info)) {
			jsonObject.put("err", "yes");
		}
		else {
			jsonObject.put("err", "修改失败，请重试！");
		}
		response.getWriter().print(jsonObject);
	}

}
