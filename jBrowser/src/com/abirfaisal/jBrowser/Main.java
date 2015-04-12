package com.abirfaisal.jBrowser;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * No FXML because its easier to manage code than to @FXML everything.
**/

public class Main extends Application {

    //Main WebView
    WebView webView = new WebView();
    //Array of Tab objects as a array list
    //This allows us to save memory since we can dynamically increase
    //the size of this and also adds feature not
    //available to a normal Object[] array
    ArrayList<Tab> tabArray = new ArrayList<Tab>();


    public static void main(String[] args) {
        launch(args);
    }


    //TODO turn browser window into an object in the future
    //TODO add multi window support

    @Override
    public void start(Stage stage) {


        //Set Window Title
        stage.setTitle("jBrowser");


        //Back Button
        Button back = Browser.backButton();
        //Forward Button
        Button forward = Browser.forwardButton();
        //AddressBar
        TextField addressField = Browser.addressField();
        //Address Bar AnchorPane
        AnchorPane addressBarAnchorPane = Browser.addressBarAnchorPane(back, forward, addressField);


        //ProgressText
        Text progressText = Browser.progressText();
        //Progress Bar
        ProgressBar progressBar = Browser.progressBar();


        //Javascript Enable
        Toggle javaScriptToggle = new ToggleButton();


        //Progress Bar AnchorPane
        AnchorPane progressBarAnchorPane = Browser.progressBarAnchorPane(progressText, progressBar);








        //TabList
        ObservableList<String> tabList = Browser.tabList();
        //Tab List View
        ListView tabListView = Browser.tabListView(tabList);


        //Top left AnchorPane
        AnchorPane topAnchorPane = Browser.topAnchorPane(addressBarAnchorPane, progressBarAnchorPane);
        //List AnchorPane
        AnchorPane listAnchorPane = Browser.listAnchorPane(tabListView);


        //Left Split Pane
        SplitPane leftSplitPane = Browser.leftSplitPane(topAnchorPane, listAnchorPane);


        //Left Anchor Pane
        AnchorPane leftAnchorPane = Browser.leftAnchorPane(leftSplitPane);


        //Add Initial Tab.
        Browser.addTab(tabArray, tabList, tabListView, webView);

        //Right Anchor Pane
        AnchorPane rightAnchorPane = Browser.rightAnchorPane(webView);




        //TODO refactor event handlers if you have time
        /////////////EVENT HANDLERS



        //Address bar handler
        //On Action
        addressField.setOnAction(e -> {

            int index = tabListView.getFocusModel().getFocusedIndex();

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
            String URL = addressField.getText();

                //check for spaces URL's don't have spaces
            if (URL.contains(" ")){
                System.out.println("Not URL1 Searching");

                //Send and display Google Search Query
                search = search + URL;

                webView.getEngine().load(search);


            }else {
                //check for TLD and add http scheme if needed
                for (int i = 0; i < TLD.length; i++) {

                    //Loop through and test TLD
                    if (URL.contains(TLD[i])) {
                        System.out.println("Has TLD");

                        //add www if needed
                        if(!URL.contains("www.")) {
                            System.out.println("No URL www.");
                            URL = "www." + URL;
                        }

                        //Check if URL has scheme
                        for (int j = 0; j < scheme.length; j++) {

                            if(URL.contains(scheme[j])) {
                                System.out.println("URL Has Scheme");
                                webView.getEngine().load(URL);
                                break;
                            }
                        }

                        //loop didnt break so it doesnt have scheme
                        //apply default scheme
                        System.out.println("No URL Scheme");
                        URL = "http://" + URL;

                        webView.getEngine().load(URL);
                        break;
                    }
                    break;
                }

                System.out.println("Not URL2 Searching: ");
                System.out.println(URL);

                //If all fails just search the string
                search = search + URL;
                webView.getEngine().load(search);
            }
        });


        //TODO change page accourdingly

        //TODO change URL accourdingly



        //Handle Back Button event.
        back.setOnAction(e -> {

            //Make sure there is actually history to go back to
            if (webView.getEngine().getHistory().getCurrentIndex() > 0) {
                webView.getEngine().getHistory().go(-1);
            }

            System.out.println("Back Button Clicked");
        });




        //Handle Forward Button event.
        forward.setOnAction(e -> {

            //Make sure there is actually a page to go ahead to
            //current index should be less than size of history -2
            if (webView.getEngine().getHistory().getCurrentIndex() <
                    (webView.getEngine().getHistory().getEntries().size() - 1)) {

                webView.getEngine().getHistory().go(1);
            }

            System.out.println("Forward Button Clicked");
        });






        //Handle Tab Switch and new Tab
        tabListView.setOnMouseClicked(e -> {

            int index = tabListView.getFocusModel().getFocusedIndex();
            int tabArraySize = tabArray.size();


            System.out.println("FocusedIndex: " + index);
            System.out.println("tabArraySize: " + tabArraySize);


            String tabTrigger = "New Tab";
            String test = tabList.get(index);


            //New Tab
            if (test.contains(tabTrigger)) {
                Browser.addTab(tabArray, tabList, tabListView, webView);
            }

            //Switch Tab
            else {
                webView = tabArray.get(index - 1).getWebView();

                tabList.set(index, webView.getEngine().getTitle());

                rightAnchorPane.getChildren().clear();
                rightAnchorPane.getChildren().add(webView);
            }
        });









        /////////////END EVENT HANDLERS/////////








        //Main Split Pane
        SplitPane mainSplitPane = Browser.mainSplitPane(leftAnchorPane, rightAnchorPane); // new SplitPane();
//        mainSplitPane.setDividerPositions(0.25);
//        zeroAnchor(mainSplitPane);
//        //Add stuff to the split pane
//        mainSplitPane.getItems().addAll(leftAnchorPane, rightAnchorPane);


        //Main Window Anchor Pane
        AnchorPane mainWindow = Browser.mainWindowAnchorPane(mainSplitPane);  // new AnchorPane();
//        mainWindow.setPrefSize(1024, 786);
//        mainWindow.getChildren().add(mainSplitPane);


        //Scene
        Scene mainScene = Browser.mainScene(mainWindow);


        //mainScene.setOnS


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