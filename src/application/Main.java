package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
	
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stg = primaryStage;
		primaryStage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		primaryStage.setTitle("Genshin Cafe");
		primaryStage.setScene(new Scene(root, 1280, 720));
		primaryStage.show();
	}
	
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
