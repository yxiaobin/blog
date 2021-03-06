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
	<link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/flat-admin.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/blue-sky.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/blue.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/red.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/yellow.css">
    <link href="${rooturl }/resource/css/article.css" rel="stylesheet"/>
<style type="text/css">
	p{
		color:white;
		text-index:2em;
	}
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
 	
 	<%
	//获取博客博主memberid
	String sq = request.getQueryString();
	sq =sq.substring(10,sq.indexOf('&'));
	WebDaoImpl op = new WebDaoImpl();
	int member_id = Integer.parseInt(sq);
	Web web1 = new Web();
	web1.setMember_id(member_id);
	Web web = op.SearchWebByMember_id(web1);
	UserDaoImpl userop = new UserDaoImpl();
	User user = userop.SearchUserByID(member_id);
	request.setAttribute("user",user);
%>
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
            <div class = "main-left-shows">
        		<table class = "maintable" >
    			<tr>
    			<%
    			    String s = request.getParameter("id");
    				ArticleDaoImpl articleop = new ArticleDaoImpl();
    				Article p = articleop.SearchArticleByID(Integer.parseInt(s));
    				p.setCount(p.getCount()+1);
    				articleop.UpdateArticle(p);
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
                  <form action = "${rooturl}/MessageAddServlet?member_id=${user.getId()}&id=${p.getId()}" method="post">
                  	<!-- <textarea placeholder = "发表评论"></textarea> -->
                    <div class = "message">
                    <table class = "commit-table">
                    <tr>
                    	<td width="50"><label>昵称：</label> </td>
                        <td><input type = "text" class = "input-text" name = "username"/></td>
                    </tr>
                      <tr>
                    	<td><label>邮箱：</label> </td>
                        <td><input id = "email"  type = "text" class = "input-text" name = "email"/><span id=myspan style="text-size:21px;color:red;"></span></td>
                    </tr> 
                     <tr><td><label>评论：</label> </td><td ><textarea placeholder = "发表评论" name = "content"></textarea></td></tr>
                    </table>
                    </div> 
                    <button type = "submit" onclick="return checkEmail()" class = "text-button">发表评论</button>
                  	<script>
                  		function checkEmail(){
                  		   var myemail=document.getElementById("email").value;
                  		　　 var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
                  		　　 if(myReg.test(myemail)){
                  		　　　　return true;
                  		　　}else{
                  		　　　　myspan.innerText="请输入正确的邮箱";
                  		　　　　return false;
                  		   }
                  			
                  		}
                  	
                  	</script>
                  </form>
                  </div>
                   <br/>
                   <%
                   String pagenum = request.getParameter("pagenum");
                   System.out.println(pagenum);
                   ArrayList<Message> list =  new ArrayList<Message>();
                   MessageDaoImpl op1 = new MessageDaoImpl();
                   int total = op1.SearchMessageByArticleIdCount(Integer.parseInt(s));
                   Page pp = new Page(Integer.parseInt(pagenum),total);
                   list = op1.SearchMessageByIndex(pp.getStartindex(),pp.getPagesize(),Integer.parseInt(s));
                   request.setAttribute("pp",pp);
                   request.setAttribute("list",list);
                   
                   %>
                   <c:forEach var = "item" items = "${list}" >
                  <hr style="height:1px;border:none;border-top:1px dashed white;" />
                    <div class = "message-box">
                    <p class = "cp11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;昵称：${item.getUsername()}</p>
                     <p class = "cp2">${item.getContent()}</p>
                     <p class = "cp1">时间:${item.getTime()}</p>
                    </div>
                    <hr style="height:1px;border:none;border-top:1px dashed white;" />
                    <br/>
                   </c:forEach>
                   
                   <c:if test = "${!empty list }">
                   <div calss = "pagenext">
            		
            		<ul id="pagination-digga">
            	    
            	    <c:if test = "${pp.getPagenum()==1}">
    				 <li class="previous-off">&laquo;Previous</li>
    				</c:if>
    				 <c:if test = "${pp.getPagenum()!=1}">
    				 <li class="next"><a href = "${rooturl }/view/show/article.jsp?member_id=${user.getId()}&id=${p.getId()}&pagenum=${pp.getPagenum()-1}">&laquo;Previous</a></li>
    				</c:if>
    				
    				<c:forEach begin="${pp.getStartPage()}" end="${pp.getEndPage() }" step="1" var="i">
      				<c:if test = "${pp.getPagenum()==i }">
      				<li class = "active"  >
      					${i }
      				</li>
      				</c:if>
      				<c:if test = "${pp.getPagenum()!=i}">
      				<li class=" "  >
      					 <a href="${rooturl }/view/show/article.jsp?member_id=${user.getId()}&id=${p.getId()}&pagenum=${i}">${i } </a>
      				</li>
      				</c:if>
      				</c:forEach>
      				
      				<c:if test = "${pp.getPagenum()==pp.getEndPage()}">
    				<li class="previous-off">Next &raquo;</li>
    				</c:if>
    				<c:if test = "${pp.getPagenum()!=pp.getEndPage()}">
    				 <li class="next"><a href = "${rooturl }/view/show/article.jsp?member_id=${user.getId()}&id=${p.getId()}&pagenum=${pp.getPagenum()+1}">Next &raquo;</a></li>
    				</c:if>
    				
  				</ul>
            </div>
            </c:if>
            
                   
                </td>
    			</tr>
			</table>
            </div>
           
            <br/>
          
            
            
            
        </div>
        
       <div class = "main-right">
        	<br/><br/>
        	<div class = "search">
        	<form action = "" method = "">
        	  <input name = "" class = "input-textt" placeholder = "搜索..."/>
        	  <button type = "submit"  style = "float:right;">搜索</button>
        	</form>
        	</div>
            <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color=b SIZE=3>
            <br/>
            <div class = "main-right-top">
            <h3 style = "color:#124410;">&nbsp;&nbsp;&nbsp;&nbsp;热门文章：</h3>
            <ul >
            <% 
            ArrayList<Article> list2 = new ArrayList<Article>();
            ArticleServiceImpl articleopp = new ArticleServiceImpl();
            list2 = articleopp.SearchArticleByCount(member_id);
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
            
            <hr style="FILTER: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color="black" !important SIZE=3/>
            <br/><br/>
        </div>
	</div>
		<!--引用js  -->
<script type="text/javascript" src="${rooturl}/resource/assets/js/vendor.js"></script>
<script type="text/javascript" src="${rooturl}/resource/assets/js/app.js"></script>
</body>
</html>