package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
	private Button listAllButton;
	
	@FXML
	private TextArea resultArea;
	
	//print full list
	@FXML
	public void listAll(ActionEvent event) throws IOException {
		resultArea.clear();
		
		
	}
	
	//search for value from user input
	@FXML
	public void searchAction(ActionEvent event) throws IOException {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Autofill up
		
	}

}
