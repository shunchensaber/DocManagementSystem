<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head> 
<style type="text/css">
#words{

width: 80%;
height: 700px;

}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>无标题文档</title> 

</head> 
<body> 
<div align="center">
<textarea rows="40" cols="150" id=word name=word>
<%
String txt = (String)session.getAttribute("a");
%>
<%= txt %>
</textarea>

</div>
<div align="center">
<a href="showdoc.jsp"><button>返回</button></a>
</div>

</body> 
</html> 