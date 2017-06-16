package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import util.JDBCUtil;

public class GetWageProjectJDBC 
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	Vector<String> wageProjectList = null;
	//��ȡJDBCUtil���������ʵ��
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public Vector<String> getProject()
	{
		wageProjectList = new Vector<>();
		try
		{
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.createStatement();
			//3.��ѯ��һ�������µĶ�����������
			rs = state.executeQuery("select * from wageProject");
			while(rs.next())
			{
				wageProjectList.add(rs.getString("wageProjectName"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			jdbcUtil.close(rs, state, conn);
		}
		return wageProjectList;
	}
}
