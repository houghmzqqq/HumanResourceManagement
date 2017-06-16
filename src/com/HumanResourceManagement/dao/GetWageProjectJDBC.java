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
	//获取JDBCUtil单例对象的实例
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public Vector<String> getProject()
	{
		wageProjectList = new Vector<>();
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
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
