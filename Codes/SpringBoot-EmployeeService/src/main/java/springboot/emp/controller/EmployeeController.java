package springboot.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import springboot.emp.exception.EmployeeException;
import springboot.emp.model.Employee;
import springboot.emp.repository.EmployeeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@RequestMapping("/")
	public ModelAndView homePage() {
		System.out.println(" ======= i came here ===============");
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;
	}

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		System.out.println("========> getAllEmployees ::: \n ");
		return repository.findAll();
	}

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		System.out.println("========> addEmployee ::: \n " + employee);
		return repository.save(employee);
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		System.out.println("========> getEmployeeById ::: \n " + id);
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new EmployeeException("Employee not found with ID :" + id));
		return ResponseEntity.ok(employee);

	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee empData) {
		System.out.println("========> updateEmployee ::: \n ID:" + id + ", \n empData:" + empData);
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new EmployeeException("Employee not found for Updating with ID :" + id));

		employee.setName(empData.getName());
		employee.setAddress(empData.getAddress());
		employee.setSalary(empData.getSalary());

		repository.save(employee);
		System.out.println("employee :: " + employee);

		return ResponseEntity.ok(employee);

	}

	// delete employee rest api
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new EmployeeException("Employee not exist with id :" + id));

		repository.delete(employee);
		Map<String, Boolean> response = new HashMap();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
