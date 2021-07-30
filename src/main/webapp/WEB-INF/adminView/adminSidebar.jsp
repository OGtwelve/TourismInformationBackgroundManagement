<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a href="${pageContext.request.contextPath }/admin" class="brand-link ">
    	<i class="nav-icon fas fa-users mx-4"></i>
      <span class="brand-text font-weight-light" >管理员模式</span>
    </a>
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          
          <li class="nav-item has-treeview <c:if test="${not empty admin }">menu-open</c:if>">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-user"></i>
               用户管理
               <i class="right fas fa-angle-left"></i>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath }/admin" class="nav-link <c:if test="${admin=='list' }">active</c:if> ">
                  <i class="far fa-circle nav-icon"></i>
                  用户信息
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath }/admin/adminInsert" class="nav-link <c:if test="${admin=='insert' }">active</c:if>">
                  <i class="far fa-circle nav-icon"></i>
                  添加用户
                </a>
              </li>
   
            </ul>
          </li>
          <li class="nav-item has-treeview <c:if test="${modelAndView=='tours' }">menu-open</c:if>
          <c:if test="${modelAndView=='attractions' }">menu-open</c:if>
          <c:if test="${modelAndView=='caterings' }">menu-open</c:if>
          <c:if test="${modelAndView=='hotels' }">menu-open</c:if>
          <c:if test="${modelAndView=='transfers' }">menu-open</c:if>">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-chart-pie"></i>
                旅游公司管理
              <i class="right fas fa-angle-left"></i>
            </a>
            <ul class="nav nav-treeview">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath }/admin/tour" class="nav-link <c:if test="${modelAndView=='tours' }">active</c:if> ">
                  <i class="far fa-circle nav-icon"></i>
                  旅游公司
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath }/admin/attraction" class="nav-link <c:if test="${modelAndView=='attractions' }">active</c:if>">
                  <i class="far fa-circle nav-icon"></i>
                  景点
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath }/admin/catering" class="nav-link <c:if test="${modelAndView=='caterings' }">active</c:if>">
                  <i class="far fa-circle nav-icon"></i>
                  餐饮
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath }/admin/hotel" class="nav-link <c:if test="${modelAndView=='hotels' }">active</c:if>">
                  <i class="far fa-circle nav-icon"></i>
                  酒店
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath }/admin/transfer" class="nav-link <c:if test="${modelAndView=='transfers' }">active</c:if>">
                  <i class="far fa-circle nav-icon"></i>
                  交通
                </a>
              </li>
            </ul>
          </li>
          
        </ul>
      </nav>
    
  </aside>
