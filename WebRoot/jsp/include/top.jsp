<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<nav class="top">
    <div class="top-bar">
        <span class="top-left">
            <c:if test="${empty home}">
            <span style="margin-left: 0"><span class=" glyphicon glyphicon-home redColor" style="margin-left: 0"></span>
            	<a href="/Small/start">首页</a></span>
            </c:if>
            <span>欢迎来到${website_name}</span>

            <c:if test="${!empty user}">
                ${user.name}
                <a href="/Small/logout" id="logout">退出</a>
            </c:if>
            <c:if test="${empty user}">
                <a href="/Small/jsp/login.jsp" id="login">请登录</a>
                <a href="/Small/jsp/register.jsp">免费注册</a>
            </c:if>
        </span>

        <span class="pull-right">
            <c:if test="${!empty user}">
            <a href="/Small/listOrder?uid=${user.id }&opt=front">我的订单</a>
            </c:if>
            <a href="/Small/cartlist?uid=${user.id }"><span class=" glyphicon glyphicon-shopping-cart redColor"></span>
               		 购物车<c:if test="${!empty user}"><strong id="cart-number">${sum }</strong>件</c:if></a>
            <c:if test="${user.group=='admin' || user.group=='superAdmin'}">
                <a href="/Small/listUser">网站后台</a>
            </c:if>
        </span>
    </div>
</nav>