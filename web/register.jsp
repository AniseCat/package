<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/1
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>
    邮箱:
    <input type='text' name='mail' value=''>
</p>
<p>
    验证码:
    <input type='text' name='authcode' value=''>
    <a href="getAuthcode.do" style="color:red;text-decoration:none;">获取验证码</a>
</p>
<p>
    密码:
    <input type='password' name='password' value=''>
</p>
<p>
    <a href="toLogin.do" style="color:red;text-decoration:none;" >登录</a>
</p>
<p>
    <a href="register.do" style="color:red;text-decoration:none;" >注册</a>
</p>

</body>
</html>
