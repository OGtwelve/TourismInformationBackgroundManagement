<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户登录</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-ico" href="https://cdn.jsdelivr.net/gh/OGtwelve/Static@main/pic04.jpg"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/resource/dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="${pageContext.request.contextPath }/login"><b>旅游网</b></a>
  </div>
  <!-- 用户登录 -->
  <div class="card" id="login" >
    <div class="card-body login-card-body">
      <p class="login-box-msg">登录<span style="color: red;">${loginMsg }</span><span style="color: red;" id="adminInterceptor">${param.text}</span></p>

      <form action="${pageContext.request.contextPath }/login" method="post">
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="账号名/手机号/邮箱" name="loginName" value="${loginMap.loginName }${updateToLoginName}${insertToLoginName}">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
              <span class="fas fa-phone mx-2"></span>
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="密码" name="loginPassword" value="${loginMap.loginPassword }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-4">
            <img alt="验证码" src="${pageContext.request.contextPath }/captcher">
          </div>
          <div class="col-4">
            <input type="text" class="form-control" name="captcher" placeholder="验证码">
          </div>
          <div class="col-4">
            <button type="submit" class="btn btn-success btn-block">登录</button>
          </div>
        </div>
      </form>

      <div class="social-auth-links text-center mb-3">
        <p>- OR -</p>
        <button  class="btn btn-block btn-primary" id="login_forgot">
           我忘记了我的密码
        </button>
        <button  class="btn btn-block btn-danger" id="login_insert">
           创建新畅游账号
        </button>
      </div>     
    </div>
  </div>
  <!-- 用户注册 -->
  <div class="card" id="insert" style="display:none">
    <div class="card-body register-card-body">
      <p class="login-box-msg">注册新账号<span style="color: red" id="insertSpen">${insertMsg }</span></p>

      <form action="${pageContext.request.contextPath }/login/insert" id="insertForm" method="post">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="insertName" placeholder="账号名" value="${insertMap.insertName }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="number" class="form-control" name="insertPhone" placeholder="手机号" value="${insertMap.insertPhone }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-phone"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="insertEmail" placeholder="邮箱" value="${insertMap.insertEmail }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" name="insertPassword"  placeholder="密码" value="${insertMap.insertPassword }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" name="insertPasswordAgin" placeholder="确认密码" value="${insertMap.insertPasswordAgin }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="agreeTerms" name="terms" value="agree">
              <label for="agreeTerms">
               我同意这些 <a href="javascript:void(0)">条款</a>
              </label>
            </div>
          </div>
          <div class="col-4">
            <button type="button" id="insertButton" class="btn btn-primary btn-block">注册</button>
          </div>
        </div>
      </form>
      <a href="javascript:void(0)" class="text-center" id="insert_login">我已有畅游账号</a>
    </div>
    <!-- /.form-box -->
  </div><!-- /.card -->


  <!-- 忘记密码 -->
  <div class="card" id="forgot" style="display:none">
    <div class="card-body login-card-body">
    <c:if test="${not empty forgotMsg }"><p class="login-box-msg" style="color: red;">${forgotMsg }</p></c:if>
    <c:if test="${ empty forgotMsg }"><p class="login-box-msg">你忘了密码？在这里您可以轻松地修改新密码。</p></c:if>
      
      <form action="${pageContext.request.contextPath }/login/forgot" method="post">
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="账号名/手机号/邮箱" name="forgotName">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user "></span>
              <span class="fas fa-phone mx-2"></span>
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block">获取新密码</button>
          </div>
        </div>
      </form>

      <p class="mt-3 mb-1">
        <a href="javascript:void(0)" id="forgot_login">登录</a>
      </p>
      <p class="mb-0">
        <a href="javascript:void(0)" id="forgot_insert" class="text-center">创建新畅游账号</a>
      </p>
    </div>
  </div>

  <!-- 修改密码 -->
   <div class="card" id="update" style="display:none">
    <div class="card-body login-card-body">
    	<c:if test="${not empty updateMsg }"><p class="login-box-msg" id="updateP" style="color: red;">${updateMsg }</p></c:if>
    	<c:if test="${empty updateMsg }"><p class="login-box-msg" id="updateP">您距新密码仅一步之遥，立即恢复密码.</p></c:if>
      <form action="${pageContext.request.contextPath }/login/update/${forgotId}" method="post">
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="新密码" name="updatePassword" value="${updateMap.updatePassword }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="确认密码" name="updatePasswordAgain" value="${updateMap.updatePasswordAgain }">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block">确认修改</button>
          </div>
        </div>
      </form>

      <p class="mt-3 mb-1">
        <a href="javascript:void(0)" id="update_login">登录</a>
      </p>
    </div>
  </div>
</div>


<script src="${pageContext.request.contextPath }/resource/plugins/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resource/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath }/resource/dist/js/adminlte.min.js"></script>
<!-- 初始化 -->
<script type="text/javascript">
	
	$(function(){
	    $("img[alt='验证码']").on("click",function(){
	    	var date=new Date().getTime();
	    	$("img[alt='验证码']").prop("src","${pageContext.request.contextPath }/captcher?"+date)
	    })
	    
		$("body:first").css("background-image","url(${pageContext.request.contextPath }/img/login.png)");
        $("body:first").css("background-position","center");
		if(${not empty insertMsg}){
			$("#login").hide();
			$("#insert").fadeIn("slow","swing");
		}
		if(${not empty forgotMsg}){
			$("#login").hide();
			$("#forgot").fadeIn("slow","swing");
		}
		if(${not empty forgotId}){
			$("#login").hide();
			$("#update").fadeIn("slow","swing");
		}
		
		$("#adminInterceptor").fadeOut(1500,"swing")
		
		
	})
</script>
<!-- 卡片动画 -->
<script type="text/javascript">
	$(function(){
		
		$("#login_insert").on("click",function(){
			$("#login").fadeOut("normal","linear",function(){
				$("#insert").fadeIn("slow","swing");
			});
		});
		$("#login_forgot").on("click",function(){
			$("#login").fadeOut("normal","linear",function(){
				$("#forgot").fadeIn("slow","swing");
			});
		});
		$("#forgot_login").on("click",function(){
			$("#forgot").fadeOut("normal","linear",function(){
				$("#login").fadeIn("slow","swing");
			});
		})
		$("#forgot_insert").on("click",function(){
			$("#forgot").fadeOut("normal","linear",function(){
				$("#insert").fadeIn("slow","swing");
			});
		})
		$("#insert_login").on("click",function(){
			$("#insert").fadeOut("normal","linear",function(){
				$("#login").fadeIn("slow","swing");
			});
		})
		$("#update_login").on("click",function(){
			$("#update").fadeOut("normal","linear",function(){
				$("#login").fadeIn("slow","swing");
			});
		})
		
	})
</script>

<!-- 注册  -->
<script type="text/javascript">
		function ajaxValue(name,value){
			$.post("${pageContext.request.contextPath }/login/insertAjax",{"name":name,"ajax":value},function(data){
				$("#insertSpen").text(data);
			},"text")
		}
		function ajax(name,value){
		if(value==""){
			if("insertName"==name){
				$("#insertSpen").text("-请输入用户名");
			}else if("insertPhone"==name){
				$("#insertSpen").text("-请输入手机号");
			}else if("insertEmail"==name){
				$("#insertSpen").text("-请输入邮箱");
			}else if("insertPassword"==name){
				$("#insertSpen").text("-请输入新密码");
			}
		}else{
			if("insertName"==name){
				if(value.length>20){
					$("#insertSpen").text("-用户名太长了.....");
				}else{
					ajaxValue("insertName",value)
				}
			}else if("insertPhone"==name){
				if(value.length!=11){
					$("#insertSpen").text("-输入的手机号有误");
				}else{
					ajaxValue("insertPhone",value)
				}
			}else if("insertEmail"==name){
				if(!(/^([A-Za-z0-9_\-\.\u4e00-\u9fa5])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,8})$/.test(value))){
					$("#insertSpen").text("-输入的邮箱有有误");
				}else{
					ajaxValue("insertEmail",value)
				}
			}else if("insertPassword"==name){
				if(value.length<3 || value.length>20){
					$("#insertSpen").text("-密码保持在3~20");
				}
			}
	
		}
		
	}
	$(function(){
		$("input[name='insertName']").blur(function(){
			ajax("insertName",$("input[name='insertName']").val())
		})
		$("input[name='insertPhone']").blur(function(){
			ajax("insertPhone",$("input[name='insertPhone']").val())
		})
		$("input[name='insertEmail']").blur(function(){
			ajax("insertEmail",$("input[name='insertEmail']").val())
		})
		$("input[name='insertPassword']").blur(function(){
			ajax("insertPassword",$("input[name='insertPassword']").val())
		})
		$("input[name='insertPasswordAgin']").blur(function(){
			if($("input[name='insertPassword']").val()!==$("input[name='insertPasswordAgin']").val()){
				$("#insertSpen").text("-请保持密码一致");
			}
		})
		$("#insertButton").on("click",function(){
			if($("#agreeTerms").prop('checked')){
				$("#insertForm").submit();
			}else{
				$("#insertSpen").text("-请同意这些条款");
			}
		})
		
	})
</script>

<!-- 修改 -->
<script type="text/javascript">
	$(function(){
		$("input[name='updatePassword']").blur(function(){
			if($("input[name='updatePassword']").val().length<3 || $("input[name='updatePassword']").val().length>20){
				$("#updateP").attr("style","color: red;");
				$("#updateP").text("新密码保持在3~20");
			}else{
				$("#updateP").attr("style","color: black;");
				$("#updateP").text("您距新密码仅一步之遥，立即恢复密码.");
			}     
		})
		$("input[name='updatePasswordAgain']").blur(function(){
			if($("input[name='updatePassword']").val()!==$("input[name='updatePasswordAgain']").val()){
				$("#updateP").attr("style","color: red;");
				$("#updateP").text("请保持密码一致");
			}else{
				$("#updateP").attr("style","color: black;");v
				$("#updateP").text("您距新密码仅一步之遥，立即恢复密码.");
			}
		})
	
		
	})
</script>

</body>
</html>
