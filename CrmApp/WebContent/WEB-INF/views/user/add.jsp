<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Thêm mới thành viên</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form action='<c:url value="/user/add"/>' 
					method="post" enctype="multipart/form-data" class="form-horizontal form-material">
					<div class="form-group">
						<label class="col-md-12">Email</label>
						<div class="col-md-12">
							<input type="email" name="email" class="form-control form-control-line" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-12">Mật khẩu</label>
						<div class="col-md-12">
							<input type="password" name="password" class="form-control form-control-line" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-12">Họ tên</label>
						<div class="col-md-12">
							<input type="text" name="fullname" class="form-control form-control-line" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-12">Avatar</label>
						<div class="col-md-12">
							<input type="file" name="avatar" class="form-control form-control-line" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-12">Loại người dùng</label>
						<div class="col-sm-12">
							<select name="roleId" class="form-control form-control-line">
								<c:forEach items="${ roles }" var="item">
									<option value="${ item.id }">${ item.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Lưu lại</button>
							<a href="<c:url value="/user" />" class="btn btn-primary">Quay lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
	<!-- /.row -->
</div>