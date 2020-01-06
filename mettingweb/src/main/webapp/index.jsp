<%@ page contentType="text/html; UTF-8" pageEncoding="utf-8"  language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
</body>
<form action="${pageContext.request.contextPath}/insertUser.action" method="post">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="提交">
</form>
</html>
a