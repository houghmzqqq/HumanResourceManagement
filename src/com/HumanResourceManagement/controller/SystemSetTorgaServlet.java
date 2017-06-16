package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SystemSetJDBC;
import exception.MsgException;

public class SystemSetTorgaServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public SystemSetTorgaServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1.��ȡ����Ϣ
		String sOrganizationName = request.getParameter("sOrgaName");
//		String tOrganizationId = request.getParameter("tOrganizationId");
		String tOrganizationName = request.getParameter("tOrganizationName");
		
		//2.�����ݷ��͸�jdbc�ļ�
		try 
		{
			new SystemSetJDBC().addElement_torga(sOrganizationName,tOrganizationName);
			request.setAttribute("msg", "��ӳɹ�");
			request.getRequestDispatcher("/tOrganizationForm.jsp").forward(request, response);
		} 
		catch(MsgException me)
		{
			request.setAttribute("msg", me.getMessage());
			request.getRequestDispatcher("/tOrganizationForm.jsp").forward(request, response);
			return;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}