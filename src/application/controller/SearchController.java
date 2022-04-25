package application.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.model.Data;
import application.model.Search;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class SearchController implements Initializable{

	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private TextField userInput;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private TextArea resultArea;
	
	
	//search for value from user input
	@FXML
	public void searchAction(ActionEvent event) throws IOException {
		resultArea.clear();
		//fill in hashmap with filtered data from search class
		String input = userInput.getText().toString();
		//resultArea.appendText(input);
		Map<String, ArrayList<String>> filteredData = Search.filterData(input);
		
		//print to result area
		for (String key: filteredData.keySet()){  
			resultArea.appendText("Room Number: " + key + "\nInformation: " + filteredData.get(key) + "\n\n");
		}
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		resultArea.clear();
		try {
			Data.loadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
