package application;
	
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			JFXButton button;
			JFXTextField tHash;
			Parent root = FXMLLoader.load(getClass()
                    .getResource("home.fxml"));
			Scene scene = new Scene(root);
			HashTask hTask = new HashTask(scene);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hashing Utility");
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(700);
			primaryStage.setMaxHeight(500);
			primaryStage.setMaxWidth(700);
			primaryStage.initStyle(StageStyle.UNIFIED);
			primaryStage.show();
			
			button =  (JFXButton) scene.lookup("#bHash");
			JFXButton copyButton = (JFXButton) scene.lookup("#copy");
			tHash = (JFXTextField) scene.lookup("#tHash");
//			button.setOnAction(e -> new Thread(hController).start());
			button.setOnAction(e -> {
				Platform.runLater(hTask);
			});

			copyButton.setOnAction(e -> {
				final Clipboard clipboard = Clipboard.getSystemClipboard();
				final ClipboardContent content = new ClipboardContent();
				content.putString(tHash.getText());
				clipboard.setContent(content);

			});
		
		} catch(Exception e) {
			System.out.println("Unexpectedn error: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
