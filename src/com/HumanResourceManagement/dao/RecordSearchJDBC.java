package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import domain.RecordBean;
import util.JDBCUtil;

public class RecordSearchJDBC 
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	Vector<RecordBean> recordList = null;
	RecordBean record = null;
	//获取JDBCUtil单例对象的实例
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public Vector<RecordBean> getSearchRecord(String fOrgaName,String sOrgaName,String tOrgaName,String postTypeName,String postName)
	{
		recordList = new Vector<>();
		try
		{
			//1.获取数据库连接
			conn = jdbcUtil.getConn();
			//2.获取传输器对象
			state = conn.createStatement();
			//3.查询该一级机构下的二级机构名称
			rs = state.executeQuery("select * from staffRecord");
			
			while(rs.next())
			{
				if(fOrgaName.equals(rs.getString("fOrganizationName")) && sOrgaName.equals(rs.getString("sOrganizationName"))
					&& tOrgaName.equals(rs.getString("tOrganizationName")) && postTypeName.equals(rs.getString("postTypeName"))
					&& postName.equals(rs.getString("postName")))
				{
					record = new RecordBean();
					record.setRecordId(rs.getString(1));
					record.setfOrgaName(rs.getString(2));
					record.setsOrgaName(rs.getString(3));
					record.settOrgaName(rs.getString(4));
					record.setGender(rs.getString(5));
					record.setEmail(rs.getString(6));
					record.setTelephoneNum(rs.getString(7));
					record.setCellPhoneNum(rs.getString(8));
					record.setQQ(rs.getString(9));
					record.setAddress(rs.getString(10));
					record.setZipCode(rs.getString(11));
					record.setNationality(rs.getString(12));
					record.setBirthplace(rs.getString(13));
					record.setBirthday(rs.getString(14));
					record.setNation(rs.getString(15));
					record.setReligious(rs.getString(16));
					record.setPolitics(rs.getString(17));
					record.setIDCardNum(rs.getString(18));
					record.setSocialSecurityNum(rs.getString(19));
					record.setAge(rs.getString(20));
					record.setEducation(rs.getString(21));
					record.setEducationYears(rs.getString(22));
					record.setMajoy(rs.getString(23));
					record.setWageStander(rs.getString(24));
					record.setBank(rs.getString(25));
					record.setAccountNum(rs.getString(26));
					record.setRegistor(rs.getString(27));
					record.setBuiltTime(rs.getString(28));
					record.setSpecialty(rs.getString(29));
					record.setHobby(rs.getString(30));
					record.setPersonalResume(rs.getString(31));
					record.setFamilyInformation(rs.getString(32));
					record.setRemarks(rs.getString(33));
					record.setPostTypeName(rs.getString(35));
					record.setPostName(rs.getString(36));
					record.setStaffName(rs.getString(37));
					recordList.add(record);
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
		return recordList;
	}
	
}
