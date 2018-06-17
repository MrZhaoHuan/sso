<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录成功页面</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
   欢迎您：${user.name}<br>
   <a href="logout">注销</a>
</body>
</html>