package com.abirfaisal.jBrowser;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage){

        TextField addressBar = new TextField();
        addressBar.setMinWidth(200);
        addressBar.setMinHeight(50);


        stage.setTitle("jBrowser");
        stage.setWidth(800);
        stage.setHeight(600);
        Scene scene = new Scene(new Group());


        final WebView browser = new WebView();
        browser.setFontSmoothingType(FontSmoothingType.LCD);



        //final WebEngine webEngine = browser.getEngine();
        //webEngine.setJavaScriptEnabled(true);

        Tab testTab = new Tab(browser.getEngine());



        //testTab.setWebContents(new WebEngine());

        //testTab.webContents.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");

        testTab.webContents.load("https://www.google.com/");

        testTab.webContents.setJavaScriptEnabled(true);





        AnchorPane Apane = new AnchorPane();


        Apane.getChildren().add(browser);


        Apane.setLeftAnchor(browser, 0.0);
        Apane.setRightAnchor(browser, 0.0);
        Apane.setTopAnchor(browser, 0.0);
        Apane.setBottomAnchor(browser, 0.0);



        scene.setRoot(Apane);

        stage.setScene(scene);
        stage.show();


    }


    public static void main(String[] args) {

        launch(args);

    }
}