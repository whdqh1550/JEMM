package application.controller;

import application.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainController {

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

    @FXMLs
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
    void PressedBookingButton(ActionEvent event) {
    	System.out.println("this");
    	FxmlLoader scene = new FxmlLoader();
    	Pane view = scene.getNewWindow("src\\Booking.fxml");
    	borderPane.setCenter(view);
    }
    
}
