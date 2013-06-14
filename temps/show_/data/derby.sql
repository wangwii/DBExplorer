/**
 * һ���������� ����¼ �ı�ṹ����������������ҵ �Լ� ���˵���ϸ��Ϣ
 */
--����һ��ʾ�������ݱ�ṹ
--��ҵ
create table groups(
	ID INTEGER not null primary key,
	NAME VARCHAR(30) not null,
	REMARK VARCHAR(300)
);

--����¼
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


--����һ����ʱ������չʾ����������Ч��
create table userinfo(
	FNAME VARCHAR(30) not null,
	LNAME VARCHAR(30) not null,
	AGE INTEGER not null default 0,
	REMARK VARCHAR(300),
	primary key (FNAME,LNAME)
)
insert into userinfo(FNAME,LNAME,AGE) values('wang','wei',30);