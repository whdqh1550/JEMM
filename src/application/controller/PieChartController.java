package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

public class PieChartController implements Initializable{
	
	private Table t;
	
	@FXML
	private PieChart roomChart;
	
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		try {
			t = new Table();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObservableList<PieChart.Data> pieChartData = 
    			FXCollections.observableArrayList(
    			new PieChart.Data("Available", t.getAvailable()),
    			new PieChart.Data("Unavaialble", t.getUnAvailable()));
    		roomChart.setData(pieChartData);
    		roomChart.setTitle("Rooms Available");
	}

}
