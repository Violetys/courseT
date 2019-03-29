package servlet;

import java.io.IOException;
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
		String stunum = request.getParameter("stunum");
		String cname = request.getParameter("cname");
		int cweekstart = Integer.parseInt(request.getParameter("cweekstart"));
		int cweekend = Integer.parseInt(request.getParameter("cweekend"));
		int cweek = Integer.parseInt(request.getParameter("cweek"));
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		String cteacher = request.getParameter("cteacher");
		String cintro = request.getParameter("cintro");
		String cplace = request.getParameter("cplace");

		// 封装
		Course course = new Course(0, stunum, cname, cweekstart, cweekend, cweek, cnum, cteacher, cintro, cplace);

		CourseDAO courseDAO = new CourseDAO();
		JSONObject jsonObject = new JSONObject();
		
		//修改数据库内容
		if(courseDAO.updateCourse(course)) {
			jsonObject.put("err", "yes");
		}
		else {
			jsonObject.put("err", "修改失败，请重试");
		}
		response.getWriter().print(jsonObject);
	}

}
