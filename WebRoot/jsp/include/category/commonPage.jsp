<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<main class="search">
    <div class="items">
        <c:forEach items="${list}" var="p" varStatus="vs">
            <a href="/Small/findProductById?id=${p.id}">
                <div class="border" price="${p.nowPrice}">
                    <div class="item">
                        <div class="content">
                           <%--  <img class="item-img" src="${productImgDir}${p.image.path}"> --%>
                            <div class="item-price">
                                ￥${p.nowPrice}
                            </div>
                            <div class="item-title">
                                    ${p.name}
                            </div>
                            <div class="item-shop">
                            </div>
                            <div class="item-bottom">
                        <span>
                            月成交<em>${p.saleCount}笔</em>
                        </span>
                                <span>
                            评价<a href="/Small/findProductById?id=${p.id }">${p.commentCount}条</a>
                        </span>
                                <span><img src="/Small/img/wangwang.png"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </c:forEach>
        <c:if test="${empty list}">
            <div class="no-match">没有满足条件的产品</div>
        </c:if>
    </div>
</main>

<div class="pagination pagination-centered" style="margin-left: 35%;">
	<li><a href="/Small/listProduct?pageIndex=1&opt=${opt }&cid=${cid}&keyword=${keyword}">首页</a></li>
	<li><a href="/Small/listProduct?pageIndex=${page.pageIndex-1}&opt=${opt }&cid=${cid}&keyword=${keyword}">上一页</a></li>
	<li><a href="/Small/listProduct?pageIndex=${page.pageIndex+1}&opt=${opt }&cid=${cid}&keyword=${keyword}">下一页</a></li>
	<li><a href="/Small/listProduct?pageIndex=${page.pageCount}&opt=${opt }&cid=${cid}&keyword=${keyword}">末页</a></li>
	<li><a>第${page.pageIndex}页/共${page.pageCount}页</a></li>
</div>
