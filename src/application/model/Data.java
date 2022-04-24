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
import java.util.stream.Stream;

public class Data {
	private static Map<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>(); //hashmap type map, takes string and arraylist of type string, to hold multiple values per key
//	private static Properties properties=new Properties();
//	private static HashMap<String, String> h1=new HashMap<String,String>();
//	private static int csvCurrentLine = 10;
	private static ArrayList<String> roomNums = new ArrayList<String>();
	public static void addRoomInfo (String room, ArrayList<String> roomInfo) throws Exception{
		
//		if(data.containsKey(room)) {
//			System.out.println("room taken bye");
//			return;
//		} 
		
		data.put(room, roomInfo); //adding to data structure 
//		h1.put("room", "this");
		System.out.println("Room booked: " + room +"\tRoom information: "+ roomInfo);
		
		File dir = new File("src/data.csv");
		String loc = dir.getCanonicalPath();
 
		FileWriter fstream = new FileWriter(loc, true);
		BufferedWriter out = new BufferedWriter(fstream);
		String toCSV = "";
		toCSV += room;
		for (int i = 0; i < roomInfo.size(); ++i) {
			toCSV += ","+roomInfo.get(i);
		}	
		out.write(toCSV);
		out.newLine();
		loadData();
		out.close();

	}
	public static ArrayList<String> getRoomNums() {
		return roomNums;
	}
	public static void setRoomNums(ArrayList<String> roomNums) {
		Data.roomNums = roomNums;
	}
	public static void loadData() throws IOException {
//		Map<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
		
		File file = new File("src/data.csv");
		if (!(file.exists())) { //exception 
			throw new IOException();
		}
		FileReader stream = new FileReader(file);
		BufferedReader buffer = new BufferedReader(stream);
		String line;
		String room = "";
		int largestRoomNum = 0;
		while((line = buffer.readLine()) != null) {
			ArrayList<String> csvDataArray = new ArrayList<String>();
			String [] csvLine = {}; //array to split the csv information 
			csvLine = line.split(",");
//			for (int i=0; i < csvLine.length; i++) {
//				System.out.print(csvLine[i]);
//			}
//			System.out.println("           " +line);
			room = csvLine[0];
//			System.out.println(room);
			if(room.matches("[0-9]+") && Integer.parseInt(room)> largestRoomNum) {
				largestRoomNum = Integer.parseInt(room);
			}
//			System.out.println("thisa");
			for (int i = 1; i < csvLine.length; ++i) {
				csvDataArray.add(csvLine[i]);
			}
			data.put(room, csvDataArray);
//			csvCurrentLine++;
		}
		for(int i = 1; i < largestRoomNum; ++i) {
			if (!roomNums.contains(String.valueOf(i))) {
				roomNums.add(String.valueOf(i));
			}
		}
//		System.out.println("this");
		
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
}
