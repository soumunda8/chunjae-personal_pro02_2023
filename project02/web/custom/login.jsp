<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop::로그인</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
</head>
<body>
<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-4">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp" class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-3 offset-xl-1">
                <form action="${path }/loginPro.do" method="post">
                    <div class="d-flex flex-row align-items-center justify-content-md-center">
                        <a class="lead fw-normal mb-0 me-3" href="${path }/">Rocket Shop</a>
                    </div>

                    <div class="divider d-flex align-items-center my-4">
                        <p class="text-center fw-bold mx-3 mb-0">Or</p>
                    </div>

                    <div class="form-outline mb-4">
                        <input type="text" id="form3Example3" name="id" class="form-control form-control-lg" placeholder="아이디를 입력하세요." />
                        <label class="form-label blind" for="form3Example3">아이디</label>
                    </div>
                    <div class="form-outline mb-3">
                        <input type="password" id="form3Example4" name="pw"  class="form-control form-control-lg" placeholder="비밀번호를 입력하세요." />
                        <label class="form-label blind" for="form3Example4">비밀번호</label>
                    </div>
                    <c:if test="${msg eq 'fail' }">
                    <div class="d-flex justify-content-md-center align-items-center">
                        <p class="link-danger" style="font-weight:700;"><i class="fas fa-exclamation-circle"></i> 아이디나 비밀번호가 맞지 않습니다.</p>
                    </div>
                    </c:if>
                    <div class="text-center mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg btn-block" style="padding-left:3.5rem; padding-right:3.5rem;">로그인</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">회원이 아니신가요? <a href="#!" class="link-danger">회원가입</a></p>
                        <p class="small fw-bold mt-2 pt-1 mb-0">비밀번호가 기억나지 않으신가요? <a href="#!" class="link-danger">비밀번호 찾기</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="d-flex flex-column flex-md-row text-center align-items-center justify-content-md-center py-4 px-4 px-xl-5  bg-primary">
        <div class="text-white mb-3 mb-md-0">
            COPYRIGHT ©2023 RocketShop. ALL RIGHTS RESERVED.
        </div>
    </div>
</section>
</body>
</html>