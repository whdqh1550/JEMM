package application.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import application.model.Data;

public class BookingController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private DatePicker dateStart;
    @FXML
    private TextField guestsField;
    @FXML
    private DatePicker dateEnd;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextArea infoTextArea;
    @FXML
    private TextField nameField;

    @FXML
    void ConfirmBookingPressed(ActionEvent event) throws Exception {
    	String[] name=  nameField.getText().toString().split(" ");
        String phoneNumber= phoneNumberField.getText().toString();
        String roomNum="";
        String guestNum=guestsField.getText().toString();
        LocalDate dateStartString = dateStart.getValue();
        LocalDate dateEndString = dateEnd.getValue();
        System.out.println(dateStartString);
        ObservableList listofItems=listView.getSelectionModel().getSelectedItems();
        for(Object item : listofItems){
        	roomNum+=String.format("%s", (String)item);
        }
        Alert error= new Alert(AlertType.ERROR);
        if(roomNum.length() == 0) {
    	  error.setContentText("Select a room!");
    	  error.showAndWait();
    	  return;
        }
        if(name.length == 0 || phoneNumber.length() == 0 || guestNum.length() == 0
          || dateStart.getValue() == null || dateEnd.getValue() == null) {
    	  error.setContentText("Fill in all boxes!");
    	  error.showAndWait();
    	  return;
        }
//        System.out.println("thisaf");
        ArrayList<String> roomInfo = new ArrayList<String>();	
//        Data var = new Data();
//        var.loadData();
        
        roomInfo.add(name[0]);
        roomInfo.add(name[1]);
        roomInfo.add(phoneNumber);  
        roomInfo.add(dateStartString.toString());
        roomInfo.add(dateEndString.toString());
        roomInfo.add(guestNum);
        roomInfo.add("False");
        System.out.println(roomNum);
        
        Data.addRoomInfo(roomNum,  roomInfo); //call addItem function in model class
//        Data.loadData();
        nameField.clear();
        phoneNumberField.clear();
        guestsField.clear();
}	

    @FXML
    void CheckAvailabilityPressed(ActionEvent event) {
    	Map<String, ArrayList<String>> localData = new HashMap<String, ArrayList<String>>();
    	ArrayList<String> localRoomInfo = new ArrayList<String>();
    	ObservableList listOfItems=listView.getSelectionModel().getSelectedItems();
    	localData = Data.getData();
    	int roomInfo = Integer.parseInt(listOfItems.get(0).toString());//get item selected
    	localRoomInfo = localData.get(listOfItems.get(0).toString());
    	//System.out.println(localRoomInfo.get(0));
    	String info = "";
    	for(int i = 0; i < 7; i++) {
    		info += localRoomInfo.get(i) + " ";
    	}
    	infoTextArea.setText(info);
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){	

    	try {
			Data.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	ArrayList<String> localRoomNums = new ArrayList<String>();
    	localRoomNums = Data.getRoomNums();
    	listView.getItems().clear();
		listView.getItems().addAll(localRoomNums);
		//listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
}
