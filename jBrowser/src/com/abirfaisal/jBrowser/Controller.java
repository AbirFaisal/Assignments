package com.abirfaisal.jBrowser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by abirfaisal on 4/10/15.
 */
public class Controller implements Initializable {


    @FXML
    Button back, forward;

    @FXML
    ListView tabList;


    @FXML
    ProgressBar pageLoadBar;

    @FXML
    Text pageLoadPercent;


    @FXML
    TextField addressBar;


    @FXML
    WebView webView;
    WebEngine webEngine;





    @FXML
    private void loadAction(ActionEvent evt) {
        webEngine.load(addressBar.getText().startsWith("http://") ? addressBar.getText() : "http://" + addressBar.getText());
    }





    @Override
    public void initialize(URL url, ResourceBundle rb) {
        webEngine = webView.getEngine();
        webEngine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                addressBar.setText(newValue);
            }
        });
        addressBar.setText("http://www.google.com");
    }

}