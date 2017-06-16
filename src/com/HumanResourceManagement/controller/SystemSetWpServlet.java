package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SystemSetJDBC;

public class SystemSetWpServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public SystemSetWpServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String wageProjectName = request.getParameter("wageProjectName");
		new SystemSetJDBC().addElement_wp(wageProjectName);
		request.setAttribute("msg", "增加成功！");
		request.getRequestDispatcher("/wageProjectForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}