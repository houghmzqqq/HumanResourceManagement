package web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetWageProjectJDBC;

public class wageStanderRegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public wageStanderRegisterServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		Vector<String> wageProjectList = new GetWageProjectJDBC().getProject();
		request.setAttribute("wageProjectList", wageProjectList);
		request.setAttribute("msg", request.getAttribute("msg"));
		request.getRequestDispatcher("/wage_register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}