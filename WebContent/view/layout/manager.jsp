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
				<i class="icon fa fa-list-alt fa-4x"></i>
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
				<i class="icon fa fa-tags"></i>
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

	<c:if test="${rank==1 }">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<a class="card card-banner card-yellow-light"
				href="${pageContext.request.contextPath}/UserServlet">
				<div class="card-body">
					<i class="icon fa fa-user-plus fa-4x"></i>
					<div class="content">
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
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
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
	int rank1 = Integer.parseInt(request.getSession().getAttribute("rank").toString());
	if(rank1==0){
		ArrayList<Article> article_list = (ArrayList<Article>) op.SearchArticleByMemberIdAndStartIndexwithoutJudge(member_id, 0, 4);
		request.setAttribute("article_list", article_list);
	}else{
		ArrayList<Article> article_list = (ArrayList<Article>) op.SearchArticles();
		request.setAttribute("article_list", article_list);
	}
	
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

							<th><c:if test="${rank==0 }">状态</c:if> <c:if
									test="${rank==1 }">作者</c:if></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${article_list.size()>0 }">
							<c:forEach var="item" items="${article_list }" end="3">
								<tr>
									<td>
									<a style="color:#444;" href="${rooturl }/view/show/article.jsp?member_id=${item.getMember_id()}&id=${item.getId()}&pagenum=1"> ${item.getTitle() } </a>
									
									</td>
									<td>${item.getNowtime() }</td>
									<td><c:if test="${rank==0 }">

											<c:if test="${item.getJudge()==0}">正在审核中</c:if>
											<c:if test="${item.getJudge()==1}">审核已通过</c:if>
										</c:if> <c:if test="${rank==1 }">${item.getMemberName()}</c:if></td>
								</tr>
							</c:forEach>
						</c:if>
				</table>

			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="card">
			<div class="card-header">小站信息</div>
			<div class="card-body" style="margin-top: 15px;">
				<ul class="list-group">
					<li class="list-group-item"><label>建站时间</label><span
						style="margin-left: 10%;">2019-01-02</span></li>
					<li class="list-group-item"><label>主要目的</label><span
						style="margin-left: 10%;">给大家提供一个记录自己成长的平台</span></li>

					<li class="list-group-item"><label>运营时间</label><span
						style="margin-left: 10%;" id="timespan"></span></li>
					<li class="list-group-item"><label>运营者</label><span
						style="margin-left: 13%;">杨小宾 </span><span
						style="margin-left: 2%;">周旋</span></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!--补充slide.jsp 的 div  -->
</div>
<script type="text/javascript">
/* 一次刷新 */
window.onload = function(){
			var url=document.location.href;  //获取浏览器访问栏里的地址
	console.log(url);        
	if( url.indexOf("r=")==-1 ){    //判断地址后面是否多了某些值，没有就进方法里进行刷新
	  			var t = new Date();
				window.location.href = url + "?r=" + t.getTime();     
	        }
	    }; 
</script>
<script>
	var t1 = window.setInterval("abstime()",1000);
	function abstime() {
		    var date1= '2019/01/02 00:00:00';  //开始时间
	        var date2 = new Date();    //结束时间
	        var date3 = date2.getTime() - new Date(date1).getTime();   //时间差的毫秒数      
	 
	        //------------------------------
	 
	        //计算出相差天数
	        var days=Math.floor(date3/(24*3600*1000))
	 
	        //计算出小时数
	 
	        var leave1=date3%(24*3600*1000)    //计算天数后剩余的毫秒数
	        var hours=Math.floor(leave1/(3600*1000))
	        //计算相差分钟数
	        var leave2=leave1%(3600*1000)        //计算小时数后剩余的毫秒数
	        var minutes=Math.floor(leave2/(60*1000))
	        //计算相差秒数
	        var leave3=leave2%(60*1000)      //计算分钟数后剩余的毫秒数
	        var seconds=Math.round(leave3/1000)
	        var str =days+"天"+hours+"小时"+minutes+"分钟"+seconds+"秒";
	        //console.log(str);
			document.getElementById("timespan").innerText=str;
	}
	//window.clearInterval(t1); 
</script>


<!--引用js  -->
<script type="text/javascript"
	src="${rooturl}/resource/assets/js/vendor.js"></script>
<script type="text/javascript"
	src="${rooturl}/resource/assets/js/app.js"></script>
<body>



</body>
</html>
