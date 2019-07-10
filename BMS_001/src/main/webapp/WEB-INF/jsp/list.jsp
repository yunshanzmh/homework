<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery.min.js"></script>
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body
	style=" background: url('${APP_PATH}/static/images/bg.jpg');background-repeat:no-repeat;background-size:100%,100%;">
	<!-- 新增图书 -->
	<div class="modal fade" id="bookAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加图书</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="${APP_PATH}/add">
						<div class="form-group">
							<label for="bookName" class="col-sm-2 control-label">图书姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name"
									id="bookName" placeholder="bookName">
							</div>
						</div>
						<div class="form-group">
							<label for="bookName" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="description"
									id="description" placeholder="description">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary" id="book_save_btn">保存</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- 跟新图书 -->
	<div class="modal fade" id="bookUpdateModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">更改图书</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="${APP_PATH}/update">
						<div class="form-group">
							<label for="bookName" class="col-sm-2 control-label">图书ID</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="id" id="id"
									placeholder="bookName">
							</div>
						</div>
						<div class="form-group">
							<label for="bookName" class="col-sm-2 control-label">图书姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name"
									id="bookName" placeholder="bookName">
							</div>
						</div>
						<div class="form-group">
							<label for="bookName" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="description"
									id="description" placeholder="description">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary" id="book_save_btn">更新</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- 查找图书 -->
	<div class="modal fade" id="bookfindModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">查找图书</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="${APP_PATH}/find">
						<div class="form-group">
							<label for="bookName" class="col-sm-2 control-label">请输入ID</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="id" id="id"
									placeholder="bookName">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary" id="book_save_btn">查找</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12 col-md-offset-4">
				<br>
				<br>
				<br>
				<h1>&nbsp;&nbsp;&nbsp;<p style="color:white">yunshan图书管理</p></h1>
				<br>
				<br>
				<br>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="book_add_modal_btn">新增</button>
				<button class="btn btn-primary" id="findById_btn">查找</button>
				<button type="button" class="btn btn-warning" id="update_btn">编辑</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th><p style="color:white">图书ID</p></th>
						<th><p style="color:white">图书名</p></th>
						<th><p style="color:white">详情</p></th>
						<th><p style="color:white">操作</p></th>
					</tr>

					<c:forEach items="${pageInfo.list }" var="book">
						<tr>
							<form action="${APP_PATH}/delete">
								<th><p style="color:white">${book.id }</p></th>
								<th><p style="color:white">${book.name }</p></th>
								<th><p style="color:white">${book.description}</p></th>
								<th>
									<button type="submit" class="btn btn-danger btn-sm">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
									</button> <input type="hidden" name="id" value="${book.id }">
							</form>
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">当前 ${pageInfo.pageNum } 页,总
				${pageInfo.pages } 页,总 ${pageInfo.total } 条记录</div>
			<div class="col-md-6">
				<nav aria-label="Page navigation">
					<ul class="pagination">

						<li><a href="${APP_PATH}/findAll"> 首页 </a></li>
						<c:if test="${pageInfo.hasPreviousPage }">
							<li><a href="${APP_PATH}/findAll?pn=${pageInfo.pageNum-1 }"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>

						<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
							<c:if test="${page_Num == pageInfo.pageNum }">
								<li class="active"><a href="#">${page_Num }</a></li>
							</c:if>
							<c:if test="${page_Num != pageInfo.pageNum }">
								<li><a href="${APP_PATH}/findAll?pn=${page_Num }">${page_Num }</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${pageInfo.hasNextPage }">
							<li><a href="${APP_PATH}/findAll?pn=${pageInfo.pageNum+1  }"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
						<li><a href="${APP_PATH}/findAll?pn=${pageInfo.pages  }">
								末页 </a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$("#book_add_modal_btn").click(function() {
			$("#bookAddModal").modal({
				backdrop : "static"
			});
		});

		$("#update_btn").click(function() {
			$("#bookUpdateModal").modal({
				backdrop : "static"
			});
		});

		$("#findById_btn").click(function() {
			$("#bookfindModal").modal({
				backdrop : "static"
			});
		});
	</script>

</body>

</html>