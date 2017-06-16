package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import domain.WageStanderBean;
import util.JDBCUtil;

public class GetWageStanderJDBC 
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	Vector<WageStanderBean> wageStanderList = null;
	//获取JDBCUtil单例对象的实例
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public Vector<WageStanderBean> getWageStanderList()
	{
		wageStanderList = new Vector<>();
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
			rs = state.executeQuery("select * from wageStander");
			
			while(rs.next())
			{
				if("待复核".equals(rs.getString("whetherReview")))
				{
					WageStanderBean wageStanderBean = new WageStanderBean();
					wageStanderBean.setWageStanderId(rs.getString(1));
					wageStanderBean.setWageStander(rs.getString(2));
					wageStanderBean.setMaker(rs.getString(3));
					wageStanderBean.setRegistor(rs.getString(4));
					wageStanderBean.setRegisterTime(rs.getString(5));
					wageStanderBean.setWageStanderName(rs.getString(6));
					wageStanderBean.setWageAmount(rs.getString(7));
					wageStanderList.add(wageStanderBean);
				}
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
		return wageStanderList;
	}
	
	public WageStanderBean getWageStander(String wageStanderId)
	{
		WageStanderBean wageStanderBean = new WageStanderBean();
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
			rs = state.executeQuery("select * from wageStander where wageStanderId="+ wageStanderId);
			
			while(rs.next())
			{
					wageStanderBean.setWageStanderId(rs.getString(1));
					wageStanderBean.setWageStander(rs.getString(2));
					wageStanderBean.setMaker(rs.getString(3));
					wageStanderBean.setRegistor(rs.getString(4));
					wageStanderBean.setRegisterTime(rs.getString(5));
					wageStanderBean.setWageStanderName(rs.getString(6));
					wageStanderBean.setWageAmount(rs.getString(7));
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
		return wageStanderBean;
	}
	
	public Map<String, String > getWageStanderAll(String wageStanderId)
	{
		Vector<String> wageProjectList = new GetWageProjectJDBC().getProject();
		Map<String,String> map = new HashMap<String,String>();
		int i=0;
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
			rs = state.executeQuery("select * from wageStander_proj where wageStanderId="+wageStanderId);
			
			while(rs.next())
			{
				map.put(wageProjectList.get(i), rs.getString("projectMoney"));
				i ++;
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
		return map;
	}
}
