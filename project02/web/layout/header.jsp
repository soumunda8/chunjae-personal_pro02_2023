<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="headerPath" value="<%=request.getContextPath() %>" />
<header class="fixed-top" id="hd">
    <nav class="navbar container navbar-expand-lg navbar-light">
        <a class="logo" href="${headerPath }/"><img src="${headerPath }/image/common/logo.png" title="로켓샵 로고" alt="로켓샵 로고" />ROCKET SHOP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="${headerPath }/sub.do" role="button" data-bs-toggle="dropdown" aria-expanded="false">상품</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="${headerPath }/sub.do">교과서</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">참고서</a></li>
                        <li><a class="dropdown-item" href="#">문제집</a></li>
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
                <c:if test="${sid eq 'admin' }">
                    <li class="nav-item"><a href="${headerPath }/memberListAdmin.do" class="nav-link">관리자페이지</a></li>
                </c:if>
                <c:if test="${!empty sid }">
                    <c:if test="${sid ne 'admin'}">
                        <li class="nav-item"><a href="${headerPath }/myPage.do" class="nav-link">마이페이지</a></li>
                    </c:if>
                    <li class="nav-item"><a href="${headerPath }/logout.do" class="nav-link">로그아웃</a></li>
                </c:if>
                <c:if test="${empty sid }">
                    <li class="nav-item"><a href="${headerPath }/login.do" class="nav-link">로그인</a></li>
                    <li class="nav-item"><a href="${headerPath }/joinTerm.do" class="nav-link">회원가입</a></li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>