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
	 		window.navigate("record_register.jsp");
	 	if(i==2)
	 		window.navigate("RecordReviewServlet");
	 	if(i==3)
	 		window.navigate("record_search.jsp");
	 	if(i==4)
	 		window.navigate("record_updata.jsp");
	 	if(i==5)
	 		window.navigate("humanResource.jsp");
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
	 <button onclick="change(1)">档案登记</button><br/>
	 <button onclick="change(2)">档案复核</button><br/>
	 <button onclick="change(3)">档案查询</button><br/>
	 <button onclick="change(4)">档案变更</button><br/>
	 <button id="back" onclick="change(5)">返回</button>
	</div>
  </body>
</html>