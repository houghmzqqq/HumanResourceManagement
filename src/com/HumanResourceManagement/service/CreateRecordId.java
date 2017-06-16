package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


/**
 * @author YJF
 * create a id for staffRecord
 * return recordId
 */
public class CreateRecordId 
{
	private ResultSet rs;
	private String f_s_t_orgaId;
	
	public CreateRecordId(ResultSet rs,String orgaId) 
	{
		this.rs = rs;
		this.f_s_t_orgaId = orgaId;
	}
	
	public String getRecordId()
	{
		int dateYear;
		int num;
		int i = 1;
		String count = "";
		
		Calendar calendar = Calendar.getInstance();
		dateYear = calendar.get(Calendar.YEAR);
		
		try 
		{
			while(rs.next())
			{
				char[] ch = rs.getString("recordId").toCharArray();
				if(f_s_t_orgaId.equals(""+ch[4]+ch[5]+ch[6]+ch[7]+ch[8]+ch[9]))
				{
					num = Integer.parseInt(""+ch[10]+ch[11]);
					if(i == num)
					{
						i ++;
					}
				}
			}
			if(i < 10)
			{
				count = "0" + i;
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return (String.valueOf(dateYear) + f_s_t_orgaId + count);
	}
}
