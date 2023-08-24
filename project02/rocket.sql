create database rocket;

-- 고객(custom) 테이블
create table custom(
	id varchar(20) primary key,						-- 아이디
	pw varchar(500) not null,						-- 비밀번호
	name varchar(100) not null,						-- 이름
	point integer default 0,						-- 포인트
	grade varchar(4) default 'F',					-- 등급
	tel varchar(13) not null,						-- 전화번호
	email varchar(100) not null,					-- 이메일
	birth varchar(20) not null,						-- 생일
	addr varchar(300),								-- 주소
	regdate timestamp default current_timestamp		-- 가입일
);

-- 공지사항(notice) 테이블
create table notice(
	no serial primary key,							-- 공지 번호 : 자동증가
	title varchar(200) not null,					-- 공지 제목
	content varchar(1000),							-- 공지 내용
	resdate timestamp default current_timestamp,	-- 공지 등록일
	visited integer default 0						-- 공지 조회수
);