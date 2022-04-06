package application.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Data;

public class BookingController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField phoneNumberField;
    
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField nameField;

    @FXML
    void ConfirmBookingPressed(ActionEvent event) throws Exception {
    	ArrayList<String> roomInfo = new ArrayList<String>();
    	Data var = new Data();
    	var.loadData();
    	String name=  nameField.getText().toString();
   	 	String phoneNumber= phoneNumberField.getText().toString();
   	 	roomInfo.add(name);
   	 	roomInfo.add(phoneNumber);	
   	 	String roomNum="";
   	 	ObservableList listofItems=listView.getSelectionModel().getSelectedItems();
   	 	for(Object item : listofItems){
   	 		roomNum+=String.format("%s", (String)item);
   	 	}
   	 	System.out.println(roomNum);
   	 	
   	  	var.addRoomInfo(roomNum,  roomInfo); //call addItem function in model class
//   	 	Data.loadData();
   	  	nameField.clear();
   	  	phoneNumberField.clear(); 
    }

    @FXML
    void CheckAvailabilityPressed(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){	
    	int[] a = new int[75];
//    	for (int i = 1; i < 76; i++) {
//    		a[i-1] = i;
//    		System.out.println(a[i-1]);
//    	}
    	
		listView.getItems().addAll("1","2","3","4","5", "51");
		try {
			Data.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 //listview.getItems().addAll("Vogue1","Time2","Elle2","Fortune2");
		 //listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
}
