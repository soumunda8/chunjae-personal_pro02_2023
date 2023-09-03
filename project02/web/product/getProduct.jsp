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
    <h2 class="text-center text-white fw-bold">상품</h2>
    <div class="sub_content pb-5">
        <nav class="container pt-2" style="--bs-breadcrumb-divider:'>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item"><a href="${path }/" class="text-end">상품</a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">${category.cname }</li>
            </ol>
        </nav>
        <div class="container product_area">
            <h3 class="text-center fs-1 my-5">${product.pname } 상세보기</h3>
            <div class="container">
                <div class="box_wrap">
                    <input type="hidden" value="${product.prono }" id="proNo">
                    <ul class="productDetail">
                        <li class="pay_list">
                            <div class="pay_thumbnail"><img src="${path }/storage/${product.thumbnail }" alt="${product.pname }"></div>
                            <div class="pay_detail">
                                <table class="table">
                                    <colgroup>
                                        <col style="width:20%;">
                                        <col style="width:80%;">
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                        <th>도서명</th>
                                        <td class="table_title">${product.pname }</td>
                                    </tr>
                                    <tr>
                                        <th>가격</th>
                                        <td class="table_title">${product.price }</td>
                                    </tr>
                                    <c:if test="${!empty sid }">
                                    <tr>
                                        <th>갯수</th>
                                        <td class="table_title">
                                            <c:if test="${amount <= 0}">
                                                <span>절판</span>
                                            </c:if>
                                            <c:if test="${amount > 0 }">
                                                <div class="amountBtnArea">
                                                    <div class="amountBtn amountMinus" onclick="minusProduct(1)"><i class="fas fa-minus"></i></div>
                                                    <input class="txt-center amountText" type="text" id="productNum1" value="1" readonly>
                                                    <div class="amountBtn amountPlus" onclick="plusProduct(1)"><i class="fas fa-plus fa-xs"></i></div>
                                                </div>
                                                <button type="button" class="inBtn" onclick="addCart('${path }', 1)">장바구니 담기</button>
                                                <%--<button type="button" class="inBtn" data-bs-toggle="modal" data-bs-target="#cartModal">장바구니 담기</button>--%>
                                            </c:if>
                                        </td>
                                    </tr>
                                    </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </li>
                    </ul>
                    <ul class="nav nav-tabs my-5" id="myTab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" id="productInfoArea-tab" data-bs-toggle="tab" data-bs-target="#productInfoArea" type="button" role="tab" aria-controls="productInfoArea" aria-selected="true">도서 상세정보</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="productReviewArea-tab" data-bs-toggle="tab" data-bs-target="#productReviewArea" type="button" role="tab" aria-controls="productReviewArea" aria-selected="false">도서 리뷰</button>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="productInfoArea" role="tabpanel" aria-labelledby="productInfoArea-tab">
                            <table class="table productInfo">
                                <tbody>
                                <tr>
                                    <th>도서 목차</th>
                                    <td>
                                        <pre>${product.plist }</pre>
                                    </td>
                                </tr>
                                <tr>
                                    <th>도서 설명</th>
                                    <td>
                                        <c:if test="${!empty product.videosub}">
                                            <video id="video" style="max-width:300px;margin-bottom:20px;" controls autoplay>
                                                <source src="${path }/storage/${product.videosub}" type="video/mp4" />
                                            </video>
                                        </c:if>
                                        <pre>${product.pcomment }</pre>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane fade" id="productReviewArea" role="tabpanel" aria-labelledby="productReviewArea-tab">
                            <c:if test="${!empty reviewList}">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>리뷰내용</th>
                                        <th>별점</th>
                                        <th>비고</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${reviewList }" var="review" varStatus="status">
                                        <tr>
                                            <td>${status.count }</td>
                                            <td>${review.content }</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${review.star eq 5}">★★★★★</c:when>
                                                    <c:when test="${review.star eq 4}">★★★★</c:when>
                                                    <c:when test="${review.star eq 3}">★★★</c:when>
                                                    <c:when test="${review.star eq 2}">★★</c:when>
                                                    <c:when test="${review.star eq 1}">★</c:when>
                                                    <c:otherwise>0</c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:if test="${sid eq 'admin' || sid eq review.author}">
                                                    <a href="${path }/deleteReviewPro.do?rno=${review.rno }&dno=0">리뷰삭제</a>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                            <c:if test="${empty reviewList}">
                                <p class="text-center">등록된 리뷰가 없습니다.</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="btn_group txt_right">
                        <a href="${path }/listProduct.do?cateno=${product.cateno }" class="inBtn">제품 목록</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--<div class="modal fade" id="cartModal" tabindex="-1" aria-labelledby="cartModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <h1 class="modal-title fs-5 text-center border-bottom py-2" id="cartModalLabel">${product.pname }</h1>
                    <p class="text-center pt-4">장바구니에 담으시겠습니까?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                    <button type="button" class="btn btn-primary" onclick="addCart()">장바구니에 담기</button>
                </div>
            </div>
        </div>
    </div>--%>
    <script src="${path }/js/common.js"></script>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>