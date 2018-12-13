package main.java.beesafe.model;

import java.util.List;

public class Injury {
	private String actualInjury;
	private List<HouseholdRemedy> households;
	private List<Risk> risks;
	
	public Injury(String injury) { 
		this.actualInjury = injury; 
	}
	
	public String getInjury() { 
		return actualInjury; 
	}
	
	public void setHouseholds(List<HouseholdRemedy> households) {
		this.households = households;
	}
	
	public void setRisks(List<Risk> risks) {
		this.risks = risks;
	}
	
	public boolean isValid() { 
		return (actualInjury != null && !actualInjury.isEmpty()); 
	}
	
	public String toString() {
		StringBuilder bldr = new StringBuilder();
		bldr.append(String.format("Name: %s" + "\nRisikofaktoren:" + "\n", actualInjury));
		for(Risk r:risks) {
			bldr.append(r.toString() + "\n");
		}
		bldr.append("Hausmittel: \n");
		for(HouseholdRemedy h:households) {
			bldr.append(h.toString() + "\n");
		}
		return bldr.toString();			
	}
}
