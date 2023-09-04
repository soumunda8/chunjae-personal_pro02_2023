<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/main.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" />
<div class="contents pt-4 pb-4">
    <div class="container">
        <section class="visual_area">
            <article class="data">
                <section id="visual">
                    <div class="img_box">
                        <a href="">
                            <img src="${path }/image/main/main_visual01.png" alt="메인비쥬얼1">
                        </a>
                        <a href="">
                            <img src="${path }/image/main/main_visual02.png" alt="메인비쥬얼2">
                        </a>
                    </div>
                </section>
                <section id="btn_box">
                    <a class="left">&lt;</a><a class="right">&gt;</a>
                </section>
            </article>
        </section>
        <section>
            <h2 class="text-center">신상품</h2>
            <div class="page mb-5">
                <div class="card-deck">
                    <c:forEach items="${productList }" var="product" varStatus="status">
                        <div class="card col-2">
                            <img class="card-img-top" src="${path }/storage/${product.thumbnail }" alt="${product.pname }">
                            <div class="card-body">
                                <h5 class="card-title" style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">${product.pname }</h5>
                                <p class="card-text">가격 : ${product.price } 원</p>
                                <a href="${path }/getProduct.do?prono=${product.prono }" class="btn btn-primary">상세보기</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <c:if test="${empty productList}">
                    <div class="col-12 text-center">해당 상품이 존재하지 않습니다.</div>
                </c:if>
            </div>
        </section>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>
<script>
    $(document).ready(function(){

        var wd = $("#visual").width();
        var len = $(".img_box a").length;
        var intv = setInterval(function(){ nextAni();}, 3500);

        $(".img_box a").each(function(index){
            $(this).find(".num").text(index + 1);
        });

        $("#btn_box .right").click(function(){
            clearInterval(intv);
            nextAni();
            intv = setInterval(function() { nextAni() }, 3500)
        });

        $("#btn_box .left").click(function(){
            clearInterval(intv);
            prevAni();
            intv = setInterval(function() { prevAni() }, 3500)
        });

        function prevAni() {
            $(".img_box a:last").prependTo($(".img_box")) ;
            $(".img_box").css("margin-left", -wd + "px");
            $(".img_box").not(":animated").animate({"margin-left" : "0px"}, 500);
        }

        function nextAni() {
            $(".img_box").not(":animated").animate({"margin-left" : -wd + "px"}, 500, function(){
                $(".img_box a").eq(0).appendTo($(".img_box"));
                $(".img_box").css("margin-left", "0px");
            });
        }

    });
</script>
