<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title></title>
	 <link rel="stylesheet" href="css/allsys.css" media="screen" type="text/css" />
	 <script type="text/javascript">
	 var i ;
	 	function change(i)
	 	{
	 		if(i==1)
	 			window.navigate("fOrganizationForm.jsp");
	 		if(i==2)
	 			window.navigate("humanResource.jsp");
	 	}
	 </script>
	 <style type="text/css">
	 	div	{text-align:center;}
	 	button	{margin-top:10px;width:150px;height:50px;}
	 </style>
  </head>
  <body>
  	<div>
		<button onclick="change(1)">系统设置</button><br/>
		<button onclick="change(2)">人力资源</button>
	</div>
  </body>
</html>