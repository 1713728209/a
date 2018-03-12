<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/5
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="用户管理"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="2"/>
<%@include file="common/adminNavigator.jsp" %>


<div class="container" >
    <ol class="breadcrumb">
        <li>用户管理</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">用户</th>
            <th scope="col">用户组</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.id}</th>
                <td>${u.name}</td>
                <td>${u.group}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination pagination-centered" style="margin-left: 35%;">
		<li><a href="/Small/listUser?pageIndex=1">首页</a></li>
		<li><a href="/Small/listUser?pageIndex=${pageIndex-1}">上一页</a></li>
		<li><a href="/Small/listUser?pageIndex=${pageIndex+1}">下一页</a></li>
		<li><a href="/Small/listUser?pageIndex=${page.pageCount}">末页</a></li>
	    <li><a>第${pageIndex}页/共${page.pageCount}页</a></li>
	</div>
</div>

<%-- <%@include file="common/adminPage.jsp" %> --%>

<%@include file="common/adminFooter.jsp" %>

