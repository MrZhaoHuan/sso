<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<form action="login" method="POST">
    用户名:<input type="text" name="name" value="${name}"><br>
    密码:<input type="password" name="pwd"><br>
    自动登录<input type="checkbox" name="isAutoLogin"><br>
    <span style="color: red">${error}</span><br>
    <input type="submit" value="登录">
</form>
</body>
</html>