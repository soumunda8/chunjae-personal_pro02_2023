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
                <form action="${path }/modifyBoardPro.do" method="post">
                    <input type="hidden" name="bno" value="${board.bno }">
                    <table class="table">
                        <tbody>
                        <tr>
                            <th><label for="title">제목</label></th>
                            <td><input type="text" id="title" name="title" class="form-control" value="${board.title }"></td>
                        </tr>
                        <tr>
                            <th><label for="content">내용</label></th>
                            <td><textarea class="form-control" id="content" name="content" rows="5" required>${board.content }</textarea></td>
                        </tr>
                        </tbody>
                    </table>
                    <c:if test="${sid eq 'admin'}">
                        <div class="btn_group">
                            <button type="submit" class="inBtn">글수정</button>
                        </div>
                    </c:if>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>