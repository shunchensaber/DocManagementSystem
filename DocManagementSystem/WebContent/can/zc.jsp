<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

	
</style>
	
<title>用户注册</title>
<script >
	function login()
	{

		var name = document.getElementById('useid');
		var  pass = document.getElementById('userpass')
		
		if(name.value==""||name.value==null)
			{
			alert("请输入用户名");
			return false;
			}
		else if(pass.value.length==0)
			{alert("请输入密码")
			return false;
			}
		
		else {
			return true;
		}	


	}
</script>
</head>
<body>
  <table width="100%" height="100%">
    
              <tr> 
                  <th  colspan="3" align=center>
           <font size="20" color="blue" align=center face ="宋体">用户注册</font></th></tr>   </table>
<table  align="center" width="10%"style=    "margin-top: 100px" >   
                 
                </th>
              </tr>   
	</table>
	 
	<table align="center" style="margin-low: 150px">
	<form action="../Zhuce" >
	<tr>
	<td>姓名:<input type="text" name="userid" id="useid" value=""></p></td>
	</tr>
	<tr>
	<td>密码:<input type="password" name="userpass" id="userpassd" value=""></td>
	
	<tr style="padding-bottom: 40px;">
 <td> <div style="text-align:center">
<input type="submit" value="注册"  >
<input type="button" value="返回" onclick="window.location.href='login.jsp'"></td></tr>
	
	</form>
	</table>


</body>
</html>