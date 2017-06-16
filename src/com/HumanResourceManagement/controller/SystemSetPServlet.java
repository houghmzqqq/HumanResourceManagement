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

public class SystemSetPServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public SystemSetPServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//1.获取表单信息
		String postTypeName = null;
		String roleName =null;
		try 
		{
			postTypeName = request.getParameter("ptName");
			roleName = request.getParameter("roleName");
			if(postTypeName.equals("请选择") || postTypeName == null || "".equals(postTypeName))
			{
				throw new MsgException("您未选择职位类型！");
			}
			if(roleName.equals("请选择") || roleName == null || "".equals(roleName))
			{
				throw new MsgException("您未选择角色！");
			}
		} 
		catch (MsgException e)
		{
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/postForm.jsp").forward(request, response);
			return;
		}
		String postId = request.getParameter("postId");
		String postName = request.getParameter("postName");
		String postCall = request.getParameter("postCall");
		//2.将数据发送给jdbc文件
		try 
		{
			new SystemSetJDBC().addElement_p(postTypeName,postName,postCall,roleName);
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/postForm.jsp").forward(request, response);
		} 
		catch(MsgException me)
		{
			request.setAttribute("msg", me.getMessage());
			request.getRequestDispatcher("/postForm.jsp").forward(request, response);
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
