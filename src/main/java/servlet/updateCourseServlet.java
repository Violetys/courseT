package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Course;
import dao.CourseDAO;
import net.sf.json.JSONObject;

/**
 * 修改课程信息
 */
@WebServlet("/updateCourseServlet")
public class updateCourseServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		String room = request.getParameter("room");
		String teacher = request.getParameter("teacher");
		int start = Integer.parseInt(request.getParameter("start"));
		int step = Integer.parseInt(request.getParameter("step"));
		int day = Integer.parseInt(request.getParameter("day"));
		String term = request.getParameter("term");
		String[] weeklists = request.getParameterValues("weeklist");
		String stunum = request.getParameter("stunum");

		List<Integer> weeklist = new ArrayList<>();
		for (int i = 0; i < weeklists.length; i++) {
			int week = Integer.parseInt(weeklists[i]);
			weeklist.add(week);
		}

		// 封装
		Course course = new Course(id, name, time, room, teacher, start, step, day, term, weeklist,0);
		CourseDAO courseDAO = new CourseDAO();
		JSONObject jsonObject = new JSONObject();

		// 修改数据库内容
		if (courseDAO.updateCourse(course, stunum)) {
			jsonObject.put("err", "yes");
		} else {
			jsonObject.put("err", "修改失败，请重试");
		}
		response.getWriter().print(jsonObject);
	}

}
