<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="footerPath" value="<%=request.getContextPath() %>" />
<footer class="text-center text-white" id="ft">
    <section class="container">
        <div class="row text-center d-flex justify-content-center pt-4">
            <div class="col-md-2"><h6 class="text-uppercase font-weight-bold"><a href="${footerPath }/" class="fs-6 text-white">회원약관</a></h6></div>
            <div class="col-md-2"><h6 class="text-uppercase font-weight-bold"><a href="${footerPath }/" class="fs-6 text-white">개인정보처리방침</a></h6></div>
            <div class="col-md-2"><h6 class="text-uppercase font-weight-bold"><a href="${footerPath }/" class="fs-6 text-white">이메일수집거부</a></h6></div>
            <div class="col-md-2"><h6 class="text-uppercase font-weight-bold"><a href="${footerPath }/" class="fs-6 text-white">고객센터</a></h6></div>
        </div>
    </section>
    <hr class="my-3" />
    <section class="container mb-2">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-8">
                <p class="text-center fs-6 text-white">서울시 금천구 가산로9길 54</p>
                <p class="text-center fs-6 text-white">대표전화 : XXX-XXX-XXXX</p>
                <p class="text-center fs-6 text-white">FAX : XXX-XXX-XXXX</p>
                <p class="text-center fs-6 text-white">admin@rocketshop.com</p>
            </div>
        </div>
    </section>
    <div class="text-center text-white p-3 fs-6 copyright">COPYRIGHT ©2023 RocketShop. ALL RIGHTS RESERVED.</div>
</footer>