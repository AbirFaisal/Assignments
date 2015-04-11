package com.abirfaisal.jBrowser;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;

/**
 * Created by abirfaisal on 4/10/15.
 */
public class Tab {

    String Website;
    WebEngine webContents;
    WebHistory history;


    //Bool isJavaScriptEnabled

    //History


    public Tab(WebEngine webContents) {
        this.webContents = webContents;

    }

    public WebEngine getWebContents() {
        return webContents;
    }

    public void setWebContents(WebEngine webContents) {
        this.webContents = webContents;
    }







}
