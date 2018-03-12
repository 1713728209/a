<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<header class="search">
    <a href="/Small/start" class="logo">
        <img src="/Small/img/logo2.png">
    </a>
    <div class="search">
        <form action="/Small/listProduct" method="get">
        <input type="hidden" name="opt" value="frontSearch">
        <input type="text" placeholder="搜索 ${website_name} 商品/品牌/店铺" name="keyword">
        <button class="search-button" type="submit">搜索</button>
        </form>
        <ul class="search-below">
           <%--  <c:forEach items="${categoryList}" var="c" varStatus="vs">
                <li><a href="/Small/listProduct?cid=${c.id}&opt=font">${c.name}</a></li>
            </c:forEach> --%>
        </ul>
    </div>
</header>