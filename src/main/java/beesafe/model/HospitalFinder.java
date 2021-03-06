package main.java.beesafe.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpException;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.*;

/**
 * used to get the next hospital for a adress
 * @author Sebastian
 *
 */
public class HospitalFinder {
	private static final String ENCODING = StandardCharsets.UTF_8.name();
    private String id;
    private String appCode;
    
    public HospitalFinder() {
        this.id = "Cg97H0BDUFqJPuMj6dyB";
        this.appCode = "Ta5UKGEqT6z2QtPNRPzqCA";
    }
    
    /**
     * gets the geocoordinates for a location. If the location could not be mapped to a geocoord. the geocoord returned will be a empty string.
     * @param location the parts of the location must be seperated with '+', or else here.com cannot evaluate the geocoordinates
     * @return the geocoordinates in format latitude,longitude or a empty string
     */
    private String getGeoCoordinates(String location) {
    	String coord = "";
        try {
            location = URLEncoder.encode(location, ENCODING);
            HttpsURLConnection connection = (HttpsURLConnection) new URL("https://geocoder.api.here.com/6.2/geocode.json"
                    + "?app_id=" + id
                    + "&app_code=" + appCode
                    + "&searchtext=" + location).openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200 || responseCode == 201) {
                JsonObject obj = Json.parse(new BufferedReader(new InputStreamReader(connection.getInputStream()))).asObject();
                obj = obj.get("Response").asObject();
                JsonArray array = (JsonArray) obj.get("View");
                if(!array.isEmpty()) {
                    obj = array.get(0).asObject();
                    array = (JsonArray) obj.get("Result");
                    obj = array.get(0).asObject();
                    obj = obj.get("Location").asObject();
                    obj = obj.get("DisplayPosition").asObject();
                    coord += obj.getFloat("Latitude", (float) 0.0) + ",";
                    coord += obj.getFloat("Longitude", (float) 0.0);
                } 
            }

        } catch (Exception ex) {
        	coord = "";
        }
        return coord;
    }
	
    /**
     * gets the address for the nearest hospital for a geocoordinate.
     * @param coord the actual position in format latitude,longitude
     * @return the address of the next hospital or null when sth went wrong. result array:
     * 		[0] = hospital name
     * 		[1] = street
     * 		[2] = city and postal code
     */
    private String[] getNextHospital(String coord) {  	
    	String[] hospitalContact = new String[3];
    	try {
            coord = URLEncoder.encode(coord, ENCODING);
            HttpsURLConnection connection = (HttpsURLConnection) new URL("https://places.cit.api.here.com/places/v1/discover/search"
                    + "?app_id=" + id
                    + "&app_code=" + appCode
                    + "&at=" + coord
                    + "&q=krankenhaus").openConnection();
            connection.setRequestProperty("accept", "application/json");
            
            int responseCode = connection.getResponseCode();
            if (responseCode == 200 || responseCode == 201) {
                JsonObject obj = Json.parse(new BufferedReader(new InputStreamReader(connection.getInputStream(), ENCODING))).asObject();
                obj = obj.get("results").asObject();
                JsonArray array = obj.get("items").asArray();
                obj = array.get(0).asObject();
                hospitalContact[0] = obj.getString("title", "hospitalname");
                String address = obj.getString("vicinity", "adress");
                hospitalContact[1] = address.split("<br/>")[0];
                hospitalContact[2] = address.split("<br/>")[1];
            } else {
            	throw new HttpException("Response code: " + responseCode);
            }

        } catch (Exception ex) {         
        	hospitalContact = null;
        }
    	return hospitalContact;
    }
    
    /**
     * gets the hospital address for a location. 
     * @param location the location from whoch the search should originate. location must be in format word+word e.g.: marienplatz+1+muenchen
     * @return the address of the next hospital or null when sth went wrong. result array:
     * 		[0] = hospital name
     * 		[1] = street
     * 		[2] = city and postal code
     */
    public String[] getNextHospitalAddress(String location) {
    	return this.getNextHospital(getGeoCoordinates(location));
    }
    
}
