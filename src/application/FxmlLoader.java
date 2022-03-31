package application;


import java.io.File;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlLoader {
	private Pane view;
	public Pane getPane(String filePath) {
			try {
//				 url = Main.class.getResource(filePath);
				 URL url = new File(filePath).toURI().toURL();
				if (filePath == null) {
					throw new Exception();
				}
				view = FXMLLoader.load(url);
			}
			catch(Exception e){
				System.out.println("file didnt open or doesnt exist");
			}
			return view;
	}
}
