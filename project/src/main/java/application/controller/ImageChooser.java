package application.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// This class is responsible for handling image loading.
public class ImageChooser extends VBox {
    // The path where images as copied to
    public static final String IMAGE_DIR_PATH = "src/main/resources/images/";

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
            new File(toFullPath(IMAGE_DIR_PATH)).mkdir();

            relativePath = IMAGE_DIR_PATH + selectedFile.getName();
            File copyFile = new File(toFullPath(relativePath));

            int index = 1;
            String extension = relativePath.substring(relativePath.lastIndexOf('.'));
            String name = relativePath.substring(0, relativePath.lastIndexOf('.'));

            while(copyFile.exists()) {
                relativePath = name + "(" + index + ")" + extension;
                copyFile = new File(toFullPath(relativePath));
                index++;
            }
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
        return Paths.get("").toAbsolutePath().toString() + "/" + relativePath;
    }
    // Copies a file to resources/images/ & then returns the filepath for the file copy.
    public String getSelectedPath() {
        copyFile();
        return relativePath;
    }

    // Sets the relative path for the file
    public void setRelativePath(String path) {
        if(path == null) return;
        this.relativePath = path;

        String labelText = path.substring(path.lastIndexOf("/") + 1);
        choiceLabel.setText(labelText);
    }

   // Sets the selected file
    public void setSelectedFile (File selectedFile) {
        this.selectedFile = selectedFile;
    }
}
