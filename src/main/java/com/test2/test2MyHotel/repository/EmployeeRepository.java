package com.test2.test2MyHotel.repository;

import javax.transaction.Transactional;
import com.test2.test2MyHotel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
	//List<Employee> findSalaryRange(int lowRange, int highRange);
	
	@Query("SELECT e from Employee e where e.salary >= :lowRange and e.salary <= :highRange")
    List<Employee> findSalaryRange(@Param("lowRange") double lowRange, @Param("highRange") double highRange);
}
