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
                <h1 class="h2">상품 등록</h1>
            </div>
            <div class="table-responsive text-center">
                <form action="${path}/addProductPro.do" method="post" enctype="multipart/form-data">
                    <table class="table table-striped-columns table-sm">
                        <colgroup>
                            <col style="width:20%">
                            <col style="width:auto">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row"><label for="pname" class="form-label">상품명</label></th>
                            <td><input type="text" name="pname" id="pname" class="form-control" placeholder="상품명 입력" maxlength="90" required></td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="cateno" class="form-label">카테고리</label></th>
                            <td>
                                <div class="form-row">
                                    <select name="cateno" id="cateno" class="form-control">
                                        <option value="no_category">선택안함</option>
                                        <c:forEach items="${categoryList }" var="category" varStatus="status">
                                            <option value="${category.cateno}">${category.cname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="price" class="form-label">상품가격</label></th>
                            <td>
                                <input type="number" name="price" id="price"  placeholder="상품 가격 입력" class="form-control" value="1000" min="1000" step="100" required>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="pcomment" class="form-label">상품설명</label></th>
                            <td>
                                <textarea rows="10" cols="100" name="pcomment" id="pcomment" placeholder="상품의 자세한 정보를 입력하세요" class="form-control" maxlength="1990" required></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="plist" class="form-label">상품목차</label></th>
                            <td>
                                <textarea rows="10" cols="100" name="plist" id="plist" placeholder="도서 상품의 목차를 입력하세요" class="form-control" maxlength="1990" required></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="thumbnail" class="form-label">상품 메인 이미지</label></th>
                            <td>
                                <input type="file" name="thumbnail" id="thumbnail" placeholder="상품 메인이미지" class="form-control" required>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="videosub" class="form-label">맛보기영상</label></th>
                            <td>
                                <input type="file" name="videosub" id="videosub" placeholder="상품 추가 영상" class="form-control">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="btn_group txt_right">
                        <button type="submit" class="inBtn">등록</button>
                        <a href="${path }/productListAdmin.do" class="inBtn inBtn2">목록</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>