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

<c:set var="title" value="分类管理 - 属性管理"/>
<%@include file="common/adminHeader.jsp" %>

<%@include file="common/adminNavigator.jsp" %>


<div class="container" >
    <ol class="breadcrumb">
        <li><a href="/Small/categorylist">分类管理</a></li>
        <li>${category.name}</li>
        <li class="active">属性管理</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">属性名称</th>
            <th scope="col">编辑</th>
            <th scope="col">删除</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="p" varStatus="vs">
            <tr>
                <th scope="row">${p.id}</th>
                <td>${p.name}</td>
                <td><a href="edit?id=${p.id}&opt=view"><span class="glyphicon glyphicon-edit"></span></a></td>
                <td><a href="edit?id=${p.id}&opt=deleteProperty&cid=${p.category.id}" class="delete-button"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="pagination pagination-centered" style="margin-left: 35%;">
		<li><a href="/Small/propertylist?pageIndex=1&cid=${cid }">首页</a></li>
		<li><a href="/Small/propertylist?pageIndex=${pageIndex-1}&cid=${cid }">上一页</a></li>
		<li><a href="/Small/propertylist?pageIndex=${pageIndex+1}&cid=${cid }">下一页</a></li>
		<li><a href="/Small/propertylist?pageIndex=${page.pageCount}&cid=${cid }">末页</a></li>
	    <li><a>第${pageIndex}页/共${page.pageCount}页</a></li>
	</div>
<%--<%@include file="common/adminPage.jsp" %>--%>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:auto">
            <div class="panel-heading">新增属性</div>
            <div class="panel-body">
                <form class="form-horizontal" method="get" id="add-form" action="add">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">属性名字</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入属性名字">
                        </div>
                        <input name="cid" value="${category.id}" type="hidden">
                    </div>
                    <div class="form-group">
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-success btn-sm">新建属性</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

