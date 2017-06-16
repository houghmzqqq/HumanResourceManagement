<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="navigation.jsp"%>
<%@ page import="util.JDBCUtil" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>系统设置-添加二级机构</title>
	 <link rel="stylesheet" href="css/systemSet.css" media="screen" type="text/css" />
	 <script src="js/systemSet.js" charset="utf-8"></script>
	 <script src="js/getSelection.js" charset="utf-8"></script>
  </head>
  <body>
	 <div id="rightDiv">
	 	<font color="red">${msg}</font>
		<form action="${pageContext.request.contextPath}/SystemSetSorgaServlet" method="POST">
			<table>
				<tr> 
					<td id="f_td">一级机构名</td>
					<td><select name="fOrganizationName" onchange="getSorga(this.value)">
						<option value="">请选择</option>
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
					</select></td>
				</tr>
				<tr>
					<td id="f_td">二级机构名称</td>
					<td><input name="sOrganizationName" /></td>
				</tr>
			</table>
			<input id="tijiao" type="submit" value="提交"/>
			<input id="turnBack" type="button" value="返回" />
		</form>
	 </div>
  </body>
</html>