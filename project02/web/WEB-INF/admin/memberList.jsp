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
            <nav class="col-2 bg-light menu_area">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item"><a class="nav-link active" href="${path }/memberListAdmin.do"><i class="fas fa-users"></i> 회원 관리<span class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-shopping-cart"></i> 상품 관리</a></li>
                        <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-truck"></i> 주문 관리</a></li>
                        <li class="nav-item"><a class="nav-link" href="${path }/categoryListAdmin.do"><i class="fas fa-layer-group"></i> 카테고리 관리</a></li>
                    </ul>
                </div>
            </nav>
            <div class="col-10 pt-3 px-4 border-start">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                    <h1 class="h2">회원 관리</h1>
                </div>
                <div class="table-responsive text-center">
                    <table class="table table-striped table-sm">
                        <colgroup>
                            <col style="width:10%">
                            <col style="width:20%">
                            <col style="width:20%">
                            <col style="width:20%">
                            <col style="width:10%">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>이름</th>
                            <th>아이디</th>
                            <th>탈퇴 여부</th>
                            <th>비고</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="member" items="${memberList }" varStatus="status">
                            <tr>
                                <td>${status.count }</td>
                                <td>${member.name}</td>
                                <td>${member.id}</td>
                                <td>
                                    <c:if test="${member.useyn eq true}">N</c:if>
                                    <c:if test="${member.useyn eq false}">Y</c:if>
                                </td>
                                <td>
                                    <c:if test="${member.useyn eq true}">
                                    <button type="button" class="inBtn" onclick="toDeletingAccount('${member.id }')">회원탈퇴</button>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <script>
                        function toDeletingAccount(id) {
                            var check = confirm("회원탈퇴를 진행시키겠습니까?");
                            if(check) {
                                location.href = "${path }/deleteMyInfoPro.do?id="+id;
                            }
                            return false;
                        }
                    </script>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
