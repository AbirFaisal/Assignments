package com.COP2805C.AddressBook;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
	// write your code here
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


       //------------------------------------------------------ Right Panel Content

        TextArea textAreaContent = new TextArea();
        textAreaContent.setPrefSize(360, 200);

        ImageView imageContentHolder = new ImageView(); //IDK Fill in later
        imageContentHolder.setFitHeight(100);
        imageContentHolder.setFitWidth(100);

        FlowPane flowPanelArea = new FlowPane(); //ImageConenetHolder is in this area and there are fonts in this area to, but they are abstract classes
        flowPanelArea.setPrefSize(360, 200);

        FlowPane flowPanelArea2 = new FlowPane(); //Same as flowPanelArea


        //----------------------------------------------------- Right Panel Content




       //------------------------------------------------------- Left Panel Content
        MenuItem menuItemContent2 = new MenuItem();
        MenuItem menuItemContent = new MenuItem();

        SplitMenuButton splitMenuButton = new SplitMenuButton(menuItemContent, menuItemContent2);

        ChoiceBox choiceBoxSelector = new ChoiceBox();
        choiceBoxSelector.setPrefSize(103, 26);

        TextField viewTextField = new TextField();
        viewTextField.setPrefSize(168, 26);

        ListView contactListview = new ListView();
        contactListview.setPrefSize(200, 200);
        //------------------------------------------------------- Left Panel Content

        AnchorPane rightAnchorPane = new AnchorPane();

        AnchorPane leftAnchorPane = new AnchorPane();
        leftAnchorPane.setPrefSize(100, 160);

        SplitPane splitPane = new SplitPane(leftAnchorPane, rightAnchorPane);
        splitPane.setPrefSize(400, 400);

        AnchorPane anchorPane = new AnchorPane(splitPane);
        anchorPane.setPrefSize(800, 600);

<<<<<<< HEAD

        AnchorPane anchorPane = new AnchorPane();
=======
>>>>>>> master
        Scene primaryScene = new Scene(anchorPane);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Bullshit Manager");
        primaryStage.show();
    }
}