<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop::배송내역</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" />
<div class="contents sub01">
    <h2 class="text-center text-white fw-bold">배송내역</h2>
    <div class="sub_content pb-5">
        <nav class="container pt-2" style="-bs-breadcrumb-divider:'>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item"><a href="${path }/myPage.do" class="text-end">마이페이지</a></li>
                <li class="breadcrumb-item"><a href="${path }/listPayProduct.do" class="text-end">나의 배송내역</a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">배송상세내역</li>
            </ol>
        </nav>
        <div class="container product_area">
            <ul class="nav nav-tabs my-5">
                <li class="nav-item">
                    <a class="nav-link" href="${path }/myPage.do">내정보</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${path }/listPayProduct.do">나의 배송내역</a>
                </li>
            </ul>
            <h3 class="text-center fs-1 my-5">배송상세내역</h3>
            <div class="page mb-5">
                <div>
                    <ul>
                        <c:forEach var="payProduct" items="${paymentList }" varStatus="status">
                            <li class="pay_list mb-5">
                                <div class="pay_thumbnail"><img src="${path }/storage/${payProduct.thumbnail }" alt="${payProduct.pname }"></div>
                                <div class="pay_detail">
                                    <p class="pay_title">
                                        <a href="${path }/getProduct.do?prono=${payProduct.prono }" class="text-left">
                                            <span>
                                            <c:choose>
                                                <c:when test="${payProduct.dstatus eq 0 }">배송전</c:when>
                                                <c:when test="${payProduct.dstatus eq 1 }">배송중</c:when>
                                                <c:when test="${payProduct.dstatus eq 2 }">배송완료</c:when>
                                                <c:when test="${payProduct.dstatus eq 3 }">구매확정</c:when>
                                                <c:otherwise>구매취소</c:otherwise>
                                            </c:choose>
                                            </span>
                                                ${payProduct.pname }
                                        </a>
                                    </p>
                                    <p class="pay_total_price">상품 총 구매금액 : ${payProduct.payprice * payProduct.amount } 원</p>
                                    <p class="pay_price">상품 금액 : ${payProduct.payprice } 원</p>
                                    <p class="pay_amount">주문 수량 : ${payProduct.amount } 개</p>
                                    <c:if test="${payProduct.dstatus eq 1 || payProduct.dstatus eq 2 || payProduct.dstatus eq 3 }">
                                        <p class="pay_delivery_date">도착(예정)일 : ${payProduct.rdate }</p>
                                    </c:if>
                                </div>
                                <c:if test="${payProduct.dstatus eq 3 }">
                                    <div class="btn_group txt_right">
                                        <a href="${path }/getReview.do?prono=${payProduct.prono }&dno=${payProduct.dno}" type="submit" class="inBtn">리뷰 등록</a>
                                    </div>
                                </c:if>
                            </li>
                        </c:forEach>
                    </ul>
                    <c:if test="${delivery.status ne 4 }">
                    <table class="table">
                        <colgroup>
                            <col style="width:20%;">
                            <col style="width:80%;">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>배송 상태</th>
                            <td>
                                <c:choose>
                                    <c:when test="${delivery.status eq 0 }">배송전</c:when>
                                    <c:when test="${delivery.status eq 1 }">배송중</c:when>
                                    <c:when test="${delivery.status eq 2 }">배송완료</c:when>
                                    <c:when test="${delivery.status eq 3 }">구매확정</c:when>
                                    <c:otherwise>구매취소</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>배송 번호</th>
                            <td>${delivery.dnum }</td>
                        </tr>
                        <tr>
                            <th>배송 회사 전화번호</th>
                            <td>${delivery.dtel }</td>
                        </tr>
                        <tr>
                            <th>화물 코드</th>
                            <td>${delivery.dcode }</td>
                        </tr>
                        <tr>
                            <th>도착 예정일</th>
                            <td>${delivery.rdate }</td>
                        </tr>
                        </tbody>
                    </table>
                    </c:if>
                </div>
                <div class="btn_group txt_right">
                    <a class="inBtn" href="${path }/listPayProduct.do">목록보기</a>
                    <c:if test="${delivery.status eq 0 }">
                        <a class="inBtn inBtn2" href="${path }/cancelPayPro.do?dno=${delivery.dno }">구매취소</a>
                    </c:if>
                    <c:if test="${delivery.status eq 2 }">
                        <a class="inBtn inBtn2" href="${path }/modifyDeliveryStatusPro.do?dno=${delivery.dno }&status=3">구매확정</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${path }/js/common.js"></script>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>