<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑食材</title>
    <%--静态包含base标签、css样式、jQuery文件--%>
    <%@ include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }

        input {
            text-align: center;
        }
    </style>

    <script type="text/javascript">

        $(function(){
            // 给上传按钮单击事件，将文件名填入到文本框中
            $("#saveImg").click(function () {
                var filename = ${requestScope.filename} + "";
                //alert(filename);
                //document.getElementById("img_path").value=filename;
            });

        });

    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
    <span class="wel_word">编辑食材</span>

    <%--静态包含manager-menu--%>
    <%@ include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <form action="barbecueServlet" method="get">
        <input type="hidden" name="action" value="${param.method}"/>
        <input type="hidden" name="id" value="${requestScope.barbecue.id}"/>
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>类型</td>
                <td>图片地址</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${requestScope.barbecue.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.barbecue.price}"/></td>
                <td><input name="type" type="text" value="${requestScope.barbecue.type}"/></td>
                <c:if test="${empty requestScope.realFileName}">
                <td><input name="img_path" type="text" value="${requestScope.barbecue.img_path}"/></td>
                </c:if>
                <c:if test="${not empty requestScope.realFileName}">
                    <td><input name="img_path" type="text" value="${requestScope.realFileName}"/></td>
                </c:if>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
    <form action="uploadImg?id=${requestScope.barbecue.id}" method="post" enctype="multipart/form-data" style="text-align: center">
        <input type="file" name="imgFile">
        <input type="submit" value="上传图片" id="saveImg"/>${msg}
    </form>

</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>