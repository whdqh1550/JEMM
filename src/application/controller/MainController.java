package application.controller;


import application.model.FxmlLoader;
import application.model.Table;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainController implements Initializable{
	
	private Table t;

	@FXML
    private BorderPane borderPane;

    @FXML
    private Button searchButton;

    @FXML
    private Button exitButton;

    @FXML
    private ImageView logoImage;

    @FXML
    private Button moreButton;

    @FXML
    private Button calanderButton;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private VBox vb;

    @FXML
    private Button bookingButton;

    @FXML
    private Button homeButton;

    @FXML
    private Label roomUnavailableLabel;

    @FXML
    private Label totalRoomLabel;

    @FXML
    private Label roomAvailableLabel;

    @FXML
    private Label unavailableNumLabel;
    
    @FXML
    private Label availableNumLabel;
    
    @FXML
    private Label roomsLabel;
    
    @FXML
    void SwitchToHome(ActionEvent event) throws IOException {
    	loadHomePage();
//    	t = new Table();
    	t.populateTable();
    	availableNumLabel.setText(Integer.toString(t.getAvailable()));
    	unavailableNumLabel.setText(Integer.toString(t.getUnAvailable()));
    	totalRoomLabel.setText(Integer.toString(t.getAvailable() + t.getUnAvailable()));
    }
    
    
    @FXML
    void PressedBookingButton(ActionEvent event) {
    	FxmlLoader scene = new FxmlLoader();
    	Pane view = scene.getPane("src/Booking.fxml");
    	borderPane.setCenter(view);
    	borderPane.setRight(null);
    }
    @FXML
    void calListener(ActionEvent event) {
    	FxmlLoader scene = new FxmlLoader();
    	Pane view = scene.getPane("src/Calender.fxml");
    	borderPane.setCenter(view);
    	borderPane.setRight(null);
    }
    
    @FXML
    void exitProgram(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void switchToSearch(ActionEvent event) {
    	FxmlLoader scene = new FxmlLoader();
    	Pane view = scene.getPane("src/Search.fxml");
    	borderPane.setCenter(view);
    	borderPane.setRight(null);
    }
    @FXML
    void loadHomePage()
    {
    	FxmlLoader scene = new FxmlLoader();
    	Pane view = scene.getPane("src/Table.fxml");
    	borderPane.setCenter(view);
    	
    	FxmlLoader scene2 = new FxmlLoader();
    	Pane view2 = scene2.getPane("src/PieChart.fxml");
    	borderPane.setRight(view2);
    }
    
    public void initialize(URL arg0, ResourceBundle arg1)
    {
    	try {
			t = new Table();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	availableNumLabel.setText(Integer.toString(t.getUnAvailable()));
    	unavailableNumLabel.setText(Integer.toString(t.getAvailable()));
    	totalRoomLabel.setText(Integer.toString(t.getAvailable() + t.getUnAvailable()));
    	loadHomePage();
    }
    

}
