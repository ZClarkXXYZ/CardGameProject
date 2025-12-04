package com.example.cardgameproject;
/**
 * Filename:    GameApplication.java
 * Purpose:     Main JavaFX application entry point. Initializes the game
 *              window and loads the primary FXML scene.
 * FXML File: main.fxml
 * Controller: GameController.java
 * Author: ZC
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GameApplication extends Application {
    @Override
    // Starts JavaFX application, loads main.fxml and displays the game window
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("main.fxml"));
        Scene sceneMain = new Scene(fxmlLoader.load());
        stage.setTitle("Card Game");
        stage.setScene(sceneMain);
        stage.show();
    }

     // Application entry point method
    public static void main(String[] args) {
        launch();
    }
}
