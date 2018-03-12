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

<c:set var="title" value="分类管理 - 产品管理 - 修改属性值"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="1"/>
<%@include file="common/adminNavigator.jsp" %>


<div class="container">
    <ol class="breadcrumb">
        <li><a href="/Small/categorylist">所有分类</a></li>
        <li><a href="/Small/listProduct?cid=${product.category.id}">${product.category.name}</a></li>
        <li>${product.name}</li>
        <li>属性值管理</li>
    </ol>
</div>

<div class="container">

    <div class="panel panel-default">
        <div class="panel-heading">编辑属性</div>
        <div class="panel-body">

            <form class="form-horizontal" method="get" id="add-form">

                <div class="form-group">
                    <c:forEach items="${list}" var="p" varStatus="vs">
                        <label for="name${vs.count}" class="col-sm-2 control-label" style="margin-bottom: 10px;">${p.property.name}</label>
                        <div class="col-sm-4" style="margin-bottom: 10px;">
                            <input type="hidden" name="id" value="${p.id}">
                            <input type="text" class="form-control" id="name${vs.count}" name="value"
                                   placeholder="请输入${p.property.name}" value="${p.value}">
                        </div>
                    <input type="hidden" name="pid" value="${product.id}">
                    <input type="hidden" name="cid" value="${product.category.id}">
                    <input type="hidden" name="ptid" value="${p.property.id}">
                    </c:forEach>
                </div>

                <div class="form-group">
                    <div style="text-align: center">
                        <button type="button" class="btn btn-success btn-sm" id="submit">保存</button>
                    </div>
                </div>
            </form>
            <script type="text/javascript">
            	$(document).ready(function(){
            		var str=new Array();
            		$("input[type='text']").each(function(dom,value){
            			str.push($(dom).val());
            		});
            		alert(str);
            		$("#submit").click(function(){
            			document.forms[0].action="updatePropertyValue?str="+str;
            			document.forms[0].submit;
            		});
            	});
            </script>
        </div>
    </div>
</div>

<div class="pagination pagination-centered" style="margin-left: 35%;">
		<li><a href="/Small/propertyValue?pageIndex=1&pid=${pid }">首页</a></li>
		<li><a href="/Small/propertyValue?pageIndex=${page.pageIndex-1}&pid=${pid }">上一页</a></li>
		<li><a href="/Small/propertyValue?pageIndex=${page.pageIndex+1}&pid=${pid }">下一页</a></li>
		<li><a href="/Small/propertyValue?pageIndex=${page.pageCount}&pid=${pid }">末页</a></li>
	    <li><a>第${page.pageIndex}页/共${page.pageCount}页</a></li>
</div>


