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
                    <h1 class="h2">카테고리 관리</h1>
                </div>
                <ul class="nav nav-tabs my-3">
                    <li class="nav-item">
                        <a class="nav-link no_btn <c:if test="${type eq 'board'}">active</c:if>" aria-current="page" href="${path }/categoryListAdmin.do?type=board">게시판</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link no_btn <c:if test="${type eq 'product'}">active</c:if>" href="${path }/categoryListAdmin.do?type=product">상품</a>
                    </li>
                </ul>
                <div class="table-responsive text-center">
                    <table class="table table-striped table-sm">
                        <colgroup>
                            <col style="width:10%">
                            <col style="width:40%">
                            <col style="width:auto">
                        </colgroup>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>카테고리명</th>
                            <th>비고</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="category" items="${categoryList }" varStatus="status">
                            <tr>
                                <td>${status.count }</td>
                                <td>${category.cname}</td>
                                <td>
                                    <a href="${path}/categoryModifyAdmin.do?id=${category.cateno }" class="inBtn">수정</a>
                                    <button type="button" class="inBtn inBtn2" onclick="toDelete('${category.cateno }', '${category.par }')">삭제</button>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${categoryList.size() < 1 }">
                            <tr>
                                <td colspan="3">등록된 카테고리가 없습니다.</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                    <div class="btn_group txt_right">
                        <a href="${path}/categoryAddAdmin.do?type=${type }" class="inBtn">등록</a>
                    </div>
                    <script>
                        function toDelete(id, par) {
                            var check = confirm("카테고리를 삭제하겠습니까?");
                            if(check) {
                                location.href = "${path }/deleteCategoryPro.do?id="+id+"&par="+par;
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
