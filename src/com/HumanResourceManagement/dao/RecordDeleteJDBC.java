package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import util.JDBCUtil;

public class RecordDeleteJDBC 
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	//��ȡJDBCUtil���������ʵ��
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public void deleteRecord(String recordId)
	{
		try
		{
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.createStatement();
			//3.��ѯ��һ�������µĶ�����������
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
