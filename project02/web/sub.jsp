<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop</title>
    <jsp:include page="./layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
</head>
<body>
<jsp:include page="./layout/header.jsp" />
<div class="contents sub01">
    <h2 class="text-center text-white fw-bold">서브페이지-1차메뉴</h2>
    <div class="sub_content pb-5">
        <nav class="container pt-2" style="-bs-breadcrumb-divider:'>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item"><a href="${path }/" class="text-end">1차메뉴</a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">2차메뉴</li>
            </ol>
        </nav>
        <div class="container">
            <h3 class="text-center fs-1 my-5">페이지명</h3>
            <div class="page mb-5" style="background-color:darkcyan">
                여기 내용이 들어갑니다.ㅇ
            </div>
        </div>
    </div>
</div>
<jsp:include page="./layout/footer.jsp" />
</body>
</html>