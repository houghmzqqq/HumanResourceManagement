package util;

import java.sql.*;

public class JDBCUtil 
{
	private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=HumanResourceManagement";
	private String userName="sa";
	private String userPwd = "870437521";
	
	private volatile static JDBCUtil uniqueInstance;
	
	private JDBCUtil() {}
	
	public static JDBCUtil getInstance()
	{
		if(uniqueInstance == null)
		{
			synchronized (JDBCUtil.class) 
			{	
				if (uniqueInstance == null)
				{
					uniqueInstance = new JDBCUtil();
				}
			}
		}
		return uniqueInstance;
	}
	/**
	 * 获取连接
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException
	{
		// 1.注册数据库驱动
		Class.forName(driverName);
		// 2.获取连接
		return DriverManager.getConnection(dbURL, userName,userPwd);
		
	}
	/**
	 * 关闭连接
	 */
	public void close(ResultSet rs, Statement stat,Connection conn)
	{
		if(rs!=null)
		{
			try 
			{
				rs.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}finally
			{
				rs = null;
			}
		}
		if(stat!=null)
		{
			try
			{
				stat.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				stat = null;
			}
		}
		if(conn!=null)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				conn = null;
			}
		}
	
	}
}
