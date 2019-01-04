<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="sdut.blog.dao.impl.UserDaoImpl"%>
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

<!-- 主要的内容  --> 
  <div class="row">
        <div class="col-md-12 col-sm-12">
            <div class="card">
                <div class="card-header">博客列表</div>
                <div class="card-body">
                    <table class=" table">
                        <thead>
						<tr>
                        <th>标题</th>
                        <th>分类</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                    
                        <c:forEach var="item" items="${article_list }">
                            <tr>
                                <td>
                                   ${item.getTitle() }
                                </td>
                                <td>
                                   ${item.getCategory_id() }
                                </td>
                                <td>
                                    ${item.getMemberName()}
                                </td>
                                <td>
                                    ${item.getNowtime() }
                                </td>
                                <td>
                                    <a href="#" target="view_window" class="btn btn-primary btn-xs" role="button">
                                     		   预览
                                    </a>
                                    <a href="#" class="btn btn-primary btn-xs" role="button">
                                      		  编辑
                                    </a>

                                    <a href="#" class="btn btn-danger btn-xs" role="button" onclick="return confirm('确认要删除吗？')">
                                        	删除
                                    </a>

                                </td>
                            </tr>
                       </c:forEach>
                    </table>
                </div>
                <div class="card-header">
                    <a href="{{url("addshow/$id")}}">
                        <input type="button" class="btn btn-primary" value="添加">
                    </a>
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