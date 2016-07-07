<%@page import="com.lxp.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>用户信息列表</h2>
	<table>
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>家庭住址</td>
		</tr>
		<%
			List<UserBean> list = (List<UserBean>) application.getAttribute("users");
			if(list != null){
				for(UserBean user : list){
					%>
					<tr>
						<td><%=user.getName() %></td>
						<td><%=user.getSex() %></td>
						<td><%=user.getAddress() %></td>
					</tr>
					<%
				}
			}
		%>
		<tr>
			<td colspan="3"><a href="index.jsp">继续添加</a></td>
		</tr>
	</table>
</body>
</html>