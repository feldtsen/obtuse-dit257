package application.view.pages;

import application.controller.PostController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class EditPage extends VBox implements Page {
    private static EditPage instance = null;

    private static TextField descriptionInput;
    private static TextField titleInput;
    private static String uuidField;

    public EditPage() {
        // Create the GUI elements
        Label newTitle = new Label("New title");
        Label newDescription = new Label("New description");
        Button update = new Button("Update");

        // Set id for reference
        this.setId("editPage");
        newTitle.setId("newTitle");
        newDescription.setId("newDescription");
        update.setId("updateButton");

        // Connect button to controller
        update.setOnMouseClicked(e -> PostController.updatePost());

        // Add GUI elements to the page
        this.getChildren().addAll(
                newTitle,
                titleInput = new TextField(),
                newDescription,
                descriptionInput = new TextField(),
                update

        );

    }

    // Singleton
    public static EditPage getInstance() {
        if (instance == null) instance = new EditPage();
        return instance;
    }

    public static TextField getTitleInput() {
        return titleInput;
    }

    public static TextField getDescriptionInput() {
        return descriptionInput;
    }

    public static void setTitleText(String oldTitle) {
        titleInput.setText(oldTitle);
    }

    public static void setDescriptionText(String oldDescription) {
        descriptionInput.setText(oldDescription);
    }

    public static void setUuid(String uuid) {
        uuidField = uuid;
    }

    public static String getUuid() {
        return uuidField;
    }

}


