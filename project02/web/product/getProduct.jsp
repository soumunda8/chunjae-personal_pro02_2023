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
        <nav class="container pt-2" style="--bs-breadcrumb-divider:url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item"><a href="${path }/" class="text-end">상품</a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">${category.cname }</li>
            </ol>
        </nav>
        <div class="container product_area">
            <h3 class="text-center fs-1 my-5">${product.pname } 상세보기</h3>
            <!---->
            <div class="container">
                <div class="box_wrap">
                    <table class="table" id="tb1">
                        <tbody>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty product.thumbnail}">
                                    <img src="${path }/storage/${product.thumbnail }" style="max-width:300px;" alt="대표 이미지">
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>도서명</th>
                            <td>${product.pname }</td>
                        </tr>
                        <tr>
                            <th>도서 설명</th>
                            <td>
                                <pre>${product.pcomment }</pre>
                            </td>
                        </tr>
                        <tr>
                            <th>도서 목차</th>
                            <td><pre>${product.plist }</pre></td>
                        </tr>
                        <tr>
                            <th>가격</th>
                            <td>${product.price } 원</td>
                        </tr>
                        <tr>
                            <th>남은 수량</th>
                            <td>
                                <c:if test="${amount <= 0}">
                                    <span>절판</span>
                                </c:if>
                                <c:if test="${amount > 0}">
                                    ${amount }
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty product.videosub}">
                                    <video id="video" style="max-width:300px" controls autoplay>
                                        <source src="${path }/storage/${product.videosub}" type="video/mp4" />
                                    </video>
                                </c:if>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="btn_group txt_right">
                        <a href="${path }/listProduct.do?cateno=${product.cateno }" class="inBtn">제품 목록</a>
                        <c:if test="${!empty sid }">
                            <a href="${path }/addPayment.do?pno=${product.prono }" class="inBtn inBtn2">구매하기</a>
                            <a href="${path }/addCart.do?pno=${product.prono }" class="inBtn">장바구니 담기</a>
                        </c:if>
                    </div>
                </div>
            <!---->
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>