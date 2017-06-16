<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="util.JDBCUtil" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>人力资源档案登记</title>
	 <link rel="stylesheet" href="css/record_register.css" media="screen" type="text/css" />
	 <script src="js/getSelection.js" charset="utf-8"></script>
	 <script type="text/javascript">
	 function change()
	 {
		 window.navigate("recordManage.jsp");
	 }
	 </script>
  </head>
  <body>
	 <form action="${pageContext.request.contextPath}/RecordRegisterServlet" name="record" method="post">
	 <jsp:useBean id="record" class="domain.RecordBean">
	 	<jsp:setProperty name="record" property="*" />
	 </jsp:useBean>
  	    <font color="red">${msg}</font>
		 <table>
			 <tr>
				 <td id="F_td"> 一级机构 </td>
				 <td id="S_td">
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
				 </td >
				 <td id="F_td"> 二级机构</td>
				 <td id="S_td">
				 	<select name="sOrgaName" id="sOrganizationName" onchange="getTorga(this.value)">
				 		<option>请选择</option>
				 	</select>
				 </td>
				 <td id="F_td"> 三级机构</td>
				 <td id="S_td" colspan="2">
				 	<select name="tOrgaName" id="tOrganizationName" onchange="getPt(this.value,'pt')">
				 		<option>请选择</option>
				 	</select>
				 </td>
				 <td rowspan="5">
				 	<img id="head_photo" src="" />
				 </td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">职位类型</td>
			 	<td>
			 		<select name="postTypeName" id="postType" onchange="getP(this.value,'p')">
			 			<option>请选择</option>
			 		</select>
				</td>
				<td id="F_td">职位名称</td>
			 	<td>
			 		<select name="postName" id="postName">
			 			<option>请选择</option>
			 		</select>
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
			 	<td><input name="staffName" /></td>
			 	<td id="F_td">性别</td>
			 	<td>
				 	<select name="gender">
				 		<option value="man">男</option>
				 		<option value="woman">女</option>
				 	</select>
			 	</td>
			 	<td id="F_td">EMAIL</td>
			 	<td colspan="2"><input name="Email" id="F_table_3lie"/></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">电话</td>
			 	<td><input name="telephoneNum" /></td>
			 	<td id="F_td">手机</td>
			 	<td><input name="cellPhoneNum" /></td>
			 	<td id="F_td">QQ</td>
			 	<td colspan="2"><input name="QQ" id="F_table_3lie"/></td>
			 </tr>
		
		
			 <tr>
			 	<td id="F_td">住址</td>
			 	<td colspan="3"><input name="address" id="address_input"/></td>
			 	<td id="F_td">邮编</td>
			 	<td colspan="2"><input name="zipCode" id="zip_input"/></td>
			 </tr>
		
		
			 <tr>
			 	<td id="F_td">国籍</td>
			 	<td>
			 		<select name="nationality">
			 			<option>中国</option>
			 		</select>
			 	</td>
			 	<td id="F_td">出生地</td>
			 	<td><input name="birthplace" /></td>
			 	<td id="F_td">生日</td>
			 	<td><input name="birthday" /></td>
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
			 	<td><input name="IDCardNum" /></td>
			 	<td id="F_td">社会保障号码</td>
			 	<td><input name="socialSecurityNum" /></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">年龄</td>
			 	<td><input name="age" /></td>
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
			 			<option>4000</option>
			 			<option>5000</option>
			 		</select>
			 	</td>
			 	<td id="F_td">开户行</td>
			 	<td><input name="bank" /></td>
			 	<td id="F_td">账号</td>
			 	<td><input name="accountNum" /></td>
			 	<td id="F_td">登记人</td>
			 	<td><input name="registor" /></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">建档时间</td>
			 	<td><input name="builtTime" /></td>
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
			 	<td colspan="7"><textarea rows="3" name="personalResume"></textarea></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">家庭关系信息</td>
			 	<td colspan="7"><textarea rows="3" name="familyInformation"></textarea></td>
			 </tr>
			 
			 <tr>
			 	<td id="F_td">备注</td>
			 	<td colspan="7"><textarea rows="3" name="remarks"></textarea></td>
			 </tr>
		 </table>
		 <input id="submin01" type="submit" value="提交" />
		 <input id="reset01" type="reset" value="清除" />
	 </form>
	 <button id="reset01" onclick="change()">返回</button><br/> 
  </body>
</html>