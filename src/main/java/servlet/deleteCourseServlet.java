package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import net.sf.json.JSONObject;

/**
 * 删除课程
 */
@WebServlet("/deleteCourseServlet")
public class deleteCourseServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
		int id = Integer.parseInt(request.getParameter("id"));

		CourseDAO courseDAO = new CourseDAO();
		JSONObject jsonObject = new JSONObject();

		// 删除数据库内容
		if (courseDAO.deleteCourse(id))
			jsonObject.put("err", "yes");
		else
			jsonObject.put("err", "删除失败，请重试");

		response.getWriter().print(jsonObject);
	}

}
