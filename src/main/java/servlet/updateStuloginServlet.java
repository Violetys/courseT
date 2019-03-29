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
 * 修改密码
 */
@WebServlet("/updateStuloginServlet")
public class updateStuloginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 获取前端传入信息
		String stunum = request.getParameter("stunum");
		String stupsd = request.getParameter("stupsd");

		// 封装
		Stu_login stu_login = new Stu_login(stunum, stupsd);

		Stu_loginDAO stu_loginDAO = new Stu_loginDAO();
		JSONObject jsonObject = new JSONObject();

		// 修改数据库内信息
		if (stu_loginDAO.updateStulogin(stu_login)) {
			jsonObject.put("err", "yes");
		} else {
			jsonObject.put("err", "修改失败，请重试");
		}
		response.getWriter().print(jsonObject);
	}

}
