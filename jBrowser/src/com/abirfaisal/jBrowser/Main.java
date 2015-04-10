package com.abirfaisal.jBrowser;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        TextField addressBar = new TextField();
        addressBar.setMinWidth(200);
        addressBar.setMinHeight(50);


        stage.setTitle("HTML");
        //stage.setWidth(800);
        //stage.setHeight(600);
        Scene scene = new Scene(new Group());

        VBox root = new VBox();

        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();


        FlowPane pane = new FlowPane();

        pane.getChildren().addAll(browser, addressBar);


        webEngine.load("https://www.google.com");


        root.getChildren().addAll(pane);

        scene.setRoot(root);

        stage.setScene(scene);
        stage.show();


    }


    public static void main(String[] args) {

        launch(args);

    }
}