<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="navigation.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>系统设置-添加一级机构</title>
	 <link rel="stylesheet" href="css/systemSet.css" media="screen" type="text/css" />
	 <script src="js/systemSet.js" type="text/javascript"></script>
  </head>
  <body>
	 <div id="rightDiv">
  	    <font color="red">${msg}</font>
		<form action="${pageContext.request.contextPath}/SystemSetForgaServlet" method="POST" >
			<table>
				<tr>
					<td id="f_td">一级机构名称</td>
					<td><input name="fOrganizationName" /></td>
				</tr>
			</table>
			<input id="tijiao" type="submit" value="提交"/>
			<input id="turnBack" type="button" value="返回" onclick="change_form(10)"/>
		</form>
	 </div>
  </body>
</html>