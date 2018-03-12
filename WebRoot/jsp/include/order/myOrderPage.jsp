<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/9
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script>
    var deleteOid = -1;
    $(function () {
        $(".order-type a").click(function () {
            var orderStatus = $(this).attr("order-status");
            if('all'===orderStatus){
                $("table[order-status]").show();
            }else{
                $("table[order-status]").hide();
                $("table[order-status="+orderStatus+"]").show();
            }
            $(".order-type div").removeClass("selected");
            $(this).parent("div").addClass("selected");

        });
        $(".delete-button").click(function () {
            deleteOid = $(this).attr("oid");
            $("#confirmModal").modal('show');
        });
        $("#confirmDelete").click(function () {
            $("#confirmModal").modal("hide");
            var page = "deleteOrder";
            $.get(page,{"oid":deleteOid},function (result) {
                if(result === "success"){
                    $("table[oid="+deleteOid+"]").remove();
                }else{
                    alert("服务器错误，删除失败");
                }
            });
        });
        $("#cancelDelete").click(function () {
            $("#confirmModal").modal("hide");
        });
    });
</script>

<section class="order-type">
    <div class="selected"><a href="#nowhere" order-status="all">所有订单</a></div>
    <div><a href="#nowhere" order-status="waitPay">待付款</a></div>
    <div><a href="#nowhere" order-status="waitDelivery">待发货</a></div>
    <div><a href="#nowhere" order-status="waitConfirm">待确认</a></div>
    <div><a href="#nowhere" order-status="waitComment">待评价</a></div>
</section>

<main class="order-list">
    <table class="head-table">
        <thead>
        <th width="16%">宝贝</th>
        <th width="16%">状态</th>
        <th width="16%">单价</th>
        <th width="16%">数量</th>
        <th width="16%">实付款</th>
        <th width="20%">交易操作</th>
        </thead>
    </table>
    <c:forEach items="${list}" var="o" varStatus="vs">
    <table class="line-table" order-status="${o.status}" oid="${o.id}">
        <tr class="item-head">
            <td class="time-and-order" colspan="2">
                <b>${o.createDate}</b>
                <span>订单号: ${o.orderCode}</span>
            </td>
            <td >
                <span class="seller"><img src="/Small/img/tmall-small.png">${website_name}</span>
            </td>
            <td>
                <span class="wangwang"></span>
            </td>
            <td class="delete">
                <c:if test="${o.status==5}">
                	<a href="#nowhere" class="delete-button" oid="${o.id}">
                    	<span class="glyphicon glyphicon-trash"></span>
                	</a>
                </c:if>
            </td>
            <td>
            </td>
        </tr>
        
        <c:forEach items="${o.orderitems}" var="oi" varStatus="vs2">
        <tr class="item-body">
            <td class="item-name" width="16%" style="text-align: center;" >
                <a class="cart-item-title" href="/Small/findProductById?id=${oi.product.id}">${oi.product.name}</a>
                <img title="保障卡" src="img/baozhang.png" >
            </td>
             <td class="num-center" width="16%" >
             	 <c:if test="${oi.order.status==0}">
                    <a >未发货</a>
                </c:if>
                <c:if test="${oi.order.status==1}">
                    <a >已发货</a>
                </c:if>
                <c:if test="${oi.order.status==2}">
                    <a >已接收</a>
                </c:if>
                <c:if test="${oi.order.status==3}">
                    <a  >已结账</a>
                </c:if>
                <c:if test="${oi.order.status==4}">
                    <a  >已完成订单</a>
                </c:if>
                <c:if test="${oi.order.status==5}">
                    <a >等待评论</a>
                </c:if>
                <c:if test="${oi.order.status==6}">
                    <a >评论完成</a>
                </c:if>
            </td>
            <td class="num-center" width="16%">
                <span class="cart-item-old-price">￥${oi.product.originalPrice}</span>
                <span class="cart-item-now-price">￥${oi.product.nowPrice}</span>
            </td>
            <td width="16%" class="num-center border-left">
                <span class="order-item-num">${oi.number}</span>
            </td>
            <td class="price-td" width="16%">
                <span class="order-item-sum">￥${o.sum}</span>
                <span class="freight">(含运费：￥0.00)</span>
            </td>
            <td width="20%" >
                <c:if test="${o.status==1 }">
                    <a href="/Small/findOrderById?oid=${o.id}" class="order-button blue">确认收货</a>
                </c:if>
                <c:if test="${o.status==2 }">
                    <a href="/Small/findOrderById?oid=${o.id}&opt=fukuan" class="order-button blue">付款</a>
                </c:if>
                <c:if test="${o.status==0 }">
                    <p><a href="#nowhere" class="order-button white">待发货</a>
                    <a href="#nowhere" class="order-button blue">自己发货</a></p>
                </c:if>
                <c:if test="${o.status==3 }">
                    <a href="#nowhere" class="order-button white">完成订单</a>
                </c:if>
                <c:if test="${o.status== 4}">
                	<a href="/Small/findOrderById?oid=${oi.order.id}&opt=pingjia&pid=${oi.product.id}" class="order-button white">评价</a>
            	</c:if>
            	<c:if test="${o.status== 6}">
                	<a href="#" class="order-button white">已评价</a>
            	</c:if>
            </td>
        </tr>
        </c:forEach>
    </table>
    </c:forEach>
    <div class="modal" tabindex="-1" role="dialog" id="confirmModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-title">删除宝贝</div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                <div class="confirm-content">确认要删除该宝贝吗？</div>
                <div class="button-group">
                    <button class="yes" id="confirmDelete">确定</button>
                    <button class="no" id="cancelDelete">取消</button>
                </div>
            </div>
        </div>
    </div>
</main>
<div class="pagination pagination-centered" style="margin-left: 35%;">
	<li><a href="/Small/listOrder?pageIndex=1&opt=${opt }&uid=${uid}">首页</a></li>
	<li><a href="/Small/listOrder?pageIndex=${page.pageIndex-1}&opt=${opt }&uid=${uid}">上一页</a></li>
	<li><a href="/Small/listOrder?pageIndex=${page.pageIndex+1}&opt=${opt }&uid=${uid}">下一页</a></li>
	<li><a href="/Small/listOrder?pageIndex=${page.pageCount}&opt=${opt }&uid=${uid}">末页</a></li>
	<li><a>第${pageIndex}页/共${page.pageCount}页</a></li>
</div>
