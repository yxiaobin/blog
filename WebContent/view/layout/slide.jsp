<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<!DOCTYPE html>

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
  
				<li class="dropdown">
                    <a href="${pageContext.request.contextPath}/CategoryServlet">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">分类管理</div>
                    </a>
                </li>
                
                <li class="dropdown">
                    <a href="#">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">博客管理</div>
                    </a>
                    <div class="dropdown-menu">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/ArticleServlet">博客列表</a></li>
                            <li><a href="${pageContext.request.contextPath}/view/article/newArticle.jsp">更新博客</a></li>
                        </ul>
                    </div> 
                </li>
  				<li class="dropdown">
                    <a href="${pageContext.request.contextPath}/FileServlet">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">文件管理</div>
                    </a>
                </li>
                
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/UserServlet">
                        <div class="icon">
                            <i class="fa fa-sliders" aria-hidden="true"></i>
                        </div>
                        <div class="title">用户管理</div>
                    </a>
                   <!--  <div class="dropdown-menu">
                        <ul>
                            <li><a href="#">幻灯片管理</a></li>
                            <li><a href="#">幻灯片管理</a></li>
                            <li><a href="#">幻灯片管理</a></li>
                        </ul>
                    </div> -->
                </li>
            </ul>
        </div>
    </aside>
 

</div>