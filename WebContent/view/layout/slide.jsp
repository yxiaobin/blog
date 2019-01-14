<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    
<!DOCTYPE html>
<%
	int rank = Integer.parseInt(request.getSession().getAttribute("rank").toString());
%>
     <link rel="stylesheet" href="${rooturl}/resource/font-awesome/css/font-awesome.min.css">
     
    
<div id="managerslide">

<aside class="app-sidebar" id="sidebar" style="height: auto;<c:if test = "${rank==1 }">background-color:gray;</c:if>" >
        <div class="sidebar-header" >
            <a class="sidebar-brand" href="#"><span class="highlight" <c:if test = "${rank==1 }">style = "background-color:#3045a2;"</c:if>>后台管理</span></a>
            <button type="button" class="sidebar-toggle" >
                <i class="fa fa-times"></i>
            </button>
        </div>
        <div class="sidebar-menu" <c:if test = "${rank==1 }">background-color:gray;</c:if>">
            <ul class="sidebar-nav" >
                <li >
                    <a href="${rooturl }/view/layout/manager.jsp">
                        <div class="icon"  <c:if test = "${rank==1 }">style="background-color:white; color:pink;"</c:if>>
                            <i class="fa fa-tasks" aria-hidden="true"></i>
                        </div>
                        <div class="title" <c:if test = "${rank==1 }">style = "color:white;"</c:if>>
                        	控制台首页
                        </div>
                    </a>
                </li>
                <c:if test = "${rank==0 }">
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user_id}&id=-1&pagenum=1" target="_blank">
                        <div class="icon">
                            <i class="fa fa-yelp" aria-hidden="true"></i>
                        </div>
                        <div class="title">查看我的博客</div>
                    </a>
                   
                </li>
                </c:if>
                 <c:if test = "${rank==0 }">
                 <li class="dropdown">
                    <a href="#">
                        <div class="icon">
                            <i class="fa fa-file-text-o" aria-hidden="true"></i>
                        </div>
                        <div class="title" >博客管理</div>
                    </a>
                    <div class="dropdown-menu">
                        <ul>
                        <li><a href="${pageContext.request.contextPath}/CategoryServlet">分类列表</a></li>
                            <li><a href="${pageContext.request.contextPath}/ArticleServlet?pagenum=1">博客列表</a></li>
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
                            <i class="fa fa-address-card-o" aria-hidden="true"></i>
                        </div>
                        <div class="title">站点管理</div>
                    </a>
                     <div class="dropdown-menu">
                        <ul>
					<%-- 		<li><a href="${pageContext.request.contextPath}/ShowArticleListServlet?member_id=${user_id}&id=-1&pagenum=1" target="_blank">查看我的博客</a></li> --%> 
							<li><a href="${pageContext.request.contextPath}/MessageServlet" >留言管理</a></li> 
							<li> <a href="${pageContext.request.contextPath}/FileServlet?pagenum=1">资源管理</a></li>
							<li><a href="${pageContext.request.contextPath}/view/web/index.jsp" >站点基本信息管理</a></li>
                        </ul>
                    </div> 
           </li> 
                </c:if>
			
                
                
                
              <!--   下面是管理员的功能菜单-->                
                
                
                
     
                
                
               <c:if test="${rank == 1}">
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/UserServlet">
                        <div class="icon" style="background-color:white; color:pink;">
                            <i class="fa fa-user-o" aria-hidden="true"></i>
                        </div>
                        <div class="title" style = "color:white;">用户管理</div>
                    </a>               
                </li>
               </c:if>
               
               
               
                <c:if test="${rank == 1}">
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/ArticleServlet?pagenum=1">
                        <div class="icon" style="background-color:white; color:pink;">
                            <i class="fa fa-window-maximize" aria-hidden="true"></i>
                        </div>
                        <div class="title"  style = "color:white;">博客审核</div>
                    </a>               
                </li>
                
                	<!-- 定时器 -->
                	<script>
                	var t2 = window.setInterval("listen()",1000);
                	 function listen() {
                		 $.post("${pageContext.request.contextPath}/CountServlet",function(data){
                			 //console.log(data.total);
                			 data = eval('(' + data + ')');
                			 //console.log(data.total);
                			 var num = data.total;
                			 if(num >0){
                				 document.getElementById("messagetotal1").style.display="block";
        		            	 document.getElementById("messagetotal1").innerText =num;
        		            	 document.getElementById("messagetotal2").innerText =num;	 
                			 }
                			 
    		            	 console.log(num);
                		 });  
		            	 
           		     }
                	</script>
                
      
               </c:if>  
            </ul>
        </div>
    </aside>
 

</div>