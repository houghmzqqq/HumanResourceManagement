package dao;

import java.sql.*;
import java.util.Calendar;

import domain.RecordBean;
import service.CreateRecordId;
import util.JDBCUtil;

public class RecordRegisterJDBC 
{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//获取JDBCUtil单例对象的实例
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public void addRecordIntoDb(RecordBean record)
	{
		String recordId = null;
		String fOrgaId = null;
		String sOrgaId = null;
		String tOrgaId = null;
		String f_s_t_orgaId = null;
		
		try
		{
			//获取数据库连接
			conn = jdbcUtil.getConn();
			//获取传输器对象
			
			ps = conn.prepareStatement("select * from organization where organizationName=?");
			ps.setString(1, record.getfOrgaName());
			//查询该一级机构下的二级机构名称
			rs = ps.executeQuery();
			while(rs.next())
			{
				if(Integer.valueOf(rs.getString("organizationId")) < 10)
					fOrgaId = "0" + rs.getString("organizationId");
			}
			
			ps = conn.prepareStatement("select * from organization where organizationName=?");
			ps.setString(1, record.getsOrgaName());
			rs = ps.executeQuery();
			while(rs.next())
			{
				if(Integer.valueOf(rs.getString("organizationId")) < 10)
					sOrgaId = "0" + rs.getString("organizationId");
			}

			ps = conn.prepareStatement("select * from organization where organizationName=?");
			ps.setString(1, record.gettOrgaName());
			rs = ps.executeQuery();
			while(rs.next())
			{
				if(Integer.valueOf(rs.getString("organizationId")) < 10)
					tOrgaId = "0" + rs.getString("organizationId");
				else
					tOrgaId = rs.getString("organizationId");
			}
			
			f_s_t_orgaId = fOrgaId + sOrgaId + tOrgaId;
			
			ps = conn.prepareStatement("select * from staffRecord");
			rs = ps.executeQuery();

			CreateRecordId id = new CreateRecordId(rs,f_s_t_orgaId);	//生成recordId
			recordId = id.getRecordId();
			
			System.out.println(recordId);
			
			ps = conn.prepareStatement("insert into staffRecord values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, recordId);
			ps.setString(2, record.getfOrgaName());
			ps.setString(3, record.getsOrgaName());
			ps.setString(4, record.gettOrgaName());
			ps.setString(5, record.getGender());
			ps.setString(6, record.getEmail());
			ps.setString(7, record.getTelephoneNum());
			ps.setString(8, record.getCellPhoneNum());
			ps.setString(9, record.getQQ());
			ps.setString(10, record.getAddress());
			ps.setString(11, record.getZipCode());
			ps.setString(12, record.getNationality());
			ps.setString(13, record.getBirthplace());
			ps.setString(14, record.getBirthday());
			ps.setString(15, record.getNation());
			ps.setString(16, record.getReligious());
			ps.setString(17, record.getPolitics());
			ps.setString(18, record.getIDCardNum());
			ps.setString(19, record.getSocialSecurityNum());
			ps.setString(20, record.getAge());
			ps.setString(21, record.getEducation());
			ps.setString(22, record.getEducationYears());
			ps.setString(23, record.getMajoy());
			ps.setString(24, record.getWageStander());
			ps.setString(25, record.getBank());
			ps.setString(26, record.getAccountNum());
			ps.setString(27, record.getRegistor());
			ps.setString(28, record.getBuiltTime());
			ps.setString(29, record.getSpecialty());
			ps.setString(30, record.getHobby());
			ps.setString(31, record.getPersonalResume());
			ps.setString(32, record.getFamilyInformation());
			ps.setString(33, record.getRemarks());
			ps.setString(34, "待复核");
			ps.setString(35, record.getPostTypeName());
			ps.setString(36, record.getPostName());
			ps.setString(37, record.getStaffName());
			ps.execute();
			/*state.executeUpdate("insert into staffRecord values('"+recordId + "','"+record.getfOrgaName() +"','"+record.getsOrgaName() 
			+ "','"+record.gettOrgaName() + "','"+record.getGender() + "','"+record.getEmail() 
			+ "','"+record.getTelephoneNum() + "','"+record.getCellPhoneNum() + "','"+record.getQQ() + "','"+record.getAddress() 
			+ "','"+record.getZipCode() + "','"+record.getNationality() + "','"+record.getBirthplace() + "','"+record.getBirthday() 
			+ "','"+record.getNation() + "','"+record.getReligious() + "','"+record.getPolitics() + "','"+record.getIDCardNum() 
			+ "','"+record.getSocialSecurityNum() + "',"+record.getAge() + ",'"+record.getEducation() + "',"+record.getEducationYears() 
			+ ",'"+record.getMajoy() + "',"+record.getWageStander() + ",'"+record.getBank() + "','"+record.getAccountNum() 
			+ "','"+record.getRegistor() + "','"+record.getBuiltTime() + "','"+record.getSpecialty() + "','"+record.getHobby() 
			+ "','"+record.getPersonalResume() + "','"+record.getFamilyInformation() + "','"+record.getRemarks()+ "','"+"待复核"
			 + "','"+record.getPostTypeName() + "','"+record.getPostName() + "','"+record.getStaffName() + "')");*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			jdbcUtil.close(rs, ps, conn);
		}
	}
}
