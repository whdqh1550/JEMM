package application;
	
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/Main.fxml").toURI().toURL();
			AnchorPane root = FXMLLoader.load(url);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.setStyle(
		            "-fx-background-image: url(" +
		                "background.jpg" +
		            "); " +
		            "-fx-background-size: cover;"
		        );
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setMaximized(true);
			primaryStage.setTitle("Hotel Management"); 
			
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
}
