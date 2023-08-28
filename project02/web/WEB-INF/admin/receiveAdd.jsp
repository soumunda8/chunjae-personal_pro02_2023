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
                <h1 class="h2">${product.pname } 상품 입고</h1>
            </div>
            <div class="table-responsive text-center">
                <form action="${path}/addReceivePro.do" method="post">
                    <table class="table table-striped-columns table-sm">
                        <colgroup>
                            <col style="width:20%">
                            <col style="width:auto">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row">상품명</th>
                            <td class="text-left">
                                ${product.pname }
                                <input type="hidden" value="${product.prono}" name="prono" id="prono">
                            </td>
                        </tr>
                        <tr>
                            <th><label for="amount">수량</label></th>
                            <td><input type="number" name="amount" id="amount" placeholder="입고 수량 입력" class="form-control" value="1" min="1" max="1000" required></td>
                        </tr>
                        <tr>
                            <th><label for="rprice">가격</label></th>
                            <td><input type="number" name="rprice" id="rprice" placeholder="입고 가격 입력" class="form-control" value="" min="1000" required></td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="btn_group txt_right">
                        <input type="submit" class="inBtn" value="상품입고">
                        <a href="${path }/productListAdmin.do" class="inBtn inBtn2">목록</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>