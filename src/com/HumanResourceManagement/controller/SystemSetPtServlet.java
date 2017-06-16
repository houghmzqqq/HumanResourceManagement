package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SystemSetJDBC;
import exception.MsgException;

public class SystemSetPtServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public SystemSetPtServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//1.��ȡ����Ϣ
		String tOrganizationName = null;
		try 
		{
			tOrganizationName = request.getParameter("tOrgaName");
			if(tOrganizationName.equals("��ѡ��") || tOrganizationName==null || "".equals(tOrganizationName))
			{
				throw new MsgException("��δѡ������������");
			}
		} 
		catch (MsgException e)
		{
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/postTypeForm.jsp").forward(request, response);
			return;
		}
//		String postTypeId = request.getParameter("postTypeId");
		String postTypeName = request.getParameter("postTypeName");
		//2.�����ݷ��͸�jdbc�ļ�
		try 
		{
			new SystemSetJDBC().addElement_pt(tOrganizationName, postTypeName);
			request.setAttribute("msg", "��ӳɹ�");
			request.getRequestDispatcher("/postTypeForm.jsp").forward(request, response);
		} 
		catch(MsgException me)
		{
			request.setAttribute("msg", me.getMessage());
			request.getRequestDispatcher("/postTypeForm.jsp").forward(request, response);
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
