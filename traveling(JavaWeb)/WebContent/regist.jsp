<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册页</title>
		<link rel="stylesheet" type="text/css" href="Css/registcss.css" />
		<script type="text/javascript">
			window.onload=function ()
			{
				var oUser=document.getElementById('username');
				var oPas1=document.getElementById('password1');
				var oPas2=document.getElementById('password2');
				var oDel=document.getElementById('denglu');
				
				oDel.onclick=function (){
					if(oUser.value==''){
						alert('用户名不能为空！');
						return;
					}
					if(oPas1.value==''||oPas2.value==''){
						alert("密码不能为空！");
						return;
					}
					if(oPas1.value!=oPas2.value)
					{
						alert('两次次输入的密码不一样！请您仔细检查');
						return;
					}
					else{
						var form=document.getElementById('form');
						form.submit();
						return;
					}
				};
			};
		</script>
	</head>
	<body>
		<div id="log">
			<div id="logg">
					<p>用户注册</p>
			</div>
			<form action="http://192.168.43.23:8080/traveling/UserRegist" method="post" id="form">
				<input id="username" name="username" type="tel" maxlength="6" placeholder="  请输入用户名" />
				<input id="password1" name="password1" type="password" maxlength="10" placeholder="  请输入密码" />
				<input id="password2" name="password2" type="password" maxlength="10" placeholder="  请再次输入密码" />
				<input id="denglu" type="button" value="注册" />
			</form>
		</div>
		<footer>
			<p>HTY版权所有</p>
		</footer>
	</body>
</html>
