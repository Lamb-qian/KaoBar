<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/19
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("a.remind").click(function () {
                return confirm("您的提醒店家已经收到，您再逛逛，正在加急为你做餐ing...")
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
    <span class="wel_word">我的订单</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.name}</span>串意十足烧烤店</span>
        <a href="userServlet?action=logout">注销</a>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="#">联系店长</a>
        <a href="index.jsp">返回</a>
    </div>

</div>

<div id="main">
    <table>
        <tr>
            <td>订单编号</td>
            <td>订单日期</td>
            <td>订单金额</td>
            <td>物流状态</td>
            <td>查看详情</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="order">
        <tr>
            <td>${order.order_id}</td>
            <td>${order.create_time}</td>
            <td>${order.price}</td>
            <c:if test="${order.status == 0}">
                <td>未发货</td>
            </c:if>
            <c:if test="${order.status == 1}">
                <td>已发货</td>
            </c:if>
            <c:if test="${order.status == 2}">
                <td>已签收</td>
            </c:if>
            <td><a href="orderServlet?action=myOrderItem&orderId=${order.order_id}">查看详情</a></td>
            <c:if test="${order.status == 0}">
                <td><a class="remind" href="index.jsp">提醒发货</a></td>
            </c:if>
            <c:if test="${order.status == 1}">
                <td><a href="orderServlet?action=updateStatus&orderId=${order.order_id}&status=${order.status}">签收订单</a></td>
            </c:if>
            <c:if test="${order.status == 2}">
                <td>订单完成</td>
            </c:if>
        </tr>
        </c:forEach>
    </table>
</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>
