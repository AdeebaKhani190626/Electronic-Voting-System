package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage NewScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("StartPage.fxml"));
			Scene scene = new Scene(root,653,455);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			NewScene = primaryStage;
			primaryStage.setTitle("EVM");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void NextScene(String nextStage) throws IOException {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(nextStage));
		Scene scene = new Scene(root,653,455);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		NewScene.setTitle("EVM");
		NewScene.setScene(scene);
		NewScene.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
