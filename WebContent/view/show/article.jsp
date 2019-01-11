<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "java.util.*,sdut.blog.domain.*,sdut.blog.dao.impl.*, sdut.blog.service.impl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 获取绝对路径 -->
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文章</title>
<link href="${rooturl }/resource/css/article.css" rel="stylesheet"/>
<style type="text/css">
	p{
		color:white;
		text-index:2em;
	}
</style>
</head>
<body background="${rooturl }/resource/img/bg.png" >
	<div class = "top2">
     	<div class = "title"> 猪猪的博客</div>
        <div class = "description">遇见一场烟花盛开的美，从此，即使梦碎，依然守着不悔，选择在回忆里沉醉。风，轻轻舞动薄衫，吹起书案零</div>
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
            <div class = "main-left-shows">
        		<table class = "maintable" >
    			<tr>
    			<%
    			    String s = request.getParameter("id");
    				ArticleDaoImpl op = new ArticleDaoImpl();
    				Article p = op.SearchArticleByID(Integer.parseInt(s));
    				p.setCount(p.getCount()+1);
    				op.UpdateArticle(p);
    				request.setAttribute("p",p);
    			%>
        		<td class = "maintd">
                  <h2 class = "mainh2">${p.getTitle()}</h2>
                  <p class = "mainp1">作者：${p.getMemberName()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间:${p.getNowtime()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浏览量：${p.getCount()}</p>
                  <p class = "mainp2" style ="color:white;!important">${p.getContent() }</p>
                  
                   <div calss = "pagenext">
            <!-- 	<ul id="pagination-digg">
    				<li class="previous-off" >&laquo;上一篇</li>
      				<li class="next"><a href="">下一篇 &raquo;</a></li>
  				</ul> -->
            </div>
           
            <div calss = "pagenext">
            	<ul id="pagination-digg">
    				<li class="previous-off" >&laquo;上一篇</li>
      				<li class="next"><a href="">下一篇 &raquo;</a></li>
  				</ul>
            </div>
            <br/><br/>
          <hr color= "#422656"/>
          <br/>
                  <div >
                  <form action = "#" method="post">
                  	<!--<textarea placeholder = "发表评论"></textarea>-->
                    <div class = "message">
                    <table class = "commit-table">
                    <tr>
                    	<td width="50"><label>昵称：</label> </td>
                        <td><input type = "text" class = "input-text"/></td>
                    </tr>
                      <tr>
                    	<td><label>邮箱：</label> </td>
                        <td><input type = "text" class = "input-text"/></td>
                    </tr> 
                     <tr><td><label>评论：</label> </td><td ><textarea placeholder = "发表评论"></textarea></td></tr>
                    </table>
                    </div>
                    <button type = "submit"“ class = "text-button">发表评论</button>
                  </form>
                  </div>
                   <br/>
                  <hr style="height:1px;border:none;border-top:1px dashed white;" />
                   
                    <div class = "message-box">
                    <p class = "cp11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;昵称：杨小猪</p>
                     <p class = "cp2">JKLJLKJKJKJ及杨小宾是只猪！！！</p>
                     <p class = "cp1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间:1997-11-30</p>
                    </div>
                    <hr style="height:1px;border:none;border-top:1px dashed white;" />
                    <br/>
                  <hr style="height:1px;border:none;border-top:1px dashed white;" />
                   
                    <div class = "message-box">
                    <p class = "cp11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;昵称：杨小猪</p>
                     <p class = "cp2">JKLJLKJKJKJ及杨小宾是只猪！！！</p>
                     <p class = "cp1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间:1997-11-30</p>
                    </div>
                    <hr style="height:1px;border:none;border-top:1px dashed white;" />
                
                </td>
    			</tr>
			</table>
            </div>
           
            <br/>
          
            
            
            
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