package com.training.disasterproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Machine {
	@Id
	@NotNull
	@Column(unique = true, nullable = false)
	private String code;

	@NotNull
	@Size(min = 3, max = 255)
	private String description;

	@NotNull
	@Size(min = 7, max = 1000)
	private Float hourlyRent;

	@NotNull
	@Min(0)
	@Max(8)
	private Float maxHoursPerDay;// (BigDecimal 6,2)

	@ManyToOne
	private User user;

	@ManyToOne
	private Site site;

	
	

	public Machine()
	{
		super();
	}

	public Machine(
			@NotNull String code, @NotNull @Size(min = 3, max = 255) String description,
			@NotNull @Size(min = 7, max = 1000) Float hourlyRent, @NotNull @Min(0) @Max(8) Float maxHoursPerDay,
			User user, Site site
	)
	{
		super();
		this.code = code;
		this.description = description;
		this.hourlyRent = hourlyRent;
		this.maxHoursPerDay = maxHoursPerDay;
		this.user = user;
		this.site = site;
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

	public Float getHourlyRent()
	{
		return hourlyRent;
	}

	public void setHourlyRent(Float hourlyRent)
	{
		this.hourlyRent = hourlyRent;
	}

	public Float getMaxHoursPerDay()
	{
		return maxHoursPerDay;
	}

	public void setMaxHoursPerDay(Float maxHoursPerDay)
	{
		this.maxHoursPerDay = maxHoursPerDay;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Site getSite()
	{
		return site;
	}

	public void setSite(Site site)
	{
		this.site = site;
	}

	
}
