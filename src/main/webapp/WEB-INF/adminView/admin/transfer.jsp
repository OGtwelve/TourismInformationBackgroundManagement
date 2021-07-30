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
				
					<div class="card card-primary">
						<div class="card-header">
							<div class="card-title">交通管理</div>
							<div class="card-tools">
								<div class="btn-group dropleft">
									<button type="button" class="btn btn-success "
										data-toggle="modal" data-target="#modal-insertTransfer">添加新交通</button>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div>
								<div class="btn-group w-100 mb-2">
									<a class="btn btn-info active" href="javascript:void(0)"
										data-filter="all"> 所有交通 </a>

									<c:forEach items="${TransferTours }" var="tour">
										<a class="btn btn-info" href="javascript:void(0)"
											data-filter="${tour.tourIdInteger }">${tour.tourNameString }</a>

									</c:forEach>

								</div>
								<div class="mb-2">
									<a class="btn btn-secondary" href="javascript:void(0)"
										data-shuffle> 随机排列 </a>
								</div>
							</div>
							<div>
								<div class="filter-container p-0 row">
									<script type="text/javascript">var i=0;</script>
									<c:forEach items="${transfers }" var="transfer">
										<div class="filtr-item col-sm-2"
											data-category="${transfer.tourIdInteger }"
											onclick="modalTransfer('${transfer.transferNameString }');"
											data-sort="white sample">
											<script type="text/javascript">
												i++;
											</script>
											<img
												src="${pageContext.request.contextPath }/img/transfer/${transfer.transferNameString }.png"
												class="img-fluid mb-2 "
												alt="${transfer.transferNameString }"
												style="height: 180px" />
											<div class="ribbon-wrapper ribbon-xl">
												<div class="ribbon bg-danger text-lg">
													${transfer.transferNameString }</div>
											</div>

										</div>
									</c:forEach>

								</div>
							</div>

						</div>
					</div>
						
				</div>
			</div>
		</div>
	</section>
	<!-- transfer模拟框 -->
	<c:forEach items="${transfers }" var="transfer">
		<div class="modal fade" id="${transfer.transferNameString }">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">${transfer.transferNameString }</h4>

						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body ">
						<div class="row">

							<div class="col-sm-6">
								<button type="button" class="btn btn-block btn-primary"
									onclick="updateTransferButton('${transfer.transferNameString }');">修改</button>
							</div>
							<div class="col-sm-6">
								<a
									href="${pageContext.request.contextPath }/admin/transfer/${transfer.transferIdInteger }"
									class="btn btn-block btn-danger">删除</a>
							</div>

						</div>
						<hr>
						<div class="row my-2">
							<dl>
								

								<dt>交通价格</dt>
								<c:if test="${transfer.transferPriceDouble == '0.0'}">
									<dd>免费</dd>
								</c:if>
								<c:if test="${transfer.transferPriceDouble != '0.0'}">
									<dd>￥${transfer.transferPriceDouble }元</dd>
								</c:if>
								<dt>交通信息</dt>
								<dd>${transfer.transferInformationString }</dd>


								<dt>交通照片</dt>
								<dd>
									<img
										src="${pageContext.request.contextPath }/img/transfer/${transfer.transferNameString }.png"
										style="width: 100%" alt="${transfer.transferNameString }" />
								</dd>
							</dl>
						</div>						
					</div>

				</div>
			</div>
		</div>
	</c:forEach>
	<!-- 添加新景点 -->
	<form
		action="${pageContext.request.contextPath }/admin/transfer/update"
		method="post" enctype="multipart/form-data">
		<div class="modal fade" id="modal-insertTransfer">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">新交通</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<!-- <label for="customFile">Custom File</label> -->

							<div class="custom-file">
								<input type="file" class="custom-file-input" id="transferCustomFile"
									name="transferImg"> <label class="custom-file-label"
									for="transferCustomFile">选择交通照片</label>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6">
								<input type="text" class="form-control"
									name="transferNameString" placeholder="交通名称">
							</div>
							<div class="form-group col-sm-6">
								<input type="text" class="form-control"
									name="transferPriceDouble" placeholder="交通价格">
							</div>
						</div>
						<select class="form-control" name="tourIdInteger">
									<option value="0">所属旅游公司</option>
									<c:forEach items="${TransferTours }" var="tour">
										<option value="${tour.tourIdInteger }">${tour.tourNameString }</option>
									</c:forEach>
						</select>
						<textarea class="textarea my-2" placeholder="交通信息"
							name="transferInformationString"
							style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>


					</div>
					<div class="modal-footer justify-content-between">
						<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
						<input type="submit" class="btn btn-primary" value="保存">
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		

	</form>
	<!-- 修改景点 -->	
	<c:forEach items="${transfers }" var="transfer">
		
		<form
			action="${pageContext.request.contextPath }/admin/transfer/update"
			method="post" enctype="multipart/form-data">
			<div class="modal fade"
				id="updateTransferModal${transfer.transferNameString }">
				<div class="modal-dialog modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">修改交通</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
							<!-- <label for="customFile">Custom File</label> -->

							<div class="custom-file">
								<input type="file" class="custom-file-input" id="transferCustomFile"
									name="transferImg"> <label class="custom-file-label"
									for="transferCustomFile">修改交通照片</label>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6">
								<input type="hidden" 	name="transferIdInteger"  value="${transfer.transferIdInteger }">
								<input type="text" class="form-control"
									name="transferNameString" placeholder="交通名称" value="${transfer.transferNameString }">
							</div>
							<div class="form-group col-sm-6">
								<input type="text" class="form-control"
									name="transferPriceDouble" placeholder="交通价格" value="${transfer.transferPriceDouble }">
							</div>
						</div>
						<select class="form-control" name="tourIdInteger">
									<option value="0">所属旅游公司</option>
									<c:forEach items="${TransferTours }" var="tour">
										<option value="${tour.tourIdInteger }" <c:if test="${tour.tourIdInteger==transfer.tourIdInteger }">selected="selected"</c:if>>${tour.tourNameString }</option>
									</c:forEach>
						</select>
						<textarea class="textarea my-2" placeholder="交通信息"
							name="transferInformationString"
							style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">${transfer.transferInformationString }</textarea>



						</div>
						<div class="modal-footer justify-content-between">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">返回</button>
							<input type="submit" class="btn btn-primary" value="修改">
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->

		</form>
	</c:forEach>
</div>
<script type="text/javascript">

$(function() {
		$(document).on('click', '[data-toggle="lightbox"]', function(event) {
			event.preventDefault();
			$(this).ekkoLightbox({
				alwaysShowClose : true
			});
		});

		$('.filter-container').filterizr({
			gutterPixels : 3
		});
		$('.btn[data-filter]').on('click', function() {
			$('.btn[data-filter]').removeClass('active');
			$(this).addClass('active');
		});
		
		for(j=0;j<i;j++){
			var date=new Date().getTime();
			var img=$("img:eq("+j+")").attr("src")+"?"+date
			$("img:eq("+j+")").prop("src",img)
			
		}
		
	})
	
</script>
<script type="text/javascript">

$(document).ready(function () {
  bsCustomFileInput.init();
});

function modalTransfer(transferNameString){
	$('#'+transferNameString).modal('show')
}
function updateTransferButton(transferNameString){
	$('#'+transferNameString).modal('hide');
	$('#updateTransferModal'+transferNameString).modal('show');
	
}
</script>
<%@include file="../adminFooter.jsp"%>