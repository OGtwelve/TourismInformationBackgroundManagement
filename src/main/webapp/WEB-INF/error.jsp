<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>非管理员页面</title>
    <link rel="icon" type="image/x-ico" href="https://cdn.jsdelivr.net/gh/OGtwelve/Static@main/pic04.jpg"/>
    <link type="text/css" rel='stylesheet' href="${pageContext.request.contextPath }/resource/assets/css/404life.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/resource/assets/js/404life.js'></script>
    <script>
        window.console = window.console || function(t) {};
    </script>
    <script>
        if (document.location.search.match(/type=embed/gi)) {
            //location.href.anchor("http://www.ogtwelve.com");
            window.parent.postMessage("resize", "*");
        }
    </script>
</head>

<body translate="no" >
<div class='terminal'>
    <h1 id='title'>404</h1>
    <h3><c:if test="${empty error}">${error}</c:if></h3>
    <div class='text' id='text_1'></div>
    <div class='text' id='text_2'></div>
    <div class='cursor'>_</div>
</div>
<script src='${pageContext.request.contextPath }/resource/assets/js/jquery.min.js'></script>
<script>
    window.console = window.console || function(t) {};
    if (document.location.search.match(/type=embed/gi)) {
        window.parent.postMessage("resize", "*");
    }
</script>
</body>
</html>