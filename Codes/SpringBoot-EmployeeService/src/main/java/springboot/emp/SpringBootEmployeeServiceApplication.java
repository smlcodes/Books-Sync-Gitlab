package springboot.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeServiceApplication.class, args);

		System.out.println(" ============================================ ");
		System.out.println(" EmployeeServices™ - Started. ");
		System.out.println(" ============================================ ");

		System.out.println("Root : http://localhost:8080/api/v1/");
		System.out.println(" \t http://localhost:8080/api/v1/all");
		System.out.println(" \t http://localhost:8080/api/v1/addEmployee");
		System.out.println(" \t http://localhost:8080/api/v1/getEmployee/{id}");
		System.out.println(" \t http://localhost:8080/api/v1/updateEmployee/{id}");		
		System.out.println(" \t http://localhost:8080/api/v1/deleteEmployee/{id}");
		
		

	}

}
