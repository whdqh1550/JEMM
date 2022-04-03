package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import application.model.Data;

public class BookingController {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField nameField;

    @FXML
    void ConfirmBookingPressed(ActionEvent event) throws Exception {
    	ArrayList<String> roomInfo = new ArrayList<String>();
    	String name=  nameField.getText().toString();
   	 	String phoneNumber= phoneNumberField.getText().toString();
   	 	roomInfo.add(name);
   	 	roomInfo.add(phoneNumber);	
   	  	Data.addRoomInfo("15",  roomInfo); //call addItem function in model class
   	  	nameField.clear();
   	  	phoneNumberField.clear(); 
    }

    @FXML
    void CheckAvailabilityPressed(ActionEvent event) {

    }

}
