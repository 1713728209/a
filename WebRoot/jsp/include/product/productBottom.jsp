<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<main class="product-content">
    <div class="product-bar">
        <div class="product-select selected" href="#nowhere" id="button-1">
            <a href="#nowhere">商品详情</a>
        </div>
        <div class="product-select" href="#nowhere" id="button-2">
            <a href="#nowhere">
                累计评价
                <span class="product-comment-number">${product.commentCount}</span>
            </a>
        </div>
    </div>
    <div class="clear" id="main-1">
        <div class="product-top">
            <div class="product-key-title">产品参数：</div>
            <ul class="product-key">
                <c:forEach items="${product.propertyValues}" var="p" varStatus="vs">
                    <li>${p.property.name}: ${p.value}</li>
                </c:forEach>
            </ul>
        </div>
        <div class="product-content-part">
            <c:forEach items="${productDetailImages}" var="img" varStatus="vs">
                <img src="${productImgDir}${img.path}">
            </c:forEach>
        </div>
    </div>
    <div class="clear" id="main-2" style="display: none;">
        <table class="comment">
            <c:forEach items="${list}" var="c" varStatus="vs">
            <tr>
                <td class="comment-left">${c.content}
                    <span class="date">${c.createDate}</span></td>
                <td class="comment-right">${c.user.name}<span class="annoy">（匿名）</span></td>
            </tr>
            </c:forEach>
        </table>
<div class="pagination pagination-centered" style="margin-left: 35%;">
	<li><a href="/Small/findProductById?pageIndex=1&id=${id }">首页</a></li>
	<li><a href="/Small/findProductById?pageIndex=${page.pageIndex-1}&id=${id }">上一页</a></li>
	<li><a href="/Small/findProductById?pageIndex=${page.pageIndex+1}&id=${id }">下一页</a></li>
	<li><a href="/Small/findProductById?pageIndex=${page.pageCount}&id=${id }">末页</a></li>
	<li><a>第${page.pageIndex}页/共${page.pageCount}页</a></li>
</div>
        
    </div>
</main>

