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
                               <img class="profile-img" src="data:image/jpg;base64,<%=request.getSession().getAttribute("user_img")%>">
                                <div class="title">Profile</div>
                            </a>
                            <div class="dropdown-menu">
                                <div class="profile-info">
                                    <h4 class="username"><%=request.getSession().getAttribute("usr_name").toString() %>&nbsp;&nbsp; 您好</h4>
                                </div>
                                <ul class="action">
                                	<li>
                                        <a href="${pageContext.request.contextPath}/view/article/newArticle.jsp">
                                            		发表新博客
                                        </a>
                                    </li>
                                    <li>
                                    	
                                        <a href="#imgModal"   data-toggle="modal" data-target="#imgModal">
                                            		上传头像
                                        </a>
                                    </li>
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
<div class="modal fade" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">修改头像</h4>
	            </div>
	              <form class="form form-horizontal" method="post" action="${pageContext.request.contextPath}/ImgUpServlet" enctype="multipart/form-data">
                    <div class="section">
                        <div class="section-body">
                           <br>
                            <div class="form-group">
                                <label class="col-md-3 control-label" style="padding-left: 12%;" >选择文件</label>
                                <div class="col-md-7">
                                    <input type="file" class="form-control"  name="file">
                                </div>
                                
                            </div>
                            <br>
                            
                            <div class="form-footer">
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <input type="submit" class="btn btn-primary" value="添加">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
	            
	     
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>

