<%@ page import="bean.MessageBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script type="text/javascript">
    if("${messageBean.message}" !== ""){
        window.alert("${messageBean.message}");
    }
</script>

<form method='POST' action='Register.do'>
    <p>邮箱:<input type='text' name='mail' value=''></p>
    <p>
        验证码:<input type='text' name='authcode' value=''>
        <input type="submit" name="getAuthcode" value="获取验证码">
    </p>
    <p>密码:<input type='password' name='password' value=''></p>
    <p>注册成为:
        <input name="userType" type="radio" value="学生" checked="checked"/>学生
        <input name="userType" type="radio" value="老师"/>老师
    </p>
    <p><input type="submit" name="register" value="注册"></p>
    <p><input type="submit" name="toLogin" value="登录"></p>
</form>

</body>
</html>
