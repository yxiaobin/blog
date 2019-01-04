<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

 <div class="app-container">

<nav class="navbar navbar-default" id="navbar">
            <div class="container-fluid">
                <div class="navbar-collapse collapse in">
                   
                    <ul class="nav navbar-nav navbar-left">
                       
                        <li class="navbar-title">后台管理系统</li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown profile">
                            <a href="/html/pages/profile.html" class="dropdown-toggle"  data-toggle="dropdown">
                                <p>设置</p>
                                <div class="title">Profile</div>
                            </a>
                            <div class="dropdown-menu">
                                <div class="profile-info">
                                    <h4 class="username">管理员您好</h4>
                                </div>
                                <ul class="action">
                                    <li>
                                       <%
                                       	 String ids = request.getSession().getAttribute("user_id").toString(); 
                                       %>
                                        <a href="${rooturl }/view/user/edit.jsp?id=<%=ids %>">
                                           		 信息修改
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/LogoutServlet">
                                            		退出
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


