use lianxi01;
-- 按要求实现下面的查询功能 
#1.查询工资最高的员工是谁？
select 
	*
from employee 
where salary = (select max(salary) from employee);

#2.查询工资小于平均工资的员工有哪些？
select 
	*
from employee
where salary < (select avg(salary) from employee);

#3.查询大于5000的员工，来至于哪些部门，输出部门的名字
select 
	employee.name, employee.salary, dept.name
from employee, dept 
where employee.dept_id = dept.id and employee.salary > 5000;

#4.查询开发部与财务部所有的员工信息，分别使用子查询和表连接实现
select 
	*
from employee
where dept_id in (select id from dept where name in ('开发部','财务部'));	

select 
	*
from employee, dept 
where employee.dept_id = dept.id and dept.name in('开发部','财务部');

#5.查询2011年以后入职的员工信息和部门信息，分别使用子查询和表连接实现
select 
	 id, name, gender, salary, join_date, dept_id, (select name from dept where dept.id = dept_id)
from employee
where year(join_date) > 2011;
	
select 
	*
from employee, dept 
where employee.dept_id = dept.id and year(join_date) > 2011;