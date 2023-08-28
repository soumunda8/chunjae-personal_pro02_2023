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
            <h3 class="text-center fs-1 my-5">${category.cname }</h3>
            <div class="page mb-5">
                <div class="card-deck">
                    <c:forEach items="${productList }" var="product">
                        <div class="card col-2">
                            <img class="card-img-top" src="${path }/storage/${product.thumbnail }" alt="${product.pname }">
                            <div class="card-body">
                                <h5 class="card-title" style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">${product.pname }</h5>
                                <p class="card-text">가격 : ${product.price } 원</p>
                                <a href="${path }/getProduct.do?prono=${product.prono }" class="btn btn-primary">상세보기</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <c:if test="${empty productList}">
                    <div class="col-12 text-center">해당 상품이 존재하지 않습니다.</div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>