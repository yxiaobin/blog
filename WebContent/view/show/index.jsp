<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "java.util.*,sdut.blog.domain.*,sdut.blog.dao.impl.*, sdut.blog.service.impl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>猪猪的博客</title>
<link href="${rooturl }/resource/css/index.css" rel="stylesheet"/>
</head>
<body background="${rooturl }/resource/img/bg.png" >

<!--	<div class = "top1">
	</div>-->
	<div class = "top2">
     	<div class = "title"> 猪猪的博客</div>
        <div class = "description">遇见一场烟花盛开的美，从此，即使梦碎，依然守着不悔，选择在回忆里沉醉。风，轻轻舞动薄衫，吹起书案零.</div>
   </div>
   
    <div class = "top1">
    <div id="nav">
    	<ul>
        	<li><a class="home" href="${pageContext.request.contextPath}/ShowArticleListServlet?id=-1&pagenum=1">首页</a></li>
        	<% 
        	ArrayList<Category> list1 = new ArrayList<Category>();
            CategoryServiceImpl categoryopp = new CategoryServiceImpl();
            list1 = categoryopp.SerarchCategoryShowTitle();
            request.setAttribute("categorylist1", list1);
            %>
            <c:forEach var="item" items="${categorylist1 }">
    			<li ><a href="${pageContext.request.contextPath}/ShowArticleListServlet?id=${item.getId()}&pagenum=1" >${item.getName()}</a></li>
            </c:forEach>
    	</ul>
    </div>
    </div>
    
    
    <div class = "main">
		<div class = "main-left">
		
			<c:if test="${pagecategoryid != -1}" >
        	<div class = "cate">${categoryname }</div></a>
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%"  SIZE=3>
            
            <br/>
            </c:if>
          <c:forEach var="item" items="${showarticlelist}"> 
            <div class = "main-left-show">
        		<table border="1" height = "200px" width = "510" aligh = "center" vspace=10px >
    				<tr>
        				<td width="408" >
        				
                  			<div class = "innertitle"><h2 style = "color:white;"><a href = "${rooturl }/view/show/article.jsp?id=${item.getId()}" style = "color:whitesmoke;">${item.getTitle()}</a></h2></div>
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
    				<li class="next"><a href="${pageContext.request.contextPath}/ShowArticleListServlet?id=${pagecategoryid }&pagenum=${pagenum-1}">&laquo;Previous</a> </li>
    				</c:if>
    				<c:forEach begin="${page.getStartPage()}" end="${page.getEndPage() }" step="1" var="i">
      				<li class="<c:if test="${i==pagenum}"> active</c:if> "  >
      					<c:if test="${i!=pagenum}"> <a href="${pageContext.request.contextPath}/ShowArticleListServlet?id=${pagecategoryid }&pagenum=${i}">${i} </a></c:if>
      					<c:if test="${i==pagenum}"> ${i}</c:if>
      				</li>
      				</c:forEach>
      				
      				<c:if test="${pagenum>=page.getEndPage()}">
    				<li class="previous-off">Next &raquo;</li>
    				</c:if>
    				<c:if test="${pagenum<page.getEndPage() }">
    				<li class="next"><a href="${pageContext.request.contextPath}/ShowArticleListServlet?id=${pagecategoryid }&pagenum=${pagenum+1}">Next &raquo;</a> </li>
    				</c:if>
      			
      				
  				</ul>
            </div>
          
            <br/>
            
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=white SIZE=3>
            <hr/>
            
            
        </div>
        
        <div class = "main-right">
        	<br/><br/>
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=b SIZE=3>
            <br/>
            <div class = "main-right-top">
            <h3 style = "color:#124410;">&nbsp;&nbsp;&nbsp;&nbsp;热门文章：</h3>
            <ul >
            <% 
            ArrayList<Article> list2 = new ArrayList<Article>();
            ArticleServiceImpl articleop = new ArticleServiceImpl();
            list2 = articleop.SearchArticleByCount();
            request.setAttribute("articlelist", list2);
            System.out.println(list2.size());
            %>
            <c:forEach var="item" items="${articlelist }">
    			<li ><a href="${rooturl }/view/show/article.jsp?id=${item.getId()}" style = "color:#064e41;" >${item.getTitle()}</a></li>
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
            list3 = categoryop.SearchCategorys();
            request.setAttribute("categorylist", list3);
            %>
    			<c:forEach var="item" items="${categorylist }">
    			<li ><a href="${pageContext.request.contextPath}/ShowArticleListServlet?id=${item.getId()}&pagenum=1" style = "color:#064e41;">${item.getName() }</a></li>
            	</c:forEach>
			</ul>
            </div>
            <br/>
            
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=b SIZE=3>
            <br/><br/>
        </div>
	</div>
</body>
</html>