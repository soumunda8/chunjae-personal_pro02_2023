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
                <li class="breadcrumb-item active" aria-current="page" class="text-end">회원정보수정</li>
            </ol>
        </nav>
        <div class="container">
            <h3 class="text-center fs-1 my-5">회원정보수정</h3>
            <div class="page mb-5">
                <form action="${path }/modifyMyInfoPro.do" method="post">
                    <table class="table table-striped-columns">
                        <tbody>
                        <tr>
                            <th scope="row"><label for="name" class="form-label">이름</label></th>
                            <td><input type="text" value="${member.name }" name="name" id="name" class="form-control" readonly></td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="id" class="form-label">아이디</label></th>
                            <td><input type="text" value="${member.id }" name="id" id="id" class="form-control" readonly></td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="rePw" class="form-label">비밀번호</label></th>
                            <td>
                                <input type="password" value="${originPw }" name="rePw" id="rePw" class="form-control" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" maxlength="16" aria-describedby="pwHelp" required>
                                <div id="pwHelp" class="form-text">비밀번호는 최소 8자리에서 최대 16자리까지 숫자, 영문, 특수문자 각 1개 이상 포함되어야 함</div>
                                <input type="hidden" value="${originPw }" name="pwCk" id="pwCk" />
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="tel" class="form-label">전화번호</label></th>
                            <td><input type="tel" value="${member.tel }" name="tel" id="tel" class="form-control" required></td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="email" class="form-label">이메일</label></th>
                            <td><input type="email" value="${member.email }" name="email" id="email" class="form-control" required></td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="birth" class="form-label">생일</label></th>
                            <td><input type="date" value="${member.birth }" name="birth" id="birth" class="form-control" readonly></td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="address1" class="form-label">주소</label></th>
                            <td>
                                <input type="text" name="address1" id="address1" placeholder="기본 주소 입력" value="${addr[0] }" class="form-control" required />
                                <input type="text" name="address2" id="address2" placeholder="상세 주소 입력" value="${addr[1] }" class="form-control mt-2" required />
                                <input type="text" name="postcode" id="postcode" placeholder="우편번호" value="${member.acode}" class="form-control mt-2">
                                <button type="button" id="post_btn" onclick="findAddr()" class="inBtn mt-2">우편번호 검색</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="btn_group txt_right">
                        <button type="submit" class="inBtn">회원정보수정</button>
                        <a href="${path }/myPage.do" class="inBtn inBtn2">마이페이지로 이동</a>
                    </div>
                </form>
                <script>
                    function findAddr(){
                        new daum.Postcode({
                            oncomplete:function(data){
                                console.log(data);
                                var roadAddr = data.roadAddress;
                                var jibunAddr = data.jibunAddress;
                                document.getElementById("postcode").value = data.zonecode;
                                if(roadAddr !== ''){
                                    document.getElementById("address1").value = roadAddr;
                                } else if(jibunAddr !== ''){
                                    document.getElementById("address1").value = jibunAddr;
                                }
                                document.getElementById("address2").focus();
                            }
                        }).open();
                    }
                </script>
                <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" />
</body>
</html>