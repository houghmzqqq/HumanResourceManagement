<%@page import="domain.WageStanderBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>薪酬标准等记</title>
	 <link rel="stylesheet" href="css/wage_register.css" media="screen" type="text/css" />
	 <script type="text/javascript">
	 function change()
	 {
		 window.navigate("wageStanderReviewServlet");
	 }
	 </script>
  </head>
  <body>
  	<div>
	 <form action="${pageContext.request.contextPath}/WageStanderReviewPassServlet" method="post">
	 <font color="red">${msg}</font>
	 <%
	 WageStanderBean wageStanderBean = (WageStanderBean)request.getAttribute("wageStanderBean");
	 Vector<String> wageProjectList = (Vector)request.getAttribute("wageProjectList");
	 Map<String,String> map = (Map<String,String>)request.getAttribute("map");
	 %>
	 	<table>
	 		<tr>
	 			<td>薪酬标准编号</td>
	 			<td><input name="wageStanderId" value="<%=wageStanderBean.getWageStanderId()%>"/></td>
	 			<td>薪酬标准名称</td>
	 			<td><input name="wageStanderName" value="<%=wageStanderBean.getWageStanderName()%>"/></td>
	 			<td>薪酬总额</td>
	 			<td><input name="wageAmount" value="<%=wageStanderBean.getWageAmount()%>"/></td>
	 		</tr>
	 		<tr>
	 			<td>制定人</td>
	 			<td><input name="maker" value="<%=wageStanderBean.getMaker()%>"/></td>
	 			<td>登记人</td>
	 			<td><input  name="registor" value="<%=wageStanderBean.getRegistor()%>"/></td>
	 			<td>登记时间</td>
	 			<td><input name="registerTime" value="<%=wageStanderBean.getRegisterTime()%>"/></td>
	 		</tr>
	 		<tr>
	 			<td >复核意见</td>
			 	<td colspan="5"><textarea rows="3" name="fuheyijian"></textarea></td>
	 		</tr>
	 		<tr>
	 			<td colspan="2" id="t">序号</td>
	 			<td colspan="2" id="t">薪酬项目名称</td>
	 			<td colspan="2" id="t">金额</td>
	 		</tr>
	 		
	 		<tr>
	 			<td id="pro" colspan="2">1</td>
	 			<td id="pro" colspan="2">基本工资</td>
	 			<td id="pro" colspan="2"><input name="wageStander" value="<%=wageStanderBean.getWageStander()%>"/></td>
	 		</tr>
	 		<%
	 		for(int i=0; i<wageProjectList.size(); i++)
	 		{
	 			%>
	 			<tr>
		 			<td id="pro" colspan="2"><%=i+2 %></td>
		 			<td id="pro" colspan="2"><%=wageProjectList.get(i) %></td>
		 			<td id="pro" colspan="2"><input name="<%=wageProjectList.get(i) %>" value="<%=map.get(wageProjectList.get(i))%>"/></td>
	 			</tr>
	 			<%
	 		}
	 		%>
	 	</table>
	 	<input id="but" type="submit" value="复核"/>
	 </form>
	 <button id="but" onclick="change()">返回</button>
	</div>
  </body>
</html>