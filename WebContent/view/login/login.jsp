<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 获取绝对路径 -->
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>login</title>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${rooturl}/resource/css/login.css">

	
</head>

<body>
	<div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-2" id="login_form">
                <h3 class="form-title">请登录</h3>
                <form class="col-md-10" action="${rooturl }/LoginServlet" method="post">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                            <i class="fa fa-lock fa-lg"></i>
                            <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="12"/>
                    </div>
                    <div class="form-group">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/>记住我
                        </label>
                    </div>
                    <div class="form-group col-md-offset-1">
                     	<button type="button"  data-toggle="modal" data-target="#register" class="btn btn-primary pull-left" >注册 </button>
                        <input type="submit" class="btn btn-success pull-right" value="登录">
                    </div>
                    
                  	
                </form>
            </div>
        </div>
    </div>
    
    
    
<!-- 模态框（Modal） -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">注册账号</h4>
            </div>
            <div class="modal-body">
            <form class="col-md-7" action="${rooturl }/RegisterServlet" method="post">
	             		<div class="form-group">
	                        <i class="fa fa-user fa-lg"></i>
	                        <input class="form-control required" type="text" placeholder="请输入你的账号" id="musername" name="username" autofocus="autofocus" maxlength="20"/>
	                    	<span id=usernamespan style="text-size:21px;color:red;"></span>
	                    </div>
	                    
	                    <div class="form-group">
	                        <i class="fa fa-user fa-lg"></i>
	                        <input class="form-control required" type="text" placeholder="请输入你的真实姓名" id="mname" name="name" autofocus="autofocus" maxlength="20"/>
	                   		<span id=namespan style="text-size:21px;color:red;"></span>
	                    </div>
	                    
	                    <div class="form-group">
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input class="form-control required" type="password" placeholder="请输入你的密码" id="mpassword" name="password" />
	                    		<span id=passwordspan style="text-size:21px;color:red;"></span>
	                    </div>
	                    
	                    <div class="form-group">
	              
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input class="form-control required" type="password" placeholder="请再次输入你的密码" id="mpassword2" name="password2" />
	                    		<span id=password2span style="text-size:21px;color:red;"></span>
	                    </div>
	                    
	                    <div class="form-group">
	                    	
	                            <i class="fa fa-email fa-lg"></i>
	                            <input class="form-control required" type="text" placeholder="请再次输入你的邮箱" id="memail" name="email" />
	                   			<span id=emailspan style="text-size:21px;color:red;"></span>
	                    </div>
	                    <div class="form-group">
	                    	
	                            <i class="fa fa-email fa-lg"></i>
	                            <input  type = "text" id="mcheckcode" name="checkcode" />
	                            <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/MakeImgServlet" id="validateCodeImg" onclick="changeImg()">
	                    		<a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>	
	                    		<span id="checkcodespan" style="text-size:21px;color:red;"></span>
	                    </div>
	                    
	                    <div class ="form-footer">
	                     <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                		 <button type="submit" onclick="return check()" class="btn btn-primary">提交</button>
	                    </div>
	            </form>
            </div>
            <div class="modal-footer">
              <!--   <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交</button> -->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
   <script>
	  function changeImg(){
	    document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/MakeImgServlet?"+Math.random();
	  } 
	  function check(){
		  
		  var item = document.getElementById("musername");
		  var str = item.value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		  console.log(str);
		  if(str ==""){
			 　usernamespan.innerText="请输入你的账号";
			 return false;
		  }
		  
		  item = document.getElementById("mname");
		  str = item.value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		  console.log(str);
		  if(str ==""){
			 　namespan.innerText="请输入你的真实姓名";
			 return false;
		  }
		  item = document.getElementById("mpassword");
		  str = item.value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		  console.log(str);
		  if(str ==""){
			 　passwordspan.innerText="请输入你的密码";
			 return false;
		  }
		  item = document.getElementById("mpassword2");
		  str = item.value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		  console.log(str);
		  if(str ==""){
			 password2span.innerText="请再次输入你的密码";
			 return false;
		  }else{
			  str1=document.getElementById("mpassword").value ;
			  str2=document.getElementById("mpassword2").value ;
			  if(str1 == str2){
				 
			  }else{
				  password2span.innerText="两次输入的密码不一致";
				  return false;
			  }
		  }
		  
		  item = document.getElementById("memail");
		  str = item.value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		  console.log(str);
		  if(str == ""){
			 　emailspan.innerText="请输入你的邮箱";
			 return false;
		  }else{
			  var myReg=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
			  
			  if(myReg.test(str)){  		　
				 
        	 }else{
        		 emailspan.innerText="请输入正确的邮箱"; 
        		　return false;　　
        	 }
		  }
		  
		  item = document.getElementById("mcheckcode");
		  str = item.value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
		  console.log(str);
		  if(str ==""){
			 checkcodespan.innerText="请输入验证码";
			 return false;
		  }
		  
		  return true;
	  }
  </script> 
</body>
  

</html>