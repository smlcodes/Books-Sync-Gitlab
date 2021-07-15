package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringBootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafApplication.class, args);
		
		System.out.println(" ============================================ ");
		System.out.println("\t ThymeLeaf®™ App Started ");
		System.out.println(" ============================================ ");
		System.out.println("\t http://localhost:8080/");
	}
}
