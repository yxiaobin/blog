<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "java.util.*,sdut.blog.domain.*,sdut.blog.dao.impl.*, sdut.blog.service.impl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<style type="text/css">

#showlist{
	width:120px;
	height:80px;
	background:pink;
	display:none;
	}
#showlist a:hover{
	background:pink;
	}
.input-textt{
	background-color:rgba(255,204,204,0.5);
	width:170px;
	height:25px;
	border-radius:8px;
	border:#63C;
	font-size:15px;
	color:#ce2a2a;
	}
.search{
	height:20px;
	width:230px;
	margin-left:40px;
}
</style>
<html>
<%
	//获取博客博主memberid
	String sq = request.getQueryString();
	sq =sq.substring(10,sq.indexOf('&'));
	
	WebDaoImpl op = new WebDaoImpl();
	int member_id = Integer.parseInt(sq);
	Web web1 = new Web();
	web1.setMember_id(member_id);
	UserDaoImpl userop = new UserDaoImpl();
	User user = userop.SearchUserByID(member_id);
	request.setAttribute("user",user);
	Web web = op.SearchWebByMember_id(web1);
%>
<script language="javascript">
function onMouseover()
{
var obj=document.getElementById("showlist");
obj.style.display="block";
}
function onMouseout()
{
var obj=document.getElementById("showlist");
obj.style.display="none";
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=web.getWebname() %></title>
	<link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/flat-admin.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/blue-sky.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/blue.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/red.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/yellow.css">
	<link href="${rooturl }/resource/css/index.css" rel="stylesheet"/>
</head>
<body background="${rooturl }/resource/img/bg.png" >

	 <div class = "top">
    		<div class = "top2-register" >
         		<c:if test= "${empty usr_name }">
         		<a href ="#" style = "color:#FFF;">注册</a>
         		&nbsp;&nbsp;&nbsp;
         		<a href ="#" style = "color:#FFF;" data-toggle="modal" data-target="#myModal">登录</a>
        		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        		 
        		 <!-- 模态框（Modal） -->
<div  class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" background="${rooturl }/resource/img/bg.png" style = "width:400px; background:pink;">
            <div  class="modal-body" style = "color:black;font-weight:100;">
            <form action = "${rooturl}/LoginServlet?member_id=${user.getId()}&id=${p.getId()}" method="post" style = "color:black;">
                    <div class = "login-form">
                    <table class = "login-table">
                    <%
                    	String url =request.getRequestURI()+"?"+request.getQueryString();
                    	System.out.print(url);
                    %>
                    <input type="text" hidden  name="url" value = "<%=url%>">
                    <tr height = "100">
                    	<td width="70">用户名： </td>
                        <td><input type = "text" class = "login-input" name = "username"/></td>
                    </tr>
                      <tr>
                    	<td>密&nbsp;&nbsp;&nbsp;码： </td>
                        <td><input type = "password" class = "login-input" name = "password"/></td>
                    </tr> 
                    </table>
                    </div> 
                    <br/>
                    <div class = "login-buttonstyle">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">登陆</button>
                    </div>
                  </form>
                  </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
        		 
        		 </c:if>
        		 <c:if test="${!empty usr_name }">
        		 <div onmouseover="onMouseover()" onmouseout="onMouseout()">
        		<span  style="font-family:楷体;">亲爱的&nbsp;${usr_name }&nbsp;，您好&nbsp;&nbsp;&nbsp;&nbsp;</span>
        		<div id = "showlist">
					<a href="${rooturl}/view/layout/manager.jsp" class="list-group-item" >
  					 进入后台管理
					</a>
					<a href="${rooturl}/LogoutServlet" class="list-group-item">退出</a>
				</div>
        		</div>
        		</c:if>
        	</div>
 	</div>
	<div class = "top2">
     	<div class = "title"> <%=web.getWebname() %> </div>
        <div class = "description"><%=web.getWebstyle()%></div>
   </div>
   
    <div class = "top1">
 	<!-- 导航栏 -->   
    <div id="nav">
    	<ul>
        	<li><a class="home" href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user.getId()}&id=-1&pagenum=1">首页</a></li>
        	<% 
        	ArrayList<Category> list1 = new ArrayList<Category>();
            CategoryServiceImpl categoryopp = new CategoryServiceImpl();
            list1 = categoryopp.SerarchCategoryShowTitle(member_id);
            request.setAttribute("categorylist1", list1);
            %>
            <c:forEach var="item" items="${categorylist1 }">
    			<li ><a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user.getId()}&id=${item.getId()}&pagenum=1" >${item.getName()}</a></li>
            </c:forEach>
    	</ul>
    </div>
    </div>
    
    
    <div class = "main">
		<div class = "main-left">
		<c:if test="${pagecategoryid == -1}" >
		<br/>
		</c:if>
			<c:if test="${pagecategoryid != -1}" >
        	<div class = "cate">${categoryname}</div></a>
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%"  SIZE=3>
            
            <br/>
            </c:if>
          <c:forEach var="item" items="${showarticlelist}"> 
            <div class = "main-left-show">
        		<table border="1" height = "200px" width = "510" aligh = "center" vspace=10px border-radius=13px>
    				<tr>
        				<td width="408" >
        				
                  			<div class = "innertitle"><h2 style = "color:white;"><a href = "${rooturl }/view/show/article.jsp?member_id=${user.getId()}&id=${item.getId()}&pagenum=1" style = "color:whitesmoke;">${item.getTitle()}</a></h2></div>
                  			<div  class = "p1">作者：${item.getMemberName()}&nbsp;&nbsp;&nbsp;时间：${item.getNowtime() }</div>
                  			
                  			<div class = "p2" style = "color:whitesmoke;">
                  				<c:if test="${item.getContent().length()>80}">
                  				<p>${item.getContent().substring(0,80) }...</p>	<br/><br/>
                  				</c:if>
                  				<c:if test="${item.getContent().length()<=80}">
                  					<p>${item.getContent()}</p>
                  					<br/><br/>
                  				</c:if>
                  			</div>
                		
                		</td>
                		
    				</tr>
				</table>
            </div>
            <br/><br/>
                        
            </c:forEach> 
           <c:if test="${showarticlelist.size()==0 }">
      			 <p style = "color:white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前分类下没有任何文章！</p>
      		</c:if>
           
            
            
            <div calss = "pagenext">
            	<ul id="pagination-digg">
            	   	<c:if test="${pagenum<=1 }">
    				<li class="previous-off">&laquo;Previous</li>
    				</c:if>
    				<c:if test="${pagenum!=1 }">
    				<li class="next"><a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user.getId()}&id=${pagecategoryid }&pagenum=${pagenum-1}">&laquo;Previous</a> </li>
    				</c:if>
    				<c:forEach begin="${page.getStartPage()}" end="${page.getEndPage() }" step="1" var="i">
      				<li class="<c:if test="${i==pagenum}"> active</c:if> "  >
      					<c:if test="${i!=pagenum}"> <a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user.getId()}&id=${pagecategoryid }&pagenum=${i}">${i} </a></c:if>
      					<c:if test="${i==pagenum}"> ${i}</c:if>
      				</li>
      				</c:forEach>
      				
      				<c:if test="${pagenum>=page.getEndPage()}">
    				<li class="previous-off">Next &raquo;</li>
    				</c:if>
    				<c:if test="${pagenum<page.getEndPage() }">
    				<li class="next"><a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user.getId()}&id=${pagecategoryid }&pagenum=${pagenum+1}">Next &raquo;</a> </li>
    				</c:if>
      			
      				
  				</ul>
            </div>
          
            <br/>
            
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=white SIZE=3>
            <hr/>
            
            
        </div>
        
        <div class = "main-right">
        	<br/><br/>
        	
        	<div class = "search">
        	<form action = "" method = "">
        	  <input name = "" class = "input-textt" placeholder = "搜索..."/>
        	  <button type = "submit"  style = "float:right;">搜索</button>
        	</form>
        	</div>
            
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=black SIZE=3>
            <br/>
            <div class = "main-right-top">
            <h3 style = "color:#124410;">&nbsp;&nbsp;&nbsp;&nbsp;热门文章：</h3>
            <ul >
            <% 
            ArrayList<Article> list2 = new ArrayList<Article>();
            ArticleServiceImpl articleop = new ArticleServiceImpl();
            list2 = articleop.SearchArticleByCount(member_id);
            request.setAttribute("articlelist", list2);
            System.out.println(list2.size());
            %>
            <c:forEach var="item" items="${articlelist }">
    			<li ><a href="${rooturl }/view/show/article.jsp?member_id=${user.getId()}&id=${item.getId()}&pagenum=1" style = "color:#064e41;" >${item.getTitle()}</a></li>
            </c:forEach>
			</ul>
            </div>
            <br/><br/>
            <div class = "main-right-top">
            <h3 style = "color:#124410;">&nbsp;&nbsp;&nbsp;&nbsp;博客分类：</h3>
            <ul>
             <%
             ArrayList<Category> list3 = new ArrayList<Category>();
            CategoryDaoImpl categoryop = new CategoryDaoImpl();
            list3 = categoryop.SearchCategorys(member_id);
            request.setAttribute("categorylist", list3);
            %>
    			<c:forEach var="item" items="${categorylist }">
    			<li ><a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user.getId()}&id=${item.getId()}&pagenum=1" style = "color:#064e41;">${item.getName() }</a></li>
            	</c:forEach>
			</ul>
            </div>
            <br/>
            
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=b SIZE=3>
            <br/><br/>
        </div>
	</div>
	
	
	<!--引用js  -->
<script type="text/javascript" src="${rooturl}/resource/assets/js/vendor.js"></script>
<script type="text/javascript" src="${rooturl}/resource/assets/js/app.js"></script>
</body>
</html>