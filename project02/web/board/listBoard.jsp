<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" />
<div class="contents sub01">
    <h2 class="text-center text-white fw-bold">공지사항</h2>
    <div class="sub_content pb-5">
        <nav class="container pt-2" style="-bs-breadcrumb-divider:'>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item"><a href="${path }/" class="text-end">커뮤니티</a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">공지사항</li>
            </ol>
        </nav>
        <div class="container product_area">
            <h3 class="text-center fs-1 my-5">공지사항</h3>
            <div class="page mb-5">
                <table class="table">
                    <thead>
                    <tr>
                        <th>연번</th>
                        <th>제목</th>
                        <th>작성자</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${boardList }" var="board" varStatus="status">
                        <tr>
                            <td>${status.count }</td>
                            <td><a href="${path }/getBoard.do?bno=${board.bno }">${board.title }</a></td>
                            <td>${board.author }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <c:if test="${sid eq 'admin'}">
                    <div class="btn_group txt_right">
                        <a href="${path }/addBoard.do" class="inBtn">글쓰기</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>