package web;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetWageProjectJDBC;
import dao.GetWageStanderJDBC;
import domain.WageStanderBean;

public class wageStanderReviewServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public wageStanderReviewServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String wageStanderId = request.getParameter("wageStanderId");
		if(wageStanderId == null || "".equals(wageStanderId))
		{
			Vector<WageStanderBean> wageStanderList = new GetWageStanderJDBC().getWageStanderList();
			request.setAttribute("wageStanderList", wageStanderList);
			request.getRequestDispatcher("/wageStander_review.jsp").forward(request, response);
		}
		else
		{
			WageStanderBean wageStanderBean = new GetWageStanderJDBC().getWageStander(wageStanderId);
			Vector<String> wageProjectList = new GetWageProjectJDBC().getProject();
			Map<String, String> map = new GetWageStanderJDBC().getWageStanderAll(wageStanderId);
			request.setAttribute("wageStanderBean", wageStanderBean);
			request.setAttribute("wageProjectList", wageProjectList);
			request.setAttribute("map", map);
			for(int i=0; i<wageProjectList.size(); i++)
			{
				System.out.println(wageProjectList.get(i));
				System.out.println(map.get(wageProjectList.get(i)));
			}
			request.getRequestDispatcher("/wageStander_review_all.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}