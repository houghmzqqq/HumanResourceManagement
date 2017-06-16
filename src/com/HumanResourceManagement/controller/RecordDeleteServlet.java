package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDeleteJDBC;

public class RecordDeleteServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public RecordDeleteServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String recordId = request.getParameter("recordId");
		new RecordDeleteJDBC().deleteRecord(recordId);
		request.setAttribute("msg", "³É¹¦É¾³ýµµ°¸!");
		request.getRequestDispatcher("/record_search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}