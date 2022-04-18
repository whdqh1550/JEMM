package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import application.model.Data;
import application.model.HotelRooms;
import application.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController implements Initializable{
	
	private Table t;
	
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
	 
	 @FXML
	 private TableColumn<HotelRooms, String> available;
	 
	
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		roomNumber.setCellValueFactory(new PropertyValueFactory<HotelRooms, Integer>("roomNumber"));
		available.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("available"));
		firstName.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("firstName"));
    	lastName.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("lastName"));
    	checkIn.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("checkIn"));
    	checkOut.setCellValueFactory(new PropertyValueFactory<HotelRooms, String>("checkOut"));
    	
    	try {
			t = new Table();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    	List<HotelRooms> table = new ArrayList<HotelRooms>();
    	List<HotelRooms> table2 = new ArrayList<HotelRooms>();
    	for(int i = 0; i < t.getNumberOfRooms(); i++)
    	{
    		if(t.getHotel(i).isAvailable() == "Y")
    			table.add(t.getHotel(i));
    		else
    			table2.add(t.getHotel(i));
    	}
    	
    	guestTable.getItems().addAll(table2);
    	guestTable.getItems().addAll(table);
    	
	}

}
