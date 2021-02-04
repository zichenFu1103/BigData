#题目一
drop database if exists student;
create  database student;
use student;

drop table if exists student;
drop table if exists course;
drop table if exists student_course;

create table student(
	studentNo int primary key not null auto_increment,
    sutdentName varchar(25),
    age int,
    sex varchar(10)
);

create table course(
	courseNo int primary key not null auto_increment,
    courseName varchar(20),
    teacher varchar(20)
);

create table student_course(
	studentNo int,
    courseNo int,
    grade double
);

alter table student_course add constraint studentNo_student_fk foreign key(studentNo) references student(studentNo);
alter table student_course add constraint courseNo_course_fk foreign key(courseNo) references course(courseNo);

insert into student values(null, 'zichen', 29, 'male'),(null,'yixi',30,'female'),(null,'dapeng',28,'male'),(null,'jianlin','24','male');

insert into course values 
	(null, 'chinese','eric'),
    (null, 'math', 'tim'),
    (null, 'english','zion');
    
rename table student_cource to student_course;   

insert into student_course values
	(1, 1, 95),
    (1, 2, 85),
    (1, 3, 75),
    (2, 1, 65),
    (2, 2, 55),
    (2, 3, 95),
    (3, 1, 65),
    (3, 2, 85),
    (3, 3, 100),
    (4, 1, 45),
    (4, 2, 75),
    (4, 3, 75);
    
    
#查询有课程大于80分又有课程低于60分的学生的学号
select studentNo from student_course 
where grade >= 80; 

select studentNo from student_course 
where studentNo in (
	select studentNo from student_course 
	where grade >= 80
) and grade < 60;

#查询各门课程去掉一个最高分和最低分后的平均成绩
select courseNo, max(grade) as highest, min(grade) as lowest from student_course group by courseNo;

select sc.courseNo, avg(sc.grade) as average
from student_course sc
left join (select courseNo, max(grade) as highest, min(grade) as lowest from student_course group by courseNo)temp
on sc.courseNo = temp.courseNo
where sc.grade != temp.lowest and sc.grade != temp.highest
group by sc.courseNo;


#题目二
drop database if exists user;
create database user;
use user;
drop table if exists t1;
drop table if exists t2;

create table t1(
	userId int primary key auto_increment
);
create table t2(
	userId int primary key auto_increment
);

insert into t1 values (111),(222),(333),(777);
insert into t2 values (111),(444),(333);

#编写一段sql，查找a,b表都有的userid
select userId from t1;
select * from t2 where userId in (select userId from t1);

#编写一段sql，查找a中有b中没有的userid
select * from t1 where userId not in (select userId from t2);



#题目三
use user;
drop table if exists person;

create table person(
	id int primary key not null auto_increment,
    email varchar(50)
);

insert into person values (null,'a@b.com '),(null,'c@d.com'),(null,'a@b.com ');

#查找 Person 表中所有重复的电子邮箱
select email from (select email, count(*) as number from person group by email) temp where temp.number > 1;

#题目四
drop table if exists employee;

create table employee(
	id int primary key not null auto_increment,
    salary double
);

insert into employee values (null, 100),(null,200),(null,300);

select distinct salary 
from (select distinct salary from employee) temp 
order by salary 
desc limit 1, 1;

select count(*) as number from (select distinct salary from employee) temp ;

delimiter $$
create function findSecondHighest() returns double
begin
	set @secondSalary = (select distinct salary 
		from (select distinct salary from employee) temp 
		order by salary 
		desc limit 1, 1);
	set @res = (select if(( @secondSalary > 0),@secondSalary,null));
    return @res;
end ;
select findSecondHighest();





