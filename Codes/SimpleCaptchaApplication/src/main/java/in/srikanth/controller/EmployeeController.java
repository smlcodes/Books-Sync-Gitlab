package in.srikanth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.apiclub.captcha.Captcha;
import in.srikanth.model.Employee;
import in.srikanth.service.IEmployeeService;
import in.srikanth.util.CaptchaUtil;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	private void setupCaptcha(Employee e) {
		Captcha captcha = CaptchaUtil.satyaCaptcha(150, 50);
		e.setHidden(captcha.getAnswer());
		e.setCaptcha("");
		e.setImage(CaptchaUtil.encodeBase64(captcha));
	}

	@RequestMapping("/register")
	public String showReg(Model model) {
		Employee emp = new Employee();
		setupCaptcha(emp);
		model.addAttribute("employee", emp);
		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Employee employee, Model model) {
		if (employee.getCaptcha().equals(employee.getHidden())) {
			service.createEmployee(employee);
			model.addAttribute("message", "Employee created");
			return "redirect:all";
		} else {
			model.addAttribute("message", "Invalid CAPTCHA");
			setupCaptcha(employee);
			model.addAttribute("employee", employee);
		}
		return "EmployeeRegister";
	}

	@GetMapping("/all")
	public String getAllEmployees(Model model) {
		model.addAttribute("list", service.getAllEmployees());
		return "EmployeeData";
	}

	@GetMapping("/edit/{id}")
	public String editEmployees(@PathVariable Integer id, Model model) {
		Optional<Employee> opt = service.getOneEmployee(id);
		Employee e = opt.get();
		setupCaptcha(e);
		model.addAttribute("employee", e);
		return "EmployeeRegister";
	}
}
