<%@page import="java.util.Enumeration"%>
<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<h1>Sorry Sir/Miss.You donn't have the access permission,pls check your account!</h1>

<%
	Enumeration men = session.getAttributeNames();
	while (men.hasMoreElements()){
		Object obj = men.nextElement();
		out.println("</br>"+obj+"->"+session.getAttribute(obj.toString()));
    } 
%>
</body>
</html>