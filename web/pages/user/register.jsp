<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/13
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册界面</title>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为3到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#usn").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{3,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名不合法！");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为3到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#psd").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{3,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#isPsd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });
        });
    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/barName.gif" width="350px">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册串意十足</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>Barbecue Member</h1>
                    <a href="pages/user/login.jsp">立即登录</a>
                    <a href="index.jsp">返回首页</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        ${ empty requestScope.msg ? "请输入注册信息" : requestScope.msg }
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register" />
                        <label>用户名称：</label>
                        <input class="itxt" id="usn" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username"
                               value="${requestScope.username}"/>
                        <br /> <br />
                        <label>用户密码：</label>
                        <input class="itxt" id="psd" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" />
                        <br /> <br />
                        <label>确认密码：</label>
                        <input class="itxt" id="isPsd" type="password" placeholder="请再次输入密码"
                               autocomplete="off" tabindex="1" name="repsd"
                               value=""/>
                        <br /> <br />
                        <label>电话号码：</label>
                        <input class="itxt" type="text" placeholder="请输入电话号码"
                               autocomplete="off" tabindex="1" name="tel"
                               value=""/>
                        <br /> <br />
                        <label>送餐地址：</label>
                        <input class="itxt" type="text" placeholder="请输入送餐地址"
                               autocomplete="off" tabindex="1" name="address"
                               value=""/>
                        <br /> <br />
                        <input style="background-color: lightsalmon;color: navy;font-size: larger" type="submit" value="注册" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
