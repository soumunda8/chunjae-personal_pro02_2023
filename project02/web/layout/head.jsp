<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="headPath" value="<%=request.getContextPath() %>" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=dege"> <!-- 인터넷익스프로러로 접근시 엣지로 연결되게 함 -->
<meta http-equiv="Author" content="로켓숍 개인 프로젝트">
<meta http-equiv="Publisher" content="로켓숍 박나연">
<meta http-equiv="Copyright" content="Copyright@soumunda8.github.io/portfolio">

<!-- 검색엔진 최적화(SEO) -->
<meta name="Subject" content="로켓숍">
<meta name="Keywords" content="로켓숍, 온라인 도서, 맛보기 강좌">
<meta name="Description" content="로켓숍는 온라인 도서, 맛보기 강좌를 제공하는 웹페이지입니다.">
<meta name="robots" content="index,follow">

<!-- 오픈 그래프(Open graph) -->
<meta property="og:type" content="website">
<meta property="og:title" content="로켓숍">
<meta property="og:description" content="로켓숍은 온라인 도서, 맛보기 강좌를 제공하는 웹페이지">
<meta property="og:image" content="https://soumunda8.github.io/portfolio/images/project2_og.png">
<meta property="og:url" content="https://soumunda8.github.io/portfolio">

<!-- 파비콘 설정 -->
<!-- 16x16, 24x24, 32x32, 48x48, 64x64, 96x96, 114x114, 128x128, 256x256 등을 활용-->
<!-- 표준 파비콘 -->
<link rel="shortcut icon" href="${headPath }/image/common/logo.ico">
<!-- 애플 계열 모바일 -->
<link rel="apple-touch-icon-precomposed" href="${headPath }/image/common/logo64.png">
<!-- IE 계열 브라우저 -->
<meta name="msapplication-TileColor" content="#FFFFFF">
<meta name="msapplication-TileImage" content="${headPath }/image/common/logo48.png">
<!-- 파이어폭스, 오페라, 또는 구형 크롬/사파리 -->
<link rel="icon" href="${headPath }/image/common/logo16.png" sizes="16x16">
<link rel="icon" href="${headPath }/image/common/logo32.png" sizes="32x32">
<link rel="icon" href="${headPath }/image/common/logo48.png" sizes="48x48">
<link rel="icon" href="${headPath }/image/common/logo64.png" sizes="64x64">

<link rel="stylesheet" href="${headPath }/css/google.css">
<link rel="stylesheet" href="${headPath }/css/common.css">
<link rel="stylesheet" href="${headPath }/css/all.css">

<script src="${headPath }/js/jquery-1.10.0.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<!-- 불펌 방지 -->
<%--
<script>
    document.oncontextmenu = function() { return false; }
    document.ondragstart = function() { return false; }
    document.onselectstart = function() { return false; }
</script>
--%>
