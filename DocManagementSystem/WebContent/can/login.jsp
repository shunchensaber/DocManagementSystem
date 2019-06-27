<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<script type="text/javascript">
function check() {
	

var id =  document.getElementById("id").value;
var pass = document.getElementById("password").value;
	
	if(id=="")
		{alert("请输入用户名");
		return false;
		}
	else if(pass=="")
		
		{
		alert("请输入密码");
		return false;
		}
	else
		return true;

	
}
</script>
</head>
<body>

<form action="../Logindeal" onsubmit="return check()" >
<table align="center" valign="center">
<caption><h2>登陆</h2></caption>
<tr>
<td>请输入用户名:</td>
<td><input type="text" id="id" name="id"></td>
</tr>
<tr style="padding-bottom: 20px;">
<td>请输入密码:</td>
<td><input type="password" id="password" name="password"></td></tr>
<tr style="padding-bottom: 40px;"><td style="padding-left: 80px">
<input type="submit" value="提交"  ></td>
<td style="padding-left: 20px;"><button type="reset" >重置</button></td></tr>
</table>
<p align="center"><a href="./Register.jsp">没有账号,请注册</a></p>

</form>
</body>
</html>