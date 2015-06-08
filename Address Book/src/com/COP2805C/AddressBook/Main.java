package com.COP2805C.AddressBook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
<<<<<<< HEAD
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

=======
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;
>>>>>>> AbirFaisal

public class Main extends Application {
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

<<<<<<< HEAD
public class Main extends Application {

=======
>>>>>>> AbirFaisal
    List<Contact> contactList;

    public static void main(String[] args) {


        launch(args);

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
        Scene primaryScene = new Scene(anchorPane);

=======
>>>>>>> AbirFaisal

        //TODO somthing here? This is a Sample
        //Information
        //TODO TEST REMOVE
        Text phoneNumberText = new Text("nigger");
        Text emailText = new Text("nigger");
        Text addressText = new Text("nigger");
        Text groupText = new Text("nigger");





        TextArea notesTextArea = new TextArea();
        //notesTextArea.setPrefSize(400, 400);
        notesTextArea.setPromptText("Notes");



        //Flowpane to format the text nicey
        FlowPane contactInfoFlowPane = new FlowPane();
        AnchorPane.setTopAnchor(contactInfoFlowPane, 0.0);
        AnchorPane.setBottomAnchor(contactInfoFlowPane, 0.0);
        AnchorPane.setLeftAnchor(contactInfoFlowPane, 0.0);
        AnchorPane.setRightAnchor(contactInfoFlowPane, 0.0);

        contactInfoFlowPane.setHgap(20.0);
        contactInfoFlowPane.setAlignment(Pos.TOP_LEFT);
        contactInfoFlowPane.setOrientation(Orientation.VERTICAL);



        //TEST Remove
        contactInfoFlowPane.getChildren().addAll(phoneNumberText, emailText, addressText, groupText, notesTextArea);




        AnchorPane contactInfoAnchorPane = new AnchorPane(contactInfoFlowPane);

        //Scroll pane incase of large amount of data
        ScrollPane contactInfoScrollPane = new ScrollPane(contactInfoAnchorPane);
        AnchorPane.setTopAnchor(contactInfoScrollPane, 120.0);
        AnchorPane.setBottomAnchor(contactInfoScrollPane, 0.0);
        AnchorPane.setLeftAnchor(contactInfoScrollPane, 0.0);
        AnchorPane.setRightAnchor(contactInfoScrollPane, 0.0);




        //Contact Photo
        ImageView contactPhotoImageView = new ImageView();
        //Image contactImage = new Image("default.jpg");
        //contactPhotoImageView.setImage(contactImage);


        //First Middle Last name text label
        Text contactNameText = new Text("nigger");
        contactNameText.strokeTypeProperty().set(StrokeType.OUTSIDE);
        contactNameText.setTextAlignment(TextAlignment.CENTER);
        contactNameText.setFont(Font.font(24.0));



        //Top banner with photo and name
        FlowPane bannerFlowPane = new FlowPane(contactPhotoImageView, contactNameText);
        bannerFlowPane.setAlignment(Pos.CENTER);
        bannerFlowPane.setColumnHalignment(HPos.CENTER);
        AnchorPane.setTopAnchor(bannerFlowPane, 20.0);
        AnchorPane.setLeftAnchor(bannerFlowPane, 20.0);
        AnchorPane.setRightAnchor(bannerFlowPane, 20.0);



        //Right side Anchor Pane
        AnchorPane rightAnchorPane = new AnchorPane(bannerFlowPane, contactInfoScrollPane);
        AnchorPane.setTopAnchor(rightAnchorPane, 0.0);
        AnchorPane.setBottomAnchor(rightAnchorPane, 0.0);
        AnchorPane.setLeftAnchor(rightAnchorPane, 0.0);
        AnchorPane.setRightAnchor(rightAnchorPane, 0.0);








        //TODO add menu items
        SplitMenuButton menuButton = new SplitMenuButton();
        //TODO MenuItems here



        //Group selection
        //TODO some shit here
        ChoiceBox<String> groupChoiceBox = new ChoiceBox<>();
        //ObservableList<String> groupObservableList =
        //groupChoiceBox.setItems();


        //Search Box
        //TODO set anchors
        TextField searchTextField = new TextField();


        //Contact List
        //TODO set anchors
        ListView<String> contactListView = new ListView<String>();
        ObservableList<String> contactObservableList = FXCollections.observableArrayList ();


        //Left side Anchor Pane
        AnchorPane leftAnchorPane = new AnchorPane();
        AnchorPane.setTopAnchor(leftAnchorPane, 0.0);
        AnchorPane.setBottomAnchor(leftAnchorPane, 0.0);
        AnchorPane.setLeftAnchor(leftAnchorPane, 0.0);
        AnchorPane.setRightAnchor(leftAnchorPane, 0.0);




        //Split Pane
        SplitPane splitPane = new SplitPane(leftAnchorPane,rightAnchorPane);
        AnchorPane.setTopAnchor(splitPane, 0.0);
        AnchorPane.setBottomAnchor(splitPane, 0.0);
        AnchorPane.setLeftAnchor(splitPane, 0.0);
        AnchorPane.setRightAnchor(splitPane, 0.0);
        splitPane.setDividerPositions(0.381966);

        //Main Window Anchor Pane
        AnchorPane mainWindowAnchorPane = new AnchorPane(splitPane);
        mainWindowAnchorPane.setPrefSize(800, 600);


        Scene primaryScene = new Scene(mainWindowAnchorPane);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Bullshit Manager");
        primaryStage.show();
    }
}