package com.training.disasterproject.web.dto;

import javax.validation.constraints.NotEmpty;

public class SubmitTimecardDto {

	@NotEmpty
	private String sitecode;

	@NotEmpty
	private String contractorname;

	@NotEmpty
	private String date;

	@NotEmpty
	private String laborcode;

	private double hrsworked;

	private double labortotal;

	@NotEmpty
	private String machinecode;

	private double hrsused;

	private double machinetotal;

	public String getSitecode() {
		return sitecode;
	}

	public void setSitecode(String sitecode) {
		this.sitecode = sitecode;
	}

	public String getContractorname() {
		return contractorname;
	}

	public void setContractorname(String contractorname) {
		this.contractorname = contractorname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLaborcode() {
		return laborcode;
	}

	public void setLaborcode(String laborcode) {
		this.laborcode = laborcode;
	}

	public double getHrsworked() {
		return hrsworked;
	}

	public void setHrsworked(double hrsworked) {
		this.hrsworked = hrsworked;
	}

	public double getLabortotal() {
		return labortotal;
	}

	public void setLabortotal(double labortotal) {
		this.labortotal = labortotal;
	}

	public String getMachinecode() {
		return machinecode;
	}

	public void setMachinecode(String machinecode) {
		this.machinecode = machinecode;
	}

	public double getHrsused() {
		return hrsused;
	}

	public void setHrsused(double hrsused) {
		this.hrsused = hrsused;
	}

	public double getMachinetotal() {
		return machinetotal;
	}

	public void setMachinetotal(double machinetotal) {
		this.machinetotal = machinetotal;
	}

}
