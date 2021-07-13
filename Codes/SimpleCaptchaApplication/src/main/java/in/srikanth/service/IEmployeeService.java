package in.srikanth.service;

import java.util.List;
import java.util.Optional;

import in.srikanth.model.Employee;

public interface IEmployeeService {

	void createEmployee(Employee e);

	List<Employee> getAllEmployees();

	Optional<Employee> getOneEmployee(Integer id);

}