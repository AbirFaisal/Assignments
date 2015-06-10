package com.COP2805C.AddressBook.UserInterface;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

/**
 * Created by abirfaisal on 6/8/15.
 */
public class MainWindow {

    public static SplitPane splitPane(Node... FXNode) {
        SplitPane splitPane = new SplitPane(FXNode);
        AnchorPane.setTopAnchor(splitPane, 0.0);
        AnchorPane.setBottomAnchor(splitPane, 0.0);
        AnchorPane.setLeftAnchor(splitPane, 0.0);
        AnchorPane.setRightAnchor(splitPane, 0.0);
        splitPane.setDividerPositions(0.381966);

        return splitPane;
    }

    //Left Side Anchor Pane
    public static AnchorPane leftAnchorPane(Node... FXNode){
        AnchorPane leftAnchorPane = new AnchorPane(FXNode);
        AnchorPane.setTopAnchor(leftAnchorPane, 0.0);
        AnchorPane.setBottomAnchor(leftAnchorPane, 0.0);
        AnchorPane.setLeftAnchor(leftAnchorPane, 0.0);
        AnchorPane.setRightAnchor(leftAnchorPane, 0.0);

        return leftAnchorPane;
    }


    public static ListView<String> contactListView(ObservableList<String> observableList){
        ListView<String> contactListView = new ListView<String>(observableList);
        AnchorPane.setTopAnchor(contactListView, 42.0);
        AnchorPane.setBottomAnchor(contactListView, 42.0);
        AnchorPane.setLeftAnchor(contactListView, 0.0);
        AnchorPane.setRightAnchor(contactListView, 0.0);

        return contactListView;
    }

    //Search Field
    public static TextField searchTextField(){
        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search");
        AnchorPane.setTopAnchor(searchTextField, 8.0);
        AnchorPane.setLeftAnchor(searchTextField, 36.0);
        AnchorPane.setRightAnchor(searchTextField, 8.0);

        return searchTextField;
    }

    //Group Selection Choice Box
    public static ChoiceBox<String> groupChoiceBox(ObservableList<String> observableList){
        ChoiceBox<String> groupChoiceBox = new ChoiceBox<>(observableList);
        AnchorPane.setBottomAnchor(groupChoiceBox, 8.0);
        AnchorPane.setLeftAnchor(groupChoiceBox, 8.0);

        return groupChoiceBox;
    }


    public static SplitMenuButton editMenuButton(){
        SplitMenuButton menuButton = new SplitMenuButton();
        menuButton.setText("Edit");
        menuButton.getItems().addAll(
                new MenuItem("Delete"),
                new MenuItem("Import/Export"));
        AnchorPane.setBottomAnchor(menuButton, 8.0);
        AnchorPane.setRightAnchor(menuButton, 8.0);

        return menuButton;
    }











}
