package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetWageProjectJDBC;
import dao.WageRegisterJDBC;
import exception.MsgException;

public class WageRegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public WageRegisterServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String wageStanderId = request.getParameter("wageStanderId");
		String wageStanderName = request.getParameter("wageStanderName");
		String wageAmount = request.getParameter("wageAmount");
		String maker = request.getParameter("maker");
		String registor = request.getParameter("registor");
		String registerTime = request.getParameter("registerTime");
		String wageStander = request.getParameter("wageStander");
		Vector<String> wageProject = new GetWageProjectJDBC().getProject();
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0; i<wageProject.size(); i++)
		{
			map.put(wageProject.get(i), request.getParameter(wageProject.get(i)));
		}
		try 
		{
			new WageRegisterJDBC().setWageStander(wageProject, map,wageStanderId,wageStanderName,wageAmount,maker,registor,registerTime,wageStander);
			request.setAttribute("msg", "提交成功");
			request.getRequestDispatcher("/wageStanderRegisterServlet").forward(request, response);
		} 
		catch (MsgException e) 
		{
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/wageStanderRegisterServlet").forward(request, response);
			return;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}