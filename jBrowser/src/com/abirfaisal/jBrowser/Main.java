package com.abirfaisal.jBrowser;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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

        //Back Button
        Button back = new Button();
        back.setMnemonicParsing(false);
        back.setText("<");
        back.setTextAlignment(TextAlignment.CENTER);
        AnchorPane.setLeftAnchor(back,0.0);


        //Forward Button
        Button forward = new Button();
        forward.setText(">");
        back.setMnemonicParsing(false);
        forward.setTextAlignment(TextAlignment.CENTER);
        AnchorPane.setLeftAnchor(forward,30.0);

        //AddressBar
        TextField addressBar = new TextField();
        addressBar.setPromptText("URL");
        AnchorPane.setLeftAnchor(addressBar,60.0);
        AnchorPane.setRightAnchor(addressBar, 0.0);



        //Address Bar AnchorPane
        AnchorPane addressBarAnchorPane = new AnchorPane();
        addressBarAnchorPane.setMinSize(0.0, 0.0);
        AnchorPane.setTopAnchor(addressBarAnchorPane,2.0);
        AnchorPane.setLeftAnchor(addressBarAnchorPane,2.0);
        AnchorPane.setRightAnchor(addressBarAnchorPane,2.0);
        addressBarAnchorPane.getChildren().addAll(back, forward, addressBar);


        //ProgressText
        Text ProgressText = new Text("100%");
        ProgressText.setTextOrigin(VPos.TOP);
        ProgressText.setTextAlignment(TextAlignment.CENTER);
        AnchorPane.setLeftAnchor(ProgressText, 0.0);

        //Progress Bar
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(100.0);
        AnchorPane.setLeftAnchor(progressBar,36.0);
        AnchorPane.setRightAnchor(progressBar,2.0);



        //Progress Bar AnchorPane
        AnchorPane progressAnchorPane = new AnchorPane();
        progressAnchorPane.setMinSize(0.0, 0.0);
        AnchorPane.setTopAnchor(progressAnchorPane,30.0);
        AnchorPane.setLeftAnchor(progressAnchorPane,0.0);
        AnchorPane.setRightAnchor(progressAnchorPane,0.0);
        progressAnchorPane.getChildren().addAll(ProgressText, progressBar);


        //Top AnchorPane
        AnchorPane topAnchorPane = new AnchorPane();
        topAnchorPane.setMinSize(0.0, 60.0);
        topAnchorPane.getChildren().addAll(addressBarAnchorPane, progressAnchorPane);


        //TabList
        ObservableList<String> tab = FXCollections.observableArrayList();
        ListView tabList = new ListView<String>(tab);
        zeroAnchor(tabList);

        //List AnchorPane
        AnchorPane listAnchorPane = new AnchorPane();
        listAnchorPane.getChildren().add(tabList);



        //Left Split Pane
        SplitPane leftSplitPane = new SplitPane();
        leftSplitPane.setDividerPositions(0.1);
        leftSplitPane.setOrientation(Orientation.VERTICAL);
        zeroAnchor(leftSplitPane);
        leftSplitPane.getItems().addAll(topAnchorPane, listAnchorPane);


        //Left Anchor Pane
        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.getChildren().addAll(leftSplitPane);



        //Create WebView with default settings
        //TODO replace with tab
        WebView webView = new WebView();
        zeroAnchor(webView);




        //Create WebView with default settings
        WebEngine webEngine = webView.getEngine();
        webEngine.load(defaultURL);
        addressBar.setText(defaultURL);


        //Add a tab
        tab.add(webView.getEngine().getLocation());

        //Add New tab button
        tab.add("New Tab");

        //Right Anchor Pane
        AnchorPane rightAnchorPane = new AnchorPane();
        rightAnchorPane.getChildren().add(webView);

        //Main Split Pane
        SplitPane mainSplitPane = new SplitPane();
        mainSplitPane.setDividerPositions(0.25);
        zeroAnchor(mainSplitPane);
        //Add stuff to the split pane
        mainSplitPane.getItems().addAll(leftAnchorPane, rightAnchorPane);



        //Main Window Anchor Pane
        AnchorPane mainWindow = new AnchorPane();
        mainWindow.setPrefSize(800, 600);
        mainWindow.getChildren().add(mainSplitPane);

        //Scene
        Scene mainScene = new Scene(mainWindow);

        //Stage
        stage.setScene(mainScene);

        //Display the window
        stage.show();
    }


    //Not used
//    void setAnchor(Node child, double[] TopBottomLeftRight) {
//
//
//
//        AnchorPane.setTopAnchor(child, top);
//        AnchorPane.setBottomAnchor(child, bottom);
//        AnchorPane.setLeftAnchor(child, left);
//        AnchorPane.setRightAnchor(child, right);
//
//    }

    void zeroAnchor(Node child) {
        AnchorPane.setTopAnchor(child, 0.0);
        AnchorPane.setBottomAnchor(child, 0.0);
        AnchorPane.setLeftAnchor(child, 0.0);
        AnchorPane.setRightAnchor(child, 0.0);
    }


}