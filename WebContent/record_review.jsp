<%@page import="domain.RecordBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>人力资源档案复核</title>
	 <link rel="stylesheet" href="css/record_review.css" media="screen" type="text/css" />
	 <script type="text/javascript">
	 var recordId;
	 function change(recordId)
	 {
		 if(recordId==1)
			 window.navigate("recordManage.jsp");
		 else
		 	 window.navigate("RecordReviewServlet?recordId=" + recordId);
	 }
	 </script>
  </head>
  <body style="text-align:center;">
	 <form>
	 <%
	 	Vector<RecordBean> recordList = (Vector)request.getAttribute("recordList"); 
	 %>
	 <p>当前等待复核的人力资源档案总数:<%=recordList.size() %></p>
	 	<table>
	 		<tr>
	 			<td	id="first">档案编号</td>
	 			<td id="first">姓名</td>
	 			<td id="first">性别</td>
	 			<td id="first">一级机构</td>
	 			<td id="first">二级机构</td>
	 			<td id="first">三级机构</td>
	 			<td id="first">职位名称</td>
	 			<td id="first">复核</td>
	 		</tr>
	 		
	 	<%
	 	for(int i=0;i<recordList.size();i++)
	 	{
	 		%>
	 		<tr>
	 			<td><%=recordList.get(i).getRecordId() %></td>
	 			<td><%=recordList.get(i).getStaffName() %></td>
	 			<td><%=recordList.get(i).getGender() %></td>
	 			<td><%=recordList.get(i).getfOrgaName() %></td>
	 			<td><%=recordList.get(i).getsOrgaName() %></td>
	 			<td><%=recordList.get(i).gettOrgaName() %></td>
	 			<td><%=recordList.get(i).getPostName() %></td>
	 			<td><a href="#" onclick="change(<%=recordList.get(i).getRecordId() %>)">复核</a></td>
	 		</tr>
	 		<%
	 	}
	 	%>	
	 	</table>
	 </form>
  	 <font color="red">${msg}</font>
  	 <button onclick="change(1)">返回</button>
  </body>
</html>