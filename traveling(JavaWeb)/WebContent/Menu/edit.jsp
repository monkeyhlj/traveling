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
<form action="http://192.168.43.23:8080/traveling/UpdateInformation" method="post" class="definewidth m20">
<input type="hidden" name="id" value="{$menu.id}" />
<table class="table table-bordered table-hover m10">
    
   
     <tr>
        <td class="tableleft">地点编号</td>
        <td><input type="text" name="lid" value="${q.lid}" /></td>
    </tr>
    <tr>
        <td class="tableleft">美食名称</td>
        <td><input type="text" name="cname" value="${q.cname}" readonly/></td>
    </tr>
    <tr>
        <td class="tableleft">具体位置</td>
        <td><input type="text" name="place" value="${q.place}" /></td>
    </tr>
    <tr>
        <td class="tableleft">特色菜品</td>
        <td><input type="text" name="special" value="${q.special}" /></td>
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
				window.location.href="http://192.168.43.23:8080/traveling/QueryInformation";
		 });

    });
</script>