package springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import springboot.model.Employee;
import springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee e = repository.save(employee);
		System.out.println(" Employee Data Saved : " + e);

	}

	@Override
	public Employee getEmployeeById(long id) {
		Employee e = repository.getById(id);
		System.out.println("Employee getEmployeeById : " + e);
		return e;
	}

	@Override
	public void deleteEmployeeById(long id) {
		Employee e = repository.getById(id);
		repository.delete(e);
		System.out.println("Employee Deleted : ");

	}
}
