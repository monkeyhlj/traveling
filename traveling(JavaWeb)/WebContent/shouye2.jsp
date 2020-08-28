<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style>
			*{
				margin: 0;
				padding: 0;
			}
			#nav{
				width: 200px;
				height: 30px;
				float: right;
				position: absolute;
				top: 10px;
				right: 10px;
			}
			#nav li{
				list-style: none;
				float: left;
			}
			#nav li a{
				text-decoration: none;
				color: black;
			}
			#nav li a:hover{
				color: #b9d302;
			}
			#logo{
				width: 360px;
				height: 200px;
				/*border: 1px solid black;*/
				margin: auto;
				margin-top: 56px;
				box-sizing: border-box;
			}
			#logo img{
				width: 360px;
				height: 200px;
			}
			#search{
				text-align: center;
				margin-top: 5px;
			}
			#ser1{
				width: 400px;
				height: 36px;
			}
			#ser2{
				width: 100px;
				height: 40px;
				color: white;
				font-size: 16px;
				background: #b9d302;
			}
			#content{
				width: 900px;
				height: 360px;
				/*border: 1px solid black;*/
				margin: auto;
				margin-top: 30px;
			}
			#content div{
				width: 200px;
				height: 150px;
				/*border: 1px solid blue;*/
				margin: 10px;
				float: left;
				box-shadow: 0px 0px 5px 5px #cecece;
			}
			#content div:hover{
				box-shadow: none;
				/*box-shadow: 0px 0px 5px 5px #aaa;*/
				/*border-bottom: 1px solide rgb(219,219,219);*/
			}
			#content div img{
				width: 200px;
				height: 150px;
			}
		</style>
	</head>
	<body>
	<%
		String name=(String)request.getParameter("name");
	%>
		<div id="nav">
			<li><%=name %>,欢迎您</li>
			<li>|</li>
			<li><a href="shouye1.html">退出</a></li>
		</div> 
		<div id="logo">
			<img src="img/food.jpg" />
		</div>
		<div id="search">
			<form action="http://192.168.43.23:8080/traveling/SearchLocation" method="get">
				<input id="ser1" name="key" type="text" placeholder="请输入您要查找的地点" />
				<input id="ser2" type="submit" value="搜索" />
			</form>
		</div>
		<div id="content">
			<div><img src="img/1.jpg" /></div>
			<div><img src="img/6.jpg" /></div>
			<div><img src="img/7.jpg" /></div>
			<div><img src="img/8.jpg" /></div>
			<div><img src="img/5.jpg" /></div>
			<div><img src="img/2.jpg" /></div>
			<div><img src="img/3.jpg" /></div>
			<div><img src="img/4.jpg" /></div>
		</div>
	</body>
</html>
