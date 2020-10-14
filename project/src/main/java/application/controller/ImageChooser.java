package application.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImageChooser extends VBox {
    private final Button chooseButton;
    private final Label choiceLabel;

    private static final String[] EXTENSIONS = {
            "*.png",
            "*.jpg",
            "*.jpeg"
    };

    private final FileChooser chooser;
    private File selectedFile = null;
    private String relativePath = null;

    public ImageChooser() {
        super();

        chooseButton = new Button();
        chooseButton.setText("Upload Image");
        chooseButton.setOnAction(e -> selectImage());


        choiceLabel = new Label("");

        this.getChildren().addAll(chooseButton, choiceLabel);

        this.chooser = new FileChooser();
        this.chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", EXTENSIONS));

    }

    private void selectImage() {
        selectedFile = chooser.showOpenDialog(null);
        if(selectedFile != null) {
            choiceLabel.setText(selectedFile.getName());
        }
    }

    private void copyFile() {
        if(isSelected()) {
            //TODO ugly semi-hard coded relative path!??
            relativePath = "/src/main/resources/" + selectedFile.getName();
            File copyFile = new File(toFullPath(relativePath));
            System.out.println(copyFile.getPath());
            //TODO: fix to not overwrite existing files
            /*while(copyFile.exists()) {
                copyFile = new File(copyFile.toPath().toString() )
            }*/
            try {
                Files.copy(selectedFile.toPath(), copyFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                ClientController.showAlert("Unable to copy images", Alert.AlertType.ERROR);
                selectedFile = null;
                relativePath = null;
            }
        }
    }

    public boolean isSelected() {
        return selectedFile != null;
    }

    public static String toFullPath(String relativePath) {
        return Paths.get("").toAbsolutePath().toString() + relativePath;
    }

    public String getSelectedPath() {
        //TODO: currently does two things... :(
        if(selectedFile != null) {
            copyFile();
        }
        return relativePath;
    }
}
