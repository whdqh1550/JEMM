package application.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Data {
	private static Map<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>(); //hashmap type map, takes string and arraylist of type string, to hold multiple values per key
	private static Properties properties=new Properties();
	private static HashMap<String, String> h1=new HashMap<String,String>();
	
	public static void addRoomInfo (String room, ArrayList<String> roomInfo) throws Exception{
		data.put(room, roomInfo);
//		h1.put("room", "this");
		System.out.println(roomInfo);
//		data.put(item,quantity);
		properties.putAll(data);
		System.out.println(data);
//		File file=new File("data.properties");
		File file = new File("data.properties");
		try {
			file.createNewFile();
			if (file.exists()) {
				System.out.println("Data file created as: " + file.getName());
			}
   		}
		catch (IOException e) {
	    	System.out.println("Data file error");
	    	e.printStackTrace();
	    }
		
		
		FileOutputStream writer = new FileOutputStream(file,true);// fileoutput used for writing to files
		System.out.println("f");
		if (writer == null) {
			System.out.println("ffffffffff");
		}
		properties.store(writer,null);//this gives error because there is list in data
		System.out.println("ff");
	}
	

}
