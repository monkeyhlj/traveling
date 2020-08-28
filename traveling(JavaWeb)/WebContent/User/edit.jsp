<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<body>
<form action="http://192.168.43.23:8080/traveling/UpdateUser" method="post" class="definewidth m20">
<input type="hidden" name="id" value="{$menu.id}" />
<table class="table table-bordered table-hover m10">
    
   
     <tr>
        <td class="tableleft">用户名称</td>
        <td><input type="text" name="username" value="${q.username}" readonly /></td>
    </tr>
    <tr>
        <td class="tableleft">用户密码</td>
        <td><input type="text" name="password" value="${q.password}" /></td>
    </tr>
    
    
   
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>

</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="http://192.168.43.23:8080/traveling/QueryUser";
		 });

    });
</script>
