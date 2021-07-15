package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import springboot.model.Employee;
import springboot.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		System.out.println("Calling Home Page....");
		return "index";
	}

	// display list of employees
	@GetMapping("/all")
	public String listEmployees(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "listEmployees";
	}
	
	
	
	// display list of employees
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {	
	     // create model attribute to bind form data
	     Employee employee = new Employee();
	     model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	 @PostMapping("/saveEmployee")
	 public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	     // save employee to database
	     employeeService.saveEmployee(employee);
	     return "redirect:/all";
	 }
}
