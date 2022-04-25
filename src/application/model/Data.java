package application.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;

public class Data {
	/*
	 * Data class will handle data storage of rooms in hashmap and initialized by reading csv file.
	 * will then write to csv file and update hashmap when new information is entered. Couldnt get csvreader to work
	 * so what I did was read all data in hashmap, update hashmap with new information then write it all to csv file.
	 * couldve used properties but too far in before learning it. 
	 * Load Data will handle reading from csv and initializing hashmap when application runs then addroominfo function
	 * will handle updating data structure and csv file 
	 * 
	 * setters and getters for roomNums which is an arraylist of all room numbers and getData is used to get hashmap and
	 * store locally elsewhere is code. 
	 */
	private static Map<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>(); //hashmap type map, takes string and arraylist of type string, to hold multiple values per key
	private static ArrayList<String> roomNums = new ArrayList<String>();
	private static int largestRoomNum;
	private static ArrayList<String> readCSV = new ArrayList<String>();
	public static void addRoomInfo (String room, ArrayList<String> roomInfo) throws Exception{
		ArrayList<String> checkRoomAvail = new ArrayList<String>();
		checkRoomAvail = data.get(room);
//		System.out.println(checkRoomAvail.get(6));
		if(checkRoomAvail.get(6).compareTo("False") == 0) { //check if room is available
			System.out.println("room already taken");
			return;
		} 
		System.out.println("Room booked: " + room +"\tRoom information: "+ roomInfo);
		for (int i = 0; i < roomInfo.size(); i++) { //update arrayList with new info
			checkRoomAvail.set(i, roomInfo.get(i));
		}
		data.put(room,  checkRoomAvail); //update hashmap data with new info booked
		
		File dir = new File("src/data.csv");
		String loc = dir.getCanonicalPath();
		FileWriter fstream = new FileWriter(loc);
		BufferedWriter out = new BufferedWriter(fstream);
		
		String[] csvHeaders = new String[] {"firstName","lastName","phoneNum",
		                       "dateStart",	"dateEnd","numGuests", "isAvailable"};
		String toCSV = "roomNum";
		for (int i = 0; i < csvHeaders.length; i++) {
			toCSV += ","+csvHeaders[i];
		}
		out.write(toCSV);
		out.newLine(); 
		
		Iterator iterator = data.entrySet().iterator();
        while (iterator.hasNext()) {
        	Map.Entry me2 = (Map.Entry) iterator.next();
        	toCSV = "";
        	String checkIfStringData = me2.getKey().toString();
        	if( checkIfStringData.compareTo("roomNum") ==0){
        		continue;
        	}
			toCSV += me2.getKey().toString(); //add room num to string
			ArrayList<String> getKeyData = (ArrayList<String>) me2.getValue();
			for (int i = 0; i < roomInfo.size(); ++i) {
				toCSV += ","+ getKeyData.get(i);
			}	
			
//			System.out.println(toCSV);
			out.write(toCSV);
			out.newLine(); 
        } 
		out.close();
	}
	
	public static void loadData() throws IOException {
		File file = new File("src/data.csv");
		if (!(file.exists())) { //exception 
			throw new IOException();
		}
		FileReader stream = new FileReader(file);
		BufferedReader buffer = new BufferedReader(stream);
		String line;
		String room = "";
		while((line = buffer.readLine()) != null) {
			ArrayList<String> csvDataArray = new ArrayList<String>();
			String [] csvLine = {}; //array to split the csv information 
			csvLine = line.split(",");
			room = csvLine[0];
			if(room.matches("[0-9]+") && Integer.parseInt(room)> largestRoomNum) {
				largestRoomNum = Integer.parseInt(room);
			}
			for (int i = 1; i < csvLine.length; ++i) {
				csvDataArray.add(csvLine[i]);
			}
			data.put(room, csvDataArray);
		}
		for(int i = 1; i < largestRoomNum+1; ++i) {
			if (!roomNums.contains(String.valueOf(i))) {
				roomNums.add(String.valueOf(i));
			}
		}
//		System.out.println("loaded Data: "+dataLoad);
		Iterator iterator = data.entrySet().iterator();
        while (iterator.hasNext()) {
             Map.Entry me2 = (Map.Entry) iterator.next();
          System.out.println("Room: "+me2.getKey() + "  RoomInfo: " + me2.getValue());
        } 
		buffer.close(); //close file 
	}
	public static Map<String, ArrayList<String>> getData() {
		return data;
	}
	public static void setData(Map<String, ArrayList<String>> data) {
		Data.data = data;
	}
	public static ArrayList<String> getRoomNums() {
		return roomNums;
	}
	public static void setRoomNums(ArrayList<String> roomNums) {
		Data.roomNums = roomNums;
	}
}
