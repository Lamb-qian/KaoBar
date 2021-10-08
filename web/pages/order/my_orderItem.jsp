<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/19
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单项</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
    <span class="wel_word">当前订单项</span>
    <c:if test="${sessionScope.user.power==0}">
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.name}</span>串意十足烧烤店</span>
        <a href="userServlet?action=logout">注销</a>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="orderServlet?action=myOrder&id=${sessionScope.user.id}">我的订单</a>
        <a href="index.jsp">返回</a>
    </div>
    </c:if>
    <c:if test="${sessionScope.user.power==1}">
        <%--静态包含manager-menu--%>
        <%@ include file="/pages/common/manager_menu.jsp"%>
    </c:if>
</div>

<div id="main">
    <table>
        <tr>
            <td>烧烤名称</td>
            <td>已购数量</td>
            <td>烧烤单价</td>
            <td>总价</td>

        </tr>
        <c:forEach items="${requestScope.itemPage.items}" var="orderItem">
            <tr>
                <td>${orderItem.name}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.total_price}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>
