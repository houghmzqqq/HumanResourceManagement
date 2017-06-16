<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title></title>
	 <link rel="stylesheet" href="css/allsys.css" media="screen" type="text/css" />
	 <script type="text/javascript">
	 var i;
	 function change(i)
	 {
		if(i==1)
	 		window.navigate("recordManage.jsp");
	 	if(i==2)
	 		window.navigate("wageStanderManage.jsp");
	 	if(i==3)
	 		window.navigate("wageProvideManage.jsp");
	 	if(i==4)
	 		window.navigate("sysSet_huSou.jsp");
	 }
	 </script>
	 <style>
	 	div	{text-align:center;}
	 	button	{margin-top:10px;width:150px;height:50px;}
	 	#back	{margin-top:50px;width:50px;height:30px;}
	 </style>
  </head>
  <body>
  	<div>
	 <button onclick="change(1)">人力资源档案管理</button><br/>
	 <button onclick="change(2)">薪酬标准管理</button><br/>
	 <button onclick="change(3)">薪酬发放管理</button><br/>
	 <button id="back" onclick="change(4)">返回</button>
	</div>
  </body>
</html>