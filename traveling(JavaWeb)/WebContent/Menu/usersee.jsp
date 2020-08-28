<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usersee</title>
<style>
			body{
				background-image: url(img/b.jpg);
				background-size: 1560px 800px;
			}
			#p1{
				font-family: "微软雅黑";
				font-size: 30px;
				text-align: center;
				color: #9fb600;
			}
			#pt{
				font-family: "微软雅黑";
				font-size: 34px;
				text-align: center;
				color: red;
			}
			#content{
			padding-top: 10px;
				width: 360px;
				margin: auto;
				/*border: 1px solid black;*/
			}
			#content ul li{
				color: #7b8c00;
				font-family: "微软雅黑";
				font-size: 22px;
				line-height: 40px;
			}
		</style>
	</head>
	<body>
		<p id="pt">${key}</p>
		<p id="p1">美食版图</p>
		<div id="content">
			<ul>
				<c:forEach var="s" items="${list}">
    				<li>大地点：${s.lid}</li>
    				<li>菜单/店名：${s.cname}</li>
    				<li>地点：${s.place}</li>
    				<li>特色菜系：${s.special}</li>
    				<br>
   				 </c:forEach>
			</ul>
		</div>
		
	</body>
</html>