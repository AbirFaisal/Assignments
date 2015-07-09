package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.OSUtils;
import javafx.animation.FadeTransition;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

/**
 * Created by EpiphX on 7/8/15.
 */
public class TransistionImageView extends ImageView {

    private final String STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
    private final String STYLE_PRESSED = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";

    private ContactInformation contactInformation;
    public TransistionImageView(ContactInformation contactInformation){
        this.contactInformation = contactInformation;

        File file = new File("/src/res/defaultProfileImage.png");

        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);
        final Image defaultImage = new Image("file://"+ workingDir + "/src/res/defaultProfileImage.png", 100.0, 100.0, true, true);
        FileChooser fileChooser = fileChooser();
        setImage(defaultImage);
        clipProperty().set(new Circle(50,50,48));

        setOnMouseClicked(event -> {
            try {
                String filePath;
                if (OSUtils.isWindows()) {
                    //filePath = fileChooser.showOpenDialog(new Stage()).getAbsolutePath();
                    File tempFile = new File(fileChooser.showOpenDialog(new Stage()).getAbsolutePath());
                    filePath = tempFile.toURI().toURL().toString();
                } else {
                    filePath = "file://" + fileChooser.showOpenDialog(new Stage()).getAbsolutePath();
                }
                Image newImage = new Image(filePath, 100.0, 100.0, true, false);
                this.contactInformation.setProfileImage(newImage);
                setImage(newImage);

            }catch (Exception e){
                System.out.println("No File selected");
                setImage(defaultImage);
            }
        });

        setOnMouseEntered(event -> {
            setCursor(Cursor.HAND); //Change cursor to hand
            FadeTransition ft = new FadeTransition(Duration.millis(250),this);
            ft.setFromValue(1.0);
            ft.setToValue(0.5);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
        });

        setOnMouseExited(event -> {
            FadeTransition ft = new FadeTransition(Duration.millis(500),this);
            ft.setFromValue(0.5);
            ft.setToValue(1.0);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
        });
        System.out.println("Testing if this prints");
    }

    public FileChooser fileChooser(){
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("View Pictures");

        //TODO make sure this works in windows
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        return fileChooser;
    }
}


//    public ImageView contactImageView(){
//        //TODO smoothout animation. To achieve the effect I desire, I may have to use two imageViews. We will discuss this in class.
//        //TODO since this ImageView is very custom, we should consider making it its own class similarly to how I made the imageButton class.
//        File file, editFile;
//        Image defaultImage, defaultEditImage;
//        ImageView imageView;
//        final ImageView editImageView;
//        FileChooser fileChooser;
//
//        file = new File("src/res/defaultProfileImage.png");
//        editFile = new File("src/res/defaultProfileEditImage.png");
//        if(OSUtils.isWindows()) {
//            System.out.println(file.getAbsolutePath());
//            defaultImage = new Image("res/defaultProfileImage.png", 100.0, 100.0, true, true);
//            defaultEditImage = new Image("res/defaultProfileEditImage.png", 100.0, 100.0, true, true);
//        }else{
//            defaultImage = new Image("file://" + file.getAbsolutePath(), 100.0, 100.0, true, true);
//            defaultEditImage = new Image("file://" + editFile.getAbsolutePath(), 100.0, 100.0, true, true);
//        }
//        imageView = new ImageView(defaultImage);
//        imageView.clipProperty().set(new Circle(50, 50, 48));
//
//        editImageView = new ImageView(defaultEditImage);
//        editImageView.clipProperty().set(new Circle(50,50,48));
//        editImageView.setOpacity(0.2);
//        editImageView.setVisible(false);
//        fileChooser = fileChooser();
//
//        imageView.setOnMouseClicked(event -> {
//            try {
//                String filePath;
//                if(OSUtils.isWindows()){
//                    //filePath = fileChooser.showOpenDialog(new Stage()).getAbsolutePath();
//                    File tempFile = new File(fileChooser.showOpenDialog(new Stage()).getAbsolutePath());
//                    filePath = tempFile.toURI().toURL().toString();
//                }else{
//                    filePath = "file://" + fileChooser.showOpenDialog(new Stage()).getAbsolutePath();
//                }
//                Image image = new Image(filePath, 100.0, 100.0, true, false);
//                this.contactInformation.setProfileImage(image);
//                imageView.setImage(image);
//
//            }catch (Exception e){
//                System.out.println("No File selected");
//                imageView.setImage(defaultImage);
//            }
//        });
//        imageView.setOnMouseEntered(event -> {
//            imageView.setCursor(Cursor.HAND); //Change cursor to hand
//            FadeTransition ft = new FadeTransition(Duration.millis(500), imageView);
//            ft.setFromValue(1.0);
//            ft.setToValue(0.5);
//            ft.setCycleCount(1);
//
//            ft.setOnFinished(event1 -> imageView.setImage(defaultEditImage));
//            ft.setAutoReverse(false);
//            ft.play();
//        });
//
//        imageView.setOnMouseExited(event -> {
//            FadeTransition ft = new FadeTransition(Duration.millis(500), imageView);
//            ft.setFromValue(0.5);
//            ft.setToValue(1.0);
//            ft.setCycleCount(1);
//
//            ft.setOnFinished(event1 -> {
//                if (this.contactInformation.getProfileImage() == null) {
//                    System.out.println("No picture selected");
//                    imageView.setImage(defaultImage);
//                }else {
//                    imageView.setImage(this.contactInformation.getProfileImage());
//                }
//            });
//            ft.setAutoReverse(false);
//            ft.play();
//        });
//
//        return imageView;
//    }
//
