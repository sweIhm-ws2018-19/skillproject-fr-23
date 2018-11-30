package main.java.beesafe.model;

public class HouseholdRemedy {
	private String name;
	private boolean instock;
	private String action;
	
	public HouseholdRemedy(String name, String action) {
		this.name = name;
		instock = false;
		this.action = action;
	}
	
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
	
	public String toString() {
		String toString = String.format("Name: %s\n\nVorraetig: %s\n\n"
				+ "Anwendung: %s", name, instock, action);
		return toString;
	}
}
