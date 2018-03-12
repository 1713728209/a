<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/9
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var msg = "${msg}";
    if(msg !== ""){
        alert(msg);
    }
    $(function () {
        if(!$("#refer").val()){
            $("#refer").val(document.referrer);
        }
        $("#form").submit(function () {
            if($("#password").val() == "" || $("#name").val() == ""){
                alert("用户名或密码为空");
                return false;
            }
            return true;
        });
    });
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<main class="login">
    <div class="login-content">
        <form method="post" action="/Small/loginIn" id="form">
        <div class="login-frame">
            <c:if test="${empty  error}">
            	<div class="login-tip">密码登录</div>
            </c:if>
            <c:if test="${not empty  error}">
            	<div class="login-tip">${error }</div>
            </c:if>
            <div class="login-input">
        <span class="login-input-icon">
                    <span class=" glyphicon glyphicon-user"></span>
                </span>
                <input type="text" placeholder="手机/会员名/邮箱" name="name" id="name" autofocus value="admin">
            </div>
            <div class="login-input">
        <span class="login-input-icon ">
                    <span class=" glyphicon glyphicon-lock"></span>
                </span>
                <input type="password" placeholder="密码" name="password" id="password" value="123456">
                <input type="hidden" name="refer" id="refer" value="${refer}">
            </div>
            <div class="login-button">
                <button type="submit" class="login-button">登 录</button>
            </div>
            <div class="login-bottom">
                <a href="#nowhere">忘记登录密码</a>
                <a class="" href="/Small/jsp/register.jsp">免费注册</a>
            </div>

        </div>
        </form>
    </div>
</main>