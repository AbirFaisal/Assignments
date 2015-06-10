package com.COP2805C.AddressBook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

    List<Contact> contactList;

    public static void main(String[] args) {


        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {


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

        //TODO TEST Remove
        contactInfoFlowPane.getChildren().addAll(phoneNumberText, emailText, addressText, groupText, notesTextArea);

        //Contact Info Anchor Pane
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
        //TODO dynamicly generate the above



        SplitMenuButton editMenuButton = MainWindow.editMenuButton();

        //Add contact button
        Button addButton = new Button("+");
        AnchorPane.setTopAnchor(addButton, 8.0);
        AnchorPane.setLeftAnchor(addButton, 8.0);

        //clear search bar button (Optional)
        Button clearSearchButton = new Button("X");
        AnchorPane.setTopAnchor(clearSearchButton, 8.0);
        AnchorPane.setRightAnchor(clearSearchButton, 8.0);




        //Group selection
        ObservableList<String> groupObservableList = FXCollections.observableArrayList();
        ChoiceBox<String> groupChoiceBox = MainWindow.groupChoiceBox(groupObservableList);

        groupObservableList.add("Main Group");//TODO for each group add to list
        groupChoiceBox.getSelectionModel().selectFirst();


        //Search Box
        TextField searchTextField = MainWindow.searchTextField();

        //Contact List
        ObservableList<String> contactObservableList = FXCollections.observableArrayList ();
        ListView<String> contactListView = MainWindow.contactListView(contactObservableList);

        //Left side Anchor Pane
        AnchorPane leftAnchorPane = MainWindow.leftAnchorPane(
                addButton,
                searchTextField,
                contactListView,
                groupChoiceBox,
                editMenuButton);


        //Split Pane
        SplitPane splitPane = MainWindow.splitPane(leftAnchorPane, rightAnchorPane);

        //Main Window Anchor Pane
        AnchorPane mainWindowAnchorPane = new AnchorPane(splitPane);
        mainWindowAnchorPane.setPrefSize(800, 600);
        Scene primaryScene = new Scene(mainWindowAnchorPane);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Contacts Manager");
        primaryStage.show();
    }
}