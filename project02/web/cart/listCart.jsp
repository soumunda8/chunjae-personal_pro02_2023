<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop::장바구니</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" />
<div class="contents sub01">
    <h2 class="text-center text-white fw-bold">장바구니</h2>
    <div class="sub_content pb-5">
        <nav class="container pt-2" style="-bs-breadcrumb-divider:'>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">장바구니</li>
            </ol>
        </nav>
        <div class="container product_area">
            <h3 class="text-center fs-1 my-5">나의 장바구니</h3>
            <div class="page mb-5">
                <table class="table">
                    <thead>
                    <tr class="table_head">
                        <th colspan="2">상품</th>
                        <th>가격</th>
                        <th>수량</th>
                        <th>총 금액</th>
                        <th>비고</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cart" items="${cartList }" varStatus="status">
                        <tr>
                            <td>
                                <div>
                                    <img src="${path }/storage/${cart.thumbnail }" alt="${cart.pname }">
                                </div>
                            </td>
                            <td><p id="productNm${status.count }">${cart.pname }</p></td>
                            <td>${cart.price } 원</td>
                            <td>
                                <div class="amountBtnArea">
                                    <div class="amountBtn amountMinus" onclick="minusProduct(${status.count })"><i class="fas fa-minus"></i></div>
                                    <input class="txt-center amountText" type="text" id="productNum${status.count }" value="${cart.amount }" readonly>
                                    <div class="amountBtn amountPlus" onclick="plusProduct(${status.count })"><i class="fas fa-plus fa-xs"></i></div>
                                    <input type="hidden" id="canAmount${status.count }" value="${cart.canAmount }">
                                </div>
                                <button type="button" class="inBtn" onclick="updateCart(${cart.amount }, ${cart.prono }, '${path }', ${status.count})">수량 변경</button>
                                <c:if test="${cart.canAmount - cart.amount < 0 }">
                                    <p id="msg${status.count }" class="no_buy">해당 상품의 구입 가능한 수량은 ${cart.canAmount }개이므로 구입 불가합니다. 구입 수량을 변경하세요.</p>
                                </c:if>
                            </td>
                            <td class="column-5">${cart.amount * cart.price } 원</td>
                            <td>
                                <button type="button" class="inBtn" onclick="removeCart(${cart.prono }, '${path }')">상품 삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty cartList }">
                        <tr>
                            <td class="text-center" colspan="6">장바구니에 등록된 상품이 없습니다.</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
                <div class="btn_group txt_right">
                    <a class="inBtn" href="${path }/getPay.do">상품 주문</a>
                    <a class="inBtn inBtn2" href="${path }/listProduct.do">쇼핑 계속하기</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${path }/js/common.js"></script>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>