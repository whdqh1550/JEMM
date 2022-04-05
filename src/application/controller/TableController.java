package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.HotelRooms;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable{
	
	 @FXML
	 private TableView<HotelRooms> guestTable;

	 @FXML
	 private TableColumn<HotelRooms, String> firstName;

	 @FXML
	 private TableColumn<HotelRooms, String> lastName;

	 @FXML
	 private TableColumn<HotelRooms, Integer> roomNumber;

	 @FXML
	 private TableColumn<HotelRooms, String> checkIn;

	 @FXML
	 private TableColumn<HotelRooms, String> checkOut;
	
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		firstName.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("firstName"));
    	lastName.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("lastName"));
    	roomNumber.setCellValueFactory(new PropertyValueFactory<HotelRooms, Integer>("roomNumber"));
    	checkIn.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("checkIn"));
    	checkOut.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("checkOut"));
	}

}
