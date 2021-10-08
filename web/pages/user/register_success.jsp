<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/14
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册成功</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
</div>

<div id="main">
    <div id="login_banner" style="text-align: center;">
        <h1>恭喜你,注册成功！</h1>
        <a  href="index.jsp">返回首页</a><br/>
        <br/>
        <a  href="pages/user/login.jsp">返回登录</a>
    </div>
</div>
<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
