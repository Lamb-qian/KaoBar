<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/15
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

    <div id="header">
        <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
        <span class="wel_word">后台管理系统</span>

        <%--静态包含manager-menu--%>
        <%@ include file="/pages/common/manager_menu.jsp"%>

    </div>

    <div id="main">
        <h1>欢迎${sessionScope.user.name}进入后台管理系统</h1>
    </div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>
