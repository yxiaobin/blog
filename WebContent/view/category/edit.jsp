<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
   <!-- 获取绝对路径 -->
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>
<%@ page import="sdut.blog.dao.impl.CategoryDaoImpl,sdut.blog.domain.Category"  %>
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
  <div class="row">
        <div class="col-lg-12">
            <div class="card card-tab">
                <div class="card-header">
                    <ul class="nav nav-tabs">
                        <li role="tab1" class = "active">
                            <a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">修改分类</a>
                        </li>
                    </ul>
                </div>
                 <%
                 String item = request.getParameter("id");
                 int id =Integer.parseInt(item);
                 int member_id =Integer.parseInt(request.getSession().getAttribute("user_id").toString()) ;
                 CategoryDaoImpl categoryop = new CategoryDaoImpl();
                 Category category = categoryop.SearchCategoryByID(member_id, id);  
                 request.setAttribute("category",category);
                 %>        
                <div class="card-body no-padding tab-content">
                    <div role="tabpanel" class="tab-pane active" id="tab2">
                        <div class="row">
                          
                            <div class="col-md-8 col-sm-12">
                                <div class="section">
                                    <div class="section-title"><i class="icon fa fa-user" aria-hidden="true"></i>请填写信息</div>
                                    <div class="section-body __indent">
                                        <form class="form form-horizontal" method="post" action="${rooturl }/CategoryUpdateServlet">
                                                                  
                                            <div class="section">
                                                <div class="section-title"></div>
                                                <div class="section-body">
                                                <input type="text" class="form-control hidden" name="id" value="<%=category.getId()%>">
                                                 <input type="text" class="form-control hidden" name="num" value="<%=category.getNum()%>">
          				                             <div class="form-group">
                                                        <label class="col-md-3 control-label">名称</label>
                                                        <div class="col-md-9">
                                                            <input type="text" class="form-control" placeholder="名称" name="name" value="<%=category.getName()%>">
                                                        </div>
                                                    </div>
                                                    
                                                     <div class="form-group">
                                                        <label class="col-md-3 control-label">是否显示</label>
                                                        <div class="col-md-9">
                                                       
                                                            <select  class="form-control"  name="show" >
                                                            	<option <c:if test="${category.getShow()==0}" >selected </c:if> value = "0">不显示</option>
                                                            	<option <c:if test="${category.getShow()==1}" > selected</c:if> value = "1">显示</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                   					<br/>
                                                    <div class="form-footer">
                                                        <div class="form-group">
                                                            <div class="col-md-9 col-md-offset-3">
                                                                <input type="submit" class="btn btn-primary" value="保存">
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