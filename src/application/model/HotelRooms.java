package application.model;

public class HotelRooms extends Person{
	int roomNumber;
	String checkIn;
	String checkOut;
	String phoneNumber;
	boolean isAvailable;
	
	public HotelRooms() {
		super();
	}

	public HotelRooms(String firstName, String lastName, int roomNumber, 
			String checkIn, String checkOut, String phoneNumber, boolean isAvailable) {
		super(firstName, lastName);
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.phoneNumber = phoneNumber;
		this.isAvailable = isAvailable;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "HotelRooms [roomNumber=" + roomNumber + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", phoneNumber=" + phoneNumber + ", isAvailable=" + isAvailable + "]";
	}
	
	
	

}
