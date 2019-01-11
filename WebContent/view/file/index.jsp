<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "sdut.blog.dao.impl.UserDaoImpl"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="rooturl" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/flat-admin.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/blue-sky.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/blue.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/red.css">
    <link rel="stylesheet" type="text/css" href="${rooturl}/resource/assets/css/theme/yellow.css">
     <link rel="stylesheet" type="text/css" href="${rooturl}/resource/layui-v2.4.5/layui/css/layui.css">
    <style type="text/css">
        th::after{
            content: "" !important;
        }
    </style>
</head>
<body>
<!--侧边栏  -->
<%@include file="../layout/slide.jsp" %>

<!-- 顶部，如果反过来会出蜜汁问题 -->
<%@include file="../layout/head.jsp" %>


<!-- 主要的内容  --> 
  <div class="row">
        <div class="col-md-12 col-sm-12">
            <div class="card">
                <div class="card-header">文件列表</div>
                <div class="card-body">
                    <table class=" table">
                        <thead>
						<tr>
                        <th>文件名称</th>
                        <th>文件类型</th>
                        <th>上传者</th>
                        <th>上传时间</th>
                        <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                    	
                       <c:forEach var="item" items="${file_list}">
                            <tr>
                                <td>
                                   ${item.getName().substring(item.getName().indexOf("_")+1) }
                                </td>
                                <td>
                                <c:if test="${item.getIsshare()==0}">共享类型</c:if>
                                 <c:if test="${item.getIsshare()==1}">私有类型</c:if>
                                </td>
                                 <td>
               
                                    ${item.getMemberName()} 
                                </td>
                                <td>
                                   ${item.getNowtime() }
                                </td>
                                <td>
                                  
                                 <a href="${rooturl }/FileDownServlet?filename=${item.getName()}" class="btn btn-success btn-xs" role="button">
                                        	下载
                                  </a>
                                  <c:if test = "${item.getMember_id()==user_id }">
									<a href="${rooturl }/FileUpdateServlet?id=${item.getId()}&pagenum=${page.getPagenum()}" class="btn btn-primary btn-xs" role="button" >
                                    	
                                    	<c:if test="${item.getIsshare()==0}">设为私有</c:if>
                                    	<c:if test="${item.getIsshare()==1}">设为共有</c:if>   
                                    	 	
                                  </a>
                                  </c:if>
                                    <c:if test = "${item.getMember_id()!=user_id }">
									<a href="#" class="btn btn-primary btn-xs" role="button" disabled>
                                    	
                                    	<c:if test="${item.getIsshare()==0}">设为私有</c:if>
                                    	<c:if test="${item.getIsshare()==1}">设为共有</c:if>   
                                    	 	
                                  </a>
                                  </c:if>
                                  <c:if test = "${item.getMember_id()==user_id }">
	                                   	<c:if test = "${page.getTotalrecords()%page.getPagesize()==1&& page.getPagenum() == page.getEndPage()}">  
	                                  		<a   href = "${rooturl}/FileDeleteServlet?filename=${item.getName()}&pagenum=${page.getPagenum()-1 }"   class="btn btn-danger btn-xs" role="button" onclick="return confirm('确认要删除吗？')">
	                                        	删除
	                                  		</a>
	                                   	</c:if>  
	                                   	<c:if test = "${page.getTotalrecords()%page.getPagesize()==1&& page.getPagenum() < page.getEndPage()}">  
	                                  		<a   href = "${rooturl}/FileDeleteServlet?filename=${item.getName()}&pagenum=${page.getPagenum()}"   class="btn btn-danger btn-xs" role="button" onclick="return confirm('确认要删除吗？')">
	                                        	删除
	                                  		</a>
	                                   	</c:if>  
	                                  	<c:if test = "${page.getTotalrecords()%page.getPagesize()!=1}">
	                                  		<a   href = "${rooturl}/FileDeleteServlet?filename=${item.getName()}&pagenum=${page.getPagenum()}"   class="btn btn-danger btn-xs" role="button" onclick="return confirm('确认要删除吗？')">
	                                        	删除
	                                  		</a>
	                                  	</c:if> 
                                  </c:if>
                                  
                                  <c:if test = "${item.getMember_id()!=user_id }">
	                                  <a href="#" disabled class="btn btn-danger btn-xs" role="button" >
	                                        	删除
	                                  </a> 
                                  
                                  </c:if>
								 <!-- <a href="#" id="del" class="btn btn-danger btn-xs" role="button" onclick="func()">
                                        	删除
                                  </a> -->
                                  <script type="text/javascript">
										function func(){

											 var layer = layui.layer;
									            layer.confirm('您确定要删除吗？', {
									                btn: ['确定', '取消'],
									            },function() {
									            	 $.post("${rooturl}/FileDeleteServlet?filename=${item.getName()}");  
									            	  var s = setTimeout('window.location.reload()',1000); 	
									            });
										}					 	
								</script>
                                </td>
                            </tr>
                       </c:forEach>
                      
                    </table>
                </div>
                <div class="bottom" style = "float:right;">
						<div class="dataTables_info" id="DataTables_Table_0_info" role="status" aria-live="polite">
    					</div>
    					<div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate">			 	
    						<ul class="pagination">
							<c:if test = "${page.getPagenum()==1}" >  						
    						  <li class="paginate_button previous  "><a  href="#"  disabled aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0">上一页</a></li> 
    						</c:if>
    						  <c:if test = "${page.getPagenum()!=1}" >  						
    						  <li class="paginate_button previous  "><a  href="${pageContext.request.contextPath}/FileServlet?pagenum=${page.getPagenum()-1}" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0">上一页</a></li> 
    						</c:if> 
    						   <c:forEach begin = "${page.getStartPage()}" end = "${page.getEndPage()}" step = "1" var = "i">
    							<li class="paginate_button <c:if test = "${page.getPagenum()==i}">active</c:if>"><a href="${pageContext.request.contextPath}/FileServlet?pagenum=${i}" aria-controls="DataTables_Table_0" data-dt-idx="1" tabindex="0">${i }</a></li>
    						  </c:forEach> 
    						<c:if test = "${page.getPagenum()==page.getTotalpage()}">
    						<li class="paginate_button next id="DataTables_Table_0_next"><a href="" disabled aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0">下一页</a></li>
    						</c:if>
    						<c:if test = "${page.getPagenum()!=page.getTotalpage()}">
    						<li class="paginate_button next id="DataTables_Table_0_next"><a href="${rooturl}/FileServlet?pagenum=${page.getPagenum()+1}" aria-controls="DataTables_Table_0" data-dt-idx="3" tabindex="0">下一页</a></li>
    						</c:if>
    						</ul>
    					</div>
    					<div class="clear">
    					</div>
					</div>
                <div class="card-header">
                    <button  class="btn btn-primary" data-toggle="modal" data-target="#myModal" >
                    			   添加
                    </button>
                </div>
            </div>
        </div>
    </div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">文件上传</h4>
	            </div>
	              <form class="form form-horizontal" method="post" action="${pageContext.request.contextPath}/FileUpServlet" enctype="multipart/form-data">
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
<!--补充slide.jsp 的 div  -->
</div>



<!--引用js  -->
<script type="text/javascript" src="${rooturl}/resource/assets/js/vendor.js"></script>
<script type="text/javascript" src="${rooturl}/resource/assets/js/app.js"></script>
<script type="text/javascript" src="${rooturl}/resource/layui-v2.4.5/layui/layui.all.js"></script>

</body>
</html>