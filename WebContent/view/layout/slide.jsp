<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<!DOCTYPE html>
<%
	int rank = Integer.parseInt(request.getSession().getAttribute("rank").toString());
%>
<div id="managerslide">

<aside class="app-sidebar" id="sidebar" style="height: auto">
        <div class="sidebar-header">
            <a class="sidebar-brand" href="#"><span class="highlight">后台管理</span></a>
            <button type="button" class="sidebar-toggle">
                <i class="fa fa-times"></i>
            </button>
        </div>
        <div class="sidebar-menu">
            <ul class="sidebar-nav">
                <li >
                    <a href="${rooturl }/view/layout/manager.jsp">
                        <div class="icon">
                            <i class="fa fa-tasks" aria-hidden="true"></i>
                        </div>
                        <div class="title">
                        	控制台首页
                        </div>
                    </a>
                </li>
                <c:if test = "${rank==0 }">
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user_id}&id=-1&pagenum=1" target="_blank">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">查看我的博客</div>
                    </a>
                   
                </li>
                </c:if>
                 <c:if test = "${rank==0 }">
                 <li class="dropdown">
                    <a href="#">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">博客管理</div>
                    </a>
                    <div class="dropdown-menu">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/ArticleServlet?pagenum=1">博客列表</a></li>
                            <li><a href="${pageContext.request.contextPath}/CategoryServlet">分类列表</a></li>
                            <li><a href="${pageContext.request.contextPath}/view/article/newArticle.jsp">撰写博客</a></li>
                             <%-- <li><a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user_id}&id=-1&pagenum=1" target="_blank">查看我的博客</a></li> --%>
                        </ul>
                    </div> 
                </li>
                </c:if>
                
                
              <c:if test = "${rank==0 }">   
  			<li class="dropdown">
                    <a href="#">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">站点管理</div>
                    </a>
                     <div class="dropdown-menu">
                        <ul>
					<%-- 		<li><a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user_id}&id=-1&pagenum=1" target="_blank">查看我的博客</a></li> --%> 
							<li><a href="${pageContext.request.contextPath}/MessageServlet" >留言管理</a></li> 
							<li><a href="${pageContext.request.contextPath}/view/web/index.jsp" >站点基本信息管理</a></li>
                        </ul>
                    </div> 
           </li> 
                </c:if>
			
                
                <c:if test = "${rank==0 }">
  				<li class="dropdown">
                    <a href="${pageContext.request.contextPath}/FileServlet?pagenum=1">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">文件管理</div>
                    </a>
                </li>
                </c:if>
                
                
                
              <!--   下面是管理员的功能菜单-->                
                
                
                
     
                
                
               <c:if test="${rank == 1}">
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/UserServlet">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">用户管理</div>
                    </a>               
                </li>
               </c:if>
               
               
               
                <c:if test="${rank == 1}">
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/ArticleServlet?pagenum=1">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">博客审核</div>
                    </a>               
                </li>
               </c:if>  
            </ul>
        </div>
    </aside>
 

</div>