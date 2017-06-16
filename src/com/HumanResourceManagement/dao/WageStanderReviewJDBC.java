package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Vector;

import exception.MsgException;
import util.JDBCUtil;

public class WageStanderReviewJDBC 
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	//��ȡJDBCUtil���������ʵ��
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public void setWageStanderReview(Vector<String> wageProject,Map map,String wageStanderId,String wageStanderName,String wageAmount,
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
			rs = state.executeQuery("select * from wageStander where wageStanderId="+wageStanderId+"");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			state.executeUpdate("update wageStander set wageStander="+wageStander+",maker='"+maker+"',registor='"+registor
					+"',wageStanderName='"+wageStanderName+"',wageAmount="+wageAmount+",whetherReview='"+"�Ѹ���"+"' where wageStanderId="+wageStanderId+"");
			for(int i=0; i<wageProject.size(); i++)
			{
				rs = state.executeQuery("select * from wageProject where wageProjectName='"+wageProject.get(i)+"'");
				while(rs.next())
					wageProjectId = rs.getString("wageProjectId");
				state.executeUpdate("update wageStander_proj set projectMoney="+map.get(wageProject.get(i)) + " where wageStanderId="+wageStanderId+" and wageProjectId="+wageProjectId+"" );
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
