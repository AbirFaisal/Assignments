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
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {


    //Main WebView
    WebView webView = new WebView();

    //Array of tabs
    //Tab[] tabArray = new Tab[500];


    ArrayList<Tab> tabArray = new ArrayList<Tab>();

    //String defaultURL = "https://www.reddit.com/";


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
        tab.add("New Tab");
        tabList.getSelectionModel().select(0);
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


        //Add Inital Tab.
        tabArray.add(new Tab());
        tabArray.get(0).getWebEngine().load("http://www.google.com/");
        tab.add(tabArray.get(0).getWebEngine().getLocation());
        webView = tabArray.get(0).getWebView();



        //Right Anchor Pane
        AnchorPane rightAnchorPane = new AnchorPane();
        rightAnchorPane.getChildren().add(webView);





        /////////////EVENT HANDLERS



        //Address bar handler
        //On Action
        addressBar.setOnAction(e -> {

            int index = tabList.getFocusModel().getFocusedIndex();

            //Search query string
            String search = "https://www.google.com/search?q=";
            //Common Scheme List
            String[] scheme = {
                    "http://", "https://", "ftp://", "mailto:",
                    "nfs://", "sftp://", "file://"
            };
            //Common TLD List
            String[] TLD = {
                    ".com", ".org", ".edu", ".gov", ".uk",  ".ca",  ".de",  ".jp",
                    ".fr",  ".au",  ".us",  ".ru", ".ch",  ".it",  ".nl",  ".se",
                    ".no",  ".es",  ".mil", ".hk", ".in",
            };

            //Get addressBar text
            String URL = addressBar.getText();

                //check for spaces URL's don't have spaces
            if (URL.contains(" ")){
                System.out.println("Not URL1");

                //Send and display Google Search Query
                search = search + URL;
                tabArray.get(index).getWebEngine().load(search);

            }else {
                //check for TLD and add http scheme if needed
                for (int i = 0; i < TLD.length; i++) {

                    //Loop through and test TLD
                    if (URL.contains(TLD[i])) {

                        //add www if needed
                        if(!URL.contains("www.")) {
                            URL = "www." + URL;
                        }

                        //Check if URL has scheme
                        for (int j = 0; j < scheme.length; j++) {

                            if(URL.contains(scheme[j])) {
                                tabArray.get(index).getWebEngine().load(URL);
                                break;
                            }
                        }

                        //loop didnt break so it doesnt have scheme
                        //apply default scheme
                        URL = "http://" + URL;

                        tabArray.get(index).getWebEngine().load(URL);
                        break;
                    }
                }
                //If all fails just search the string
                search = search + URL;
                tabArray.get(index).getWebEngine().load(search);
            }
        });


        //TODO change page accourdingly

        //TODO change URL accourdingly


        //Handle Back Button event.
        back.setOnAction(e -> {


            //TODO add go back code here


            System.out.println("Back Button Clicked");
        });



        //Handle Forward Button event.
        forward.setOnAction(e -> {


            //TODO add go forward code here


            webView = tabArray.get(1).getWebView();



            System.out.println("Back Button Clicked");
        });


        //Handle Tab Switch and new Tab
        tabList.setOnMouseClicked(e -> {

            int index = tabList.getFocusModel().getFocusedIndex();
            int tabArraySize = tabArray.size();


            System.out.println("FocusedIndex: " + index);
            System.out.println("tabArraySize: " + tabArraySize);


            String tabTrigger = "New Tab";
            String test = tab.get(index);


            //New Tab
            if (test.contains(tabTrigger)) {

                tabArray.add(new Tab());
                tabArray.get(tabArraySize).getWebEngine().load("http://www.google.com/");

                //set tab as domain
                tab.add(tabArray.get(tabArraySize).getWebEngine().getLocation());


                webView = tabArray.get(tabArraySize).getWebView();
            }

            //Switch Tab
            else {
                webView = tabArray.get(index - 1).getWebView();

                rightAnchorPane.getChildren().clear();
                rightAnchorPane.getChildren().add(webView);
            }
        });






        /////////////EVENT HANDLERS







        //Main Split Pane
        SplitPane mainSplitPane = new SplitPane();
        mainSplitPane.setDividerPositions(0.25);
        zeroAnchor(mainSplitPane);
        //Add stuff to the split pane
        mainSplitPane.getItems().addAll(leftAnchorPane, rightAnchorPane);

        //Main Window Anchor Pane
        AnchorPane mainWindow = new AnchorPane();
        mainWindow.setPrefSize(1024, 786);
        mainWindow.getChildren().add(mainSplitPane);

        //Scene
        Scene mainScene = new Scene(mainWindow);

        //Stage
        stage.setScene(mainScene);

        //Display the window
        stage.show();
    }









    void zeroAnchor(Node child) {
        AnchorPane.setTopAnchor(child, 0.0);
        AnchorPane.setBottomAnchor(child, 0.0);
        AnchorPane.setLeftAnchor(child, 0.0);
        AnchorPane.setRightAnchor(child, 0.0);
    }
}