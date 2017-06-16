package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SystemSetJDBC;
import exception.MsgException;
import util.JDBCUtil;

public class SystemSetForgaServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public SystemSetForgaServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		//1.��ȡ����Ϣ
//		String fOrganizationId = request.getParameter("fOrganizationId");
		String fOrganizationName = request.getParameter("fOrganizationName");
		//2.�����ݷ��͸�jdbc�ļ�
		try 
		{
			new SystemSetJDBC().addElement_forga(fOrganizationName);
			request.setAttribute("msg", "��ӳɹ�");
			request.getRequestDispatcher("/fOrganizationForm.jsp").forward(request, response);
		} 
		catch(MsgException me)
		{
			request.setAttribute("msg", me.getMessage());
			request.getRequestDispatcher("/fOrganizationForm.jsp").forward(request, response);
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
