<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%
		String name=(String)request.getAttribute("name"); 
	%>
	<head>
		<meta charset="UTF-8">
		<title>登录页</title>
		<link rel="stylesheet" type="text/css" href="Css/logincss.css" />
		<script type="text/javascript">
			window.onload=function ()
			{
				var t=${t};
				if(t){
					alert('登录成功！');
					window.location.href="http://192.168.43.23:8080/traveling/shouye2.jsp?name=<%=name%>";
				}
				else{
					alert('用户名或密码错误，登录失败！');
				}
				
				
			};
		</script>	
	</head>
	<body>

		<div id="log">
			<div id="logg">
					<p><a href="login1.jsp" style="color: #b9d302;">用户登录</a></p>
					<p>|</p>
					<p><a href="login2.jsp" >管理员登录</a></p>
				</div>
			<form action="http://192.168.43.23:8080/traveling/UserLogin" method="post" id="form">
				<input id="username" name="username" type="tel" maxlength="6" placeholder="  请输入用户名" />
				<input id="password" name="password" type="password" maxlength="10" placeholder="  请输入密码" />
				<input id="denglu" type="submit" value="登录" />
			</form>
			<p><a href="regist.jsp">还没有注册？点击注册</a></p>
		</div>
		<footer>
			<p>HTY版权所有</p>
		</footer>
	</body>
</html>
