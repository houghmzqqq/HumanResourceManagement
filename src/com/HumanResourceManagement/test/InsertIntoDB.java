package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import util.JDBCUtil;


public class InsertIntoDB 
{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
//	@Test
	public void putOrganization()
	{
		try 
		{
			conn = jdbcUtil.getConn();
			for(int j=10;j<26;j++)
			{
				for(int i=0;i<3;i++)
				{
					ps = conn.prepareStatement("insert into organization(organizationName,fatherOrganizationId) values(?,?)");
					ps.setString(1, "tOrganization0"+i);
					ps.setInt(2,j);
					ps.executeUpdate();
				}
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			jdbcUtil.close(rs, ps, conn);
		}
	}
	
	@Test
	public void putPostType()
	{
		try 
		{
			conn = jdbcUtil.getConn();
			for(int j=52;j<76;j++)
			{
				for(int i=0;i<3;i++)
				{
					ps = conn.prepareStatement("insert into postType(postTypeName,organizationId) values(?,?)");
					ps.setString(1, "postType0"+i);
					ps.setInt(2,j);
					ps.executeUpdate();
				}
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			jdbcUtil.close(rs, ps, conn);
		}
	}
	
	public void putPost()
	{
		try 
		{
			conn = jdbcUtil.getConn();
			for(int j=1;j<72;j++)
			{
				for(int i=1;i<4;i++)
				{
					ps = conn.prepareStatement("insert into post(postTypeId,postName,postCall,roleId) values(?,?,?,?)");
					ps.setInt(1,j);
					ps.setString(2,"post0"+i);
					ps.setString(3,"postCall0"+i);
					ps.setInt(4,i);
					ps.executeUpdate();
				}
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			jdbcUtil.close(rs, ps, conn);
		}
	}
}
