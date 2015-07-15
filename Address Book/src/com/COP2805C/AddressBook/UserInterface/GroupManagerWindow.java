package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Functions;
import com.COP2805C.AddressBook.Main;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import javax.swing.*;
import java.util.Optional;


public class GroupManagerWindow {



    public static Scene groupManager(){

        ListView listView = groupListView(Main.getGroupObservableList());

        FlowPane buttonsFlowPane = new FlowPane(addButton(), deleteButton(listView));
        AnchorPane.setBottomAnchor(buttonsFlowPane, 8.0);
        AnchorPane.setLeftAnchor(buttonsFlowPane, 8.0);
        AnchorPane.setRightAnchor(buttonsFlowPane, 8.0);
        buttonsFlowPane.setAlignment(Pos.CENTER);
        buttonsFlowPane.setHgap(8.0);

        AnchorPane anchorPane = new AnchorPane(
                listView,
                buttonsFlowPane);


        return new Scene(anchorPane);
    }


    public static ListView<String> groupListView(ObservableList<String> observableList) {
        ListView<String> groupListView = new ListView<String>(observableList);
        AnchorPane.setTopAnchor(groupListView, 0.0);
        AnchorPane.setBottomAnchor(groupListView, 40.0);
        AnchorPane.setLeftAnchor(groupListView, 0.0);
        AnchorPane.setRightAnchor(groupListView, 0.0);

        return groupListView;
    }


    public static Button addButton(){
        Button button = new Button("Add Group");

        button.setOnMouseClicked(e -> {

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Group Creation");
            dialog.setHeaderText("Enter Group Name");
            dialog.setGraphic(null);

            Optional<String> result = dialog.showAndWait();
            String entered = "";

            if (result.isPresent()) {
                entered = result.get();
            }

            if(entered.length()> 0) {
                Main.getGroupObservableList().add(entered);
            }
        });

        return button;
    }

    private static Button deleteButton(ListView<String> listView){
        Button button = new Button("Delete Group");

        //Delete all in group
        button.setOnMouseClicked(e ->{
            Functions.deleteAllPictureFile(listView.getSelectionModel().getSelectedItem());
            Main.getDatabase().deleteGroup(Main.getCredentials(), listView.getSelectionModel().getSelectedItem());
            Main.getGroupObservableList().remove(listView.getSelectionModel().getSelectedItem());
            Functions.refreshGroupList();
            Functions.refreshContactArray();
            Functions.refreshListView();
            Main.getGroupChoiceBox().getSelectionModel().selectFirst();
        });

        return button;
    }

    private static Button editButton(ListView listView){
        Button button = new Button("Edit Group");

        button.setOnMouseClicked(e -> {
            
            listView.getSelectionModel().getSelectedIndex();



            //TODO edit existing group
            //TODO updated contacts in group using new group string
        });

        return button;
    }
}
