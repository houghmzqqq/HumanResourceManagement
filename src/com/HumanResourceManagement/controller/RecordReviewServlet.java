package web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordReviewJDBC;
import domain.RecordBean;

public class RecordReviewServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public RecordReviewServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String recordId = request.getParameter("recordId");
		if(recordId == null || "".equals(recordId))
		{
			//获取未复核的档案
			Vector<RecordBean> recordList = new RecordReviewJDBC().getRecordList();
			request.setAttribute("recordList", recordList);
			request.getRequestDispatcher("/record_review.jsp").forward(request, response);
		}
		else
		{
			RecordBean record = new RecordReviewJDBC().getRecord(recordId);
			request.setAttribute("record", record);
			request.getRequestDispatcher("/record_review_all.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

}