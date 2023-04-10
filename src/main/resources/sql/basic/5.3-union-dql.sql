select * from department;

select * from employee;

-- union distinct
select name, department from employee
union DISTINCT
select manager, name from department;

-- union all
select name, department from employee
union DISTINCT
select manager, name from department;