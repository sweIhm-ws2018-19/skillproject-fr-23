package main.java.beesafe.model;

public class Injury {
	private String injury; 
	
	public Injury(String injury) { 
		this.injury = injury; 
	}
	
	public void setInjury(String injury) { 
		this.injury = injury; 
	}
	
	public String getInjury() { 
		return injury; 
	}
	
	public boolean isValid() { 
		return (injury != null && !injury.isEmpty()); 
	}
}
