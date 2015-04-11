package com.abirfaisal.jBrowser;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;



public class Main extends Application {

    String defaultURL = "https://www.google.com/";


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        //Set Window Title
        stage.setTitle("jBrowser");

        Button back = new Button();
        back.setText("<");

        Button forward = new Button();
        forward.setText(">");

        TextField addressBar = new TextField();
        AnchorPane.setTopAnchor(addressBar, 2.0);




        AnchorPane addressBarAnchorPane = new AnchorPane();
        AnchorPane.setTopAnchor(addressBarAnchorPane,2.0);
        AnchorPane.setBottomAnchor(addressBarAnchorPane,0.0);
        AnchorPane.setLeftAnchor(addressBarAnchorPane,0.0);
        AnchorPane.setRightAnchor(addressBarAnchorPane,0.0);
        addressBarAnchorPane.getChildren().addAll(back, forward, addressBar);



        Text loadPercent = new Text(null);
        loadPercent.setTextOrigin(VPos.CENTER);


        ProgressBar progressBar = new ProgressBar();
        AnchorPane.setLeftAnchor(progressBar,32.0);
        AnchorPane.setRightAnchor(progressBar,2.0);



        AnchorPane progressAnchorPane = new AnchorPane();
        AnchorPane.setTopAnchor(progressAnchorPane,30.0);
        AnchorPane.setBottomAnchor(progressAnchorPane,0.0);
        AnchorPane.setLeftAnchor(progressAnchorPane,0.0);
        AnchorPane.setRightAnchor(progressAnchorPane,0.0);

        progressAnchorPane.getChildren().addAll(loadPercent, progressBar);


        AnchorPane topAnchorPane = new AnchorPane();
        //set min height

        ListView tabList = new ListView();

        AnchorPane.setTopAnchor(tabList,0.0);
        AnchorPane.setBottomAnchor(tabList,0.0);
        AnchorPane.setLeftAnchor(tabList,0.0);
        AnchorPane.setRightAnchor(tabList,0.0);

        AnchorPane listAnchorPane = new AnchorPane();
        listAnchorPane.getChildren().add(tabList);



        SplitPane leftSplitPane = new SplitPane();
        AnchorPane.setTopAnchor(leftSplitPane,0.0);
        AnchorPane.setBottomAnchor(leftSplitPane,0.0);
        AnchorPane.setLeftAnchor(leftSplitPane,0.0);
        AnchorPane.setRightAnchor(leftSplitPane,0.0);

        leftSplitPane.setOrientation(Orientation.VERTICAL);
        leftSplitPane.getItems().addAll(topAnchorPane, listAnchorPane);


        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.getChildren().addAll(leftSplitPane);



        //Create WebView with default settings
        //TODO replace with tab
        WebView webView = new WebView();

        AnchorPane.setTopAnchor(webView,0.0);
        AnchorPane.setBottomAnchor(webView,0.0);
        AnchorPane.setLeftAnchor(webView,0.0);
        AnchorPane.setRightAnchor(webView,0.0);

        //Create WebView with default settings

        WebEngine webEngine = webView.getEngine();
        webEngine.load(defaultURL);


        AnchorPane rightAnchorPane = new AnchorPane();
        rightAnchorPane.getChildren().add(webView);


        SplitPane mainSplitPane = new SplitPane();
        mainSplitPane.setDividerPositions(0.25);
        AnchorPane.setTopAnchor(mainSplitPane, 0.0);
        AnchorPane.setBottomAnchor(mainSplitPane,0.0);
        AnchorPane.setLeftAnchor(mainSplitPane,0.0);
        AnchorPane.setRightAnchor(mainSplitPane,0.0);
        //Add stuff to the split pane
        mainSplitPane.getItems().addAll(leftAnchorPane, rightAnchorPane);





        AnchorPane mainWindow = new AnchorPane();
        mainWindow.setPrefSize(800, 600);
        mainWindow.getChildren().add(mainSplitPane);


        Scene mainScene = new Scene(mainWindow);

        stage.setScene(mainScene);

        //Show the window
        stage.show();
    }






}