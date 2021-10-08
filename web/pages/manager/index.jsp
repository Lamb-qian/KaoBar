<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/17
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
    <style>
        .good{
            width: 400px;
            height: 200px;
            padding: 10px;
            float: left;
            position: relative;
        }
        .ph{
            width: 200px;
            height: 200px;
            display: block;
            float: left;
        }
        .info{
            display: block;
            float: left;
            margin: 10px;
        }
        .tt{
            font-weight: bold;
            font-size: 26px;
        }
        .bar_add{
            position: absolute;
            right: 10px;
            bottom: 10px;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            //给加入购物车按钮绑定单击事件
            $("button.addToCart").click(function () {
                var barName = $(this).attr("barName");
                $.getJSON("http://localhost:8080/KaoBar/cartServlet","action=ajaxAddItem&id="+barName,function (data) {
                    $("#cartTotalCount").text("您的购物车中有"+ data.totalCount +"件商品");
                    $(".cartLastName").text(data.lastName);
                })
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
    <span class="wel_word">Barbecue</span>
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
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="#">联系店长</a>
    </div>
</div>
<div id="main">
    <div style="text-align: center">
        <form action="barbecueServlet" method="get" style="display: inline">
            <input type="hidden" name="action" value="queryByType">
            <select name="type">
                <option name="type" value="素食">素食</option>
                <option name="type" value="肉食">肉食</option>
                <option name="type" value="海鲜">海鲜</option>
            </select>
            <input type="submit" value="按类型查询"/>
        </form>
        <!--<form action="" method="get" style="display: inline">
            <input type="hidden" name="action" value="pageByPrice">价格：
            <input type="text" name="min" value="" style="width: 40px;">元-
            <input type="text" name="max" value="" style="width: 40px;">元
            <input type="submit" value="按价格区间查询"/>
        </form>-->
        <form action="barbecueServlet" method="get" style="display: inline">
            <input type="hidden" name="action" value="sortUpByPrice">
            <input type="submit" value="按价格升序查询"/>
        </form>
        <form action="barbecueServlet" method="get" style="display: inline">
            <input type="hidden" name="action" value="sortDownByPrice">
            <input type="submit" value="按价格降序查询"/>
        </form><br/>
        <c:if test="${empty sessionScope.cart.items}">
            <%--购物车为空--%>
            <span id="cartTotalCount"></span>
            <div>
                <span class="cartLastName"  style="color: red">当前购物车为空</span>
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">
            <%--购物车非空--%>
            <span id="cartTotalCount">您的购物车中有${sessionScope.cart.totalCount}件商品</span>
            <div>
                您刚刚将<span class="cartLastName" style="color: red">${sessionScope.lastName}</span>加入到了购物车中
            </div>
        </c:if>
    </div>

    <div id="bar">

        <c:forEach items="${requestScope.page.items}" var="bar">
            <div class="good">
                <div class="ph">
                    <c:if test="${empty bar.img_path}">
                        <img src="static/img/dianmian.jpg" width="200px" height="200px">
                    </c:if>
                    <c:if test="${not empty bar.img_path}">
                        <img src="static/img/${bar.img_path}" width="200px" height="200px">
                    </c:if>
                </div>
                <div class="info">
                    <span class="tt">${bar.name}</span><br/>
                    价格：<span style="color:red">￥${bar.price}</span><br/>
                    <span>类型：${bar.type}</span>
                    <div style="width: 100px;"><span>优惠：点赞收藏后联系店长可以领大红包</span></div>
                </div>
                <div class="bar_add">
                    <button barName="${bar.id}" class="addToCart">加入购物车</button>
                </div>
            </div>
        </c:forEach>

    </div>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
