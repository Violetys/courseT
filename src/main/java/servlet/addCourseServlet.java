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
 * 添加课程
 */
@WebServlet("/addCourseServlet")
public class addCourseServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
//		int id = Integer.parseInt(request.getParameter("id"));

//		String time = request.getParameter("time");
		String room = request.getParameter("room");
		String name = request.getParameter("name");
		String teacher = request.getParameter("teacher");
		int start = Integer.parseInt(request.getParameter("start"));
		int step = Integer.parseInt(request.getParameter("step"));
		int day = Integer.parseInt(request.getParameter("day"));
		String term = request.getParameter("term");
		String[] weeklists = request.getParameterValues("weeklist");
		String stunum = request.getParameter("stunum");

		System.out.println(room+name+teacher);
		for(int i = 0;i < weeklists.length ;i++) {
			System.out.println(weeklists[i]);
		}
		List<Integer> weeklist = new ArrayList<>();
		for (int i = 0; i < weeklists.length; i++) {
			int week = Integer.parseInt(weeklists[i]);
			weeklist.add(week);
		}

		// 封装
		Course course = new Course(0, name, "", room, teacher, start, step, day, term, weeklist, 1);
		CourseDAO courseDAO = new CourseDAO();
		JSONObject jsonObject = new JSONObject();

		if (courseDAO.addCourse(course, stunum)) {
			jsonObject.put("err", "yes");
		} else {
			jsonObject.put("err", "添加失败，请重试");
		}
		response.getWriter().print(jsonObject);
	}

}
