package com.buttonow.simplecrudapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.*;
import java.io.IOException;

public class SimpleCrudApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SimpleCrudApp.class.getResource("simplecrud-view.fxml"));
        VBox root = fxmlLoader.load();
        Scene scene = new Scene(root);
        SimpleCrudController fxmlController = fxmlLoader.getController();


        fxmlController.loadItems();

        primaryStage.setTitle("Simple CRUD App");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
