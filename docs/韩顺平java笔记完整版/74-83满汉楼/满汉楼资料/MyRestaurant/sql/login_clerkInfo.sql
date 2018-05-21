create database restaurant
on primary
(name='data_1',
filename='E:\sqlProgram\mhlPro\data\data_1.mdf',
size=3MB,maxsize=200MB,
filegrowth=500KB),
filegroup data2
(name='data_2',
filename='E:\sqlProgram\mhlPro\data\data_2.ndf',
size=1MB,maxsize=100MB,
filegrowth=500KB)
log on
(name='log_1',
filename='E:\sqlProgram\mhlPro\log_1.ldf',
size=1MB,maxsize=100MB,
filegrowth=500KB)
go
use restaurant
go
--创建登陆用户的信息表
create table clerkInfo
(
cleId nvarchar(30)primary key not null,
cleName nvarchar(30) not null,
cleSex nchar(1 )check(cleSex in('男','女')) default '女' not null,
cleAge int check(cleAge>1)not null,
cleZw nvarchar(30)not null,
)
go

--创建用户登陆
create table login
(
cleId nvarchar(30) foreign key references clerkInfo(cleId),
passwd nvarchar(30) not null
)
go


insert into clerkInfo values('m001','李洁','女',25,'主管')
insert into clerkInfo values('m002','黄梅','女',23,'管理员')
insert into clerkInfo values('m003','王小毅','男',28,'经理')
insert into clerkInfo values('m004','钟琴','女',30,'会计')
insert into clerkInfo values('m005','吴丽','女',24,'收银员')
insert into clerkInfo values('m006','金秀琴','女',26,'服务员')
insert into clerkInfo values('m007','陈凤','女',28,'服务员')
go

insert into login values('m001','mhl001')
insert into login values('m002','mhl002')
insert into login values('m003','mhl003')
go


select * from clerkInfo
select * from login


select l.cleId,l.passwd,c.cleName,c.cleZw 
from clerkInfo c,login l 
where c.cleId=l.cleId  
order by cleAge
