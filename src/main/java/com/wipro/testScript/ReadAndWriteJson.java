package com.wipro.testScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadAndWriteJson {
	
	    @SuppressWarnings("unchecked")
	    public static void main(String[] args) { 
	    	try {
	    		//reading the json file
	    		FileReader reader = new FileReader("employee.json");
	    		
	    		JSONParser jsonparser = new JSONParser();
	    		
				JSONObject jsonObject = (JSONObject) jsonparser.parse(reader);
				
				JSONObject employee = (JSONObject) jsonObject.get("employee");
				
				String companyName =  (String) employee.get("companyName");
				//Checking for the company name and changing the value
				if(companyName.equals("Wipro")){
					employee.put("companyName", "Wipro Ltd");
				}
				//Writing into an new file
					FileWriter file = new FileWriter("employee1.json");
					file.write(employee.toJSONString());			
					file.flush();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}	
	}
}

