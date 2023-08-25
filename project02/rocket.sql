create database rocket;

-- 고객(custom) 테이블
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
	regdate timestamp default current_timestamp		-- 가입일
);

SELECT acode FROM member;
update member set aCode = '08511'

-- 게시판(board) 테이블
create table board(
	bno serial primary key,							-- 게시글 번호 : 자동증가
	boardType varchar(20) not NULL,   				-- 게시글 타입 - 카테고리 테이블 연결 예정
	title varchar(200) not null,					-- 게시글 제목
	content varchar(1000),							-- 게시글 내용
	author varchar(20) not NULL,					-- 게시글 작성자
	resDate timestamp default current_timestamp,	-- 게시글 등록일
	visited integer default 0						-- 게시글 조회수
);

-- 카테고리 추가한 부분 확인하기
CREATE VIEW boardList AS (
	SELECT 
	b.bno AS bno, b.boardType AS boardType, b.title AS title, b.content AS content, b.author AS author, 
	b.resdate AS resdate, b.cnt as cnt, m.name AS name, c.name AS categoryNm
	FROM board b, member m, category c WHERE b.author=m.id and b.boardType = c.cno order BY b.bno ASC
);

-- 댓글(comment) 테이블
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


-- 문의(qna) 테이블
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

-- 파일(file) 테이블
create table files(
	fno serial primary key,			-- 파일 번호 : 자동증가
	author varchar(20),				-- 파일 작성자ID
	fileName varchar(500),			-- 파일 이름
	fileType varchar(20),			-- 파일 타입/확장자
	par varchar(100),				-- 해당 테이블명
	parNo INTEGER					-- 해당 테이블 PK값
);

CREATE VIEW fileList AS (
	SELECT f.fno AS fno, f.author AS author, f.fileName AS fileName, f.fileType AS fileType, f.par AS par, 
	f.parNo AS parNo, m.name AS name 
	FROM files f, member m WHERE f.author = m.id order BY f.fno ASC
);

-- 카테고리(category) 테이블
create table category(
	cno varchar(20) primary key,		-- 카테고리 번호
	cname varchar(100) not null,		-- 카테고리 이름
	par varchar(100)					-- 해당 테이블명
);