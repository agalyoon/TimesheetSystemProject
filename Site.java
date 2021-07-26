package com.saikat.springboot.model;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Site {
	@Id
	@Size(max = 10)
	@NotBlank
	private String code;// (String 10,PK, Unique, NotNull)

	@Size(max = 255)
	private String description;// (String255,Not Null)

	@OneToMany(mappedBy = "site")
	private List<Machine> machines;

	

	public Site()
	{
	}

	public Site(String code, String description)
	{
		super();
		this.code = code;
		this.description = description;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<Machine> getMachines()
	{
		return machines;
	}

	public void setMachines(List<Machine> machines)
	{
		this.machines = machines;
	}

	

}
