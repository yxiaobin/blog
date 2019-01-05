<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
   <!-- 获取绝对路径 -->
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户管理</title>
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
<body>
<!--侧边栏  -->

<%@include file="../layout/slide.jsp" %>

<!-- 顶部，如果反过来会出蜜汁问题 -->
<%@include file="../layout/head.jsp" %>

<!-- 主要内容 -->
<!-- 主要的内容  --> 
    <div class="row">
        <div class="col-lg-12">
            <div class="card card-tab">
                <div class="card-header">
                    <ul class="nav nav-tabs">
                        <li role="tab1" <c:if test="${tab == 1}"> class="active" </c:if> >
                            <a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">用户列表</a>
                        </li>
                        <li role="tab2" style="width:160px"  <c:if test="${tab == 2}"> class="active" </c:if> >
                            <a href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">添加用户</a>
                        </li>
                    </ul>
                </div>
                <div class="card-body no-padding tab-content">
                    <div role="tabpanel" class="tab-pane <c:if test="${tab == 1}">  active </c:if>" id="tab1" style="padding-top: 100px">
                        <table class="datatable table" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                            
                                <th>邮箱</th>
                                <th>姓名</th>
                                <th>账号</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                          
                          	<c:forEach var="item" items="${user_list }">
                                <tr>
                                  
                                    <td>${item.getEmail() }</td>
                                    <td>${item.getName()}</td>
                                    <td>${item.getUsername() }</td>
                                    <td>
                                        <a href="${rooturl }/UserDeleteServlet?id=${item.getId()}">
                                            <input type="button" class="btn btn-xs btn-danger" onclick="return confirm('确认要删除吗？')" value="删除">
                                        </a>
                                        <a href="${rooturl }/view/user/edit.jsp?id=${item.getId()}">
                                            <input type="button" class="btn btn-xs btn-primary"  value="修改">
                                        </a>
                                    </td>
                                </tr>
                         </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div role="tabpanel" class="tab-pane <c:if test="${tab == 2}"> active  </c:if>" id="tab2">
                        <div class="row">
                            <div class="col-md-8 col-sm-12">
                                <div class="section">
                                    <div class="section-title"><i class="icon fa fa-user" aria-hidden="true"></i>请填写信息</div>
                                    <div class="section-body __indent">
                                        <form class="form form-horizontal" method="post" action="${rooturl }/UserAddServlet" >
                                           
                                                <div class="section-body">
                                                    <div class="form-group">
                                                        <label class="col-md-3 control-label">用户名</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="用户名" name="name">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-3 control-label">账号</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="账号" name="username">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-3 control-label">密码</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="密码" name="password">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-3 control-label">邮箱</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="请输入您的邮箱" name="email">
                                                        </div>
                                                    </div>
                                                    
                                                   
                                                    
                                                    <div class="form-footer">
                                                        <div class="form-group">
                                                            <div class="col-md-9 col-md-offset-3">
                                                                <input type="submit" class="btn btn-primary" value="添加">
                                                                <input type="button" class="btn btn-default" value="取消">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                          
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
<!--补充slide.jsp 的 div  -->
</div>

<!--引用js  -->
<script type="text/javascript" src="${rooturl}/resource/assets/js/vendor.js"></script>
<script type="text/javascript" src="${rooturl}/resource/assets/js/app.js"></script>

</body>
</html>