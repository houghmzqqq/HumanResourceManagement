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
	 * ��ȡ����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException
	{
		// 1.ע�����ݿ�����
		Class.forName(driverName);
		// 2.��ȡ����
		return DriverManager.getConnection(dbURL, userName,userPwd);
		
	}
	/**
	 * �ر�����
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
