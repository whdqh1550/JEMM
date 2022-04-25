package application.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Table {
	
	private ArrayList<HotelRooms> hotel;
	private int numberOfRooms = 0;
	private int available = 0;
	private int unAvailable = 0;

	public Table() throws IOException {
		hotel = new ArrayList<HotelRooms>();
		populateTable();
	}
	
	public void populateTable() throws IOException
	{
		File file = new File("src/data.csv");
		
		/*if(!file.exists())
		{
			System.out.println("File not found");
		}
		else
		{
			System.out.println("File found");
		}*/
		
		FileReader readFile = new FileReader(file);
		try(BufferedReader br = new BufferedReader(readFile))
		{
			String line = br.readLine();
			line = br.readLine();
			//System.out.println(line);
			//String line = br.readLine();
			while(line != null)
			{
				String[] hotelData = line.split(",");
				//System.out.println(hotelData[0]);
				int roomNumber = Integer.valueOf(hotelData[0]);
				String firstName;
				String lastName;
				String phoneNumber;
				String checkIn;
				String checkOut;
				String isAvailable;
				//System.out.println("Size: " +hotelData[7]);
				if(hotelData[7].equalsIgnoreCase("FALSE"))
				{
					isAvailable = "N";
					firstName = hotelData[1];
					lastName = hotelData[2];
					phoneNumber = hotelData[3];
					checkIn = hotelData[4];
					checkOut = hotelData[5];
					unAvailable++;
					
				}
				else
				{
					isAvailable = "Y";
					firstName = "";
					lastName = "";
					phoneNumber = "";
					checkIn = "";
					checkOut = "";
					available++;
				}
				
				HotelRooms hotel = new HotelRooms(firstName, lastName, roomNumber,
						checkIn, checkOut, phoneNumber, isAvailable);
				
				addHotels(hotel);
				
				line = br.readLine();
			}
			
			br.close();
			
		}
		
		setNumberOfRooms();
	}
	
	public void addHotels(HotelRooms h)
	{
		hotel.add(h);
	}

	public HotelRooms getHotel(int index) {
		return hotel.get(index);
	}

	public void setHotel(ArrayList<HotelRooms> hotel) {
		this.hotel = hotel;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	private void setNumberOfRooms() {
		this.numberOfRooms = hotel.size();
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getUnAvailable() {
		return unAvailable;
	}

	public void setUnAvailable(int unAvailable) {
		this.unAvailable = unAvailable;
	}
	
	
	
	

}
