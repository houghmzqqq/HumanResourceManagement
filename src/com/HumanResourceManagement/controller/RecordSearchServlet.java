package web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordReviewJDBC;
import dao.RecordSearchJDBC;
import domain.RecordBean;

public class RecordSearchServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public RecordSearchServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String recordId = request.getParameter("recordId");
		String fOrgaName = request.getParameter("fOrgaName");
		String sOrgaName = request.getParameter("sOrgaName");
		String tOrgaName = request.getParameter("tOrgaName");
		String postTypeName = request.getParameter("postTypeName");
		String postName = request.getParameter("postName");
		if(recordId == null || "".equals(recordId))
		{
			Vector<RecordBean> recordList = new RecordSearchJDBC().getSearchRecord(fOrgaName, sOrgaName, tOrgaName, postTypeName, postName);
			request.setAttribute("recordList", recordList);
			request.setAttribute("hasSearch", "yes");
			request.getRequestDispatcher("/record_search.jsp").forward(request, response);
		}
		else
		{
			RecordBean record = new RecordReviewJDBC().getRecord(recordId);
			request.setAttribute("record", record);
			request.getRequestDispatcher("/record_search_all.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}
