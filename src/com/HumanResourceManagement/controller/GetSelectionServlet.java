package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetSelectionJDBC;


public class GetSelectionServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public GetSelectionServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		//��ȡ����
		String pt = request.getParameter("pt");				//������ʶ��ѯpostType�����ֵΪ�գ���ѯorganization��
		String organizationName = request.getParameter("organizationName");
		String tOrganizationName = request.getParameter("tOrganizationName");
		
		String allSelection = null;
		//���������͸�jdbc�ļ���ȡ�÷���ֵ
		if(pt == null)
		{
			allSelection = new GetSelectionJDBC().getSorgaSelection(organizationName);
		}
		if("pt".equals(pt))
			allSelection = new GetSelectionJDBC().getPtSelection(organizationName);
		if("p".equals(pt))
			allSelection = new GetSelectionJDBC().getPSelection(organizationName,tOrganizationName);
		//��jdbc���صĲ���print��ajax
		response.getWriter().print(allSelection);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}