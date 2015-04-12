package com.abirfaisal.jBrowser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebView;

import java.util.ArrayList;

/**
 * Created by abirfaisal on 4/10/15.
 */
public class Browser {

    //Back Button
    public static Button backButton(){
        //Back Button
        Button back = new Button();
        back.setMnemonicParsing(false);
        back.setText("<");
        back.setTextAlignment(TextAlignment.CENTER);
        AnchorPane.setLeftAnchor(back, 0.0);

        return back;
    }


    //Forward Button
    public static Button forwardButton(){
        //Forward Button
        Button forward = new Button();
        forward.setText(">");
        forward.setMnemonicParsing(false);
        forward.setTextAlignment(TextAlignment.CENTER);
        AnchorPane.setLeftAnchor(forward, 30.0);

        return forward;
    }

    //Address Field
    public static TextField addressField(){
        //AddressBar
        TextField addressBar = new TextField();
        addressBar.setPromptText("URL");
        AnchorPane.setLeftAnchor(addressBar,60.0);
        AnchorPane.setRightAnchor(addressBar, 0.0);

        return addressBar;
    }

    //Address Bar AnchorPane
    public static AnchorPane addressBarAnchorPane(){



        //Address Bar AnchorPane
        AnchorPane addressBarAnchorPane = new AnchorPane();
        addressBarAnchorPane.setMinSize(0.0, 0.0);
        AnchorPane.setTopAnchor(addressBarAnchorPane,2.0);
        AnchorPane.setLeftAnchor(addressBarAnchorPane,2.0);
        AnchorPane.setRightAnchor(addressBarAnchorPane,2.0);

        return addressBarAnchorPane;
    }

    //ProgressText
    public static Text progressText() {
        Text progressText = new Text("100%");
        progressText.setTextOrigin(VPos.TOP);
        progressText.setTextAlignment(TextAlignment.CENTER);
        AnchorPane.setLeftAnchor(progressText, 0.0);

        return progressText;
    }

    //Progress Bar
    public static ProgressBar progressBar() {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(100.0);
        AnchorPane.setLeftAnchor(progressBar, 36.0);
        AnchorPane.setRightAnchor(progressBar, 2.0);

        return progressBar;
    }


    //Progress Bar AnchorPane

    public static AnchorPane progressBarAnchorPane() {
        AnchorPane progressBarAnchorPane = new AnchorPane();
        progressBarAnchorPane.setMinSize(0.0, 0.0);
        AnchorPane.setTopAnchor(progressBarAnchorPane, 30.0);
        AnchorPane.setLeftAnchor(progressBarAnchorPane, 0.0);
        AnchorPane.setRightAnchor(progressBarAnchorPane, 0.0);
        //progressBarAnchorPane.getChildren().addAll(ProgressText, progressBar);

        return progressBarAnchorPane;
    }


    //Top AnchorPane
    public static AnchorPane topAnchorPane() {
        AnchorPane topAnchorPane = new AnchorPane();
        topAnchorPane.setMinSize(0.0, 60.0);
        // topAnchorPane.getChildren().addAll(addressBarAnchorPane, progressAnchorPane);

        return topAnchorPane;
    }


    //TabList
    public static ObservableList<String> tabList() {
        ObservableList<String> tabList = FXCollections.observableArrayList();
        tabList.add("New Tab");

        return tabList;
    }


    //Tab List View
    public static ListView tabListView(ObservableList<String> tabList){
        ListView tabListView = new ListView<String>(tabList);
        tabListView.getSelectionModel().select(0);
        zeroAnchor(tabListView);

        return tabListView;
    }



//    //List AnchorPane
//    AnchorPane listAnchorPane = new AnchorPane();
//    listAnchorPane.getChildren().add(tabList);



    //Left Split Pane
    public static SplitPane leftSplitPane() {

        SplitPane leftSplitPane = new SplitPane();
        leftSplitPane.setDividerPositions(0.1);
        leftSplitPane.setOrientation(Orientation.VERTICAL);
        zeroAnchor(leftSplitPane);
        //leftSplitPane.getItems().addAll(topAnchorPane, listAnchorPane);

        return leftSplitPane;
    }



    //Left Anchor Pane
    //Simple so no finction

    public static AnchorPane listAnchorPane() {
        AnchorPane leftAnchorPane = new AnchorPane();
        //leftAnchorPane.getChildren().addAll(leftSplitPane);

        return leftAnchorPane;
    }

    //Add Tab.
    public static void addTab(ArrayList<Tab> tabArray, ObservableList<String> tabList, WebView webView) {

        tabArray.add(new Tab());
        tabArray.get(0).getWebEngine().load("http://www.google.com/");
        tabList.add(tabArray.get(0).getWebEngine().getLocation());
        webView = tabArray.get(0).getWebView();
    }



    //Right Anchor Pane
//    AnchorPane rightAnchorPane = new AnchorPane();
//    rightAnchorPane.getChildren().add(webView);


    static void zeroAnchor(Node child) {
        AnchorPane.setTopAnchor(child, 0.0);
        AnchorPane.setBottomAnchor(child, 0.0);
        AnchorPane.setLeftAnchor(child, 0.0);
        AnchorPane.setRightAnchor(child, 0.0);
    }


}
