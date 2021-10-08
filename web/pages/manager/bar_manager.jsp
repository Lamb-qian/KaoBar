<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/15
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食材管理</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>

    <script type="text/javascript">

        $(function(){
            // 给删除的a标签绑定单击事件，用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                return confirm("您确定要删除【"+ $(this).parent().parent().find("td:first").text() +"】？")
            });

        });

    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
    <span class="wel_word">食材管理系统</span>
    <%--静态包含manager-menu--%>
    <%@ include file="/pages/common/manager_menu.jsp"%>

</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>类型</td>
            <td>图片地址</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="bar">
            <tr>
                <td>${bar.name}</td>
                <td>${bar.price}</td>
                <td>${bar.type}</td>
                <td>${bar.img_path}</td>
                <td><a href="barbecueServlet?action=getBar&id=${bar.id}&method=update">修改</a></td>
                <td><a class="deleteClass" href="barbecueServlet?action=del&id=${bar.id}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/bar_edit.jsp?method=add">添加食材</a></td>
        </tr>
    </table>
</div>
    <%--静态包含页脚内容--%>
    <%@include file="/pages/common/footer.jsp"%>
</body>
</html>
