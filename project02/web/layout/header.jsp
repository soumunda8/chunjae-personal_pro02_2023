<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.rocket.model.CategoryDAO" %>
<%@ page import="com.rocket.dto.Category" %>
<%@ page import="java.util.List" %>
<c:set var="headerPath" value="<%=request.getContextPath() %>" />
<header class="fixed-top border-bottom" id="hd">
    <div class="top-bar">
        <div class="content-topbar container px-0">
            <div class="right-top-bar">
                <c:if test="${sid eq 'admin' }">
                    <a href="${headerPath }/memberListAdmin.do" class="flex-c-m trans-04 px-2">관리자페이지</a>
                </c:if>
                <c:if test="${!empty sid }">
                    <c:if test="${sid ne 'admin'}">
                        <a href="${headerPath }/myPage.do" class="flex-c-m trans-04 px-2">마이페이지</a>
                    </c:if>
                    <a href="${headerPath }/logout.do" class="flex-c-m trans-04 px-2">로그아웃</a>
                </c:if>
                <c:if test="${empty sid }">
                    <a href="${headerPath }/login.do" class="flex-c-m trans-04 px-2">로그인</a>
                    <a href="${headerPath }/joinTerm.do" class="flex-c-m trans-04 px-2">회원가입</a>
                </c:if>
            </div>
        </div>
    </div>
    <nav class="navbar container navbar-expand-lg navbar-light">
        <a class="logo" href="${headerPath }/"><img src="${headerPath }/image/common/logo.png" title="로켓샵 로고" alt="로켓샵 로고" />ROCKET SHOP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">상품</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="${headerPath }/listProduct.do">전체</a></li>
                        <c:forEach items="${categoryHeaderList }" var="categoryList">
                            <li><a class="dropdown-item" href="${headerPath }/listProduct.do?cateno=${categoryList.cateno }">${categoryList.cname }</a></li>
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
                    <button class="nav-link" type="button" data-bs-toggle="offcanvas" data-bs-target="#showCart" aria-controls="offcanvasRight"><i class="fas fa-cart-plus"></i></button>
                </c:if>
            </ul>
        </div>
    </nav>
</header>
<c:if test="${!empty sid && sid ne 'admin' }">
<div class="offcanvas offcanvas-end p-5" tabindex="-1" id="showCart" aria-labelledby="showCartLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="showCartLabel">나의 장바구니</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <ul class="p-0">
            <c:forEach var="lists" items="${cartList }">
            <li class="py-2">
                <div class="cart-item-img">
                    <img src="${headerPath }/storage/${lists.thumbnail }" alt="${lists.pname }">
                </div>
                <div class="cart-item-txt">
                    <a href="${headerPath }/getProduct.do?prono=${lists.prono}" class="cart-item-name">${lists.pname }</a>
                    <span class="cart-item-info">${lists.amount } x ${lists.price }</span>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
    <div class="btn_group">
        <a class="inBtn">구매하기</a>
        <a class="inBtn inBtn2">비우기</a>
    </div>
</div>
</c:if>