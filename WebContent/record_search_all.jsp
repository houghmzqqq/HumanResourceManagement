<%@page import="domain.RecordBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>档案查询明细</title>
	 <link rel="stylesheet" href="css/record_register.css" media="screen" type="text/css" />
	 <script type="text/javascript">
	 var i;
	 function change(i)
	 {
		 if(i==1)
		 	window.navigate("record_search.jsp");
		 else
			 window.navigate("RecordDeleteServlet?recordId=" + i);
	 }
	 </script>
  </head>
  <body>
	 <form action="${pageContext.request.contextPath}/HasReviewServlet" name="record" method="post">
	 <jsp:useBean id="record" class="domain.RecordBean">
	 	<jsp:setProperty name="record" property="*" />
	 </jsp:useBean>
	 <%
	 	RecordBean record1 = (RecordBean)request.getAttribute("record");
	 %>
		 <table>
		 	 <tr>
		 	 	<td id="F_td">档案编号</td>
		 	 	<td id="S_td" colspan="6">
					<input id="recordId" name="recordId" readonly="readonly" value="<%=record1.getRecordId() %>" />
				</td>
				 <td rowspan="6">
				 	<img id="head_photo" src="" />
				 </td>
		 	 </tr>
			 <tr>
				 <td id="F_td"> 一级机构 </td>
				 <td id="S_td">
				 	<input name="fOrgaName" readonly="readonly" value="<%=record1.getfOrgaName() %>" />
				 </td >
				 <td id="F_td"> 二级机构</td>
				 <td id="S_td">
				 	<input name="sOrgaName" readonly="readonly" value="<%=record1.getsOrgaName() %>" />
				 </td>
				 <td id="F_td"> 三级机构</td>
				 <td id="S_td" colspan="2">
				 	<input id="F_table_3lie" name="tOrgaName" readonly="readonly" value="<%=record1.gettOrgaName() %>" />
				 </td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">职位类型</td>
			 	<td>
				 	<input name="postTypeName" readonly="readonly" value="<%=record1.getPostTypeName() %>" />
				</td>
				<td id="F_td">职位名称</td>
			 	<td>
				 	<input name="postName" readonly="readonly" value="<%=record1.getPostName() %>" />
				</td>
				<td id="F_td">职称</td>
			 	<td colspan="2">
			 		<select name="postCall" id="F_table_3lie">
			 			<option></option>
			 		</select>
				</td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">姓名</td>
			 	<td><input name="staffName" value="<%=record1.getStaffName() %>" /></td>
			 	<td id="F_td">性别</td>
			 	<td>
				 	<select name="gender">
				 		<option value="man">男</option>
				 		<option value="woman">女</option>
				 	</select>
			 	</td>
			 	<td id="F_td">EMAIL</td>
			 	<td colspan="2"><input name="Email" id="F_table_3lie" value="<%=record1.getEmail() %>"/></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">电话</td>
			 	<td><input name="telephoneNum" value="<%=record1.getTelephoneNum() %>"/></td>
			 	<td id="F_td">手机</td>
			 	<td><input name="cellPhoneNum" value="<%=record1.getCellPhoneNum() %>"/></td>
			 	<td id="F_td">QQ</td>
			 	<td colspan="2"><input name="QQ" id="F_table_3lie" value="<%=record1.getQQ() %>"/></td>
			 </tr>
		
		
			 <tr>
			 	<td id="F_td">住址</td>
			 	<td colspan="3"><input name="address" id="address_input" value="<%=record1.getAddress() %>"/></td>
			 	<td id="F_td">邮编</td>
			 	<td colspan="2"><input name="zipCode" id="zip_input" value="<%=record1.getZipCode() %>"/></td>
			 </tr>
		
		
			 <tr>
			 	<td id="F_td">国籍</td>
			 	<td>
			 		<select name="nationality">
			 			<option>中国</option>
			 		</select>
			 	</td>
			 	<td id="F_td">出生地</td>
			 	<td><input name="birthplace" value="<%=record1.getBirthplace() %>"/></td>
			 	<td id="F_td">生日</td>
			 	<td><input name="birthday" value="<%=record1.getBirthday() %>"/></td>
			 	<td id="F_td">民族</td>
			 	<td>
			 		<select name="nation">
			 			<option>汉</option>
			 		</select>
			 	</td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">宗教信仰</td>
			 	<td>
			 		<select name="religious">
			 			<option>无</option>
			 		</select>
			 	</td>
			 	<td id="F_td">政治面貌</td>
			 	<td>
			 		<select name="politics">
			 			<option>无</option>
			 		</select>
			 	</td>
			 	<td id="F_td">身份证号码</td>
			 	<td><input name="IDCardNum" value="<%=record1.getIDCardNum() %>"/></td>
			 	<td id="F_td">社会保障号码</td>
			 	<td><input name="socialSecurityNum" value="<%=record1.getSocialSecurityNum() %>"/></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">年龄</td>
			 	<td><input name="age" value="<%=record1.getAge() %>"/></td>
			 	<td id="F_td">学历</td>
			 	<td>
			 		<select name="education">
			 			<option>本科</option>
			 		</select>
			 	</td>
			 	<td id="F_td">教育年限</td>
			 	<td>
			 		<select name="educationYears">
			 			<option>16</option>
			 		</select>
			 	</td>
			 	<td id="F_td">学历专业</td>
			 	<td>
			 		<select name="majoy">
			 			<option>计算机</option>
			 		</select>
			 	</td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">薪酬标准</td>
			 	<td>
			 		<select name="wageStander">
			 			<option>未定义/0</option>
			 			<option>4000.00</option>
			 			<option>5000.00</option>
			 		</select>
			 	</td>
			 	<td id="F_td">开户行</td>
			 	<td><input name="bank" value="<%=record1.getBank() %>"/></td>
			 	<td id="F_td">账号</td>
			 	<td><input name="accountNum" value="<%=record1.getAccountNum() %>"/></td>
			 	<td id="F_td">登记人</td>
			 	<td><input name="registor" value="<%=record1.getRegistor() %>"/></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">建档时间</td>
			 	<td><input name="builtTime" value="<%=record1.getBuiltTime() %>"/></td>
			 	<td id="F_td">特长</td>
			 	<td>
			 		<select name="specialty">
			 			<option>数据库</option>
			 		</select>
			 	</td>
			 	<td id="F_td">爱好</td>
			 	<td>
			 		<select name="hobby">
			 			<option>篮球</option>
			 		</select>
			 	</td>
			 	<td></td>
			 	<td></td>
			 </tr>
		
		
			 <tr>
			 	<td id="F_td">个人履历</td>
			 	<td colspan="7"><textarea rows="3" name="personalResume" value="<%=record1.getPersonalResume() %>"></textarea></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">家庭关系信息</td>
			 	<td colspan="7"><textarea rows="3" name="familyInformation" value="<%=record1.getFamilyInformation() %>"></textarea></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">备注</td>
			 	<td colspan="7"><textarea rows="3" name="remarks" value="<%=record1.getRemarks() %>"></textarea></td>
			 </tr>
		 </table>
	 </form>
	 <button id="reset01" onclick="change(1)">返回</button>
	 <button id="reset01" onclick="change(<%=record1.getRecordId()%>)">删除</button>
  </body>
</html>