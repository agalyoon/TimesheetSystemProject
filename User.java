package com.saikat.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class User {
	@Id
	@NotNull
	@Size(max = 16)
	String userId;

	@Size(min = 3, max = 50)
	String name;

	@Size(max = 45)
	String password;
	
	@Size(max = 50)
	String roles;
	
	public User()
	{
		super();
	}

	public User(
			@NotNull @Size(max = 16) String userId, @Size(min = 3, max = 50) String name,
			@Size(max = 45) String password, @Size(max = 50) String roles
	)
	{
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRoles()
	{
		return roles;
	}

	public void setRoles(String roles)
	{
		this.roles = roles;
	}
		
		
}
