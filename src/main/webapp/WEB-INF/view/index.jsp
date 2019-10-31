<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/global_color.css" /> 
    </head>
    <body class="index">
        <!--导航区域开始-->
        <div id="index_navi">
            <ul id="menu">
            <li><a href="${pageContext.request.contextPath }/admin/index1" class="index_off"></a></li>
                 <c:forEach items="${admin.powerlist}" var="power">
                 <li><a href="${pageContext.request.contextPath }${power.purl}" class="${power.pclass}_off"></a></li>
                 </c:forEach>     
                 <li><a href="${pageContext.request.contextPath }/admin/user_info" class="information_off"></a></li>
                  <li><a href="${pageContext.request.contextPath }/admin/user_modi_pwd" class="password_off"></a></li>       
            </ul>
        </div>
    </body>
</html>
