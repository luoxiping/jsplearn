<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/LoginServlet" method="post">
		userName:<input type="text" name="uname" ><br>
		password:<input type="password" name="upwd" ><br>
		<input type="reset" value="reset"><br>
		<input type="submit" value="submit"><br>
	</form>
</body>
</html>