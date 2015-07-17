package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.FirstNameComparator;
import com.COP2805C.AddressBook.Functions;
import com.COP2805C.AddressBook.Main;
import com.COP2805C.AddressBook.UserInterface.ContactForms.FormFactory;
import com.COP2805C.AddressBook.UserInterface.ContactViewPane.ContactViewFactory;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Collections;

/*
 * Copyright (c) 2015
 * Abir Faisal
 * Chris Buruchian
 * Alex Truong-Mai
 * Will Herrin
 *
 * COP2805 Valencia College
 * Professor dsfasdfa
 */

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
    public static AnchorPane leftAnchorPane(Node... FXNode) {
        AnchorPane leftAnchorPane = new AnchorPane(FXNode);
        AnchorPane.setTopAnchor(leftAnchorPane, 0.0);
        AnchorPane.setBottomAnchor(leftAnchorPane, 0.0);
        AnchorPane.setLeftAnchor(leftAnchorPane, 0.0);
        AnchorPane.setRightAnchor(leftAnchorPane, 0.0);

        //TODO ???
        leftAnchorPane.setStyle("-fx-background-color: linear-gradient(#4A4A4A 0%, #2B2B2B 100%)");

        return leftAnchorPane;
    }


    public static ListView<String> contactListView(ObservableList<String> observableList) {
        ListView<String> contactListView = new ListView<String>(observableList);
        AnchorPane.setTopAnchor(contactListView, 42.0);
        AnchorPane.setBottomAnchor(contactListView, 42.0);
        AnchorPane.setLeftAnchor(contactListView, 0.0);
        AnchorPane.setRightAnchor(contactListView, 0.0);

        contactListView.setCellFactory(list -> new AttachmentListCell());
        contactListView.setFixedCellSize(40.0);
        contactListView.getSelectionModel().selectFirst();

        contactListView.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {

            int selectedIndex = 0;
            //error checking necessary to avoid array Out Of Bounds.
            if (newValue.intValue() != -1) selectedIndex = newValue.intValue();

            if (Main.getContactInformationArrayList().size() != 0) {
                AnchorPane newRightAnchorPane = ContactViewFactory.contact(
                        Main.getContactInformationArrayList().get(selectedIndex)).contactView();


                Functions.zeroAnchor(newRightAnchorPane);

                Main.getRightAnchorPane().getChildren().clear();
                Main.getRightAnchorPane().getChildren().add(newRightAnchorPane);
                //contactViewFactory.contact(contactInformationArrayList.get(selectedIndex)).contactView());
            }
        });

        contactListView.getStylesheets().add("/listStyle.css");
        return contactListView;
    }

    //Add Contact Button
    //TODO Instead of passing mainStage, I opted to have it generate a stage within the button for its use.
    //TODO I did this because mainStage was persisting in the memory and not allowing me to use modality.
    //TODO I needed to use modality to prevent the user from messing with the Main window while in the addContact form and thus protecting our database from corruption.

    public static Button addButton() {
        Button button = new Button("+");
        FormFactory formFactory = new FormFactory();

        button.setOnMouseClicked(e -> {
            Stage stage = new Stage();
            stage.setTitle("Add Group");
            stage.setResizable(false);
            stage.setScene(formFactory.getForm(new ContactInformation(), "ADD", stage).form());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        });

        AnchorPane.setTopAnchor(button, 8.0);
        AnchorPane.setLeftAnchor(button, 8.0);

        return button;
    }

    //Search Field
    public static TextField searchTextField() {
        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search");
        AnchorPane.setTopAnchor(searchTextField, 8.0);
        AnchorPane.setLeftAnchor(searchTextField, 38.0);
        AnchorPane.setRightAnchor(searchTextField, 102.0);


        searchTextField.textProperty().addListener((v, oldValue, newValue) -> {
            Functions.searchByKey(oldValue, newValue);
        });


        return searchTextField;
    }

    //Todo Work on sorting.
    public static ChoiceBox<String> sortChoiceBox() {
        //String[] sortMethods = {""};
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        choiceBox.getItems().addAll("First", "Last", "Phone #");
        choiceBox.getSelectionModel().selectFirst();

        AnchorPane.setTopAnchor(choiceBox, 8.0);
        AnchorPane.setRightAnchor(choiceBox, 8.0);


        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {

            if (newValue.contains("First")) {
                Collections.sort(Main.getContactInformationArrayList(), new FirstNameComparator());
                Functions.refreshListView();
            }

            if (newValue.contains("Last")) {
                Collections.sort(Main.getContactInformationArrayList(), new Functions.LastNameComparator());
                Functions.refreshListView();
            }

            if (newValue.contains("Phone #")) {
                Collections.sort(Main.getContactInformationArrayList(), new Functions.PhoneNumberComparator());
                Functions.refreshListView();
            }
        });
        return choiceBox;
    }

    //Group Selection Choice Box
    public static ChoiceBox<String> groupChoiceBox(ObservableList<String> observableList) {

        ChoiceBox<String> groupChoiceBox = new ChoiceBox<>(observableList);

        Main.setGroupsArrayList(
                Main.getDatabase().getGroups(
                        Main.getCredentials()));

        Functions.refreshGroupList();
        groupChoiceBox.getSelectionModel().selectFirst(); // select first by default

        groupChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            Main.setContactInformationArrayList(
                    Main.getDatabase().populateContactList(
                            Main.getCredentials(), newValue));
            Collections.sort(Main.getContactInformationArrayList(), new FirstNameComparator());
            Functions.refreshListView();
        });

        return groupChoiceBox;
    }


    public static Button manageGroupsButton() {
        Button button = new Button("Manage");

        button.setOnMouseClicked(e -> {
            Stage stage = new Stage();
            stage.setTitle("Group Manager");
            stage.setResizable(false);
            stage.setScene(GroupManagerWindow.groupManager());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        });

        return button;
    }

    public static FlowPane groupFlowPane() {
        FlowPane flowPane = new FlowPane(
                Main.getGroupChoiceBox(),
                manageGroupsButton());

        flowPane.setHgap(8.0);
        AnchorPane.setLeftAnchor(flowPane, 8.0);
        AnchorPane.setBottomAnchor(flowPane, 8.0);
        flowPane.setMaxWidth(250.0);

        return flowPane;
    }


    public static SplitMenuButton editMenuButton() {
        SplitMenuButton menuButton = new SplitMenuButton();
        FormFactory formFactory = new FormFactory();

        menuButton.setText("Edit");
        MenuItem delete = new MenuItem("Delete");

        menuButton.getItems().addAll(delete,
                new MenuItem("Import/Export"));
        AnchorPane.setBottomAnchor(menuButton, 8.0);
        AnchorPane.setRightAnchor(menuButton, 8.0);


        menuButton.setOnMouseClicked(e -> {
            Stage stage = new Stage();

            stage.setTitle("Edit Contact - " +
                    Functions.getFormattedNameFMLN(
                            Main.getContactInformationArrayList().get(
                                    Main.getContactListView().getSelectionModel().getSelectedIndex())));


            stage.setResizable(false);
            stage.setScene(formFactory.getForm(Main.getContactInformationArrayList()
                    .get(Main.getContactListView().getSelectionModel()
                            .getSelectedIndex()), "EDIT", stage).form());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        });

        //TODO COMMENT THIS and move to another method
        delete.setOnAction(e -> {
            int selectedIndex = Main.getContactListView().getSelectionModel().getSelectedIndex();

            Main.getDatabase().deleteCONTACTID(
                    Main.getContactInformationArrayList().get(selectedIndex).getKey());

            Functions.deletePictureFile(Main.getContactInformationArrayList().get(selectedIndex).getKey());

            Main.getContactInformationArrayList().remove(selectedIndex);

            Functions.refreshListView();
            Main.setGroupsArrayList(
                    Main.getDatabase().getGroups(
                            Main.getCredentials()));

            Functions.refreshGroupList();

            Main.getGroupChoiceBox().getSelectionModel().selectFirst();

        });

        return menuButton;
    }

}


