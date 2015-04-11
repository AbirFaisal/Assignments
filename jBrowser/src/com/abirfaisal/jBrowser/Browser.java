package com.abirfaisal.jBrowser;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;

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

    //AddressField


    //Address Bar AnchorPane
    public static AnchorPane createAddressBarAnchorPane(){


        //Forward Button
        Button forward = new Button();
        forward.setText(">");
        forward.setMnemonicParsing(false);
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

        return addressBarAnchorPane;
    }




}
