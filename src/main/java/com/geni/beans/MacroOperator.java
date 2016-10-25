package com.geni.beans;

public class MacroOperator {
	private int macid;
	private String domain;
	private String resource;
	private String precondition;
	private float totalCost;
	private int ApplicationIdentifie;
	public int getMacid() {
		return macid;
	}
	public String getDomain() {
		return domain;
	}
	public String getResource() {
		return resource;
	}
	public String getPrecondition() {
		return precondition;
	}
	public float getTotalCost() {
		return totalCost;
	}
	
	public void setMacid(int macid) {
		this.macid = macid;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	
	public void setApplicationIdentifie(int applicationIdentifie) {
		ApplicationIdentifie = applicationIdentifie;
	}
	public int getApplicationIdentifie() {
		return ApplicationIdentifie;
	}
	
	
}
