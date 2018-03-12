<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<section class="head-bar">
    <div class="c-menu">
        <span class="glyphicon glyphicon-th-list icon"></span>
        <span>商品分类</span>
    </div>
    <div class="r-menu">
        <a href="#nowhere"><img src="/Small/img/chaoshi.png"></a>
        <a href="#nowhere"><img src="/Small/img/guoji.png"></a>
        <c:forEach items="${categoryList}" var="c" varStatus="vs">
             <a href="/Small/listProduct?cid=${c.id}&opt=font">${c.name}</a>
        </c:forEach>
    </div>
</section>

<section class="carousel">
    <div data-ride="carousel" class="carousel-of-product carousel slide" id="carousel-of-product" >
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li class="active" data-slide-to="0" data-target="#carousel-of-product"></li>
            <li data-slide-to="1" data-target="#carousel-of-product" class=""></li>
            <li data-slide-to="2" data-target="#carousel-of-product" class=""></li>
            <li data-slide-to="3" data-target="#carousel-of-product" class=""></li>
        </ol>
        <!-- Wrapper for slides -->
        <div role="listbox" class="carousel-inner">
            <div class="item active">
                <a href="/Small/product?id=27" target="_blank">
                <img src="/Small/img/1.jpg" class="carousel carousel-image">
                </a>
            </div>
            <div class="item">
                <a href="/Small/product?id=1" target="_blank">
                <img src="/Small/img/2.jpg" class="carousel-image">
                </a>
            </div>
            <div class="item">
                <a href="/Small/product?id=20" target="_blank">
                <img src="/Small/img/3.png" class="carousel-image">
                </a>
            </div>
            <div class="item">
                <a href="/Small/product?id=30" target="_blank">
                <img src="/Small/img/4.png" class="carousel-image">
                </a>
            </div>
        </div>

        <div class="m-menu">
            <ul>
            <c:forEach items="${categoryList}" var="c" varStatus="vs">
                <li cid="${c.id}"><span class="glyphicon glyphicon-link"></span><a href="/Small/listProduct?cid=${c.id}&opt=font">${c.name}</a></li>
            </c:forEach>
            </ul>
        </div>
       <%--  <c:forEach items="${categories}" var="c" varStatus="vs">
        <div class="d-menu" cid="${c.id}" style="display: none">
            <c:forEach items="${c.products}" var="p" varStatus="vs">
                <a href="product?id=${p.id}">${p.subTitle}</a>
            </c:forEach> --%>
        </div>
    </div>

</section>
