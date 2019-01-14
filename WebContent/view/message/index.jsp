<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 获取绝对路径 -->
<c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>留言管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/vendor.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/flat-admin.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/theme/blue-sky.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/theme/blue.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/theme/red.css">
<link rel="stylesheet" type="text/css"
	href="${rooturl}/resource/assets/css/theme/yellow.css">
<style type="text/css">
th::after {
	content: "" !important;
}
</style>
</head>
<body>
	<!--侧边栏  -->

	<%@include file="../layout/slide.jsp"%>

	<!-- 顶部，如果反过来会出蜜汁问题 -->
	<%@include file="../layout/head.jsp"%>

	<!-- 主要内容 -->
	<!-- 主要的内容  -->
	<div class="row">
		<div class="col-lg-12">
			<div class="card card-tab">
				<div class="card-header">
					<ul class="nav nav-tabs">
						<li role="tab1" <c:if test="${tab == 1}"> class="active" </c:if>>
							<a href="#tab1" aria-controls="tab1" role="tab" data-toggle="tab">留言管理</a>
						</li>
					</ul>
				</div>
				<div class="card-body no-padding tab-content">
					<div role="tabpanel"
						class="tab-pane <c:if test="${tab == 1}">  active </c:if>"
						id="tab1" style="padding-top: 100px">
						<table class="datatable table" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>文章</th>
									<th>昵称</th>
									<th>邮箱</th>
									<th>时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="item" items="${list}">
									<tr>

										<td>${item.getArticleByArticleId() }</td>
										<td>${item.getUsername() }</td>
										<td>${item.getEmail()}</td>
										<td>${item.getTime() }</td>
										<td><a class="btn btn-success btn-xs" data-toggle="modal"
											data-target="#myModal" role="button"> 预览 </a>

											<div class="modal fade" id="myModal" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content" style="width: 400px;">
														<div class="modal-header"
															style="height: 110px; background: #00000024;">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">&times;</button>
															<span style="font-size: 10px;">
																昵称：${item.getUsername() }<br />评论文章：${item.getArticleByArticleId() }<br />时间：${item.getTime() }
															</span>
														</div>
														<div class="modal-body">${item.getContent() }</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">关闭</button>
															<button type="button" class="btn btn-primary">确认</button>
														</div>
													</div>
													<!-- /.modal-content -->
												</div>
												<!-- /.modal -->
											</div> <c:if test="${item.getJudge()==0}">
												<a
													href="${rooturl }/MessageModifyServlet?id=${item.getId()}"
													class="btn btn-primary btn-xs" role="button"> 待审核 </a>
											</c:if> <c:if test="${item.getJudge()==1}">
												<a class="btn btn-primary btn-xs" role="button" disabled>
													审核通过 </a>
											</c:if> <a
											href="${rooturl }/MessageDeleteServlet?id=${item.getId()}">
												<input type="button" class="btn btn-xs btn-danger"
												onclick="return confirm('确认要删除吗？')" value="删除">
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>


				</div>
			</div>
		</div>
	</div>
	<!--补充slide.jsp 的 div  -->
	</div>

	<!--引用js  -->
	<script type="text/javascript"
		src="${rooturl}/resource/assets/js/vendor.js"></script>
	<script type="text/javascript"
		src="${rooturl}/resource/assets/js/app.js"></script>

</body>
</html>