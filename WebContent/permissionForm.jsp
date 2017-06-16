<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>系统设置-添加权限</title>
	 <link rel="stylesheet" href="css/systemSet.css" media="screen" type="text/css" />
	 <script src="js/systemSet.js"></script>
  </head>
  <body>
	 <div id="leftDiv">
	 	<button id="pm" type="button" onclick="change_form(6)">添加权限</button>
	 	<button id="role" type="button" onclick="change_form(7)">添加角色</button>
	 	<button id="role_pm" type="button" onclick="change_form(8)">设置角色-权限</button>
	 	<button id="forga" type="button" onclick="change_form(1)">添加一级机构</button>
	 	<button id="sorga" type="button" onclick="change_form(2)">添加二级机构</button>
	 	<button id="torga" type="button" onclick="change_form(3)">添加三级机构</button>
	 	<button id="pt" type="button" onclick="change_form(4)">添加职位类型</button>
	 	<button id="p" type="button" onclick="change_form(5)">添加职位</button>
	 	<button id="wp" type="button" onclick="change_form(9)">添加薪酬项目</button>
	 </div>
	 
	 <div id="rightDiv">
	 	<font color="red">${msg}</font>
		<form action="${pageContext.request.contextPath}/SystemSetPmServlet" method="post">
			<table>
				<tr>
					<td id="f_td">权限编号</td>
					<td><input name="permissionId" /></td>
				</tr>
				<tr>
					<td id="f_td">权限名称</td>
					<td><input name="permissionName" /></td>
				</tr>
			</table>
			<input id="tijiao" type="submit" value="提交"/>
		</form>
		<button id="tijiao" onclick="change_form(10)">返回</button>
	 </div>
  </body>
</html>