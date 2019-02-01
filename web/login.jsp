<%@ page import="bean.MessageBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome!</title>
</head>
<body>

<script type="text/javascript">
    if("${messageBean.message}" !== ""){
        window.alert("${messageBean.message}");
    }
</script>
<p>
    邮箱:
    <input type='text' name='mail' value=''>
</p>
<p>
    密码:
    <input type='password' name='password' value=''>
</p>
<p>
    <a href="login.do" style="color:red;text-decoration:none;">登录</a>
</p>
<p>
    <a href="toRegister.do" style="color:red;text-decoration:none;">注册</a>
</p>

</body>
</html>