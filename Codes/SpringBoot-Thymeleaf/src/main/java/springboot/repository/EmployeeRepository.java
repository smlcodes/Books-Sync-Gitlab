package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	/*
	 * JpaRepository is JPA specific extension of Repository. It contains the full
	 * API of CrudRepository and PagingAndSortingRepository. So it contains API for
	 * basic CRUD operations and also API for pagination and sorting.
	 */
	
}
