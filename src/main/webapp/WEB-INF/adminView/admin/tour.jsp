<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../adminHead.jsp"%>
<%@include file="../adminNavbar.jsp"%>
<%@include file="../adminSidebar.jsp"%>
<div class="content-wrapper">
	<section class="content my-2">

		<div class="container-fluid">
			<div class="row">
				<div class="col-12">

					<div class="card">
						<div class="card-header">
							<h1 class="card-title">旅游公司</h1>
							<div class="card-tools">
								<div class="btn-group dropleft">
									<button type="button" class="btn btn-secondary dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">添加新公司</button>
									<div class="dropdown-menu">
										<div style="height: 280px; width: 200px; padding: 25px">
											<input type="text" class="form-control" id="insertName"
												placeholder="公司名称"> <input type="text"
												class="form-control" id="insertPrice" placeholder="价格"
												style="margin-top: 25px"> <input type="text"
												class="form-control" id="insertPhone" placeholder="联系电话"
												style="margin-top: 25px; margin-bottom: 25px">
											<button class="btn btn-block btn-success" id="insertButton">确定</button>
										</div>

									</div>

								</div>
							</div>
						</div>
						<!-- /.card-header -->
						<div class="card-body table-responsive p-0">

							<table class="table table-striped table-valign-middle"
								style="text-align: center;">
								<thead>
									<tr>
										<th style="width: 10%">id</th>
										<th style="width: 20%">公司名称</th>
										<th style="width: 10%">价格</th>
										<th style="width: 15%">联系电话</th>
										<th style="width: 10%">更多</th>
										<th style="width: 10%"></th>
										<th style="width: 10%"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${tours}" var="tour">
										<tr>
											<td>${tour.tourIdInteger}</td>
											<td><p class="my-1 updateTd${tour.tourIdInteger}">${tour.tourNameString}</p>
												<input type="text"
												class="form-control updateInput${tour.tourIdInteger}"
												id="updateName${tour.tourIdInteger}"
												placeholder="${tour.tourNameString}"
												value="${tour.tourNameString}"
												style="display: none; text-align: center;"></td>
											<td><p class="my-1 updateTd${tour.tourIdInteger}">${tour.tourPriceDouble }</p>
												<input type="text"
												class="form-control updateInput${tour.tourIdInteger}"
												id="updatePrice${tour.tourIdInteger}"
												placeholder="${tour.tourPriceDouble }"
												value="${tour.tourPriceDouble }"
												style="display: none; text-align: center;"></td>
											<td><p class="my-1 updateTd${tour.tourIdInteger}">${tour.tourPhoneString }
												</p> <input type="text"
												class="form-control updateInput${tour.tourIdInteger}"
												id="updatePhone${tour.tourIdInteger}"
												placeholder="${tour.tourPhoneString } "
												value="${tour.tourPhoneString } "
												style="display: none; text-align: center;"></td>
											<td><a href="#" class="text-muted"> <i
													class="fas fa-search"></i>
											</a></td>
											<td>
												<button type="button"
													onclick="update(${tour.tourIdInteger});"
													class="btn btn-block btn-primary updateButton">修改</button>
												<button id="updateSubmitButton${tour.tourIdInteger}"
													onclick="updateSubmit(${tour.tourIdInteger});"
													class="btn btn-block btn-outline-success"
													style="display: none; margin-top: -1px">提交</button>
											</td>
											<td><a
												href="${pageContext.request.contextPath }/admin/tour/${tour.tourIdInteger}"
												class="btn btn-block btn-danger deleteButton">删除</a>
												<button type="button" class="btn btn-block btn-outline-info"
													id="returnButton${tour.tourIdInteger}"
													style="display: none; margin-top: -1px"
													onclick="returnUpdate(${tour.tourIdInteger});">返回</button></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- /.card -->

				</div>
			</div>
		</div>
	</section>

	<!-- /.content -->
</div>
<form action="${pageContext.request.contextPath }/admin/tour/update"
	method="post" id="updateForm">
	<input type="hidden" id="formId" name="tourIdInteger"> <input
		type="hidden" id="formName" name="tourNameString"> <input
		type="hidden" id="formPrice" name="tourPriceDouble"> <input
		type="hidden" id="formPhone" name="tourPhoneString">
</form>
<!-- 修改 -->
<script type="text/javascript">
 	function update(id){
 		$(".updateTd"+id).hide();
 		$(".updateButton").hide();
 		$(".deleteButton").hide();
 		$(".updateInput"+id).fadeIn("slow","swing");
 		$("#updateSubmitButton"+id).fadeIn("slow","swing");
 		$("#returnButton"+id).fadeIn("slow","swing");
 	}
	function returnUpdate(id){
		$(".updateInput"+id).hide();
 		$("#updateSubmitButton"+id).hide();
 		$("#returnButton"+id).hide();
		$(".updateTd"+id).fadeIn("slow","swing");
 		$(".updateButton").fadeIn("slow","swing");
 		$(".deleteButton").fadeIn("slow","swing");
 		
	}
	function updateSubmit(id){
		$("#formId").val(id);
		$("#formName").val($("#updateName"+id).val());
		$("#formPrice").val($("#updatePrice"+id).val());
		$("#formPhone").val($("#updatePhone"+id).val());
		$("#updateForm").submit();
	}
	$(function(){
		$("#insertButton").on("click",function(){
			$("#formName").val($("#insertName").val());
			$("#formPrice").val($("#insertPrice").val());
			$("#formPhone").val($("#insertPhone").val());
			$("#updateForm").submit();
		})
	})
	
</script>

<%@include file="../adminFooter.jsp"%>