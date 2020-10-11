use lianxi01;

drop table if exists lesson;
drop table if exists professor;
drop table if exists category;

create table professor (
	pid int primary key auto_increment,
    pname varchar(20),
    pdescription varchar(100),
    plevel char(4),
    index pname_index (pname)
);

create table category (
	cid int primary key auto_increment,
    cname varchar(20),
    cdescription varchar(100),
    createDate datetime,
    updateDate datetime
);

create table lesson (
	lid int primary key auto_increment,
    professor_id int,
    category_id int,
    title varchar(20),
    totalTime int,
    visitTime bigint,
    status char(1) default 0,
    index title_index (title),
    constraint lession_professor_fk foreign key (professor_id) references professor(pid),
    constraint lession_category_fk foreign key (category_id) references category(cid)
);

-- 向讲师表插入两条数据
insert into professor values (1, '刘德华', '毕业于清华大学，主攻前端技术,授课风格生动活泼,深受学员喜爱', '高级讲师');

insert into professor values (2, '郭富城', '毕业于北京大学，多年的IT经验，研发多项Java课题,授课经验丰富', '首席讲师');

-- 向课程分类表中插入两条数据
insert into category values (1, '后端开发', '后端课程包括 Java PHP Python', '2020-03-27 00:44:04', '2020-03-27 00:44:04');
insert into category values (2, '前端开发', '前端课程包括 JQuery VUE angularJS', '2020-02-27 10:00:04', '2020-02-27 18:44:04');

-- 向课程表中插入两条数据
-- 插入Java课程
insert into lesson values (1,1,1 ,'Java', 300,250000, '1');
-- 插入VUE课程
insert into lesson values  (2,2,2, 'VUE', 400,200000,'1');

-- 查询刘德华老师所教的课程属于哪个课程分类
select 
	category.cname
from category where category.cid = (
	select 
	lesson.category_id
	from professor, lesson where professor.pid = lesson.professor_id and professor.pname = '刘德华'
);
