create table permission(
pid int(11) not null auto_increment,
name varchar(255) not null default '',
url varchar(255) not null default '',
primary key (pid)
)ENGINE = InnoDB default charset = utf8;

insert into permission (pid, name) values ('1','add');
insert into permission (pid, name) values ('2','delete');
insert into permission (pid, name) values ('3','update');
insert into permission (pid, name) values ('4','query');


create table user(
uid int(11) not null auto_increment,
username varchar(255) not null  default '',
password varchar(20) not null default '',
primary key (uid)
)ENGINE = InnoDB default charset = utf8;
insert into user values ('1','admin','123');
insert into user values ('2','lht','123');


create table role(
rid int(11) not null auto_increment,
rname varchar(255) not null default '',
primary key (rid)
)ENGINE = InnoDB default charset = utf8;
insert into role values ('1','admin');
insert into role values ('2','test');

create table permission_role(
rid int(11) not null ,
pid int(11) not null,
key idx_rid(rid),
key idx_pid(pid)
)ENGINE = InnoDB default charset = utf8;
insert into permission_role (rid, pid) values ('1','1');
insert into permission_role (rid, pid) values ('1','2');
insert into permission_role (rid, pid) values ('1','3');
insert into permission_role (rid, pid) values ('1','4');
insert into permission_role (rid, pid) values ('2','1');
insert into permission_role (rid, pid) values ('2','4');

create table user_role(
rid int(11) not null ,
uid int(11) not null,
key idx_rid(rid),
key idx_uid(uid)
)ENGINE = InnoDB default charset = utf8;
insert into user_role (rid, uid) values ('1','1');
insert into user_role (rid, uid) values ('2','2');
