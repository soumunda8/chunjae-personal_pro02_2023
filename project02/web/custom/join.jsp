<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보입력</title>
    <c:set var="path" value="<%=request.getContextPath() %>" />
</head>
<body>
<form action="${path }/joinPro.do" method="post">

    <input type="hidden" name="test" value="hi">
    <input type="submit" value="회원가입">
</form>
</body>
</html>