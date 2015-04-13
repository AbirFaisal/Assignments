package com.abirfaisal.jBrowser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


    ///////Browswer window nodes////////////


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
    public static AnchorPane addressBarAnchorPane(Node... FXnodes){

        //Address Bar AnchorPane
        AnchorPane addressBarAnchorPane = new AnchorPane();
        addressBarAnchorPane.setMinSize(0.0, 0.0);

        AnchorPane.setTopAnchor(addressBarAnchorPane,3.0);
        AnchorPane.setLeftAnchor(addressBarAnchorPane,3.0);
        AnchorPane.setRightAnchor(addressBarAnchorPane,3.0);

        addressBarAnchorPane.getChildren().addAll(FXnodes);

        return addressBarAnchorPane;
    }

    //ProgressText
    public static Text progressText() {
        Text progressText = new Text("100%");
        progressText.setTextOrigin(VPos.TOP);
        progressText.setTextAlignment(TextAlignment.CENTER);

        AnchorPane.setTopAnchor(progressText, 4.0);
        AnchorPane.setBottomAnchor(progressText, 0.0);
        AnchorPane.setLeftAnchor(progressText, 0.0);

        return progressText;
    }

    //Progress Bar
    public static ProgressBar progressBar() {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(100.0);

        AnchorPane.setTopAnchor(progressBar, 0.0);
        AnchorPane.setBottomAnchor(progressBar, 0.0);
        AnchorPane.setLeftAnchor(progressBar, 40.0);
        AnchorPane.setRightAnchor(progressBar, 40.0);

        return progressBar;
    }


    //Javascript Enable/Disable toggle
    public static ToggleButton javaScriptToggle(String buttonText) {
        ToggleButton javaScriptToggle = new ToggleButton();
        javaScriptToggle.setText(buttonText);

        AnchorPane.setTopAnchor(javaScriptToggle, 0.0);
        AnchorPane.setBottomAnchor(javaScriptToggle, 0.0);
        AnchorPane.setRightAnchor(javaScriptToggle, 0.0);

        return javaScriptToggle;
    }



    //Progress Bar AnchorPane
    public static AnchorPane progressBarAnchorPane(Node... FXnodes) {
        AnchorPane progressBarAnchorPane = new AnchorPane();
        progressBarAnchorPane.setMinSize(0.0, 0.0);
        AnchorPane.setTopAnchor(progressBarAnchorPane, 32.0);
        AnchorPane.setLeftAnchor(progressBarAnchorPane, 3.0);
        AnchorPane.setRightAnchor(progressBarAnchorPane, 3.0);
        progressBarAnchorPane.getChildren().addAll(FXnodes);

        return progressBarAnchorPane;
    }


    //Top AnchorPane
    public static AnchorPane topAnchorPane(Node... FXnodes) {
        AnchorPane topAnchorPane = new AnchorPane();
        topAnchorPane.setMinSize(0.0, 60.0);
        topAnchorPane.getChildren().addAll(FXnodes);

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
        tabListView.getSelectionModel().select(1);
        zeroAnchor(tabListView);


        return tabListView;
    }


    //List AnchorPane
    public static AnchorPane listAnchorPane(ListView<Tab> tabListView) {
        AnchorPane listAnchorPane = new AnchorPane();
        listAnchorPane.getChildren().add(tabListView);

        return listAnchorPane;
    }



    //Left Split Pane
    public static SplitPane leftSplitPane(Node... FXnode) {

        SplitPane leftSplitPane = new SplitPane();
        leftSplitPane.setDividerPositions(0.1);
        leftSplitPane.setOrientation(Orientation.VERTICAL);
        zeroAnchor(leftSplitPane);
        leftSplitPane.getItems().addAll(FXnode);

        return leftSplitPane;
    }



    //Left Anchor Pane
    //Simple so no finction

    public static AnchorPane leftAnchorPane(Node... FXnode){
        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.getChildren().addAll(FXnode);

        return leftAnchorPane;
    }

    public static AnchorPane listAnchorPane(Node... FXnode) {
        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.getChildren().addAll(FXnode);

        return leftAnchorPane;
    }





    //Right Anchor Pane
    public static AnchorPane rightAnchorPane(Node... FXnode){
        AnchorPane rightAnchorPane = new AnchorPane();
        rightAnchorPane.getChildren().addAll(FXnode);

        return rightAnchorPane;
    }


    //Main Split Pane
    public static SplitPane mainSplitPane(Node... FXnode) {
        SplitPane mainSplitPane = new SplitPane();
        mainSplitPane.setDividerPositions(0.25);
        zeroAnchor(mainSplitPane);
        mainSplitPane.getItems().addAll(FXnode);

        return mainSplitPane;
    }


    //Main Window Anchor Pane
    public static AnchorPane mainWindowAnchorPane(Node... FXnode) {
        AnchorPane mainWindow = new AnchorPane();
        mainWindow.setPrefSize(1024, 786);

        mainWindow.getChildren().addAll(FXnode);

        return mainWindow;
    }

    //Scene
    public static Scene mainScene(Parent FXParent) {

        Scene mainScene = new Scene(FXParent);

        return mainScene;
    }


    ////////Functions//////////////



    //Add Tab
    public static void addTab(ArrayList<Tab> tabArray, ObservableList<String> tabList,ListView<String> tabListView, WebView webView) {


        //know last index
        int index = tabArray.size();

        //Add tab to tabArray
        tabArray.add(new Tab());

        //setTab to Google.com
        tabArray.get(index).getWebEngine().load("https://www.google.com/");

        //add the new tab to the Observable tabList
        tabList.add(tabArray.get(index).getWebEngine().getLocation());


        //switch to and

        tabListView.getFocusModel().focus(index+1);

        tabListView.getSelectionModel().select(index+1);

        webView = tabArray.get(index).getWebView();

        //Somtimes title is null
        if (webView.getEngine().getTitle() != null)
            tabList.set(index+1, webView.getEngine().getTitle());

        else tabList.set(index+1, webView.getEngine().getLocation());
    }



    //Automatic zero anchor so we can save time typing
    static void zeroAnchor(Node child) {
        AnchorPane.setTopAnchor(child, 0.0);
        AnchorPane.setBottomAnchor(child, 0.0);
        AnchorPane.setLeftAnchor(child, 0.0);
        AnchorPane.setRightAnchor(child, 0.0);
    }


}
