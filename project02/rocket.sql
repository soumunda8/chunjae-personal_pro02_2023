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

-- 게시판(board) 테이블 - X
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
	b.resdate AS resdate, b.cnt as cnt, m.name AS name, c.name AS categoryNm
	FROM board b, member m, category c WHERE b.author=m.id and b.boardtype = c.cno order BY b.bno ASC
);

-- 댓글(comment) 테이블 - X
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


-- 문의(qna) 테이블 - X
CREATE TABLE qna(
	qno serial primary key,	   						-- 문의 번호 : 자동증가
	title varchar(100) not null,   					-- 문의 제목
	content varchar(1000) not null,   				-- 문의 내용
	author varchar(16) not null,   					-- 문의 작성자
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
create view profit as (select prono, sum(sprice*amount) as tot from serve group by prono EXCEPT select prono, sum(rprice*amount) as tot from receive group by prono);

-- 재고 처리 뷰 생성
create view inventory as (select a.prono as prono, (sum(a.amount)-sum(b.amount)) as amount from receive a, serve b where a.prono=b.prono group by a.prono, b.prono);

-- 배송(delivery) 테이블 - O
create table delivery(
    dno serial primary key,                             -- 배송 번호 : 자동증가
    payno integer not null,                             -- 결제 번호
    cid varchar(20) not null,                           -- 회원 아이디
    daddr varchar(300) not null,                        -- 배송 주소
    custel varchar(13) not null,                        -- 고객 연락처
    pcom varchar(100),                                  -- 배송 번호
    ptel varchar(13),                                   -- 배송회사
    pstate integer default 0,                           -- 배송상태 - [0:배송전 | 1:배송중 | 2:도착 | 3:구매결정]
    sdate timestamp default current_timestamp,          -- 배송 등록일
    rdate varchar(13),                                  -- 배송 완료일
    bcode varchar(30)                                   -- 화물코드
);

-- 결제(payment) 테이블 - O
create table payment(
    payno serial primary key,           -- 결제 번호 : 자동증가
    cid varchar(20) not null,           -- 회원 아이디
    prono integer not null,             -- 상품 번호
    amount integer default 1,           -- 결제 수량
    pmethod varchar(100),               -- 결제 방법
    pcom varchar(100),                  -- 결제 대행사
    cnum varchar(100),                  -- 결제카드(계좌)번호
    payprice integer default 1000,      -- 결제 금액
    dno varchar(100)                    -- 배송 번호
);

-- 장바구니(cart) 테이블 - O
create table cart(
    cartno serial primary key,          -- 장바구니 번호 : 자동증가
    cid varchar(20) not null,           -- 회원 아이디
    prono integer not null,             -- 상품 번호
    amount integer not null             -- 상품 수량
);

create view cartList as (select p.prono as prono, p.pname as pname, p.price as price, p.thumbnail as thumbnail, sum(c.amount) as amount, c.cid as cid from product p, cart c where p.prono = c.prono group by c.cid, p.prono order by p.prono desc)

-- 리뷰(review) 테이블 - O
create table review(
    rno serial primary key,                         -- 리뷰 번호 : 자동증가
    prono integer not null,                         -- 상품 번호
    cid varchar(20) not null,                       -- 회원 아이디
    content varchar(500) not null,                  -- 리뷰 내역
    star integer default 10,                        -- 리뷰 별점
    resdate timestamp default current_timestamp     -- 리뷰 등록일
);

-- 아래 참조하면서 진행하기
-- 상품 목록
select * from product order by prono;
-- 신상품 목록
select * from product order by prono desc limit 5;
-- 베스트셀러 상품 목록
select * from product where prono in (select prono from payment group by prono order by sum(amount) desc limit 5);
-- 카테고리별 신상품 목록
select * from product where cateno=? order by prono desc limit 3;
-- 카테고리별 베스트셀러 상품 목록
select * from product where pcode in (select prono from payment group by prono order by sum(amount)) and cateno=? limit 3;

-- 입고 처리 패턴
insert into receive values (default, ?, ?, ?, default);
insert into receive(prono, amount, rprice) values (?, ?, ?);

-- 출고 처리 패턴
insert into payment values (default, ?, ?, ?, ?, ?, ?, ?, '');
insert into serve values(default, ?, ?, ?, default);
insert into delivery values (default, ?, ?, ?, ?, '','',default,default,'','');
delete from cart where cartno=?;

-- 반품 처리 패턴(배송전이면 반품 가능)
delete from payment where payno=?;
insert into receive values (default, ?, ?, ?, default);
delete from serve where sno=?;
insert into cart values (default, ?, ?, ?);
delete from delivery where payno=?;

-- 배송처리
update delivery set pcom=?, ptel=?, pstate=1, sdate=current_timestamp, rdate=?, bcode=? where dno=?;

-- 배송 완료 처리
update delivery set pstate=2 where dno=?;