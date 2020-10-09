package application.controller;

import application.App;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImageChooser extends HBox {
    private final Button chooseButton;
    private final Label choiceLabel;

    private static final String[] EXTENSIONS = {
            "*.png",
            "*.jpg",
            "*.jpeg"
    };

    private final FileChooser chooser;
    private File selectedFile = null;
    private File copiedFile = null;

    public ImageChooser() {
        super();

        chooseButton = new Button();
        chooseButton.setText("Select image");
        chooseButton.setOnAction(e -> selectImage());

        choiceLabel = new Label("");

        this.getChildren().addAll(chooseButton, choiceLabel);

        this.chooser = new FileChooser();
        this.chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", EXTENSIONS));

    }

    private void selectImage() {
        selectedFile = chooser.showOpenDialog(null);
        choiceLabel.setText(selectedFile.getName());
    }

    private void copyFile() {
        if(isSelected()) {
            //TODO ugly semi-hard coded relative path!??
            File copyFile = new File(Paths.get("").toAbsolutePath().toString() + "/src/main/resources/" + selectedFile.getName());
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
                copiedFile = null;
            }
            copiedFile = copyFile;
        }
    }

    public boolean isSelected() {
        return selectedFile != null;
    }

    public Image getSelectedImage() {
        if(selectedFile != null) {
            copyFile();
        }
        return new Image(copiedFile.toURI().toString());
    }
}
