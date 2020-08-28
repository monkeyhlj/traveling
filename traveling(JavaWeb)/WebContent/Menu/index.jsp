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
<form class="form-inline definewidth m20" action="http://192.168.43.23:8080/traveling/SelectInformation" method="get">    
    地点编号：
    <input type="text" name="lid" id="lid" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增美食信息</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
   <thead>
    <tr>
        <th>地点编号</th>
        <th>美食名称</th>
        <th>具体位置</th>
        <th>特色菜品</th>
        <th>操作</th>
        
    </tr>
    </thead>
      <c:forEach var="s" items="${list}">
    <tr>
    	<td>${s.lid }</td>
    	<td>${s.cname }</td>
    	<td>${s.place }</td>
    	<td>${s.special }</td>
    	<td><a href="http://192.168.43.23:8080/traveling/DeleteoneInformation?cname=${s.cname}">删除</a>
    	<a href="http://192.168.43.23:8080/traveling/UpdateoneInformation?cname=${s.cname}">编辑</a></td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
<script>
    $(function () {
        

		$('#addnew').click(function(){

				window.location.href="Menu/add.jsp";
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
