package application;

public class GuestInfo {
	String firstName;
	String lastName;
	int roomNumber;
	String checkIn;
	String checkOut;
	
	public GuestInfo(String firstName, String lastName, int roomNumber, String checkIn, String checkOut) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	

}
