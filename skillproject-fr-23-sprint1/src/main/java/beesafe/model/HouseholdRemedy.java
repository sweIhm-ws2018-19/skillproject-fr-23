package main.java.beesafe.model;

public class HouseholdRemedy {
	private String name;
	private boolean instock;
	private String action;
	
	public String getName() {
		return name;
	}
	
	public String getAction() {
		return action;
	}
	
	public boolean getInstock() {
		return instock;
	}
	
	public void setInstock(boolean instock) {
		this.instock = instock;
	}
}
