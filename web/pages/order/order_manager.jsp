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
    <title>订单管理</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("a.remind").click(function () {
                 confirm("顾客已经收到你的提醒,请稍等...");
                 return false;
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
    <span class="wel_word">订单管理</span>
    <%--静态包含manager-menu--%>
    <%@ include file="/pages/common/manager_menu.jsp"%>

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
                    <td><a href="orderServlet?action=updateStatus&orderId=${order.order_id}&status=${order.status}">发货</a></td>
                </c:if>
                <c:if test="${order.status == 1}">
                    <td><a class="remind" href="">提醒签收</a></td>
                </c:if>
                <c:if test="${order.status == 2}">
                    <td>完成订单</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>