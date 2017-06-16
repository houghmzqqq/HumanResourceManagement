package web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SystemSetJDBC;
import exception.MsgException;

public class SystemSetSorgaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SystemSetSorgaServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//1.获取表单信息
		String fOrganizationName = request.getParameter("fOrganizationName");
//		String sOrganizationId = request.getParameter("sOrganizationId");
		String sOrganizationName = request.getParameter("sOrganizationName");
		//2.将数据发送给jdbc文件
		try 
		{
			new SystemSetJDBC().addElement_sorga(fOrganizationName,sOrganizationName);
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/sOrganizationForm.jsp").forward(request, response);
		} 
		catch(MsgException me)
		{
			request.setAttribute("msg", me.getMessage());
			request.getRequestDispatcher("/sOrganizationForm.jsp").forward(request, response);
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