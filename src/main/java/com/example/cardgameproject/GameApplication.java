package com.example.cardgameproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("main.fxml"));
        Scene sceneMain = new Scene(fxmlLoader.load());
        stage.setTitle("Card Game");
        stage.setScene(sceneMain);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}