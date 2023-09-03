<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop::상품후기</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" />
<div class="contents sub01">
    <h2 class="text-center text-white fw-bold">상품후기</h2>
    <div class="sub_content pb-5">
        <nav class="container pt-2" style="-bs-breadcrumb-divider:'>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item"><a href="${path }/myPage.do" class="text-end">마이페이지</a></li>
                <li class="breadcrumb-item"><a href="${path }/listPayProduct.do" class="text-end">나의 배송내역</a></li>
                <li class="breadcrumb-item"><a href="${path }/getPayProduct.do?dno=${dno }" class="text-end">배송상세내역</a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">후기작성</li>
            </ol>
        </nav>
        <div class="container product_area">
            <h3 class="text-center fs-1 my-5">후기 <c:if test="${pass }">수정</c:if><c:if test="${!pass }">작성</c:if></h3>
            <div class="page mb-5">
                <div class="reviewArea my-5">
                    <form action="${path }/addReviewPro.do" method="post">
                        <input type="hidden" value="${prono }" id="prono" name="prono" >
                        <input type="hidden" value="${dno }" id="dno" name="dno" >
                        <input type="hidden" value="${pass }" id="pass" name="pass">
                        <table class="table">
                            <thead>
                            <tr>
                                <th class="txt_center" colspan="2">${product.pname } 관련 리뷰</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th class="txt_center" scope="row"><label for="star" class="form-label">별점</label></th>
                                <td><input type="number" class="form-control" id="star" name="star" value="${review.star }" min="1" max="5" required></td>
                            </tr>
                            <tr>
                                <th class="txt_center" scope="row"><label for="content" class="form-label">리뷰내용</label></th>
                                <td><textarea class="form-control" id="content" name="content" rows="5" required>${review.content }</textarea></td>
                            </tr>
                            <tr>
                                <td colspan="2" class="btn_group txt_center">
                                    <button type="submit" class="inBtn">리뷰 <c:if test="${pass }">수정</c:if><c:if test="${!pass }">작성</c:if></button>
                                    <c:if test="${pass }">
                                        <a href="${path }/deleteReviewPro.do?rno=${review.rno }&dno=${dno }" class="inBtn inBtn2">리뷰삭제</a>
                                    </c:if>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
                <div class="btn_group txt_right">
                    <a class="inBtn" href="${path }/getPayProduct.do?dno=${dno }">배송상세내용으로 이동</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${path }/js/common.js"></script>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>