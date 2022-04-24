package application.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class Search {
	 //getting already filled hashmap
	 //static Map<String, ArrayList<String>> rawData = Data.getData();
	
	//filters data and returns filtered data Hashmap
	public static Map<String, ArrayList<String>> filterData(String userInput) throws IOException {
		//create filteredData hashmap to fill out
		Map<String, ArrayList<String>> rawData = new HashMap<String, ArrayList<String>>();
		rawData = Data.getData();
		
		
		Map<String, ArrayList<String>> filteredData = new HashMap<String, ArrayList<String>>();
		
		//System.out.println(rawData);
		
		for(Map.Entry<String, ArrayList<String>> data : rawData.entrySet()) {
			//possibly replace data.getValue().contains() with data.getValue().equals if doesn't work
			if(data.getKey().equals(userInput) || data.getValue().contains(userInput)) {
				filteredData.put(data.getKey(), data.getValue());
				
			}
		}
		
		//System.out.println(filteredData);
		return filteredData;
		
	}
	
	public String arrayToString(ArrayList<String> arrList) {
		String result = new String();
		   
		for (int i = 0; i < arrList.size();i++) 
	      { 		      
	          System.out.println(arrList.get(i)); 		
	      }
		
		return result;
		
	}
	
	
}
