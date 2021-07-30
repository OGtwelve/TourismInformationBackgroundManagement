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
							<div class="card-title">景点管理</div>
							<div class="card-tools">
								<div class="btn-group dropleft">
									<button type="button" class="btn btn-success "
										data-toggle="modal" data-target="#modal-insertAttraction">添加新景点</button>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div>
								<div class="btn-group w-100 mb-2">
									<a class="btn btn-info active" href="javascript:void(0)"
										data-filter="all"> 所有景点 </a>

									<c:forEach items="${AttractionTours }" var="tour">
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
									<c:forEach items="${attractions }" var="attraction">
										<div class="filtr-item col-sm-2"
											data-category="${attraction.tourIdInteger }"
											onclick="modalAttraction('${attraction.attractionNameString }');"
											data-sort="white sample">
											<script type="text/javascript">
												i++;
											</script>
											<img
												src="${pageContext.request.contextPath }/img/attraction/${attraction.attractionNameString }.png"
												class="img-fluid mb-2 "
												alt="${attraction.attractionNameString }"
												style="height: 180px" />
											<div class="ribbon-wrapper ribbon-xl">
												<div class="ribbon bg-danger text-lg">
													${attraction.attractionNameString }</div>
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

	<!-- attraction模拟框 -->
	<c:forEach items="${attractions }" var="attraction">
		<div class="modal fade" id="${attraction.attractionNameString }">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">${attraction.attractionNameString }</h4>

						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body ">
						<div class="row">

							<div class="col-sm-4">
								<button type="button" class="btn btn-block btn-primary"
									onclick="updateAttractionButton('${attraction.attractionNameString }');">修改景点</button>
							</div>
							<div class="col-sm-4">
								<button type="button" class="btn btn-block btn-success"
									onclick="insertAttractionProjectButton(${attraction.attractionIdInteger },'${attraction.attractionNameString }');">添加新项目</button>
							</div>
							<div class="col-sm-4">
								<a
									href="${pageContext.request.contextPath }/admin/attraction/${attraction.attractionIdInteger }"
									class="btn btn-block btn-danger">删除景点</a>
							</div>

						</div>
						<hr>
						<div class="row my-2">

							<div class="col-sm-4">
								<div class="nav flex-column nav-tabs h-100" id="vert-tabs-tab" role="tablist" aria-orientation="vertical">
									<a class="nav-link active" id="vert-tabs-${attraction.attractionNameString }-tab" data-toggle="pill" href="#vert-tabs-${attraction.attractionNameString }" role="tab" aria-controls="vert-tabs-${attraction.attractionNameString }" aria-selected="true">${attraction.attractionNameString }</a>
									<c:forEach items="${attraction.attractionProjects }"
										var="attractionProject">
										<div class="row">
											<div class="col-sm-6">
												<a class="nav-link" id="vert-tabs-${attractionProject.attractionItemString }-tab" data-toggle="pill" href="#vert-tabs-${attractionProject.attractionItemString }" role="tab" aria-controls="vert-tabs-${attractionProject.attractionItemString }" aria-selected="false">${attractionProject.attractionItemString }</a>
											</div>
											<div class="col-sm-3">
												<button type="button" class="btn btn-block btn-primary"
													onclick="updateAttractionProjectButton('${attraction.attractionNameString }','${attractionProject.attractionItemString }');">修改</button>
											</div>
											<div class="col-sm-3">
												<a
													href="${pageContext.request.contextPath }/admin/attractionProject/${attractionProject.attractionProjectIdInteger }"
													class="btn btn-block btn-danger">删除</a>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
							<div class="col-sm-8">
								<div class="tab-content" id="vert-tabs-tabContent">
									<div class="tab-pane text-left fade show active" id="vert-tabs-${attraction.attractionNameString }" role="tabpanel" aria-labelledby="vert-tabs-${attraction.attractionNameString }-tab">
										<dl>

											<dt>景点位置</dt>
											<dd>
												百度地图-<a href="${attraction.attractionPositionString }"
													target="_blank">${attraction.attractionNameString }</a>
											</dd>

											<dt>景点价格</dt>
											<c:if test="${attraction.attractionProjectDouble == '0.0'}">
												<dd>免费</dd>
											</c:if>
											<c:if test="${attraction.attractionProjectDouble != '0.0'}">
												<dd>￥${attraction.attractionProjectDouble }元</dd>
											</c:if>

											<dt>开放时间</dt>
											<c:if
												test="${attraction.openingTimeUpDate == attraction.openingTimeOffDate}">
												<dd>全天</dd>
											</c:if>
											<c:if
												test="${attraction.openingTimeUpDate != attraction.openingTimeOffDate}">
												<dd>上午${attraction.openingTimeUpDate }-下午${attraction.openingTimeOffDate }</dd>
											</c:if>


											<dt>景点信息</dt>
											<dd>${attraction.attractionInformationString }</dd>


											<dt>景点照片</dt>
											<dd>
												<img
													src="${pageContext.request.contextPath }/img/attraction/${attraction.attractionNameString }.png"
													style="width: 100%"
													alt="${attraction.attractionNameString }" />
											</dd>

										</dl>

									</div>
									<c:forEach items="${attraction.attractionProjects }"
										var="attractionProject">
										<div class="tab-pane fade" id="vert-tabs-${attractionProject.attractionItemString }" role="tabpanel" aria-labelledby="vert-tabs-${attractionProject.attractionItemString }-tab">
											<dl>
												<dt>项目价格</dt>
												<c:if
													test="${attractionProject.attractionProjectPriceDouble == '0.0'}">
													<dd>免费</dd>
												</c:if>
												<c:if
													test="${attractionProject.attractionProjectPriceDouble != '0.0'}">
													<dd>￥${attractionProject.attractionProjectPriceDouble }元</dd>
												</c:if>

												<dt>项目信息</dt>
												<dd>${attractionProject.attractionPorjectInformationString }</dd>

												<dt>项目图片</dt>
												<dd>
													<img class="attractionImg"
														src="${pageContext.request.contextPath }/img/attractionProject/${attractionProject.attractionItemString }.png"
														style="width: 100%"
														alt="${attractionProject.attractionItemString }" />
												</dd>
											</dl>

										</div>
									</c:forEach>
								</div>
							</div>


						</div>
					</div>

				</div>
			</div>
		</div>
	</c:forEach>

	<!-- 添加新景点 -->
	<form
		action="${pageContext.request.contextPath }/admin/attraction/update"
		method="post" enctype="multipart/form-data">
		<div class="modal fade" id="modal-insertAttraction">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">新景点</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<!-- <label for="customFile">Custom File</label> -->

							<div class="custom-file">
								<input type="file" class="custom-file-input" id="customFile"
									name="attractionImg"> <label class="custom-file-label"
									for="customFile">选择景点照片</label>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6">
								<input type="text" class="form-control"
									name="attractionNameString" placeholder="景点名称">
							</div>
							<div class="form-group col-sm-1"></div>
							<div class="form-group col-sm-1">
								<label for="openingTimeUpDate" class="my-2">开放时间</label>
							</div>
							<div class="form-group col-sm-2">
								<input id="openingTimeUpDate" type="time" class="form-control"
									name="openingTimeUpDate">
							</div>
							<div class="form-group col-sm-2">
								<input type="time" class="form-control"
									name="openingTimeOffDate">
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6">
								<select class="form-control" name="tourIdInteger">
									<option value="0">所属旅游公司</option>
									<c:forEach items="${AttractionTours }" var="tour">
										<option value="${tour.tourIdInteger }">${tour.tourNameString }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-sm-1"></div>
							<div class="form-group col-sm-5">
								<input type="text" class="form-control"
									name="attractionProjectDouble" placeholder="景点价格">
							</div>
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
								name="attractionPositionString" placeholder="景点位置">
						</div>
						<textarea class="textarea" placeholder="景点信息"
							name="attractionInformationString"
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

	<!-- 添加新项目 -->

<form
		action="${pageContext.request.contextPath }/admin/attractionProject/update"
		method="post" enctype="multipart/form-data">
		<div class="modal fade" id="modal-insertAttractionProject">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">新项目</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<!-- <label for="customFile">Custom File</label> -->

							<div class="custom-file">
								<input type="file" class="custom-file-input" id="customFile"
									name="attractionProjectImg">
									 <label class="custom-file-label"
									for="customFile">选择项目照片</label>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6">
								<input type="hidden"  id="insertAttractionIdInteger"
									name="attractionIdInteger" >
								<input type="text" class="form-control"
									name="attractionItemString" placeholder="项目名称">
							</div>
							<div class="form-group col-sm-6">
								<input type="text" class="form-control"
									name="attractionProjectPriceDouble" placeholder="项目价格">
							</div>
						</div>
						<textarea class="textarea" placeholder="项目信息"
							name="attractionPorjectInformationString"
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
	<c:forEach items="${attractions }" var="attraction">
		
		<form
			action="${pageContext.request.contextPath }/admin/attraction/update"
			method="post" enctype="multipart/form-data">
			<div class="modal fade"
				id="updateAttractionModal${attraction.attractionNameString }">
				<div class="modal-dialog modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">修改景点</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<!-- <label for="customFile">Custom File</label> -->

								<div class="custom-file">
									<input type="file" class="custom-file-input" id="customFile"
										name="attractionImg"> <label class="custom-file-label"
										for="customFile">修改景点照片</label>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-sm-6">
									<input type="hidden" name="attractionIdInteger"
										value="${attraction.attractionIdInteger }"> <input
										type="text" class="form-control" name="attractionNameString"
										placeholder="景点名称" value="${attraction.attractionNameString }">
								</div>
								<div class="form-group col-sm-1"></div>
								<div class="form-group col-sm-1">
									<label for="openingTimeUpDate" class="my-2">开放时间</label>
								</div>
								<div class="form-group col-sm-2">
									<input id="openingTimeUpDate" type="time" class="form-control"
										name="openingTimeUpDate"
										value="${attraction.openingTimeUpDate }">
								</div>
								<div class="form-group col-sm-2">
									<input type="time" class="form-control"
										name="openingTimeOffDate"
										value="${attraction.openingTimeOffDate }">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-sm-6">
									<select class="form-control" name="tourIdInteger">
										<option value="0">所属旅游公司</option>
										<c:forEach items="${AttractionTours }" var="tour">
											<option value="${tour.tourIdInteger }" <c:if test="${tour.tourIdInteger==attraction.tourIdInteger }">selected="selected"</c:if>>${tour.tourNameString }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-sm-1"></div>
								<div class="form-group col-sm-5">
									<input type="text" class="form-control"
										name="attractionProjectDouble" placeholder="景点价格"
										value="${attraction.attractionProjectDouble }">
								</div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control"
									name="attractionPositionString" placeholder="景点位置"
									value="${attraction.attractionPositionString }">
							</div>
							<textarea class="textarea" placeholder="景点信息"
								name="attractionInformationString"
								style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">${attraction.attractionInformationString }</textarea>


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
	
	<!-- 修改项目 -->	
	<c:forEach items="${attractions }" var="attraction">
	<c:forEach items="${attraction.attractionProjects }"	var="attractionProject">
		<form	action="${pageContext.request.contextPath }/admin/attractionProject/update"
			method="post" enctype="multipart/form-data">
			<div class="modal fade "
				id="updateAttractionProjectModal${attractionProject.attractionItemString }">
				<div class="modal-dialog modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">修改项目</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<!-- <label for="customFile">Custom File</label> -->

								<div class="custom-file">
									<input type="file" class="custom-file-input" id="customFile"
										name="attractionProjectImg"> <label class="custom-file-label"
										for="customFile">修改项目照片</label>
								</div>
							</div>
							<div class="row">
							<div class="form-group col-sm-6">
								<input type="hidden"  
									name="attractionProjectIdInteger" value="${attractionProject.attractionProjectIdInteger }">
								<input type="hidden"  
									name="attractionIdInteger"  value="${attractionProject.attractionIdInteger }">	
								<input type="text" class="form-control"
									name="attractionItemString" placeholder="项目名称" value="${attractionProject.attractionItemString }">
							</div>
							<div class="form-group col-sm-6">
								<input type="text" class="form-control"
									name="attractionProjectPriceDouble" placeholder="项目价格" value="${attractionProject.attractionProjectPriceDouble }">
							</div>
						</div>
						<textarea class="textarea" placeholder="项目信息"
							name="attractionPorjectInformationString"
							style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">${attractionProject.attractionPorjectInformationString }</textarea>
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
	</c:forEach>
	
</div>
<script>
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

function modalAttraction(attractionName){
	$('#'+attractionName).modal('show')
}
function updateAttractionButton(attractionNameString){
	$('#'+attractionNameString).modal('hide');
	$('#updateAttractionModal'+attractionNameString).modal('show');
	
}
function updateAttractionProjectButton(attractionNameString,attractionItemString){
	$('#'+attractionNameString).modal('hide');
	$('#updateAttractionProjectModal'+attractionItemString).modal('show');
	
}
function insertAttractionProjectButton(attractionIdInteger,attractionNameString){
	$('#'+attractionNameString).modal('hide');
	$("#insertAttractionIdInteger").val(attractionIdInteger);
	$('#modal-insertAttractionProject').modal('show');
}
</script>
<%@include file="../adminFooter.jsp"%>