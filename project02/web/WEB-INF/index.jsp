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
<jsp:include page="../layout/header.jsp" />
<div class="contents pt-4 pb-4">
    <div class="container">

    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>