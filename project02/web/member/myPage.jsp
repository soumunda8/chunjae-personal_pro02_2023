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
        <nav class="container pt-2" style="--bs-breadcrumb-divider:url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item"><a href="${path }/myPage.do" class="text-end">마이페이지</a></li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">마이페이지</li>
            </ol>
        </nav>
        <div class="container">
            <h3 class="text-center fs-1 my-5">마이페이지</h3>
            <div class="page mb-5">
                <table>
                    <tbody>
                    <tr>
                        <th>이름</th>
                        <td>${member.name }</td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td>${member.id }</td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td>${originPw }</td>
                    </tr>
                    <tr>
                        <th>포인트</th>
                        <td>${member.point }</td>
                    </tr>
                    <tr>
                        <th>등급</th>
                        <td>${member.grade }</td>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td>${member.tel }</td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td>${member.email }</td>
                    </tr>
                    <tr>
                        <th>생일</th>
                        <td>${member.birth }</td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            [${member.acode}]
                            <c:forEach var="addrDetaild" items="${addr }">
                                ${addrDetaild }
                            </c:forEach>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>