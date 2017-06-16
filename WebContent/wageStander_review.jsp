<%@page import="domain.WageStanderBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>薪酬标准复核</title>
	 <link rel="stylesheet" href="css/wage_register.css" media="screen" type="text/css" />
	 <script type="text/javascript">
	 var i;
	 function change(i)
	 {
		 if(i==1)
		 	window.navigate("wageStanderManage.jsp");
		 else
			window.navigate("wageStanderReviewServlet?wageStanderId=" + i);
	 }
	 </script>
  </head>
  <body>
	 <div>
	 <font color="red">${msg}</font>
	 	<table>
	 		<tr>
	 			<td>薪酬标准编号</td>
	 			<td>薪酬标准</td>
	 			<td>制定人</td>
	 			<td>登记人</td>
	 			<td>登记时间</td>
	 			<td>薪酬标准名称</td>
	 			<td>薪酬总额</td>
	 			<td>状态</td>
	 		</tr>
	 		<%
	 		Vector<WageStanderBean> wageStanderList = (Vector)request.getAttribute("wageStanderList");
	 		for(int i=0; i<wageStanderList.size(); i++)
	 		{
	 			%>
	 			<tr>
	 				<td id="pro"><%=wageStanderList.get(i).getWageStanderId() %></td>
	 				<td id="pro"><%=wageStanderList.get(i).getWageStander() %></td>
	 				<td id="pro"><%=wageStanderList.get(i).getMaker() %></td>
	 				<td id="pro"><%=wageStanderList.get(i).getRegistor() %></td>
	 				<td id="pro"><%=wageStanderList.get(i).getRegisterTime() %></td>
	 				<td id="pro"><%=wageStanderList.get(i).getWageStanderName() %></td>
	 				<td id="pro"><%=wageStanderList.get(i).getWageAmount() %></td>
	 				<td id="pro"><a href="#" onclick="change(<%=wageStanderList.get(i).getWageStanderId()%>)">复核</a></td>
	 			</tr>
	 			<%
	 		}
	 		%>
	 	</table>
	 <button id="but" onclick="change(1)">返回</button>
	</div>
  </body>
</html>