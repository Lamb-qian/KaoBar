<%@ page import="com.jspsmart.upload.SmartUpload" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/18
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //之所以要放到异常抛出结构里面，是为了避免直接访问此页报错
    try{
        //指定动作
        SmartUpload smart=new SmartUpload();
        smart.initialize(pageContext);
        smart.upload();
        //把文件保存到同目录的pic文件夹
        smart.save("static/img");
    }
    catch(Exception e){
        System.out.println("出错了");
    }
%>
<a href="bar_edit.jsp">返回</a>
</body>
</html>
