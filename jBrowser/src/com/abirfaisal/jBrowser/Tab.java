package com.abirfaisal.jBrowser;

import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Created by abirfaisal on 4/10/15.
 */

//Implement runnable
public class Tab {

    //TODO i dont think i need the engine so remove if possible

    private WebView webView;
    private WebEngine webEngine;



    public Tab() {
        this.webView = new WebView();



        this.webView.setFontSmoothingType(FontSmoothingType.LCD);
        zeroAnchor(this.webView);

        this.webEngine = this.webView.getEngine();

        //user data directory
        //this.webView.getEngine().setUserDataDirectory();

        this.webEngine.setJavaScriptEnabled(false);


        //still testing speed improvements
        this.webView.setCache(true);
        this.webView.cacheProperty().set(true);
        this.webView.cacheHintProperty().set(CacheHint.SPEED);


        this.webEngine.load("https://www.google.com/");

    }

    public Tab(WebEngine webEngine, WebView webView) {
        this.webEngine = webEngine;
        this.webView = webView;
    }


    public WebView getWebView() {
        return webView;
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }

    public WebEngine getWebEngine() {
        return webEngine;
    }

    public void setWebEngine(WebEngine webEngine) {
        this.webEngine = webEngine;
    }

    void zeroAnchor(Node child) {
        AnchorPane.setTopAnchor(child, 0.0);
        AnchorPane.setBottomAnchor(child, 0.0);
        AnchorPane.setLeftAnchor(child, 0.0);
        AnchorPane.setRightAnchor(child, 0.0);
    }



}
