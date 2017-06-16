package dao;

import java.sql.ResultSet;
import java.sql.*;


import util.JDBCUtil;

public class GetSelectionJDBC 
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	//获取JDBCUtil单例对象的实例
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public String getSorgaSelection(String organizationName)
	{
		String allSorgaSelection = null;
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
			rs = state.executeQuery("select organizationName from organization where fatherOrganizationId="
					+ "(select organizationId from organization where organizationName='"+ organizationName +"')");
			while(rs.next())
			{
				//将查询结果放进allSorgaSelection中，用“；”隔开
				if(allSorgaSelection == null || "".equals(allSorgaSelection))
					allSorgaSelection = rs.getString("organizationName");
				else
					allSorgaSelection = allSorgaSelection + ";" + rs.getString("organizationName");
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
		return allSorgaSelection;
	}
	
	public String getPtSelection(String tOrganizationName)
	{
		String allSorgaSelection = null;
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
			rs = state.executeQuery("select postTypeName from postType where OrganizationId="
					+ "(select organizationId from organization where organizationName='"+ tOrganizationName +"')");
			while(rs.next())
			{
				//将查询结果放进allSorgaSelection中，用“；”隔开
				if(allSorgaSelection == null || "".equals(allSorgaSelection))
					allSorgaSelection = rs.getString("postTypeName");
				else
					allSorgaSelection = allSorgaSelection + ";" + rs.getString("postTypeName");
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
		return allSorgaSelection;
	}
	
	public String getPSelection(String postTypeName,String organizationName)
	{
		String allSorgaSelection = null;
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
			rs = state.executeQuery("select * from post where postTypeId="
					+ "(select postTypeId from postType where postTypeName='"+ postTypeName +"' and organizationId=("
							+ "select organizationId from organization where organizationName='" + organizationName + "'))");
			while(rs.next())
			{
				//将查询结果放进allSorgaSelection中，用“；”隔开
				if(allSorgaSelection == null || "".equals(allSorgaSelection))
					allSorgaSelection = rs.getString("postName");
				else
					allSorgaSelection = allSorgaSelection + ";" + rs.getString("postName");
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
		return allSorgaSelection;
	}
}
