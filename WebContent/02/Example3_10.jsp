<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="get" name="form">
		<input type="submit" value="yes" name="submit">
	</form>
	<%
		String str = request.getParameter("submit");
		if(str == null) {
			str = "";
		}
		if(str.equals("yes")){
			response.setContentType("application/msword;charset=UTF-8");
		}
	%>
</body>
</html>