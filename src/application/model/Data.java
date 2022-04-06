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
	private static int csvCurrentLine = 10;
	public static void addRoomInfo (String room, ArrayList<String> roomInfo) throws Exception{
		
		if(data.containsKey(room)) {
			System.out.println("room taken bye");
			return;
		}
		
		data.put(room, roomInfo); //adding to data structure 
//		h1.put("room", "this");
		System.out.println("Room booked: " + room +"\tRoom information: "+ roomInfo);
//		data.put(item,quantity);
//		System.out.println("\n"+data);
//		try (PrintWriter writer = new PrintWriter("src/data.csv")) { //adding to csv file for storage
//
//		      StringBuilder sb = new StringBuilder();
//		      
//		      String newLine = "";
//		      for (int i = 0; i < csvCurrentLine; ++i) {
//		    	  newLine += "\n";
//		      }
//		      sb.append(newLine); //use insert with given line index 
////		      sb.insert(5, "yes");
//		      sb.append(room); 
//		      sb.append(',');
//		      for (int i = 0; i < roomInfo.size(); ++i) {
//		    	  sb.append(roomInfo.get(i));
//		    	  sb.append(',');
//		      }
//		      sb.append('\n');
////		      sb.append("1");
////		      sb.append(','); //go next column
////		      sb.append("Prashant Ghimire");
////		      sb.append('\n');//go to next row
//		      writer.write(sb.toString());
//		      System.out.println("done!");
//		    } catch (FileNotFoundException e) {
//		      System.out.println(e.getMessage());
//		    }
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
		while((line = buffer.readLine()) != null) {
			ArrayList<String> csvDataArray = new ArrayList<String>();
			String [] csvLine = {}; //array to split the csv information 
			csvLine = line.split(",");
//			for (int i=0; i < csvLine.length; i++) {
//				System.out.print(csvLine[i]);
//			}
//			System.out.println("           " +line);
			room = csvLine[0];
			for (int i = 1; i < csvLine.length; ++i) {
				csvDataArray.add(csvLine[i]);
			}
			data.put(room, csvDataArray);
//			csvCurrentLine++;
		}
		
//		System.out.println("loaded Data: "+dataLoad);
		Iterator iterator = data.entrySet().iterator();
        while (iterator.hasNext()) {
             Map.Entry me2 = (Map.Entry) iterator.next();
          System.out.println("Room: "+me2.getKey() + "  RoomInfo: " + me2.getValue());
        } 
		buffer.close(); //close file 
	}
}
