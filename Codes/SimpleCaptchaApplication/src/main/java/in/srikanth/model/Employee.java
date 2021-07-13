package in.srikanth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@SequenceGenerator(sequenceName = "Employee_Id_Seq", name = "E_Id_Seq", allocationSize = 1)
	@GeneratedValue(generator = "E_Id_Seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Double salary;

	@Transient
	private String captcha;

	@Transient
	private String hidden;

	@Transient
	private String image;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}