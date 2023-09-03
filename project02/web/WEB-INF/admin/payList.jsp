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
                    <h1 class="h2">주문 관리</h1>
                </div>
                <div class="table-responsive text-center">
                    <table class="table table-striped table-sm">
                        <colgroup>
                            <col style="width:10%">
                            <col style="width:40%">
                            <col style="width:20%">
                            <col style="width:10%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th class="table_title">배송</th>
                            <th>배송상태</th>
                            <th>비고</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="delivery" items="${deliveryList }" varStatus="status">
                            <tr>
                                <td>${status.count }</td>
                                <td class="table_title"><a href="${path }/payGetAdmin.do?dno=${delivery.dno }">${delivery.author } 님의 주문내역</a></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${delivery.status eq 0 }">배송전</c:when>
                                        <c:when test="${delivery.status eq 1 }">배송중</c:when>
                                        <c:when test="${delivery.status eq 2 }">배송완료</c:when>
                                        <c:when test="${delivery.status eq 3 }">구매확정</c:when>
                                        <c:otherwise>구매취소</c:otherwise>
                                    </c:choose>
                                </td>
                                <td></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${deliveryList.size() < 1 }">
                            <tr>
                                <td colspan="4">등록된 주문이 없습니다.</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
