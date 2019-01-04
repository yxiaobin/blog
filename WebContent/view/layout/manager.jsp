<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="java.text.SimpleDateFormat, java.util.Date, sdut.blog.dao.impl.ArticleDaoImpl, java.util.ArrayList, sdut.blog.domain.Article"%>
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

<!-- 主要的内容  --> 
   <div class="row" style="margin: 10px -15px 30px -15px">
        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
            <a class="card card-banner card-yellow-light" href="#">
                <div class="card-body">
                    <i class="icon fa fa-user-plus fa-4x"></i>
                    <div class="content">
                        <div class="title"> 用户管理</div>
                        <div class="value"><span class="sign"></span>2</div>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
            <a class="card card-banner card-blue-light" href="#">
                <div class="card-body">
                    <i class="icon fa fa-newspaper-o fa-4x"></i>
                    <div class="content">
                        <div class="title"> 我的文章</div>
                        <div class="value"><span class="sign"></span>432</div>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-lg-4 col-md-8col-sm-6 col-xs-12">
            <a class="card card-banner card-green-light" href="#">
                <div class="card-body">
                    <i class="icon fa fa-star fa-4x"></i>
                    <div class="content">
                        <div class="title">我的分类</div>
                        <div class="value"><span class="sign"></span>7</div>
                    </div>
                </div>
            </a>
        </div>
    </div>
  <%
  ArticleDaoImpl  op = new ArticleDaoImpl();
	ArrayList<Article> article_list = (ArrayList<Article>) op.SearchArticles();
	request.setAttribute("article_list", article_list);
  %>
   <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    	Last Statuses
                </div>
                <div class="card-body">
                    <ul class="list-group">
                    	<c:forEach var="item" items="${article_list }" end="4" >
                        <li class="list-group-item">
                            <label> ${item.getTitle() }  </label>  <span style="margin-left:45%;"> 作者: ${item.getMemberName()}</span>
                        </li>
                       </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
          <%
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                       	Date begin = new Date();
                       	begin = dateFormat.parse("2019-01-02");
                       	Date end = new Date();
                       	long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
                       	long day1=between/(24*3600);
                       	long hour1=between%(24*3600)/3600;
                       	long minute1=between%3600/60;
                       	long second1=between%60/60;
                       	String len = ""+day1+"天"+hour1+"小时";
           %>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                   	 小站信息
                </div>
                <div class="card-body">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <label>建站时间</label><span style="margin-left:10%;">2019-01-02</span>
                        </li>
                         <li class="list-group-item">
                            <label>主要目的</label><span style="margin-left:10%;">记录学到的知识与那些不想忘记的生活</span>
                        </li>
                      
                        <li class="list-group-item">
                            <label>运行时间</label><span style="margin-left:10%;"><%=len %></span>
                        </li>
                       <li class="list-group-item">
                            <label>建站者</label><span style="margin-left:13%;">杨小宾 </span ><span style="margin-left:2%;">周旋</span>
                        </li>


                    </ul>
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