		-- Employees on different salary ranges
select count(*) from employees where salary <= 3500;
select count(*) from employees where salary between 3500 and 8000;
select count(*) from employees where salary >= 8000;
-- --------------------------------------------------------------------------------------------------------------------------------------------
		
        -- Employees on different salary ranges group by department
select departments.department_name as 'Department', count(*) as 'Employee count' 
from employees inner join departments on employees.department_id = departments.department_id 
where employees.salary <= 3500 group by employees.department_id;

select departments.department_name as 'Department', count(*) as 'Employee count' 
from employees inner join departments on employees.department_id = departments.department_id 
where employees.salary between 3500 and 8000 group by employees.department_id;

select departments.department_name as 'Department', count(*) as 'Employee count' 
from employees inner join departments on employees.department_id = departments.department_id 
where employees.salary >= 8000 group by employees.department_id;
-- --------------------------------------------------------------------------------------------------------------------------------------------
		
        -- Employee with biggest salary in each department
select employees.employee_id as 'ID', concat(employees.first_name, ' ', employees.last_name) as 'Name', 
max(employees.salary) as 'Salary', departments.department_name as 'Department'
from employees inner join departments on employees.department_id = departments.department_id
where departments.department_id is not null group by employees.department_id;
-- --------------------------------------------------------------------------------------------------------------------------------------------
		
        -- Managers hired more than 15 years ago
select *, TIMESTAMPDIFF(year, hire_date, now()) as 'Years of service' from employees
inner join jobs on employees.job_id = jobs.job_id
where jobs.job_title like '% Manager' and TIMESTAMPDIFF(year, hire_date, now()) > 15;
-- -------------------------------------------------------------------------------------------------------------------------------------------
		
        -- Average salary of every department with 10 or more employees
select departments.department_id as 'ID', departments.department_name as 'Department', avg(salary) as 'Average Salary'
from employees inner join departments on employees.department_id = departments.department_id 
group by employees.department_id HAVING count(*) > 10;
-- -------------------------------------------------------------------------------------------------------------------------------------------
		
        -- Get employee count, average salary, biggest salary, smallest salary and average years of service grouped by country 
        -- (job_history have very little data, because of that i decided to make a query with and without taking this table into consideration)
-- Assuming all employees are still working here without job_history table
select countries.country_name as 'Country', count(*) as 'Number of employees', avg(employees.salary) as 'Average Salary', 
max(employees.salary) as 'Max Salary', min(employees.salary) as 'Min Salary', avg(TIMESTAMPDIFF(year, hire_date, now())) as 'Average worked years'
from employees inner join departments on employees.department_id = departments.department_id
inner join locations on departments.location_id = locations.location_id
inner join countries on locations.country_id = countries.country_id
group by locations.country_id;

-- With job_history table
select countries.country_name as 'Country', count(*) as 'Number of employees', avg(employees.salary) as 'Average Salary', 
max(employees.salary) as 'Max Salary', min(employees.salary) as 'Min Salary', avg(TIMESTAMPDIFF(year, job_history.start_date, job_history.end_date)) as 'Average worked years'
from employees inner join departments on employees.department_id = departments.department_id
inner join locations on departments.location_id = locations.location_id
inner join countries on locations.country_id = countries.country_id
left join job_history on employees.employee_id = job_history.employee_id
group by locations.country_id;

			-- There are some inconsistent data, whit does that some employees are not considered 
            -- because there are not in a valid department, the department have an invalid location or the 
            -- location has an invalid country


