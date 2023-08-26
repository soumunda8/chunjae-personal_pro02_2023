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
                        <li class="nav-item"><a class="nav-link" href="${path }/memberListAdmin.do"><i class="fas fa-users"></i> 회원 관리</a></li>
                        <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-shopping-cart"></i> 상품 관리</a></li>
                        <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-truck"></i> 주문 관리</a></li>
                        <li class="nav-item"><a class="nav-link active" href="${path }/categoryListAdmin.do"><i class="fas fa-layer-group"></i> 카테고리 관리<span class="sr-only">(current)</span></a></li>
                    </ul>
                </div>
            </nav>
            <div class="col-10 pt-3 px-4 border-start">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                    <h1 class="h2">카테고리 등록</h1>
                </div>
                <div class="table-responsive text-center">
                    <form action="${path}/categoryAddProAdmin.do" method="post">
                        <input type="hidden" name="par" id="par" value="${par }">
                        <table class="table table-striped-columns table-sm">
                            <colgroup>
                                <col style="width:20%">
                                <col style="width:auto">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th scope="row"><label for="cname" class="form-label">카테고리명</label></th>
                                <td><input type="text" name="cname" id="cname" class="form-control" required></td>
                            </tr>
                            <tr>
                                <th scope="row"><label for="cateno" class="form-label">카테고리아이디</label></th>
                                <td>
                                    <input type="text" name="cateno" id="cateno" class="form-control" aria-describedby="pwHelp" required>
                                    <div id="pwHelp" class="form-text">4자리로 설정해주세요.</div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="btn_group txt_right">
                            <button type="submit" class="inBtn">등록</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
