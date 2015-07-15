package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Main;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;


public class GroupManagerWindow {


    public static Scene groupManager(){

        ListView listView = groupListView(Main.getGroupObservableList());

        FlowPane buttonsFlowPane = new FlowPane(addButton(), deleteButton(), editButton(listView));
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

            //TODO wtf makes program freeze
            String group = JOptionPane.showInputDialog("Enter Group Name");

            System.out.println(group);

            Main.getGroupObservableList().add(group);

            //TODO add group to DB

            //TODO add group to list
        });

        return button;
    }

    private static Button deleteButton(){
        Button button = new Button("Delete Group");

        //Delete all in group
        button.setOnMouseClicked(e ->{


            //TODO delete group
            //TODO delete all contacts in group

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
