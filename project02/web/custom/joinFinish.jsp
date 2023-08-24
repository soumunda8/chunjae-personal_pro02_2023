<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop::회원가입</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
</head>
<body>
<section class="bg-image join_finish">
    <div class="mask d-flex align-items-center">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card">
                        <div class="card-body p-5">

                            <a class="logo text-center" href="${path }/"><img src="${path }/image/common/logo.png" title="로켓샵 로고" alt="로켓샵 로고" />RocketShop</a>

                            <h2 class="text-uppercase text-center mb-5">회원가입완료</h2>

                            <p class="text-center text-muted mt-4 mb-0">회원가입을 축하드립니다!</p>

                            <p class="text-center text-muted mt-4 mb-0">
                                <a href="${path }/">홈으로</a>
                            </p>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>