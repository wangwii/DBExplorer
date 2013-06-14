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
    PHOTO blob,
	RESUME clob,
    REMARK VARCHAR(500)
); 