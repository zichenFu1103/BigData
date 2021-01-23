create database cms;

use cms;

create table department(
	depart_id int primary key AUTO_INCREMENT,
    depart_name VARCHAR(50) not null,
    depart_manager VARCHAR(50) default null,
    manager_tel Varchar(11) default null,
    manager_email VARCHAR(25) default null
);

alter table department character set utf8mb4;

create table employee(
	emp_id int primary key AUTO_INCREMENT,
    emp_name VARCHAR(30) not null,
    emp_depart_id int not null,
    emp_position VARCHAR(30) default null,
    emp_start_date DATE default null,
    emp_tel VARCHAR(11) default null,
    CONSTRAINT emp_depart_fk FOREIGN KEY (emp_depart_id) REFERENCES department (depart_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into department values (null, '市场部', '傅梓宸', '18792750495','zichenfu@163.com'),
							  (null, '销售部', '林旖曦', '18792750496','yixilin@163.com');

insert into employee values (null,'王自凡', 1, '客户经理', '2015-08-08', '18792750497');
insert into employee values (null,'王建国', 1, '客户经理', '2015-08-08', '18792750499');
insert into employee values (null,'王子建', 2, '销售经理', '2015-09-09', '18792750498');

alter table employee modify  emp_start_date VARCHAR(25);


