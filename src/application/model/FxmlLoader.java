package application.model;

import java.io.File;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlLoader {
	private Pane view;
	
	public Pane getNewWindow(String filePath) {
		try {
			URL url = new File(filePath).toURI().toURL();
			System.out.println(url);
			if (url == null) {
				throw new Exception();
			}
			view = FXMLLoader.load(url);
		}
		catch(Exception e) {
			System.out.println("exception file didnt load");
		}
		return view;
	}
}
