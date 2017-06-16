<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="navigation.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>系统设置-添加薪酬项目</title>
	 <link rel="stylesheet" href="css/systemSet.css" media="screen" type="text/css" />
	 <script src="js/systemSet.js" type="text/javascript"></script>
  </head>
  <body>
	 <div id="rightDiv">
  	    <font color="red">${msg}</font>
		<form action="${pageContext.request.contextPath}/SystemSetWpServlet" method="POST" >
			<table>
				<tr>
					<td id="f_td">薪酬项目名称</td>
					<td><input name="wageProjectName" /></td>
				</tr>
			</table>
			<input id="tijiao" type="submit" value="提交"/>
			<input id="turnBack" type="button" value="返回" />
		</form>
	 </div>
  </body>
</html>