package in.srikanth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.srikanth.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
