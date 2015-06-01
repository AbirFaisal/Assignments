package com.COP2805C.AddressBook;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{




    public static void main(String[] args) {
	// write your code here
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        AnchorPane anchorPane = new AnchorPane();
        Scene primaryScene = new Scene(anchorPane);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Bullshit Manager");
        primaryStage.show();
    }
}
