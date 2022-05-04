<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="${pageContext.request.contextPath}/CY" class="nav-link">首页</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="javaScript:void(0)" id="myInformationButton" class="nav-link" data-toggle="modal" data-target="#myInformation">个人信息</a> 
        
      </li>
    </ul>

    <!-- SEARCH FORM -->
<%--    <form class="form-inline ml-3">--%>
<%--      <div class="input-group input-group-sm">--%>
<%--        <input class="form-control form-control-navbar" type="search" placeholder="搜索" aria-label="Search">--%>
<%--        <div class="input-group-append">--%>
<%--          <button class="btn btn-navbar" type="submit">--%>
<%--            <i class="fas fa-search"></i>--%>
<%--          </button>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </form>--%>

    <ul class="navbar-nav ml-auto">
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
        <i class="far fa-bars"></i>
          进入畅游网        
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link"  href="${pageContext.request.contextPath }/admin/exitLogin">
          <i class="far fa-user"></i>
          退出登录
        </a>
      </li>
      
    </ul>
  </nav>
  <script type="text/javascript">
	$(function(){
		$("#myInformationButton").on("click",function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/admin/myInformation",//请求路径
				type:"POST",//默认是get
				success:function(data){
					
					$("#myInformationName").text(data.userNameString);
					if(data.userAdminString=="T"){
						$("#myInformationAdminString").text("是");
					}else{
						$("#myInformationAdminString").text("否");
					}
					for(var i=0;i<data.accounts.length;i++){
						var p=data.accounts[i];
						for(key in p){
							
							if(key=="accountGenderString") {$("#myInformationGender").text(p[key]);}
							if(key=="accountAgeString") {$("#myInformationAge").text(p[key]);}
							if(key=="accountPhoneString"){ $("#myInformationPhone").text(p[key]);}
							if(key=="accountEmailString") {$("#myInformationEmail").text(p[key]);}
							if(key=="accountIdCardString") {$("#myInformationIdCard").text(p[key]);}
							if(key=="accountBalanceDouble") {$("#myInformationBalance").text(p[key]);}
						}
						
					}
				},

				//设置接受到的响应数据的格式
				dataType:"json"
			})
		})
	})
</script>
  <!-- /.navbar -->
    <div class="modal fade" id="myInformation">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title">个人信息</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
               <div class="card">

              <!-- /.card-header -->
              <div class="card-body">
                <dl class="row">
                  <dt class="col-sm-4" >用户名</dt>
                  <dd class="col-sm-8" id="myInformationName" style="text-align: right;"></dd>
                  <dt class="col-sm-4">性别</dt>
                  <dd class="col-sm-8" id="myInformationGender" style="text-align: right;"></dd>
               	  <dt class="col-sm-4">年龄</dt>
                  <dd class="col-sm-8" id="myInformationAge" style="text-align: right;"></dd>
                  <dt class="col-sm-4">手机号</dt>
                  <dd class="col-sm-8" id="myInformationPhone" style="text-align: right;"></dd>
            	  <dt class="col-sm-4">邮箱</dt>
                  <dd class="col-sm-8" id="myInformationEmail" style="text-align: right;"></dd>
                  <dt class="col-sm-4">身份证</dt>
                  <dd class="col-sm-8" id="myInformationIdCard" style="text-align: right;"></dd>
               	  <dt class="col-sm-4">余额</dt>
                  <dd class="col-sm-8" id="myInformationBalance" style="text-align: right;"></dd>
                  <dt class="col-sm-4">管理员</dt>
                  <dd class="col-sm-8" id="myInformationAdminString" style="text-align: right;"></dd>
               </dl>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->
  
