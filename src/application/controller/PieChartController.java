package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

public class PieChartController implements Initializable{
	
	  @FXML
	  private PieChart roomChart;
	
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		ObservableList<PieChart.Data> pieChartData = 
    			FXCollections.observableArrayList(
    			new PieChart.Data("Available", 25),
    			new PieChart.Data("Unavaialble", 25));
    		roomChart.setData(pieChartData);
    		roomChart.setTitle("Rooms Available");
	}

}
