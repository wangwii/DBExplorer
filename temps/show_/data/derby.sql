/**
 * 一个用于描述 名人录 的表结构，包括名人所属行业 以及 名人的详细信息
 */
--创建一个示例的数据表结构
--行业
create table groups(
	ID INTEGER not null primary key,
	NAME VARCHAR(30) not null,
	REMARK VARCHAR(300)
);

--名人录
create table celebs(
	ID INTEGER not null primary key,
	NAME VARCHAR(30) not null,
	BIRTHDAY DATE,
	BELONG INTEGER not null,
    PHOTO BLOB (1024K),
	RESUME CLOB (256K),
    REMARK VARCHAR(300),
    constraint FK_BE_GS_ID foreign key (BELONG) references groups(ID)
);


--创建一个临时表，用于展示联合主键的效果
create table userinfo(
	FNAME VARCHAR(30) not null,
	LNAME VARCHAR(30) not null,
	AGE INTEGER not null default 0,
	REMARK VARCHAR(300),
	primary key (FNAME,LNAME)
)
insert into userinfo(FNAME,LNAME,AGE) values('wang','wei',30);