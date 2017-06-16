package web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.HasReviewJDBC;
import dao.RecordRegisterJDBC;
import domain.RecordBean;
import exception.MsgException;

public class HasReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HasReviewServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try 
		{
			//������Ϣ����bean��
			RecordBean record = new RecordBean();
			BeanUtils.populate(record, request.getParameterMap());
			//У�����Ϣ
			record.infomationCheck();
			//�������ݿ�
			new HasReviewJDBC().updateRecord(record);
			request.setAttribute("msg", "���˳ɹ�����Ա����������Ч��");
			request.getRequestDispatcher("/RecordReviewServlet").forward(request, response);
		} 
		catch(MsgException e)
		{
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/RecordReviewServlet").forward(request, response);
			return;
		}
		catch (Exception e) 
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