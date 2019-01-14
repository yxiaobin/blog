<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.text.SimpleDateFormat, java.util.Date, sdut.blog.dao.impl.*, java.util.ArrayList, sdut.blog.domain.Article, sdut.blog.utils.JDBCUtil,java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/vendor.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/flat-admin.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/theme/blue-sky.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/theme/blue.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/theme/red.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/theme/yellow.css">
<style type="text/css">
th::after {
	content: "" !important;
}
</style>
</head>

<!-- 内容部分 -->

<!--侧边栏  -->
<%@include file="slide.jsp"%>

<!-- 顶部，如果反过来会出蜜汁问题 -->
<%@include file="head.jsp"%>

<!-- 主要的内容  -->
<div class="row" style="margin: 10px -15px 30px -15px">
<c:if test = "${rank==0 }">
	<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
		<a class="card card-banner card-yellow-light"
			href="${rooturl}/MessageServlet">
			<div class="card-body">
				<i class="icon fa fa-user-plus fa-4x"></i>
				<div class="content" >
					<div class="title">留言管理</div>
					<%
            				int messagecount = 0; 
            				int categorycount = 0;
            				int articlecount = 0;
            				int member_id = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
                        	MessageDaoImpl Messageop = new MessageDaoImpl();
                        	messagecount = Messageop.SearchMessages(member_id).size();
                        	int rank1 = Integer.parseInt(request.getSession().getAttribute("rank").toString());
                        	
                        %>
					<div class="value">
						<span class="sign"></span><%=messagecount %></div>
				</div>
			</div>
		</a>
	</div>
	<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
		<a class="card card-banner card-blue-light"
			href="${rooturl }/ArticleServlet?pagenum=1">
			<div class="card-body">
				<i class="icon fa fa-newspaper-o fa-4x"></i>
				<div class="content">
					<div class="title">我的文章</div>
					<div class="value">
					<%
					ArticleDaoImpl Articleop = new ArticleDaoImpl();
                    articlecount = Articleop.SearchArticleCount(member_id);
					%>
						<span class="sign"></span><%=articlecount %></div>
				</div>
			</div>
		</a>
	</div>
	<div class="col-lg-4 col-md-8col-sm-6 col-xs-12">
		<a class="card card-banner card-green-light"
			href="${rooturl }/CategoryServlet">
			<div class="card-body">
				<i class="icon fa fa-star fa-4x"></i>
				<div class="content">
					<div class="title">我的分类</div>
					<% 
							CategoryDaoImpl Categoryop = new CategoryDaoImpl();
                            categorycount  = Categoryop.SearchCategorys(member_id).size();
                        %>
					<div class="value">
						<span class="sign"></span><%=categorycount%></div>
				</div>
			</div>
		</a>
	</div>
	</c:if>
	
	<!-- 超级用户显示内容 -->
	
	<c:if test = "${rank==1 }">
	<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
		<a class="card card-banner card-yellow-light"
			href="${rooturl}/MessageServlet">
			<div class="card-body">
				<i class="icon fa fa-user-plus fa-4x"></i>
				<div class="content" >
					<div class="title">用户管理</div>
					<%
					int usercount = 0;
					UserDaoImpl userop = new UserDaoImpl();
                    usercount  = userop.SearchUsers().size();
                    %>
					
					<div class="value">
						<span class="sign"></span><%=usercount %></div>
				</div>
			</div>
		</a>
	</div>
		<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
		<a class="card card-banner card-blue-light"
			href="${rooturl }/ArticleServlet?pagenum=1">
			<div class="card-body">
				<i class="icon fa fa-newspaper-o fa-4x"></i>
				<div class="content">
					<div class="title">待审核文章</div>
					<%
					int articlecount1 = 0;
					ArticleDaoImpl Articleopp = new ArticleDaoImpl();
                    articlecount1 = Articleopp.SearchUnjudgeArticleCount();
					%>
					<div class="value">
						<span class="sign"></span><%=articlecount1%></div>
				</div> 
			</div>
		</a>
	</div>
	</c:if>
	
</div>
<%
    ArticleDaoImpl  op = new ArticleDaoImpl();
	int member_id = Integer.parseInt(request.getSession().getAttribute("user_id").toString());
	ArrayList<Article> article_list = (ArrayList<Article>) op.SearchArticleByMemberIdAndStartIndexwithoutJudge(member_id, 0, 4);
	request.setAttribute("article_list", article_list);
 %>
<div class="row">
	<div class="col-md-6">
		<div class="card">
			<div class="card-header">Last Statuses</div>
			<div class="card-body" style="margin-top: -30px;">
				<table class=" table">
					<thead>
						<tr>
							<th>标题</th>
							<th>时间</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${article_list.size()>0 }">
							<c:forEach var="item" items="${article_list }" end="3">
								<tr>
									<td>${item.getTitle() }</td>
									<td>${item.getNowtime() }</td>
									<td>${item.getJudge()}</td>
								</tr>
							</c:forEach>
						</c:if>
				</table>
				<%--  <ul class="list-group">
                    	<c:forEach var="item" items="${article_list }" end="4" >
                        <li class="list-group-item">
                            <label style="width=70px;"><th>博客标题: &nbsp;</label>  <span style="margin-left:5%;"> ${item.getTitle() }  </span>
                        </li>
                       </c:forEach>
                    </ul> --%>

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
			<div class="card-header">小站信息</div>
			<div class="card-body" style="margin-top: 15px;">
				<ul class="list-group">
					<li class="list-group-item"><label>建站时间</label><span
						style="margin-left: 10%;">2019-01-02</span></li>
					<li class="list-group-item"><label>主要目的</label><span
						style="margin-left: 10%;">记录学到的知识与那些不想忘记的生活</span></li>

					<li class="list-group-item"><label>运行时间</label><span
						style="margin-left: 10%;"><%=len %></span></li>
					<li class="list-group-item"><label>建站者</label><span
						style="margin-left: 13%;">杨小宾 </span><span
						style="margin-left: 2%;">周旋</span></li>


				</ul>
			</div>
		</div>
	</div>
</div>
<!--补充slide.jsp 的 div  -->
</div>

<!--引用js  -->
<script type="text/javascript"
	src="${rooturl}/resource/assets/js/vendor.js"></script>
<script type="text/javascript"
	src="${rooturl}/resource/assets/js/app.js"></script>
<body>



</body>
</html>
