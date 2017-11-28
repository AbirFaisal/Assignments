package com.abirfaisal.jBrowser;

import javafx.scene.web.WebView;

import java.awt.event.ActionEvent;

/**
 * Created by abirfaisal on 4/11/15.
 */
public class BrowserEventHandler {



    public void handleButtonAction(ActionEvent event, WebView webView, Tab[] tab){


        webView = tab[1].getWebView();


    }





}
