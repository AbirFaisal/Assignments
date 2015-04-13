package com.abirfaisal.jBrowser;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
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
 *
 * Proposed features
 *  - Save/load last browser state
 *
 *  - Multi-Window support
 *
 *  - User data & cache Encryption
 *
 *  - Multi Threading
 *
 *  - Change JavaFX webView from built in Webkit and Nashorn JavaScript
 *  to WebKit and V8 JavaScript or embed a chrome instance because slow
 *
**/

public class Main extends Application {

    //Main WebView
    WebView webView = new WebView();
    //Array of Tab objects as a array list
    //This allows us to save memory since we can increase
    //the number of elements on demand and also adds features not
    //available to a normal Object[] array
    ArrayList<Tab> tabArray = new ArrayList<Tab>();


    public static void main(String[] args) {
        launch(args);
    }


    //TODO turn browser window into an object in the future
    //TODO add multi window support

    @Override
    public void start(Stage stage) {


        //TODO refactor into hierarchy format


        //Back Button
        Button back = Browser.backButton();
        //Forward Button
        Button forward = Browser.forwardButton();
        //AddressBar
        TextField addressField = Browser.addressField();
        //Address Bar AnchorPane
        AnchorPane addressBarAnchorPane = Browser.addressBarAnchorPane(back, forward, addressField);






        //TODO make progress bar and text work
        //ProgressText
        Text progressText = Browser.progressText();
        //Progress Bar
        ProgressBar progressBar = Browser.progressBar();


        //Javascript Enable
        ToggleButton javaScriptToggle = Browser.javaScriptToggle("JS");


        //Progress Bar AnchorPane
        AnchorPane progressBarAnchorPane = Browser.progressBarAnchorPane(progressText, progressBar, javaScriptToggle);



        //TODO make stats here
        //Not implemented yet
        /**
         * OS CPUs Mem Java
         * CPU usage
         * Heap Memory
         * Free Heap Memory
         * Tab count
         *
         */

        String OS = System.getProperty("os.name");

        int CPUs = Runtime.getRuntime().availableProcessors();
        String arch = System.getProperty("os.arch");


        long freeMemory = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        String javaHome = System.getProperty("java.home");
        String javaClassPath = System.getProperty("java.class.path");
        String javaVendor = System.getProperty("java.vendor");
        String javaVendorURL = System.getProperty("java.vendor.url");
        String javaVersion = System.getProperty("java.version");



        System.out.println("OS: " + OS);

        System.out.println("CPUs: " + CPUs);
        System.out.println("Arch :" + arch);

        System.out.println("freeMemory: " + freeMemory);
        System.out.println("totalMemory: " + totalMemory);
        System.out.println("maxMemory: " + maxMemory);

        System.out.println("javaHome: " + javaHome);
        System.out.println("javaClassPath: " + javaClassPath);
        System.out.println("javaVendor: " + javaVendor);
        System.out.println("javaVendorURL: " + javaVendorURL);
        System.out.println("javaVersion: " + javaVersion);





        //System Info Text
        Text systemInfoText = new Text("OS CPUs Memory JVM");

        //Tab Count Text
        Text tabCountText = new Text("tabCount");

        //System Info AnchorPane
        AnchorPane statsAnchorPane = new AnchorPane();







        //Top left AnchorPane
        AnchorPane topAnchorPane = Browser.topAnchorPane(addressBarAnchorPane, progressBarAnchorPane);


        //TabList
        ObservableList<String> tabList = Browser.tabList();
        //Tab List View
        ListView tabListView = Browser.tabListView(tabList);


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
                }



//                System.out.println("Not URL2 Searching: ");
//                System.out.println(URL);
//
//                //If all fails just search the string
//                search = search + URL;
//                webView.getEngine().load(search);
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






        //TODO change to setOnMouseClicked
        //throws exeptions please fix

//        //Handle javascript toggle button
        javaScriptToggle.setOnMouseClicked(e -> {
            webView.getEngine().setJavaScriptEnabled(javaScriptToggle.isSelected());
            webView.getEngine().reload();
        });






//        webView.getEngine().getLoadWorker().stateProperty().addListener(
//                new ChangeListener<Worker.State>() {
//            @Override
//            public void changed(ObservableValue<? extends Worker.State> observable,
//                                Worker.State oldValue,
//                                Worker.State newValue) {
//
//
//                //System.out.println("Load Listner: " + Worker.State.);
//
//                if (newValue == Worker.State.SUCCEEDED) {
//                    stage.setTitle(webView.getEngine().getLocation());
//                    System.out.println("called");
//                }
//
//            }
//        });






        //Handle Tab Switch and new Tab
        tabListView.setOnMouseClicked(e -> {


            int index = tabListView.getFocusModel().getFocusedIndex();
            int tabArraySize = tabArray.size();
            System.out.println("FocusedIndex: " + index);
            System.out.println("tabArraySize: " + tabArraySize);


            //New Tab
            if (index == 0) {
                Browser.addTab(tabArray, tabList, tabListView, webView);
            }




            //Switch Tab
            else {
                webView = tabArray.get(index - 1).getWebView();

                //Bind progress indicators to current webView
                //TODO make text int or remove precision
                progressText.textProperty().bind(
                        webView.getEngine().getLoadWorker().progressProperty().multiply(100).asString().concat("%"));
                progressBar.progressProperty().bind(
                        webView.getEngine().getLoadWorker().progressProperty());


                //Handle Loading Bar
                //TODO Add Remove listner add removal of webview while resizing
                webView.getEngine().getLoadWorker().stateProperty().addListener(
                        new ChangeListener<Worker.State>() {
                            @Override
                            public void changed(ObservableValue<? extends Worker.State> observable,
                                                Worker.State oldValue,
                                                Worker.State newValue) {

                                if (newValue == Worker.State.SCHEDULED) {
                                    System.out.print("\nSCHEDULED: ");
                                    System.out.println(observable.getValue());

                                    progressBar.setProgress(-1);

                                }

                                if (newValue == Worker.State.RUNNING) {
                                    System.out.print("RUNNING: ");
                                    System.out.println(observable.getValue());



                                }

                                if (newValue == Worker.State.SUCCEEDED) {
                                    System.out.print("SUCCEEDED: ");
                                    System.out.println(observable.getValue());


                                    //Somtimes title is null
                                    if (webView.getEngine().getTitle() != null)
                                        tabList.set(index, webView.getEngine().getTitle());

                                    else tabList.set(index, webView.getEngine().getLocation());

                                }



                                if (newValue == Worker.State.READY) {
                                    System.out.print("READY: ");
                                    System.out.println(observable.getValue());
                                }

                                if (newValue == Worker.State.CANCELLED) {
                                    System.out.print("CANCELLED: ");
                                    System.out.println(observable.getValue());
                                }

                                if (newValue == Worker.State.FAILED) {
                                    System.out.print("FAILED: ");
                                    System.out.println(observable.getValue());
                                }

                            }
                        });




                //TODO BUG returns null
                //tabList.set(index, webView.getEngine().getTitle());





                rightAnchorPane.getChildren().clear();
                rightAnchorPane.getChildren().add(webView);

                System.out.println("webView.isCache(): " + webView.isCache());
                System.out.println("webView.cacheProperty().get(): " + webView.cacheProperty().get());
                System.out.println("webView.cacheHintProperty().get(): " + webView.cacheHintProperty().get());


                printMemoryInfo();

                // javaScriptToggle.setSelected(webView.getEngine().isJavaScriptEnabled());
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






        //Stage
        //Set Window Title
        stage.setTitle("jBrowser");
        stage.setScene(mainScene);

        //Display the window
        stage.show();
    }




    void printMemoryInfo(){
        long freeMemory = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        long totalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("freeMemory: " + freeMemory);
        System.out.println("totalMemory: " + totalMemory);
        System.out.println("maxMemory: " + maxMemory);
    }



    void zeroAnchor(Node child) {
        AnchorPane.setTopAnchor(child, 0.0);
        AnchorPane.setBottomAnchor(child, 0.0);
        AnchorPane.setLeftAnchor(child, 0.0);
        AnchorPane.setRightAnchor(child, 0.0);
    }
}