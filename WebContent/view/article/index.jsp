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
                    	<c:if test="${article_list.size()>0 }">
                        <c:forEach var="item" items="${article_list }">
                            <tr>
                                <td>
                                   ${item.getTitle() }
                                </td>
                                <td>
                                   ${item.getCategoryName()}
                                </td>
                                <td>
                                    ${item.getMemberName()}
                                </td>
                                <td>
                                    ${item.getNowtime() }
                                </td>
                                <td>
                                    <a href="${rooturl }/view/show/article.jsp?id=${item.getId()}" target="view_window" class="btn btn-primary btn-xs" role="button">
                                     		   预览
                                    </a>
                                    <a href="${rooturl }/view/article/edit.jsp?id=${item.getId()}&pagenum=${page.getPagenum()}" class="btn btn-primary btn-xs" role="button">
                                      		  编辑
                                    </a>

                                    <a <c:if test = "${page.getTotalrecords()%page.getPagesize()==1}">href="${rooturl }/ArticleDeletServlet?id=${item.getId()}&pagenum=${page.getPagenum()-1}"</c:if> <c:if test = "${page.getTotalrecords()%page.getPagesize()!=1}">href="${rooturl }/ArticleDeletServlet?id=${item.getId()}&pagenum=${page.getPagenum()}"</c:if> class="btn btn-danger btn-xs" role="button" onclick="return confirm('确认要删除吗？')">
                                        	删除
                                    </a>

                                </td>
                            </tr>
                       </c:forEach>
                       </c:if>
                    </table>
                    <div class="bottom" style = "float:right;">
						<div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">
    					</div>
    					<div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">			 	
    						<ul class="pagination">
    						  <c:if test = "${page.getPagenum()==1}" >
    						  <li class="paginate_button previous  "><a  href="" disabled aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0">上一页</a></li> 
    						   </c:if>
    						   <c:if test = "${page.getPagenum()!=1}" >
    						  <li class="paginate_button previous  "><a  href="${pageContext.request.contextPath}/ArticleServlet?pagenum=${page.getPagenum()-1}" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0">上一页</a></li> 
    						   </c:if>
    						   <c:forEach begin = "${page.getStartPage()}" end = "${page.getEndPage()}" step = "1" var = "i">
    							<li class="paginate_button <c:if test = "${page.getPagenum()==i}">active</c:if>"><a href="${pageContext.request.contextPath}/ArticleServlet?pagenum=${i}" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">${i }</a></li>
    						  </c:forEach> 
    						  <c:if test = "${page.getPagenum()==page.getTotalpage()}">
    						<li class="paginate_button next  id="DataTables_Table_0_next"><a href="" aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0">下一页</a></li>
    						  </c:if>
    						  <c:if test = "${page.getPagenum()!=page.getTotalpage()}">
    						<li class="paginate_button next  id="DataTables_Table_0_next"><a href="${rooturl}/ArticleServlet?pagenum=${page.getPagenum()+1}" aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0">下一页</a></li>
    						  </c:if>
    						</ul>
    					</div>
    					<div class="clear">
    					</div>
					</div>
                </div>
                
                <div class="card-header">
                    <a href="${pageContext.request.contextPath}/view/article/newArticle.jsp">
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