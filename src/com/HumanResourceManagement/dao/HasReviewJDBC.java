package dao;

import java.sql.*;

import domain.RecordBean;
import util.JDBCUtil;

public class HasReviewJDBC
{
	Connection conn = null;
	java.sql.Statement state = null;
	ResultSet rs = null;
	//��ȡJDBCUtil���������ʵ��
	JDBCUtil jdbcUtil = JDBCUtil.getInstance();
	
	public void updateRecord(RecordBean record) 
	{
		try
		{
			//��ȡ���ݿ�����
			conn = jdbcUtil.getConn();
			//��ȡ����������
			state = conn.createStatement();
			//��ѯ��һ�������µĶ�����������
			rs = state.executeQuery("select * from staffRecord where recordId='"+record.getRecordId()+"'");
		
			state.executeUpdate("update staffRecord set gender='" +record.getGender() + "',EMAIL='"+record.getEmail() 
			+ "',telephoneNum='"+record.getTelephoneNum() + "',cellphoneNum='"+record.getCellPhoneNum() + "',QQ='"+record.getQQ() + "',homeAddress='"+record.getAddress() 
			+ "',zipCode='"+record.getZipCode() + "',nationality='"+record.getNationality() + "',birthplace='"+record.getBirthplace() 
			+ "',nation='"+record.getNation() + "',religious='"+record.getReligious() + "',politics='"+record.getPolitics() + "',IDCardNum='"+record.getIDCardNum() 
			+ "',socialSecurityNum='"+record.getSocialSecurityNum() + "',age="+record.getAge() + ",education='"+record.getEducation() + "',educationYears="+record.getEducationYears() 
			+ ",majoy='"+record.getMajoy() + "',wageStander="+record.getWageStander() + ",bank='"+record.getBank() + "',accountNum='"+record.getAccountNum() 
			+ "',registor='"+record.getRegistor() + "',specialty='"+record.getSpecialty() + "',hobby='"+record.getHobby() 
			+ "',personalResume='"+record.getPersonalResume() + "',familyInformation='"+record.getFamilyInformation() + "',remarks='"+record.getRemarks()+ "',whetherReview='"+"�Ѹ���"
			+ "',staffName='"+record.getStaffName() + "' where recordId='"+record.getRecordId()+"'");
			
			String postId = null;
			int count = 1;
			rs = state.executeQuery("select * from post where postName='"+record.getPostName()+"'");
			while(rs.next())
				postId = rs.getString("postId");
			
			rs = state.executeQuery("select * from staff");
			while(rs.next())
				count++;
			
			state.executeUpdate("insert into staff values('"+count+"','"+postId+"','"+record.getStaffName()
			+"','"+record.getRecordId()+"')");
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