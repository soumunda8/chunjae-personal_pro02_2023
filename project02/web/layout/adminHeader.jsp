<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<nav class="col-2 bg-light menu_area">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item"><a class="nav-link<c:if test="${page eq 'member'}"> active</c:if>" href="${path }/memberListAdmin.do"><i class="fas fa-users"></i> 회원 관리<span class="sr-only">(current)</span></a></li>
            <li class="nav-item"><a class="nav-link<c:if test="${page eq 'product'}"> active</c:if>" href="${path }/productListAdmin.do"><i class="fas fa-shopping-cart"></i> 상품 관리</a></li>
            <li class="nav-item"><a class="nav-link<c:if test="${page eq 'order'}"> active</c:if>" href="${path }/memberListAdmin.do"><i class="fas fa-truck"></i> 주문 관리</a></li>
            <li class="nav-item"><a class="nav-link<c:if test="${page eq 'category'}"> active</c:if>" href="${path }/categoryListAdmin.do"><i class="fas fa-layer-group"></i> 카테고리 관리</a></li>
        </ul>
    </div>
</nav>