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
                    <h1 class="h2">주문 관리 상세</h1>
                </div>
                <div class="table-responsive text-center">
                    <ul>
                        <c:forEach var="pay" items="${payList }" varStatus="status">
                            <li class="pay_list">
                                <div class="pay_thumbnail"><img src="${path }/storage/${pay.thumbnail }" alt="${pay.pname }"></div>
                                <div class="pay_detail">
                                    <p class="pay_title">
                                        <a href="${path }/getProduct.do?prono=${pay.prono }" class="text-left">
                                            <span>
                                            <c:choose>
                                                <c:when test="${pay.dstatus eq 0 }">배송전</c:when>
                                                <c:when test="${pay.dstatus eq 1 }">배송중</c:when>
                                                <c:when test="${pay.dstatus eq 2 }">배송완료</c:when>
                                                <c:when test="${pay.dstatus eq 3 }">구매확정</c:when>
                                                <c:otherwise>구매취소</c:otherwise>
                                            </c:choose>
                                            </span>
                                            ${pay.pname }
                                        </a>
                                    </p>
                                    <p class="pay_total_price">상품 총 구매금액 : ${pay.payprice * pay.amount } 원</p>
                                    <p class="pay_price">상품 금액 : ${pay.payprice } 원</p>
                                    <p class="pay_amount">주문 수량 : ${pay.amount } 개</p>
                                    <c:if test="${delivery.status eq 1 || delivery.status eq 2 || delivery.status eq 3 }">
                                        <p class="pay_delivery_date">도착(예정)일 : ${pay.rdate }</p>
                                    </c:if>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <c:if test="${delivery.status eq 0 || delivery.status eq 1 || delivery.status eq 2 }">
                    <form action="${path }/modifyDeliveryStatusPro.do" method="get">
                        <input type="hidden" name="dno" id="dno" value="${delivery.dno }">
                        <table class="table">
                            <colgroup>
                                <col style="width:20%;">
                                <col style="width:80%;">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th><label for="status">배송 상태</label></th>
                                <td>
                                    <select name="status" id="status">
                                        <option value="0" <c:if test="${delivery.status eq 0 }">selected</c:if>>배송전</option>
                                        <option value="1" <c:if test="${delivery.status eq 1 }">selected</c:if>>배송중</option>
                                        <option value="2" <c:if test="${delivery.status eq 2 }">selected</c:if>>배송완료</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><label for="dnum">배송 번호</label></th>
                                <td><input type="text" name="dnum" id="dnum" value="${delivery.dnum }" placeholder="배송 번호를 입력하세요."></td>
                            </tr>
                            <tr>
                                <th><label for="dtel">배송 회사 전화번호</label></th>
                                <td><input type="text" name="dtel" id="dtel" value="${delivery.dtel }" placeholder="배송 회사 전화번호를 입력하세요."></td>
                            </tr>
                            <tr>
                                <th><label for="dcode">화물 코드</label></th>
                                <td><input type="text" name="dcode" id="dcode" value="${delivery.dcode }" placeholder="화물 코드를 입력하세요."></td>
                            </tr>
                            <tr>
                                <th><label for="rdate">도착 예정일</label></th>
                                <td><input type="date" name="rdate" id="rdate" value="${delivery.rdate }"></td>
                            </tr>
                            <tr>
                                <td colspan="2" class="btn_group txt_center">
                                    <input type="submit" class="inBtn" value="배송상태 변경">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </c:if>
                <c:if test="${delivery.status eq 3 }">
                    <table class="table">
                        <colgroup>
                            <col style="width:20%;">
                            <col style="width:80%;">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th>배송 상태</th>
                            <td>구매확정</td>
                        </tr>
                        <tr>
                            <th>배송 번호</th>
                            <td>${delivery.dnum }</td>
                        </tr>
                        <tr>
                            <th>배송 회사 전화번호</th>
                            <td>${delivery.dtel }</td>
                        </tr>
                        <tr>
                            <th>화물 코드</th>
                            <td>${delivery.dcode }</td>
                        </tr>
                        <tr>
                            <th>도착 예정일</th>
                            <td>${delivery.rdate }</td>
                        </tr>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${delivery.status eq 4 }">
                    <table class="table">
                        <colgroup>
                            <col style="width:20%;">
                            <col style="width:80%;">
                        </colgroup>
                        <tbody>
                        <tr>
                            <th><label for="status">배송 상태</label></th>
                            <td>구매취소</td>
                        </tr>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
