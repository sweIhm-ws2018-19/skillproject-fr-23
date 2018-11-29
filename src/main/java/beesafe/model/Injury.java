package beesafe.model;

import java.util.ArrayList;

public class Injury {
	private String injury;
	private ArrayList<HouseholdRemedy> households;
	private ArrayList<Risk> risks;
	
	public Injury(String injury) { 
		this.injury = injury; 
	}
	
	public String getInjury() { 
		return injury; 
	}
	
	public void setHouseholds(ArrayList<HouseholdRemedy> households) {
		this.households = households;
	}
	
	public void setRisks(ArrayList<Risk> risks) {
		this.risks = risks;
	}
	
	public boolean isValid() { 
		return (injury != null && !injury.isEmpty()); 
	}
	
	public String toString() {
		String toString = String.format("Name: %s\n\nRisikofaktoren: \n", injury);
		toString += "\nRisikofaktoren: \n";
		for(Risk r:risks) {
			toString+= r.toString() + "\n";
		}
		for(HouseholdRemedy h:households) {
			toString += h.toString() + "\n";
		}
		return toString;			
	}
}
