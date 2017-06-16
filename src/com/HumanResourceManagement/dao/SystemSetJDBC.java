package dao;

import java.sql.*;

import exception.MsgException;
import util.JDBCUtil;

public class SystemSetJDBC extends MsgException
{
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet rs = null;
	//��ȡJDBCUtil���������ʵ��
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
		
	public void addElement_forga(String fOrganizationName) throws MsgException, SQLException
	{
		try
		{
			String sql = "select * from organization";
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.prepareStatement(sql);
			//3.У������
			rs = state.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		while(rs.next())
		{
			if(fOrganizationName.equals(rs.getString("organizationName")))
			{
				throw new MsgException("�Ѵ���" + fOrganizationName);
			}
		}
		try
		{
			//4.�������ݲ���
			String sql = "insert into organization(organizationName) values(?)";
			state = conn.prepareStatement(sql);
			state.setString(1, fOrganizationName);
			state.executeUpdate();
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
	
	public void addElement_sorga(String fOrganizationName,String sOrganizationName) throws MsgException, SQLException
	{
		String fatherOrganizationId = null;
		String sql = "select organizationId from organization where organizationName=?";
		try
		{
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.prepareStatement(sql);
			state.setString(1, fOrganizationName);
			//3.��ѯ�ϼ��������
			rs = state.executeQuery();
			while(rs.next())
			{
				fatherOrganizationId = rs.getString(1);
				System.out.println(fatherOrganizationId);
			}
			
			sql = "select * from organization where fatherOrganizationId=?";
			state = conn.prepareStatement(sql);
			state.setString(1, fatherOrganizationId);
			rs = state.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//4.У�����ݣ����id��û����Ѵ��ڣ���ʾ�û�
		while(rs.next())
		{
			if(sOrganizationName.equals(rs.getString("organizationName")))
			{
				throw new MsgException("�Ѵ���" + sOrganizationName);
			}
		}
		try
		{
			//5.�������ݲ���
			sql = "insert into organization(organizationName,fatherOrganizationId) values(?,?) ";
			state = conn.prepareStatement(sql);
			state.setString(1, sOrganizationName);
			state.setString(2,fatherOrganizationId);
			state.executeUpdate();
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
	
	public void addElement_torga(String sOrganizationName,String tOrganizationName) throws MsgException, SQLException
	{
		String fatherOrganizationId = null;
		String sql = "select organizationId from organization where organizationName=?";
		try
		{
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.prepareStatement(sql);
			state.setString(1, sOrganizationName);
			//3.��ѯ�ϼ��������
			rs = state.executeQuery();
			while(rs.next())
			{
				fatherOrganizationId = rs.getString(1);
			}
			
			rs = state.executeQuery("select * from organization");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//4.У�����ݣ����id��û����Ѵ��ڣ���ʾ�û�
		while(rs.next())
		{
			if(tOrganizationName.equals(rs.getString("organizationName")))
			{
				throw new MsgException("�Ѵ���" + tOrganizationName);
			}
		}
		try
		{
			//5.�������ݲ���
			sql = "insert into organization(organizationName,fatherOrganizationId) values(?,?)";
			state = conn.prepareStatement(sql);
			state.setString(1,tOrganizationName);
			state.setString(2,fatherOrganizationId);
			state.executeUpdate();
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
	
	public void addElement_pt(String tOrganizationName,String postTypeName) throws MsgException, SQLException
	{
		String fatherOrganizationId = null;
		String sql = "select organizationId from organization where organizationName=?";
		try
		{
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.prepareStatement(sql);
			state.setString(1, tOrganizationName);
			//3.��ѯ�ϼ��������
			rs = state.executeQuery();
			while(rs.next())
			{
				fatherOrganizationId = rs.getString(1);
			}
			
			rs = state.executeQuery("select * from postType");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//4.У�����ݣ����id��û����Ѵ��ڣ���ʾ�û�
		while(rs.next())
		{
			if(postTypeName.equals(rs.getString("postTypeName")) && fatherOrganizationId.equals(rs.getString("organizationId")))
			{
				throw new MsgException(tOrganizationName+"���Ѵ���"+  postTypeName);
			}
		}
		try
		{
			//5.�������ݲ���
			sql = "insert into postType(postTypeName,organizationId) values(?,?)";
			state = conn.prepareStatement(sql);
			state.setString(1,postTypeName);
			state.setString(2,fatherOrganizationId);
			state.executeUpdate();
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
	
	public void addElement_p(String postTypeName,String postName,String postCall,String roleName) throws MsgException, SQLException
	{
		String fatherOrganizationId = null;
		String roleId = null;
		String sql = "select postTypeId from postType where postTypeName=?";
		try
		{
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.prepareStatement(sql);
			state.setString(1, postTypeName);
			//3.��ѯ�ϼ��������
			rs = state.executeQuery();
			while(rs.next())
			{
				fatherOrganizationId = rs.getString(1);
			}
			
			rs = state.executeQuery("select roleId from roles where roleName='" 
					+ roleName + "'");
			while(rs.next())
			{
				roleId = rs.getString(1);
			}
			
			rs = state.executeQuery("select * from post");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//4.У�����ݣ����id��û����Ѵ��ڣ���ʾ�û�
		while(rs.next())
		{
			if(postName.equals(rs.getString("postName")) && fatherOrganizationId.equals(rs.getString("postTypeId")))
			{
				throw new MsgException(postTypeName+"���Ѵ���"+  postName);
			}
		}
		try
		{
			//5.�������ݲ���
			sql = "insert into post(postTypeId,postName,postCall,roleId) values(?,?,?,?)";
			state = conn.prepareStatement(sql);
			state.setString(1,fatherOrganizationId);
			state.setString(2,postName);
			state.setString(3,postCall);
			state.setString(4, roleId);
			state.executeUpdate();
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

	public void addElement_wp(String wageProjectName)
	{
		String sql = "insert into wageProject(wageProjectName) values(?)";
		try
		{
//			int wageProjectId = 1;
			//1.��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//2.��ȡ����������
			state = conn.prepareStatement(sql);
			state.setString(1,wageProjectName);
			state.executeUpdate();
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
