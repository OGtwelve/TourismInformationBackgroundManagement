<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../adminHead.jsp"%>
<%@include file="../adminNavbar.jsp"%>
<%@include file="../adminSidebar.jsp"%>
<!-- Content Wrapper. Contains page content -->


<div class="content-wrapper">


	<section class="content ">

		<div class="container-fluid">
			<div class="row">
				<div class="col-3"></div>
				<div class="col-6 " >
					<div class="card " style="margin-top: 11%">
						<div class="card-body register-card-body">
							<p class="login-box-msg">新建用户</p>

							<form action="${pageContext.request.contextPath }/admin/adminInsert" method="post">
								<div class="input-group mb-3">
									<input type="text" class="form-control" placeholder="用户名" name="userNameString">
									<div class="input-group-append">
										<div class="input-group-text">
											<span class="fas fa-user"></span>
										</div>
									</div>
								</div>
								<div class="input-group mb-3">
									<input type="text" class="form-control" placeholder="密码" name="userPasswordEncryptionString">
									<div class="input-group-append">
										<div class="input-group-text">
											<span class="fas fa-lock"></span>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<select class="form-control" name="accountGenderString">
												<option value="男">男</option>
												<option value="女">女</option>
											</select>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="input-group mb-3">
											<input type="text" class="form-control" placeholder="年龄" name="accountAgeString">
											<div class="input-group-append">
												<div class="input-group-text">
													<span class="fas fa-angle-left right"></span>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="input-group mb-3">
									<input type="text" class="form-control" placeholder="手机号" name="accountPhoneString">
									<div class="input-group-append">
										<div class="input-group-text">
											<span class="fas fa-phone"></span>
										</div>
									</div>
								</div>
								<div class="input-group mb-3">
									<input type="text" class="form-control" placeholder="邮箱" name="accountEmailString">
									<div class="input-group-append">
										<div class="input-group-text">
											<span class="fas fa-envelope"></span>
										</div>
									</div>
								</div>
								<div class="input-group mb-3">
									<input type="text" class="form-control" placeholder="身份证" name="accountIdCardString">
									<div class="input-group-append">
										<div class="input-group-text">
											<span class="fas fa-angle-left right"></span>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<div class="input-group mb-3">
											<input type="text" class="form-control" placeholder="余额" name="accountBalanceDouble">
											<div class="input-group-append">
												<div class="input-group-text">
													<span class="fas fa-angle-left right"></span>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-1"></div>
									<div class="col-sm-1">
									 	<label class="my-2">管理员</label>
									</div>
									<div class="col-sm-4">
										<div class="form-group">
											<select class="form-control" name="userAdminString">
												<option value="F">否</option>
												<option value="T">是</option>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-2"></div>
									<div class="col-sm-8"><input type="submit" class="btn btn-block bg-gradient-primary" value="提交"></div>
									<div class="col-sm-2"></div>
								</div>
								
							</form>

							
						</div>
						<!-- /.form-box -->
					</div>
					<!-- /.card -->
					<div class="col-3"></div>
				</div>
			</div>
		</div>
	</section>

	<!-- /.content -->
</div>

<%@include file="../adminFooter.jsp"%>