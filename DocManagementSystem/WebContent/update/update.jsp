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
<script type="text/javascript">
function update() {
	
	var text = document.getElementById('word').value
	//text =  escape(text) 
	text = encodeURI(encodeURI(text))
	var title= document.getElementById('title').value
	var main = document.getElementById('main').value
	
    var xmlHttp;
	if(window.XMLHttpRequest)
    {
        xmlHttp = new XMLHttpRequest();

    }
	else
    {
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
	xmlHttp.open("post","../Update",true);
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;");
	xmlHttp.send("text1="+text+"&title="+title+"&main="+main);
	
	xmlHttp.onreadystatechange=function () {
		  if (xmlHttp.readyState==4)
		    {
			  alert(xmlHttp.responseText)		  
			}
  
    }

}
</script>

</head> 
<body> 

<div align="center">
<%
String txt = (String)session.getAttribute("a");
String title = (String)session.getAttribute("title");
String main  = (String)session.getAttribute("main");
String path = (String)session.getAttribute("path");
%>




<textarea rows="1" cols="150" id=title name=title>
<%=title %>
</textarea>
<textarea rows="1" cols="150" id=main name=main>
<%=main %>
</textarea>

<textarea rows="40" cols="150" id=word name=word>

<%= txt %>
</textarea>

</div>
<div align="center">
<input type="button" value="修改" onclick="update()">
<a href="../Show/showdoc.jsp"><button>返回</button></a>
</div>


</body> 
</html> 