package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import util.JDBCUtil;

public class RecordDeleteJDBC 
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	//获取JDBCUtil单例对象的实例
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public void deleteRecord(String recordId)
	{
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
			state.executeUpdate("delete from staffRecord where recordId='" + recordId + "' ");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			jdbcUtil.close(rs, state, conn);
		}
	}
	
}
