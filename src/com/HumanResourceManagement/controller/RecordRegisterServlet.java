package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.RecordRegisterJDBC;
import domain.RecordBean;
import exception.MsgException;

public class RecordRegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public RecordRegisterServlet() 
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
			new RecordRegisterJDBC().addRecordIntoDb(record);
			request.setAttribute("msg", "�ύ�ɹ���");
			request.getRequestDispatcher("/record_register.jsp").forward(request, response);
		} 
		catch(MsgException e)
		{
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/record_register.jsp").forward(request, response);
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