package com.COP2805C.AddressBook.UserInterface;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by abirfaisal on 7/11/15.
 */
public class GroupManagerWindow {


    static Stage stage;

    public static void groupManager(){


        ListView listView;





        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }


    private static Button addbuttpn(){
        Button button = new Button("Add Group");
        return button;
    }


    private Button deleteButton (){
        Button button = new Button("Add Group");
        return button;
    }



    private Button editButton(){
        Button button = new Button("Add Group");
        return button;
    }
}
