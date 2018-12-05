package com.example.demo;

import io.swagger.annotations.ApiModelProperty;

public class Company {

	String name;
	String address;
	String employment;

	public Company() {

	}

	public Company(String name, String address, String employment) {

		this.name = name;
		this.address = address;
		this.employment = employment;
	}

	@ApiModelProperty(position = 1, required = true, value = "Exlibris")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ApiModelProperty(position = 2, required = true, value = "Jerusalem")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ApiModelProperty(position = 3, required = true, value = "programming")
	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

}
