package main.java.beesafe.model;

public class Emergency {
	private static int emergencyCall = 112;
	private String address;
	
	public Emergency(String address) {
		this.address = address;
	}
	
	public int getEmergencyCall() {
		return emergencyCall;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String toString() {
		String toString = String.format("Notrufnummer: %s\nAdresse: %s",
				emergencyCall, address);
		return toString;
	}
}
