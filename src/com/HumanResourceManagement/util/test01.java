package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class test01 
{
	public static void main(String[] args)
	{
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=test01";
		String userName="sa";
		String userPwd = "870437521";
		try
		{
			Class.forName(driverName);
			Connection dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("连接数据库成功");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
