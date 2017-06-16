package dao;

import java.sql.*;
import java.util.Map;
import java.util.Vector;

import exception.MsgException;
import util.JDBCUtil;

public class WageRegisterJDBC
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	//��ȡJDBCUtil���������ʵ��
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public void setWageStander(Vector<String> wageProject,Map map,String wageStanderId,String wageStanderName,String wageAmount,
			String maker,String registor,String registerTime,String wageStander) 
			throws MsgException, SQLException
	{
		String wageProjectId = null;
		try
		{
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.createStatement();
			//3.��ѯ��һ�������µĶ�����������
			rs = state.executeQuery("select * from wageStander");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		while(rs.next())
		{
			if(wageStanderId.equals(rs.getString("wageStanderId")))
			{
				throw new MsgException("н���׼����ظ���");
			}
		}
		
		try 
		{
			state.executeUpdate("insert into wageStander values("+wageStanderId+","+wageStander+",'"+maker+"','"+registor
					+"',"+registerTime+",'"+wageStanderName+"',"+wageAmount+",'"+"������"+"')");
			for(int i=0; i<wageProject.size(); i++)
			{
				rs = state.executeQuery("select * from wageProject where wageProjectName='"+wageProject.get(i)+"'");
				while(rs.next())
					wageProjectId = rs.getString("wageProjectId");
				state.executeUpdate("insert into wageStander_proj values("+wageStanderId+","+wageProjectId+","+map.get(wageProject.get(i))+")");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			jdbcUtil.close(rs, state, conn);
		}
	}
}