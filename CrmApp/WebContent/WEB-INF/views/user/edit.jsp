<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Cập nhật thành viên</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form action='<c:url value="/user/edit"/>' enctype="multipart/form-data" 
					method="post" class="form-horizontal form-material">

					<div class="form-group">
						<label class="col-md-12">Id</label>
						<div class="col-md-12">
							<input type="text" name="id" value="${ user.id }"
								class="form-control form-control-line" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-12">Email</label>
						<div class="col-md-12">
							<input type="email" name="email" value="${ user.email }"
								class="form-control form-control-line" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-12">Họ tên</label>
						<div class="col-md-12">
							<input type="text" name="fullname" value="${ user.fullname }"
								class="form-control form-control-line" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-12">Avatar</label>
						<div class="col-md-12">
							<input type="file" name="avatar" value="${ user.avatar }"
								class="form-control form-control-line" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-12">Loại người dùng</label>
						<div class="col-sm-12">
							<select name="roleId" class="form-control form-control-line">
								<c:forEach items="${ roles }" var="role">
									<c:choose>
										<c:when test="${ role.id == user.roleId }">
											<option value="${ role.id }" selected>${ role.name }</option>
										</c:when>
										<c:otherwise>
											<option value="${ role.id }">${ role.name }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Lưu lại</button>
							<a href="<c:url value="/user" />" class="btn btn-primary">Quay
								lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
	<!-- /.row -->
</div>