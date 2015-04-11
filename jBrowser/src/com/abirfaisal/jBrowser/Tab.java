package com.abirfaisal.jBrowser;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

/**
 * Created by abirfaisal on 4/10/15.
 */
public class Tab {

    private String domainName;
    private String URL;
    private WebView webView;
    private WebEngine webEngine;
    private WebHistory webHistory;



    public Tab() {

        this.webView = new WebView();
        zeroAnchor(this.webView);
        this.webEngine = this.webView.getEngine();
        this.webEngine.load("https://www.google.com/");



//        this.domainName = domainName;
//        this.URL = URL;
//        this.webView = webView;
//        this.webEngine = webEngine;
//        this.webHistory = webHistory;

    }


    public Tab(String domainName, String URL, WebView webView, WebEngine webEngine, WebHistory webHistory) {
        this.domainName = domainName;
        this.URL = URL;
        this.webView = webView;
        this.webEngine = webEngine;
        this.webHistory = webHistory;
    }


    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
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

    public WebHistory getWebHistory() {
        return webHistory;
    }

    public void setWebHistory(WebHistory webHistory) {
        this.webHistory = webHistory;
    }






    void zeroAnchor(Node child) {
        AnchorPane.setTopAnchor(child, 0.0);
        AnchorPane.setBottomAnchor(child, 0.0);
        AnchorPane.setLeftAnchor(child, 0.0);
        AnchorPane.setRightAnchor(child, 0.0);
    }



}
