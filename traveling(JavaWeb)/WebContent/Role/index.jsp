<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>

 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="http://192.168.43.23:8080/traveling/SelectAdmin" method="get">    
    用户名称：
    <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增管理员</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
   <thead>
    <tr>
        <th>管理员</th>
        <th>密码</th>
        <th>操作</th>
        
    </tr>
    </thead>
      <c:forEach var="s" items="${list}">
    <tr>
    	<td>${s.username }</td>
    	<td>${s.password }</td>
    	<td><a href="http://192.168.43.23:8080/traveling/DeleteoneAdmin?id=${s.username}">删除</a>
    	<a href="http://192.168.43.23:8080/traveling/UpdateoneAdmin?id=${s.username}">编辑</a></td>
    </tr>
    </c:forEach>

</table>
</body>

<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="Role/add.jsp";
		 });


    });

	function del(id)
	{
		
		
		if(confirm("确定要删除吗？"))
		{
		
			var url = "index.html";
			
			window.location.href=url;		
		
		}
	
	
	
	
	}
</script>
</html>