package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Database.Crypto;
import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.UserInterface.LoginWindow;
import com.COP2805C.AddressBook.UserInterface.MainWindow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Main extends Application {

    static String[] credentials = new String[2];
    ObservableList<String> contactObservableList = FXCollections.observableArrayList();
    ObservableList<String> groupObservableList = FXCollections.observableArrayList();
    static Database db = Database.getDatabase();
    public static void main(String[] args) {
        System.out.println("Address Book Manager");
        db.innitialize();

        //initialise Database
        //Database.initializeDatabase();

        //TODO check if username table is empty

        //TODO if DB is empty launch createAccount

        //TODO Else launch loginWindow()


        //Prompt for user and password
        credentials = LoginWindow.loginPrompt();

        //TODO TEST REMOVE
        System.out.println("\n Username: " + credentials[0] + "\n Passowrd: " + credentials[1]);
        //temp Method call
        //Database.checkLogin(con,credentials);

        //TODO Authenticate User re-prompt on error

        //TODO Load Contact List from database

        launch(args);
        System.out.println("Quitting");
        //Authenticate the user
        //TODO TEST
        String sha1 = Crypto.stringSHA("test");
        String sha2 = Crypto.stringSHA("tedst");
        boolean shabool = Crypto.verifySHA(sha1, sha2);

        System.out.println(shabool + " Quitting");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        //TODO somthing here? This is a Sample
        //Information
        //TODO TEST REMOVE


        Text phoneNumberText = new Text("dfsd");
        Text emailText = new Text("dfsdsf");
        Text addressText = new Text("sdfsdf");
        Text groupText = new Text("sdfsdfsd");


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
        Text contactNameText = new Text("First Middle Last");
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

        //Something like this then re add the nodes
        //rightAnchorPane.getChildren().clear();


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
        //ObservableList<String> groupObservableList = FXCollections.observableArrayList();
        ChoiceBox<String> groupChoiceBox = MainWindow.groupChoiceBox(groupObservableList);

        groupObservableList.add("Main Group");//TODO for each group add to list
        groupChoiceBox.getSelectionModel().selectFirst();


        //Search Box
        TextField searchTextField = MainWindow.searchTextField();

        //Contact List
        //ObservableList<String> contactObservableList = FXCollections.observableArrayList ();
        ListView<String> contactListView = MainWindow.contactListView(contactObservableList);

        //TODO test
        contactObservableList.add("test");
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

            //TODO fix this?? what is this?
        //Login.loginScreen();//Note I intend for this to pop-up first before the user can do anything thus requiring them to log-in.
    }
}