<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>관리자::RocketShop</title>
    <jsp:include page="../../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/admin.css">
</head>
<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0 logo" href="${path }/"><img src="${path }/image/common/logo.png" title="로켓샵 로고" alt="로켓샵 로고" />ROCKET SHOP</a>
    <ul class="navbar-nav px-4">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="${path }/logout.do">로그아웃</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="../../layout/adminHeader.jsp" />
        <div class="col-10 pt-3 px-4 border-start">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h1 class="h2">${prodcut.pname } 상세보기</h1>
            </div>
            <div class="table-responsive text-center">
                <table class="table table-striped-columns table-sm">
                    <colgroup>
                        <col style="width:20%">
                        <col style="width:auto">
                    </colgroup>
                    <tbody>
                    <tr>
                        <th scope="row">상품명</th>
                        <td>${product.pname }</td>
                    </tr>
                    <tr>
                        <th scope="row">카테고리</th>
                        <td>${product.cname}</td>
                    </tr>
                    <tr>
                        <th scope="row">상품가격</th>
                        <td>${product.price } 원</td>
                    </tr>
                    <tr>
                        <th scope="row">상품수량</th>
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
                        <th scope="row">상품설명</th>
                        <td>${product.pcomment }</td>
                    </tr>
                    <tr>
                        <th scope="row">상품목차</th>
                        <td>${product.plist }</td>
                    </tr>
                    <tr>
                        <th scope="row">상품 메인 이미지</th>
                        <td>
                            <img src="${path }/storage/${product.thumbnail}" alt="${product.pname }" style="max-width:300px">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">맛보기영상</th>
                        <td>
                            <video id="video" style="max-width:300px" controls autoplay>
                                <source src="${path }/storage/${product.videosub}" type="video/mp4" />
                            </video>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn_group txt_right">
                    <a href="${path }/deleteProductPro.do?prono=${product.prono }" class="inBtn">상품 삭제</a>
                    <a href="${path }/noUseProductPro.do?prono=${product.prono }&useyn=${!product.useyn }" class="inBtn inBtn2">상품 판매<c:if test="${product.useyn eq true}"> 중지</c:if></a>
                    <a href="${path }/productModifyAdmin.do?prono=${product.prono }" class="inBtn">수정</a>
                    <a href="${path }/addReceiveAdmin.do?prono=${product.prono }" class="inBtn inBtn2">상품 입고</a>
                    <a href="${path }/productListAdmin.do" class="inBtn">목록</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>