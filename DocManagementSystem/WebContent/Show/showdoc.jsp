<%@page import="Bean.DocInf"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.gridtable {
	
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
	font-size:20px; 
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
	width:140px;
	height: 50px;
}
</style>
<meta charset="utf-8">
<title>查看文档</title>
</head>
<body>






<%
ArrayList<DocInf> pagelist =(ArrayList<DocInf>)session.getAttribute("pagelist");
%>
<table class="gridtable" align="center">
<tr>
<th>用户名</th>
<th>标题</th>
<th>主要内容</th>
<th></th>
<th></th>
<th></th>

</tr>
<% for(DocInf temp:pagelist) {%>
<tr>
<%
String userid=temp.getUserid();
String title =temp.getTitle();
String main = temp.getMain();
String path = temp.getPath();
%>
<td ><%=userid %></td>
<td><%=title %></td>
<td><%=main %></td>
<td><a href="../GetTxt?filepath=<%=path%>">查看文档</a> </td>
<td><a href="../GetTxt?title=<%=title%>&main=<%=main %>&filepath=<%=path%>&do=update">修改文档信息</a>
<td><a href="../Delete?filepath=<%=path%>">删除文档</a></td>
</tr>
<%} %>
</table>
<div align="center">
<%
int nowpage = (int)session.getAttribute("nowpage"); 
for(int i = 1;i<=(int)session.getAttribute("page");i++) {%>
<a href="../ShowDoc?page=<%=i%>"><%=i %>页</a>
<%} %>
<a href="../ShowDoc?page=<%=nowpage-1%>">上一页</a>

<a href="../ShowDoc?page=<%=nowpage+1%>">下一页</a>
<p>当前第<%=(int)session.getAttribute("nowpage") %>

<a href="../daohang/index.jsp">返回上一层</a>

</p>
</div>
</body>
</html>