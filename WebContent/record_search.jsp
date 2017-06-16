<%@page import="domain.RecordBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="util.JDBCUtil" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>档案查询</title>
	 <link rel="stylesheet" href="css/record_search.css" media="screen" type="text/css" />
	 <script src="js/getSelection.js" charset="utf-8"></script>
	 <script type="text/javascript">
	 var i;
	 function change(i)
	 {
		 if(i==1)
			window.navigate("recordManage.jsp");
		 else
			window.navigate("RecordSearchServlet?recordId=" + i);
	 }
	 </script>
  </head>
  <body>
	 <form action="${pageContext.request.contextPath}/RecordSearchServlet" method="post">
	 	<li>
	 		<div>I级机构</div>
	 		<select name="fOrgaName" onchange="getSorga(this.value)">
	 			<option>请选择</option>
	 			<%
					Connection conn = null;
					Statement state = null;
					ResultSet rs = null;
					JDBCUtil jdbcUtil = JDBCUtil.getInstance();
					
					try
					{
						//1.获取数据库连接
						conn = jdbcUtil.getConn();
						//2.获取传输器对象
						state = conn.createStatement();
						//3.查询一级级机构名称
						rs = state.executeQuery("select organizationName from organization"
								+ " where fatherOrganizationId is null");
						while(rs.next())
						{
							%>
							<option value="<%=rs.getString("organizationName")%>">
							<%=rs.getString("organizationName")%></option>
							<%
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
					%>
	 		</select>
	 	</li>
	 	<li>
	 		<div>II级机构</div>
	 		<select name="sOrgaName" id="sOrganizationName" onchange="getTorga(this.value)">
	 			<option>请选择</option>
	 		</select>
	 	</li>
	 	<li>
	 		<div>III级机构</div>
	 		<select name="tOrgaName" id="tOrganizationName" onchange="getPt(this.value,'pt')">
	 			<option>请选择</option>
	 		</select>
	 	</li>
	 	<li>
	 		<div>职位分类</div>
	 		<select name="postTypeName" id="postType" onchange="getP(this.value,'p')">
	 			<option>请选择</option>
	 		</select>
	 	</li>
	 	<li>
	 		<div>职位名称</div>
	 		<select name="postName" id="postName">
	 			<option>请选择</option>
	 		</select>
	 	</li>
	 	<li>
	 		<div>建档时间</div>
	 		<input  /> 至
	 		<input />（YYYY.MM.DD）
	 	</li>
	 	<li><input type="submit" value="查询" />
	 	</li>
	 </form>
	 <button onclick="change(1)">返回</button>
	 <font color="red">${msg}</font>
	 <%
	 	Vector<RecordBean> recordList = (Vector)request.getAttribute("recordList");
	 	if("yes".equals(request.getAttribute("hasSearch")))
	 	{
	 		%>
	 		<table>
	 			<tr>
	 				<td id="top">档案编号</td>
	 				<td id="top">姓名</td>
	 				<td id="top">性别</td>
	 				<td id="top">一级机构</td>
	 				<td id="top">二级机构</td>
	 				<td id="top">三级机构</td>
	 				<td id="top">职位名称</td>
	 				<td id="top">查询</td>
	 			</tr>
	 			<%
	 			for(int i=0;i<recordList.size();i++)
	 			{
	 				%>
	 				<tr>
	 					<td id="bottom"><%=recordList.get(i).getRecordId() %></td>
	 					<td id="bottom"><%=recordList.get(i).getStaffName() %></td>
	 					<td id="bottom"><%=recordList.get(i).getGender() %></td>
	 					<td id="bottom"><%=recordList.get(i).getfOrgaName() %></td>
	 					<td id="bottom"><%=recordList.get(i).getsOrgaName() %></td>
	 					<td id="bottom"><%=recordList.get(i).gettOrgaName() %></td>
	 					<td id="bottom"><%=recordList.get(i).getPostName() %></td>
	 					<td id="bottom"><a href="#" onclick="change(<%=recordList.get(i).getRecordId()%>)">查看明细</a></td>
	 				</tr>
	 				<%
	 			}
	 			%>
	 		</table>
	 		<%
	 	}
	 %>
  </body>
</html>