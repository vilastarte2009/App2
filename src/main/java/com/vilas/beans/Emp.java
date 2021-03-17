package com.vilas.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "EMP")
public class Emp
{	
	@Id
	int id;
	@Size(min=2, message="Enter at least 2 Characters...")
	@NotEmpty(message = "Please enter the Name...")
	String name;
	@Min(value = 1, message = "Salary must be greater than or equal to 1")
	int salary;
	@Past
	Date bdate;
	@Transient
	int secretValue;
	public Emp() {};
	
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public int getSecretValue() {
		return secretValue;
	}
	public void setSecretValue(int secretValue) {
		this.secretValue = secretValue;
	}
	public Emp(int id, String name, int slary) 
	{
		super();
		this.id = id;
		this.name = name;
		this.salary = slary;
	}
	@Override
	public String toString()
	{
		return "Emp [id=" + id + ", name=" + name + ", slary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	} 

	
	
	
}
