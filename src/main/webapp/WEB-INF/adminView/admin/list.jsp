<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../adminHead.jsp"%>
<%@include file="../adminNavbar.jsp"%>
<%@include file="../adminSidebar.jsp"%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <section class="content my-2" >
		
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">

            <div class="card">
              <div class="card-header">
                <h3 class="card-title">用户信息</h3>

<%--                <div class="card-tools">--%>
<%--                  <div class="input-group input-group-sm" style="width: 150px;">--%>
<%--                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">--%>

<%--                    <div class="input-group-append">--%>
<%--                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>--%>
<%--                    </div>--%>
<%--                  </div>--%>
<%--                </div>--%>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0" >
              
                <table class="table table-hover text-nowrap" style="text-align: center;" >
                  <thead>
                    <tr >
                      <th style="width: 4%">ID</th>
                      <th style="width: 9%">用户名</th>
                      <th style="width: 5%">年龄</th>
                      <th style="width: 7%">性别</th>
                      <th style="width: 12%">手机号</th>
                      <th style="width: 18%">邮箱</th>
                      <th style="width: 18%">身份证</th>
                      <th style="width: 10%">余额</th>
                      <th style="width: 5%">管理员</th>
                      <th style="width: 6%"></th>
                      <th style="width: 6%"></th>
                    </tr>
                  </thead>
                  <tbody>           
                    <c:forEach items="${users }" var="user">        
                    <tr >
                      <td ><p class="my-1">${user.userIdInteger }</p></td>
                      <td><p class="my-1 updateTd${user.userIdInteger }">${user.userNameString }</p><input type="text" class="form-control updateInput${user.userIdInteger }"  id="updateName${user.userIdInteger }" placeholder="${user.userNameString }" value="${user.userNameString }" style="display:none;text-align: center;"></td>
	                      <c:forEach  items="${user.accounts }" var="account">
		                      <td><input type="hidden" name="updateAccountId" value="${account.accountIdInteger }" id="updateAccountId${user.userIdInteger }"><p class="my-1 updateTd${user.userIdInteger }">${account.accountAgeString }</p><input  type="text" class="form-control updateInput${user.userIdInteger }"  id="updateAge${user.userIdInteger }" placeholder="${account.accountAgeString }" value="${account.accountAgeString }" style="display:none;text-align: center;"></td>
		                      <td><p class="my-1 updateTd${user.userIdInteger }">${account.accountGenderString }</p><input type="text" class="form-control updateInput${user.userIdInteger }" id="updateGender${user.userIdInteger }"  placeholder="${account.accountGenderString }" value="${account.accountGenderString }" style="display:none;text-align: center;"></td>
		                      <td><p class="my-1 updateTd${user.userIdInteger }">${account.accountPhoneString }</p><input type="text" class="form-control updateInput${user.userIdInteger }"  id="updatePhone${user.userIdInteger }" placeholder="${account.accountPhoneString }" value="${account.accountPhoneString }" style="display:none;text-align: center;"></td>
		                      <td><p class="my-1 updateTd${user.userIdInteger }">${account.accountEmailString }</p><input type="text" class="form-control updateInput${user.userIdInteger }"  id="updateEmail${user.userIdInteger }" placeholder="${account.accountEmailString }" value="${account.accountEmailString }" style="display:none;text-align: center;"></td>
		                      <td><p class="my-1 updateTd${user.userIdInteger }">${account.accountIdCardString }</p><input type="text" class="form-control updateInput${user.userIdInteger }"  id="updateIdCard${user.userIdInteger }" placeholder="${account.accountIdCardString }" value="${account.accountIdCardString }" style="display:none;text-align: center;"></td>
		                      <td><p class="my-1 updateTd${user.userIdInteger }">${account.accountBalanceDouble }</p><input type="text" class="form-control updateInput${user.userIdInteger }"  id="updateBalance${user.userIdInteger }" placeholder="${account.accountBalanceDouble }" value="${account.accountBalanceDouble }" style="display:none;text-align: center;"></td>
	                     	  <td><div class="form-group my-1"><div class="custom-control custom-switch"><input type="checkbox" onclick="clickCheckbox(${user.userIdInteger });" class="custom-control-input" <c:if test="${ user.userAdminString=='T' }">checked="checked"</c:if>   id="updateCheckbox${user.userIdInteger }"><label class="custom-control-label" for="updateCheckbox${user.userIdInteger }"></label></div></div></td>
	                     	  <td> <button type="button"  onclick="update(${user.userIdInteger });" class="btn btn-block btn-primary updateButton">修改</button><button id="updateSubmitButton${user.userIdInteger }" onclick="updateSubmit(${user.userIdInteger });"   class="btn btn-block btn-outline-success"  style="display:none;margin-top: -1px">提交</button></td>
                     		  <td ><a href="${pageContext.request.contextPath }/admin/adminDelete/${user.userIdInteger }/${account.accountIdInteger }"  class="btn btn-block btn-danger deleteButton">删除</a><button type="button"  class="btn btn-block btn-outline-info" id="returnButton${user.userIdInteger }" style="display:none;margin-top: -1px" onclick="returnUpdate(${user.userIdInteger });">返回</button></td>
                 
	                      </c:forEach>  
                      </tr>
                   
                    </c:forEach>
                  </tbody>
                </table>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <!-- /.content -->
  </div>
  <form action="${pageContext.request.contextPath }/admin/adminUpdate" method="post" id="updateForm">
  	<input type="hidden" id="formId" name="updateId" >
  	<input type="hidden" id="formAccountId" name="accountIdInteger" >
  	<input type="hidden" id="formName" name="updateName" >
  	<input type="hidden" id="formAge" name="accountAgeString" >
  	<input type="hidden" id="formGender" name="accountGenderString" >
  	<input type="hidden" id="formPhone" name="accountPhoneString" >
  	<input type="hidden" id="formEmail" name="accountEmailString" >
  	<input type="hidden" id="formIdCard" name="accountIdCardString" >
  	<input type="hidden" id="formBalance" name="accountBalanceDouble" >

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
		$("#formAccountId").val($("#updateAccountId"+id).val());
		$("#formName").val($("#updateName"+id).val());
		$("#formAge").val($("#updateAge"+id).val());
		$("#formGender").val($("#updateGender"+id).val());
		$("#formPhone").val($("#updatePhone"+id).val());
		$("#formEmail").val($("#updateEmail"+id).val());
		$("#formIdCard").val($("#updateIdCard"+id).val());
		$("#formBalance").val($("#updateBalance"+id).val());
		$("#updateForm").submit();
	}
	function clickCheckbox(id){
		$.ajax({
			url:"${pageContext.request.contextPath }/admin/isAdmin/"+id,//请求路径
			type:"POST",//默认是get
			
		})
	}
	
	
</script>
  
  
<%@include file="../adminFooter.jsp"%>