<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/17
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            //给删除绑定单击事件
            $("a.deleteItem").click(function () {
                return confirm("您确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？")
            });

            //给清空购物车绑定单击事件
            $("#clearCart").click(function () {
                return confirm("您确定要清空购物车吗？")
            });

            //给输入框绑定change内容发生改变事件
            $(".updateCount").change(function () {
                //获取商品名称
                var name = $(this).parent().parent().find("td:first").text();
                var barName = $(this).attr("barName");
                //获取商品数量
                var count = this.value;
                if(confirm("您确定要将【"+ name +"】商品数量修改为："+ count +"吗？")){
                    location.href = "http://localhost:8080/KaoBar/cartServlet?action=updateCount&count="+count+"&id="+barName;
                }else{
                    //defaultValue属性表示表单项DOM对象的属性，它表示默认的value值
                    this.value = this.defaultValue;
                }
            });
        });
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
    <span class="wel_word">购物车</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/register.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.name}</span>串意十足烧烤店</span>
            <a href="orderServlet?action=myOrder&id=${sessionScope.user.id}">我的订单</a>
            <a href="userServlet?action=logout">注销</a>
        </c:if>
        <a href="#">联系店长</a>
        <a href="index.jsp">返回</a>
    </div>
</div>

<div id="main">

    <table>

        <tr>
            <td>名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">当前购物车为空，快去挑选喜欢的商品吧！</a></td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount" barName="${entry.value.id}" width="50px" type="text" value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <c:if test="${empty sessionScope.user}">
                <span class="cart_span"><a href="#">登录后结账</a></span>
            </c:if>
            <c:if test="${not empty sessionScope.user}">
                <span class="cart_span"><a href="orderServlet?action=addOrder&id=${sessionScope.user.id}">去结账</a></span>
            </c:if>
        </div>
    </c:if>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
