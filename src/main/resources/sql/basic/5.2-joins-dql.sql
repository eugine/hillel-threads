select * from department;

select * from employee;

-- inner join
select * from employee as e
 -- inner join department d
    join department d
        on e.department = d.name;

-- left join
select * from employee as e
    left join department d
        on e.department = d.name;

-- only in left
select * from employee as e
    left join department d
        on e.department = d.name
    where d.id is null;

-- right join
select * from employee as e
    right join department d
        on e.department = d.name;

-- only in right
select * from employee as e
    right join department d
        on e.department = d.name
    where e.id is null;

-- full join
select * from employee as e
--     full outer join department d
    full join department d
        on e.department = d.name;

-- cross join
select * from employee, department;

select name, department from employee
union all
select manager, name from department;