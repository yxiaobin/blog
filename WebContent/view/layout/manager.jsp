<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
 	<title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/flat-admin.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/blue-sky.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/blue.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/red.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/yellow.css">
     <style type="text/css">
        th::after{
            content: "" !important;
        }
    </style>
</head>

<!-- 内容部分 -->
<!--侧边栏  -->
<%@include file="slide.jsp" %>
<!-- 顶部，如果反过来会出蜜汁问题 -->
<%@include file="head.jsp" %>

<!-- 内容 -->
   <div class="row">
        <div class="col-lg-12">
            <div class="card card-tab">
                <div class="card-header">
                    <ul class="nav nav-tabs">
              
                        <li role="tab1" class="active">
                            <a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">管理员列表</a>
                        </li>
                      
                    </ul>
                </div>
                <div class="card-body no-padding tab-content">
                    <div role="tabpanel" class="tab-pane active" id="tab1" style="padding-top: 100px">
                        <table class="datatable table" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>姓名</th>
                                <th>账号</th>
                                <th>操作</th>

                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                             	<th>3</th>
                             	<td>3</td>
                             	<td>3</td>
                             	<td>3</td>
                             </tr>	
                            </tbody>
                        </table>
                </div>
           
                </div>

    
        </div>
    </div>
 

<!--补充slide.jsp 的 div  -->
</div>

<!--引用js  -->
<script type="text/javascript" src="${rooturl}/resource/assets/js/vendor.js"></script>
<script type="text/javascript" src="${rooturl}/resource/assets/js/app.js"></script>
<body>
		


</body>
</html> 