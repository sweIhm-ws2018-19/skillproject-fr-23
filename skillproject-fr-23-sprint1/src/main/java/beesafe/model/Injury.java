package main.java.beesafe.model;

import java.util.ArrayList;

public class Injury {
	private String injury;
	private ArrayList<HouseholdRemedy> housholds;
	private ArrayList<Risk> risks;
	
	public Injury(String injury) { 
		this.injury = injury; 
		// Hausmittel aus den Slots holen
		// Risiken aus dem Slot holen
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
