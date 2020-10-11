-- 第一题
-- 1、查询平均成绩大于70分的同学的学号,姓名,和平均成绩
-- 1.1 分组查询每个学生的 学号,姓名,平均分
select 
	id,
    name,
    avg(score)
from student, student_course where student.id = student_course.student_id 
group by student_id;

-- 1.2 增加条件：平均成绩大于70
select 
	id,
    name,
    avg(score)
from student, student_course where student.id = student_course.student_id 
group by student_id having avg(score) > 70; 

-- 第二题
-- 2. 查询所有同学的学号、姓名、选课数、总成绩
-- 2.1 需要查询两张表 student表和 student_course表
-- 2.2 需要使用 student_id 学号字段,进行分组
-- 2.3 需要使用到 count函数 sum函数
select
	id,
    name,
    count(course_id),
    sum(score)
from student, student_course where student.id = student_course.student_id 
group by student_id;

-- 第三题
-- 3. 查询学过赵云老师课程的同学的学号、姓名
-- 3.1 查询赵云老师的id
-- 3.2 根据老师ID,在课程表中查询所教的课程编号
-- 3.3 将上面的子查询作为 where 后面的条件

select 
	id,
    name
from student, student_course where student.id = student_course.student_id 
and course_id in (select id from course where teacher_id = (select id from teacher where NAME = '赵云'));

-- 第四题
-- 4. 查询选课 少于三门学科的学员			
-- 4.1 查询每个学生学了几门课 条件1：小于等于三门
-- 4.2 查询 学号和姓名， 将4.1 作为临时表

select temp_table.id, temp_table.name
from (
	select student.id, student.name, count(course_id)
	from student, student_course where student.id = student_course.student_id 
	group by student_id  having count(s.name) < 3
) temp_table;


