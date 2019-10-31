<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
        <div id="header">
            <img src="${pageContext.request.contextPath }/images/logo.png" alt="logo" class="left"/>
            <span>${sessionScope.admin.acname }</span><a href="${pageContext.request.contextPath }/admin/ExitAction">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
           <ul id="menu">
                  <li><a href="${pageContext.request.contextPath }/admin/index1" class="index_off"></a></li>                   
                 <c:forEach items="${sessionScope.admin.powerlist}" var="power">
                 <li><a href="${pageContext.request.contextPath }${power.purl}" class="${power.pclass}_off"></a></li>
                 </c:forEach>    
                 <li><a href="${pageContext.request.contextPath }/admin/user_info" class="information_off"></a></li>
                  <li><a href="${pageContext.request.contextPath }/admin/user_modi_pwd" class="password_off"></a></li>       
            </ul>
        </div>