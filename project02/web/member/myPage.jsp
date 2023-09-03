<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop::마이페이지</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" />
<div class="contents sub01">
    <h2 class="text-center text-white fw-bold">마이페이지</h2>
    <div class="sub_content pb-5">
        <nav class="container pt-2" style="-bs-breadcrumb-divider:'>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item"><a href="${path }/myPage.do" class="text-end">마이페이지</a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">내정보</li>
            </ol>
        </nav>
        <div class="container">
            <ul class="nav nav-tabs my-5">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${path }/myPage.do">내정보</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${path }/listPayProduct.do">나의 배송내역</a>
                </li>
            </ul>
            <h3 class="text-center fs-1 my-5">내정보</h3>
            <div class="page mb-5">
                <table class="table table-striped-columns">
                    <tbody>
                    <tr>
                        <th scope="row">이름</th>
                        <td>${member.name }</td>
                    </tr>
                    <tr>
                        <th scope="row">아이디</th>
                        <td>${member.id }</td>
                    </tr>
                    <tr>
                        <th scope="row">비밀번호</th>
                        <td>${originPw }</td>
                    </tr>
                    <tr>
                        <th scope="row">포인트</th>
                        <td>${member.point }</td>
                    </tr>
                    <tr>
                        <th scope="row">등급</th>
                        <td>${member.grade }</td>
                    </tr>
                    <tr>
                        <th scope="row">전화번호</th>
                        <td>${member.tel }</td>
                    </tr>
                    <tr>
                        <th scope="row">이메일</th>
                        <td>${member.email }</td>
                    </tr>
                    <tr>
                        <th scope="row">생일</th>
                        <td>${member.birth }</td>
                    </tr>
                    <tr>
                        <th scope="row">주소</th>
                        <td>
                            [${member.acode}]
                            <c:forEach var="addrDetaild" items="${addr }">
                                ${addrDetaild }
                            </c:forEach>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn_group txt_right">
                    <a href="${path }/modifyMyInfo.do" class="inBtn">회원정보수정</a>
                    <button type="button" class="inBtn inBtn2" onclick="toDeletingAccount('${member.id }')">회원탈퇴</button>
                </div>
                <script>
                    function toDeletingAccount(id) {
                        var check = confirm("회원탈퇴를 하시겠습니까?");
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
<jsp:include page="../layout/footer.jsp" />
</body>
</html>