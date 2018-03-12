<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>


<script src="/Small/js/index.js"></script>

<header class="index-top">
    <a href="/Small/start" class="logo">
        <img src="/Small/img/logo.png">
    </a>
    <div class="search">
        <form action="/Small/listProduct" method="get">
        	<input type="hidden" name="opt" value="frontSearch">
        	<input type="text" placeholder="本网站仅供技术演示，源码见 http://github.com/xenv/S-mall-ssm" name="keyword">
        	<button class="search-button" type="submit">搜索</button>
        </form>
        <ul class="search-below">
            <c:forEach items="${categoryList}" var="c" varStatus="vs">
                <li><a href="/Small/listProduct?cid=${c.id}&opt=font">${c.name}</a></li>
            </c:forEach>
        </ul>
    </div>
</header>