create sequence seq_board;
create table tbl_board (
  bno number(10,0),
  title varchar2(200) not null,
  content varchar2(2000) not null,
  writer varchar2(50) not null,
  regdate date default sysdate, 
  updatedate date default sysdate
);
alter table tbl_board add constraint pk_board 
primary key (bno);

insert into tbl_board (bno, title, content, writer) 
values (seq_board.nextval, '테스트 제목','테스트 내용','user00');

select * from tbl_board order by bno desc;

alter sequence seq_board nocache;

/*아파트 정보 테이블*/
drop table info_apart;
create table info_apart (
  apt_bno number(10,0),
  apt_name varchar2(200) PRIMARY KEY,
  apt_lat varchar2(200) not null,
  apt_lng varchar2(200) not null,
  apt_admin varchar2(200) not null,
  regdate date default sysdate 
);

insert into info_apart (apt_bno, apt_name, apt_lat, apt_lng, apt_admin) 
values (seq_apart.nextval, '테스트 이름','테스트 위도','테스트 경도', '테스트 관리자');
alter sequence seq_apart nocache;

/*시설물 정보 테이블 */
drop table info_facility;
create sequence seq_facility;
create table info_facility (
  fac_bno number(10,0),
  fac_name varchar2(200) not null,
  fac_aptname varchar2(200) not null,
  fac_lat varchar2(200) not null,
  fac_lng varchar2(200) not null,
  fac_admin varchar2(200) not null,
  fac_numperson number,
  fac_usingperson number,
  fac_info varchar(2000),
  regdate date default sysdate,
  fac_opentime varchar(200) not null,
  fac_closetime varchar(200) not null,
  PRIMARY KEY(fac_name,fac_aptname),
  CONSTRAINT info_facility_FK FOREIGN KEY(fac_aptname)
  REFERENCES info_apart(apt_name) ON DELETE CASCADE
);
alter sequence seq_facility nocache;

/*예약중 정보*/
create table reserveFac (
  fac_name varchar2(200) not null,
  fac_aptname varchar2(200) not null,
  userId varchar2(200) not null,
  start_time varchar(200) not null,
  finish_time varchar(200) not null,
  reserve_date date not null,
  PRIMARY KEY(fac_name,fac_aptname, userId),
  CONSTRAINT reserveFac_FK FOREIGN KEY(fac_name, fac_aptname)
  REFERENCES info_facility(fac_name, fac_aptname) ON DELETE CASCADE
);
