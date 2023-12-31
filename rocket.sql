create database rocket;

-- 고객(member) 테이블 - O
create table member(
    id varchar(20) primary key,						-- 아이디
    pw varchar(500) not null,						-- 비밀번호
    name varchar(100) not null,						-- 이름
    point integer default 0,						-- 포인트
    grade varchar(4) default 'F',					-- 등급
    tel varchar(13) not null,						-- 전화번호
    email varchar(100) not null,					-- 이메일
    birth varchar(20) not null,						-- 생일
    addr varchar(300),								-- 주소
    acode varchar(10),								-- 우편번호
    regdate timestamp default current_timestamp,	-- 가입일
    useyn boolean default true                    	-- 사용여부
);

-- 게시판(board) 테이블 - O
create table board(
	bno serial primary key,							-- 게시글 번호 : 자동증가
	boardtype varchar(20) not NULL,   				-- 게시글 타입 - 카테고리 테이블 연결 예정
	title varchar(200) not null,					-- 게시글 제목
	content varchar(1000),							-- 게시글 내용
	author varchar(20) not NULL,					-- 게시글 작성자
	resdate timestamp default current_timestamp,	-- 게시글 등록일
	visited integer default 0						-- 게시글 조회수
);

-- 카테고리 추가한 부분 확인하기
CREATE VIEW boardList AS (
	SELECT 
	b.bno AS bno, b.boardtype AS boardtype, b.title AS title, b.content AS content, b.author AS author,
	b.resdate AS resdate, b.visited as visited, m.name AS name, c.cname AS categorynm
	FROM board b, member m, category c WHERE b.author=m.id and b.boardtype = c.cateno order BY b.bno ASC
);

-- 댓글(comment) 테이블 - O
CREATE TABLE comment(
   	cno serial primary key,									-- 댓글 번호 : 자동증가
	author VARCHAR(20) not null,							-- 댓글 작성자
	content VARCHAR(1000) not null,							-- 댓글 내용
	resdate timestamp not null default current_timestamp,   -- 댓글 등록일
	bno integer not null   									-- 해당 게시글 PK값
);

CREATE VIEW commentlist AS (
	SELECT c.cno AS cno, c.author AS author, c.content AS content, c.resdate AS resdate, c.bno AS bno, 
	m.name AS name FROM comment c, member m 
	WHERE c.author=m.id order BY c.cno ASC
);


-- 문의(qna) 테이블 - O
CREATE TABLE qna(
	qno serial primary key,	   						-- 문의 번호 : 자동증가
	title varchar(100) not null,   					-- 문의 제목
	content varchar(1000) not null,   				-- 문의 내용
	author varchar(20) not null,   					-- 문의 작성자
	resdate timestamp default current_timestamp,	-- 문의 등록일자
	answer varchar(1000),   						-- 답변 내용
	answeryn boolean default false, 				-- 답변 여부
	answerdate timestamp							-- 답변 등록일자
);

CREATE VIEW qnaList AS (
	SELECT q.qno AS qno, q.title AS title, q.content AS content, q.answer AS answer, q.author AS author, 
	q.resdate AS resdate, q.answerdate AS answerdate, q.answeryn AS answeryn, m.name AS name 
	FROM qna q, member m WHERE q.author=m.id order BY q.qno ASC
);

-- 카테고리(category) 테이블 - O
create table category(
	cateno varchar(4) primary key,		-- 카테고리 번호
	cname varchar(100) not null,		-- 카테고리 이름
	par varchar(100)					-- 해당 테이블명
);

-- 파일(file) 테이블 - O
create table files(
    fno serial primary key,			            	-- 파일 번호 : 자동증가
    filetitle varchar(500),	   						-- 파일 사용 용도
    filename varchar(500) default 'noImage.png',	-- 파일 이름
    filetype varchar(20) default 'image/png',	    -- 파일 타입/확장자
    par varchar(100),				            	-- 해당 테이블명
    parno INTEGER					            	-- 해당 테이블 PK값
);

-- 상품(product) 테이블 - O
create table product(
    prono serial primary key,                       -- 상품 번호 : 자동증가
    cateno varchar(4) not null,                     -- 카테고리 번호
    pname varchar(100) not null,                    -- 상품 이름
    price integer default 1000,                     -- 상품 가격
    pcomment varchar(2000) not null,                -- 상품 설명
    plist varchar(2000),                            -- 상품 목차
    thumbnail varchar(200),                			-- 상품 섬네일
    videosub varchar(200),			                -- 비디오 존재시 제목
    useyn boolean default true,                    	-- 판매여부
    resdate timestamp default current_timestamp     -- 상품 등록일
);

-- 상품 뷰 생성
CREATE VIEW productList AS (
    select p.prono as prono, p.cateno as cateno, p.pname as pname, p.price as price, p.pcomment as pcomment,
          p.plist as plist, p.thumbnail as thumbnail, p.videosub as videosub, p.useyn as useyn, p.resdate as resdate, c.cname as cname
    from product p, category c
    where p.cateno = c.cateno
    order by p.prono desc
);

-- 입고(receive) 테이블 - O
create table receive(
    rno serial primary key,                       -- 입고 번호 : 자동증가
    prono integer not null,                       -- 상품 번호
    amount integer default 1,                     -- 입고 갯수
    rprice integer default 1000,                  -- 입고 가격
    resdate timestamp default current_timestamp   -- 입고일
);

-- 출고(serve) 테이블 - O
create table serve(
    sno serial primary key,                       -- 출고 번호 : 자동증가
    prono integer not null,                       -- 상품 번호
    amount integer default 1,                     -- 출고 갯수
    sprice integer default 1000,                  -- 출고 가격
    resdate timestamp default current_timestamp   -- 출고일
);

-- 전체 이익 통계 뷰 작성
create view profit as (select a.prono as prono, sum(a.tot - b.tot) AS tot from serveProfit a, receiveProfit b where a.prono = b.prono group by a.prono);
create view serveProfit as (select prono, sum(sprice*amount) as tot from serve group by prono);
create view receiveProfit as (select prono, sum(rprice*amount) as tot from receive group by prono);

-- 재고 처리 뷰 생성
create view inventory as (select a.prono as prono, (a.amount-b.amount) AS amount from receiveInventory a, serveInventory b  WHERE a.prono = b.prono)
create view serveInventory as (select prono, sum(amount) as amount from serve group by prono);
create view receiveInventory as (select prono, sum(amount) as amount from receive group by prono);

-- 배송(delivery) 테이블 - O
create table delivery(
     dno serial primary key,                             -- 배송 번호 : 자동증가
     cusname varchar(300) not null,                      -- 배송 고객 이름
     custel varchar(13) not null,                        -- 배송 고객 연락처
     cusaddr varchar(300) not null,                      -- 배송 고객 주소
     dnum varchar(100),                                  -- 배송 번호
     dtel varchar(13),                                   -- 배송회사 전화번호
     status integer default 0,                           -- 배송상태 - [0:배송전 | 1:배송중 | 2:도착 | 3:구매결정 | 4.구매취소]
     sdate timestamp default current_timestamp,          -- 배송 등록일
     rdate timestamp,                                    -- 배송 완료일
     dcode varchar(30),                                  -- 화물코드
     author varchar(20) not null                         -- 구매 고객 아이디
);

-- 결제(payment) 테이블 - O
create table payment(
    payno serial primary key,           			-- 결제 번호 : 자동증가
    author varchar(20) not null,        			-- 회원 아이디
    prono integer not null,             			-- 상품 번호
    amount integer default 1,           			-- 결제 수량
    pmethod varchar(10),                			-- 결제 방법 - [1:신용카드 | 2:체크카드 | 3:계좌이체]
    pcom varchar(100),                  			-- 결제 대행사
    pnum varchar(100),                  			-- 결제카드(계좌)번호
    payprice integer default 1000,      			-- 결제 금액
    status integer default 0,           			-- 배송상태 - [0:결제완료 | 1:결제완료 | 2:결제취소]
    dno integer not null default 0,               	-- 배송 번호
    resdate timestamp default current_timestamp     -- 결제 등록일
);

create view productpaylist as (select pay.payno as payno, pay.author as author, pro.prono as prono, pay.amount as amount, pay.pmethod as pmethod, pay.pcom as pcom, pay.pnum as pnum, pay.payprice as payprice, pay.status as paystatus, deli.dno as dno, pro.pname as pname, pro.thumbnail as thumbnail, deli.cusname as cusname, deli.custel as custel, deli.cusaddr as cusaddr, deli.dnum as dnum, deli.dtel as dtel, deli.status as dstatus, deli.sdate as sdate, deli.rdate as rdate, deli.dcode as dcode from payment pay, delivery deli, product pro where pay.prono = pro.prono and pay.dno = deli.dno);

-- 장바구니(cart) 테이블 - O
create table cart(
    cartno serial primary key,          -- 장바구니 번호 : 자동증가
    author varchar(20) not null,        -- 회원 아이디
    prono integer not null,             -- 상품 번호
    amount integer not null             -- 상품 수량
);

create view cartList as (select p.prono as prono, p.pname as pname, p.price as price, p.thumbnail as thumbnail, sum(c.amount) as amount, c.author as author from product p, cart c where p.prono = c.prono group by c.author, p.prono order by p.prono desc);

-- 리뷰(review) 테이블 - O
create table review(
    rno serial primary key,                         -- 리뷰 번호 : 자동증가
    prono integer not null,                         -- 상품 번호
    author varchar(20) not null,                    -- 회원 아이디
    content varchar(500) not null,                  -- 리뷰 내역
    star integer default 5,                         -- 리뷰 별점
    resdate timestamp default current_timestamp     -- 리뷰 등록일
);