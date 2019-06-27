<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#zheng{
font-size: 20px;

}
#kuang{
margin:40px;
width: 400px;
height: 50px;

}
</style>
<meta charset="utf-8">
<title>文件上传</title>
</head>
<body>
<div align="center" id="zheng">
<form action="../ReceiveFile" method="post" enctype="multipart/form-data">
<input id="uploadfile" type="file" name="uploadfile"><br>
文档标题<input id="kuang" type="text" name="title"><br>
主要内容<input id="kuang" type="text" name="main"><br>
<input type="submit" value="上传">
</form>
<a href="../daohang/index.jsp" >返回上一层</a>

</div>


</body>
</html>