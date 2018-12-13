package main.java.beesafe.model;

public class Risk {
	private String name;
	private boolean isOccured;
	
	public Risk(String name) {
		this.name = name;
		isOccured = false;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getIsOccured() {
		return isOccured;
	}
	
	public void setIsOccured(boolean isOccured) {
		this.isOccured = isOccured;
	}
	
	public String toString() {
		return String.format("Name: %s\n" + "Aufgetreten: %s", name, isOccured);
	}
}
