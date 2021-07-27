package com.training.disasterproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timecard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	private String sitecode;
	private String machinecode;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMachinecode() {
		return machinecode;
	}

	public void setMachinecode(String machinecode) {
		this.machinecode = machinecode;
	}

	private double workedhrs;
	private double usedhrs;

	public double getUsedhrs() {
		return usedhrs;
	}

	public void setUsedhrs(double usedhrs) {
		this.usedhrs = usedhrs;
	}

	private double labortotal;
	private double machinetotal;

	public double getLabortotal() {
		return labortotal;
	}

	public void setLabortotal(double labortotal) {
		this.labortotal = labortotal;
	}

	public double getMachinetotal() {
		return machinetotal;
	}

	public void setMachinetotal(double machinetotal) {
		this.machinetotal = machinetotal;
	}

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timecard() {
	}

	public Timecard(String contractorname) {
		this.name = contractorname;
	}

	public String getSitecode() {
		return sitecode;
	}

	public void setSitecode(String sitecode) {
		this.sitecode = sitecode;
	}

	public double getWorkedhrs() {
		return workedhrs;
	}

	public void setWorkedhrs(double workedhrs) {
		this.workedhrs = workedhrs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
