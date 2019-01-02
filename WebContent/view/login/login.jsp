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
                <form class="col-md-10">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                            <i class="fa fa-lock fa-lg"></i>
                            <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
                    </div>
                    <div class="form-group">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/>记住我
                        </label>
                    </div>
                    <div class="form-group col-md-offset-1">
                        <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>


</html>