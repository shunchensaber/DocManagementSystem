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
<script type="text/javascript">
function update() {
	
	var text = document.getElementById('word').value
    var xmlHttp;
	if(window.XMLHttpRequest)
    {
        xmlHttp = new XMLHttpRequest();

    }
	else
    {
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
	xmlHttp.open("post","update",true);
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;");
	xmlHttp.send("text="+text);
	xmlHttp.onreadystatechange=function () {
		  if (xmlHttp.readyState==4)
		    {
			  alert(xmlHttp.responseText)		  
			}
  
    }

}
</script>
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
<input type="button" value="修改" onclick="update()">
<a><button>返回</button></a>
</div>

</body> 
</html> 