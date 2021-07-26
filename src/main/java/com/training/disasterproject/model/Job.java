package com.saikat.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Job {
	
		@Id
		@Column(unique = true, nullable = false)
		private String code;// (String 25,PK,Unique,NotNull)(eg Plumber,
							// Electrician, general contractor)

		private String description; // (String 255)

		@NotNull
		@Column(nullable = false)
		private Float hourlyRate; // (BigDecimal 7,2)

		@NotNull
		@Column(nullable = false)
		private Float maxHoursPerDay;// (BigDecimal 6,2)

		@ManyToOne
		@NotNull
		private User user;
		
	
		public Job()
		{
			super();
		}

		public Job(String code, String description, @NotNull Float hourlyRate, @NotNull Float maxHoursPerDay)
		{
			super();
			this.code = code;
			this.description = description;
			this.hourlyRate = hourlyRate;
			this.maxHoursPerDay = maxHoursPerDay;
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

		public Float getHourlyRate()
		{
			return hourlyRate;
		}

		public void setHourlyRate(Float hourlyRate)
		{
			this.hourlyRate = hourlyRate;
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

}
