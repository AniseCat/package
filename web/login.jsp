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

<form method='POST' action='UserServlet'>
username: <input type='text' name='username' value='${userBean.username}'>
password: <input type='password' name='password' value=''>
<input type='submit' name='loginAction' value='登录'>
</form>

</body>
</html>