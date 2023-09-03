<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<header class="fixed-top border-bottom" id="hd">
    <div class="top-bar">
        <div class="content-topbar container px-0">
            <div class="right-top-bar">
                <c:if test="${sid eq 'admin' }">
                    <a href="${path }/memberListAdmin.do" class="flex-c-m trans-04 px-2">관리자페이지</a>
                </c:if>
                <c:if test="${!empty sid }">
                    <c:if test="${sid ne 'admin'}">
                        <a href="${path }/myPage.do" class="flex-c-m trans-04 px-2">마이페이지</a>
                    </c:if>
                    <a href="${path }/logout.do" class="flex-c-m trans-04 px-2">로그아웃</a>
                </c:if>
                <c:if test="${empty sid }">
                    <a href="${path }/login.do" class="flex-c-m trans-04 px-2">로그인</a>
                    <a href="${path }/joinTerm.do" class="flex-c-m trans-04 px-2">회원가입</a>
                </c:if>
            </div>
        </div>
    </div>
    <nav class="navbar container navbar-expand-lg navbar-light">
        <a class="logo" href="${path }/"><img src="${path }/image/common/logo.png" title="로켓샵 로고" alt="로켓샵 로고" />ROCKET SHOP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">상품</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="${path }/listProduct.do">전체</a></li>
                        <c:forEach items="${headerMenuCategoryList }" var="categoryList">
                            <li><a class="dropdown-item" href="${path }/listProduct.do?cateno=${categoryList.cateno }">${categoryList.cname }</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        커뮤니티
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">공지사항</a></li>
                        <li><a class="dropdown-item" href="#">묻고답하기</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">학습후기</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav justify-content-end">
                <c:if test="${!empty sid && sid ne 'admin' }">
                    <li><a class="nav-link" href="${path }/listCart.do"><i class="fas fa-cart-plus"></i></a></li>
                    <button class="nav-link" type="button">찜목록</button>
                </c:if>
            </ul>
        </div>
    </nav>
</header>