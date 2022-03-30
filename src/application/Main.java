package application;
	
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/Main.fxml").toURI().toURL();
			AnchorPane root = FXMLLoader.load(url);
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("JEMM"); 
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		System.out.println("hi guys");//thirdtest
		System.out.println("hi guys from Erik"); //Test comment
		System.out.println("This is Marco"); //Test comment
	}
}
