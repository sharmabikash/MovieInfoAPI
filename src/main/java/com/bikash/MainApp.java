package com.bikash;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load FXML from the correct folder
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/view/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Set title
        stage.setTitle("Movie Search App 🎬");

        // Set icon from /view/icon.png
        stage.getIcons().add(new Image(MainApp.class.getResourceAsStream("/view/icon.png")));

        // Apply stylesheet from /view/styles.css
        scene.getStylesheets().add(MainApp.class.getResource("/view/styles.css").toExternalForm());

        // Show the stage
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
