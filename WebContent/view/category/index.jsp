<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="sdut.blog.dao.impl.*, java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
   <!-- 获取绝对路径 -->
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>分类管理</title>
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
                        <li role="tab1"<c:if test="${tab == 1}"> class="active" </c:if>>
                            <a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">分类列表</a>
                        </li>
                        <li role="tab2" style="width:160px" <c:if test="${tab == 2}"> class="active" </c:if>">
                            <a href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">添加分类</a>
                        </li>
                    </ul>
                </div>
                <div class="card-body no-padding tab-content">
                    <div role="tabpanel" class="tab-pane <c:if test="${tab == 1}">  active </c:if>" id="tab1" style="padding-top: 100px">
                        <table class="datatable table <c:if test="${tab == 2}">  active </c:if>" cellspacing="0" width="100%">
                           <thead>
                            <tr>
                                <th>序号</th>
                                <th>名称</th>
                                <th>是否显示</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${list }">
                                <tr>
                                	<td>${item.getNum () }</td>
                                    <td>${item.getName()}</td>
                                    <td><c:if test= "${item.getShow()==1}">显示</c:if>
                                    	<c:if test= "${item.getShow()==0}">不显示</c:if>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/CategoryDeleteServlet?id=${item.getId()}">
                                            <input type="button" class="btn btn-xs btn-danger" onclick="return confirm('确认要删除吗？')" value="删除">
                                        </a>
                                        <a href="${pageContext.request.contextPath}/view/category/edit.jsp?id=${item.getId()}&num=${item.getNum()}">
                                            <input type="button" class="btn btn-xs btn-primary"  value="修改">
                                        </a>
                                        <%
                                        	CategoryDaoImpl op = new CategoryDaoImpl();
                                        	List list =op.SearchCategorys(); 
                                        	request.setAttribute("totalnum",list.size());
                                        %>
                                        <a href="${pageContext.request.contextPath}/CategoryDownServlet?id=${item.getId()}">
                                            <input type="button" <c:if test="${item.getNum()==totalnum }">disabled</c:if> class="btn btn-xs btn-warning"  value="下移">
                                        </a>
                                         <a href="${pageContext.request.contextPath}/CategoryUpServlet?id=${item.getId()}">
                                            <input type="button" <c:if test="${item.getNum()==1 }">disabled</c:if> class="btn btn-xs btn-success"  value="上移">
                                        </a>
                                    </td>
                                </tr>
                         </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div role="tabpanel" class="tab-pane " id="tab2">
                        <div class="row">
                           
                            <div class="col-md-8 col-sm-12">
                                <div class="section">
                                    <div class="section-title"><i class="icon fa fa-user" aria-hidden="true"></i>请填写信息</div>
                                    <div class="section-body __indent">
                                        <form class="form form-horizontal" method="post" action="${pageContext.request.contextPath}/CategoryAddServlet" >
                                            <div class="section">
                                                <div class="section-body">
                                                    
                                                    <div class="form-group">
                                                        <label class="col-md-3 control-label">名称</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="分类名称" name="name">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-3 control-label">是否显示</label>
                                                        <div class="col-md-9">
                                                            <select  class="form-control"  name="show" >
                                                            	<option  selected = "selected"  value = "0">不显示</option>
                                                            	<option  value = "1">显示</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                     <br/>
                                                    <!--<div class="form-group">
                                                        <label class="col-md-3 control-label">描述</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="描述" name="description">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-3 control-label">链接地址</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="链接地址" name="url">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-3 control-label">链接名称</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="链接名称" name="url_title">
                                                        </div>
                                                    </div>-->
                                                    <div class="form-footer">
                                                        <div class="form-group">
                                                            <div class="col-md-9 col-md-offset-3">
                                                                <input type="submit" class="btn btn-primary" value="添加">
                                                                <input type="button" class="btn btn-default" value="取消">
                                                            </div>
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