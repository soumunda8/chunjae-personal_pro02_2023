<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/main.css">
</head>
<body>
<div class="container">
    <jsp:include page="../layout/header.jsp" />
    <div class="contents">

        <p style="color:darkred;font-weight:700;"><i class="fas fa-exclamation-circle"></i> 아이디나 비밀번호가 맞지 않습니다.</p>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>