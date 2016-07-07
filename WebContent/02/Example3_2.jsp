<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Example3_2.jsp" method="post" name="form">
		<input type="text" name="girl">
		<input type="submit" value="Enter" name="submit">
	</form>
	
	<%
		String content = request.getParameter("girl");
		double number = 0, r = 0;
		if(content == null){
			content = "";
		}
		try{
			number = Double.parseDouble(content);
			if(number >= 0){
				r = Math.sqrt(number);
				out.println(String.valueOf(number) + "	的平方根是：");
				out.println(String.valueOf(r));
			} else {
				out.println("请输入一个正数");
			}
		}catch(NumberFormatException e){
			out.println("请输入数字字符");
		}
		
	%>
</body>
</html>