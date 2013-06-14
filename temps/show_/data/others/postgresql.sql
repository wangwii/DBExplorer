--创建一个示例的数据表结构
--行业
create table groups(
	ID NUMERIC(5) not null primary key,
	NAME VARCHAR(30) not null,
	REMARK VARCHAR(500)
);

--名人录
create table celebs(
	ID NUMERIC(8) not null primary key,
	NAME VARCHAR(30) not null,
	BIRTHDAY DATE,
	BELONG NUMERIC(5),
    PHOTO BYTEA,
	RESUME TEXT,
    REMARK VARCHAR(500),
    constraint FK_CELEBS_GROUP_ID foreign key (BELONG) references groups(ID)
);