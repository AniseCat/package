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

<form method='POST' action='Login.do'>
    <p>
        邮箱:
        <input type='text' name='mail' value=''>
    </p>
    <p>
        密码:
        <input type='password' name='password' value=''>
    </p>
    <p><input type="submit" name="login" value="登录"></p>
    <p><input type="submit" name="toRegister" value="注册"></p>
</form>

</body>
</html>