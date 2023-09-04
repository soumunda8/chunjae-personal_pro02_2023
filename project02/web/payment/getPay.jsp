<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RocketShop::결제</title>
    <jsp:include page="../layout/head.jsp" />
    <link rel="stylesheet" href="${path }/css/sub.css">
    <!-- 결제 api -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script>
        var IMP = window.IMP;
        IMP.init("imp42203668");

        function requestPay() {
            var email = "testimport@naver.com";
            var cname = $("#cusname").val();
            if(cname === "") {
                alert("이름을 입력해주세요");
                $("#cusname").focus();
                return false;
            }
            var tel = $("#custel").val();
            if(tel === "") {
                alert("전화번호를 입력해주세요");
                $("#custel").focus();
                return false;
            }
            var addr = $("#address1").val();
            if(addr === "" || $("#address2").val() === "") {
                alert("주소를 입력해주세요");
                $("#address1").focus();
                return false;
            }
            var postcode = $("#postcode").val();
            if(postcode === "") {
                alert("우편번호를 입력해주세요");
                $("#postcode").focus();
                return false;
            }
            var total = $("#payTotal").val();
            //alert("총금액 : " + total);
            IMP.request_pay(
                {
                    pg: "T5102001",
                    pay_method: "card",
                    merchant_uid: "rockect_product_" + new Date().getTime(),
                    name: "당근 10kg",
                    amount: total,
                    buyer_email: email,
                    buyer_name: cname,
                    buyer_tel: tel,
                    buyer_addr: addr,
                    buyer_postcode: postcode,
                },
                function (rsp) {
                    if (rsp.success) {
                        // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
                        // jQuery로 HTTP 요청
                        /*jQuery.ajax({
                            url: "{서버의 결제 정보를 받는 가맹점 endpoint}",
                            method: "POST",
                            headers: { "Content-Type": "application/json" },
                            data: {
                                imp_uid: rsp.imp_uid,            // 결제 고유번호
                                merchant_uid: rsp.merchant_uid   // 주문번호
                            }
                        }).done(function (data) {
                            // 가맹점 서버 결제 API 성공시 로직
                        })*/
                    } else {
                        //alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
                    }
                    $("#payCk").val("yes");
                    $("#buyProduct").removeClass("blind");
                    $("#payProduct").addClass("blind");
                }
            );
        }
    </script>
</head>
<body>
<jsp:include page="../layout/header.jsp" />
<div class="contents sub01">
    <h2 class="text-center text-white fw-bold">결제</h2>
    <div class="sub_content pb-5">
        <nav class="container pt-2" style="-bs-breadcrumb-divider:'>';" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${path }/" class="text-end"><i class="fas fa-home"></i></a></li>
                <li class="breadcrumb-item">장바구니</li>
                <li class="breadcrumb-item active" aria-current="page" class="text-end">결제</li>
            </ol>
        </nav>
        <div class="container product_area">
            <h3 class="text-center fs-1 my-5">결제하기</h3>
            <div class="page mb-5">
                <form class="frm" action="${path }/addPayPro.do" method="post" onsubmit="return payCheck(this)">
                    <input type="hidden" name="payCk" id="payCk" value="no">
                    <div class="row">
                        <div class="col-7 mb-2">
                            <table class="table">
                                <thead>
                                <tr class="table_head">
                                    <th colspan="2">상품</th>
                                    <th>가격</th>
                                    <th>수량</th>
                                    <th>총 금액</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cart" items="${cartList }" varStatus="status">
                                    <tr>
                                        <td>
                                            <div>
                                                <img src="${path }/storage/${cart.thumbnail }" alt="${cart.pname }">
                                            </div>
                                        </td>
                                        <td>${cart.pname }</td>
                                        <td>${cart.price } 원</td>
                                        <td>${cart.amount }</td>
                                        <td class="column-5">${cart.amount * cart.price } 원</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-5 mb-2">
                            <h4 class="pb-3">결제 금액</h4>
                            <div class="">
                                <span class="">Subtotal : ${total } 원</span>
                            </div>
                            <div class="">

                                <div>
                                    <label class="form-label" for="cusname">이름</label><br>
                                    <input type="text" name="cusname" id="cusname" placeholder="이름 입력" class="form-control" required />

                                    <label class="form-label" for="custel">전화번호</label><br>
                                    <input type="tel" name="custel" id="custel" maxlength="13" placeholder="전화번호 숫자만 입력 000-0000-0000" class="form-control" required>

                                    <label class="form-label" for="address1">주소</label><br>
                                    <input type="text" name="address1" id="address1" placeholder="기본 주소 입력" class="form-control" required />
                                    <input type="text" name="address2" id="address2" placeholder="상세 주소 입력" class="form-control" required />
                                    <input type="text" name="postcode" id="postcode" placeholder="우편번호" class="form-control">
                                    <button type="button" id="post_btn" onclick="findAddr()" class="inBtn">우편번호 검색</button>
                                </div>
                            </div>
                        </div>
                        <script src="${path }/js/common.js"></script>
                        <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
                    </div>
                    <div class="row pay_area">
                        <h3>결제 정보</h3>
                        <table class="table">
                            <tbody>
                            <tr>
                                <th><label for="pmethod">결제 수단</label></th>
                                <td>
                                    <select name="pmethod" id="pmethod">
                                        <option value="1">신용카드</option>
                                        <option value="2">체크카드</option>
                                        <option value="3">계좌이체</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><label for="pcom">결제사</label></th>
                                <td>
                                    <select name="pcom" id="pcom" class="indata">
                                        <option value="신한은행">신한은행</option>
                                        <option value="카카오뱅크">카카오뱅크</option>
                                        <option value="우리은행">우리은행</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><label for="pnum">결제 번호</label></th>
                                <td>
                                    <input type="text" name="pnum" id="pnum" class="inData" required>
                                    <input type="hidden" name="payTotal" id="payTotal" value="${total }">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="btn_group txt_center">
                            <button type="button" class="inBtn" id="payProduct" onclick="requestPay()">결제하기</button>
                            <button type="submit" class="inBtn blind" id="buyProduct">구매하기</button>
                            <p id="paymentResult" style="color:red; font-size: 20px;"></p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function payCheck(fms){
        var payCk = fms.payCk.value;
        if(payCk !== "yes"){
            alert("결제가 완료되지 않았습니다.");
            return false;
        }
    }
</script>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>