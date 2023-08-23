<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="footerPath" value="<%=request.getContextPath() %>" />
<footer class="footer" id="ft">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link" href="#">회원약관</a>
                    <a class="nav-link" href="#">개인정보처리방침</a>
                    <a class="nav-link" href="#">이메일수집거부</a>
                    <a class="nav-link" href="#">고객센터</a>
                </div>
            </div>
        </div>
    </nav>
    <div class="container text-center">
        <div class="row">
            <div class="col">COPYRIGHT ©2023 RocketShop. ALL RIGHTS RESERVED.</div>
            <div class="col">RocketShop</div>
            <div class="col"><img src="${footerPath }/image/common/ft_logo.png" alt="RocketShop 푸터 로고"><p>RocketShop</p></div>
        </div>
    </div>
</footer>