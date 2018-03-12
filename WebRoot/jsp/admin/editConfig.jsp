<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/5
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="网站设置"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="4"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container" >
    <ol class="breadcrumb">
        <li>网站设置</li>
    </ol>
</div>

<div class="container">

    <div class="panel panel-default">
        <div class="panel-heading">修改设置</div>
        <div class="panel-body">
            <form class="form-horizontal" method="post" id="add-form" action="updateConfig">
                <div class="form-group">
                    <c:forEach items="${list}" var="c" varStatus="vs">
                        <label for="name${vs.count}" class="col-sm-2 control-label" style="margin-bottom: 10px;">${c.cname}</label>
                        <div class="col-sm-10" style="margin-bottom: 10px;">
                        	<input type="hidden" name="list[${vs.index }].id" value="${c.id}">
                            <input type="text" class="form-control" id="name${vs.count}" name="list[${vs.index }].value"
                                   placeholder="请输入${c.cname}" value="${c.value}">
                        </div>
                    </c:forEach>
                </div>

                <div class="form-group">
                    <div style="text-align: center">
                        <button type="submit" class="btn btn-success btn-sm">保存</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="pagination pagination-centered" style="margin-left: 35%;">
		<li><a href="/Small/configedit?pageIndex=1">首页</a></li>
		<li><a href="/Small/configedit?pageIndex=${page.pageIndex-1}">上一页</a></li>
		<li><a href="/Small/configedit?pageIndex=${page.pageIndex+1}">下一页</a></li>
		<li><a href="/Small/configedit?pageIndex=${page.pageCount}">末页</a></li>
	    <li><a>第${page.pageIndex}页/共${page.pageCount}页</a></li>
</div>
<%@include file="common/adminFooter.jsp" %>