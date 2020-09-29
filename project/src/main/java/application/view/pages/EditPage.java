package application.view.pages;

import application.controller.PostController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class EditPage extends VBox implements Page {
    private static EditPage instance = null;
    private static TextField descriptionInput;
    private static TextField titleInput;
    private static String uuidField;

    public EditPage() {
        this.setId("editPage");
        Button update = new Button("Update");
        Label newTitle = new Label("New title");
        Label newDescription = new Label("New description");

        this.getChildren().addAll(
                newTitle,
                titleInput = new TextField(),
                newDescription,
                descriptionInput = new TextField(),
                update

        );

        newTitle.setId("newTitle");
        newDescription.setId("newDescription");

        update.setOnMouseClicked(this::updatePost);
        update.setId("updateButton");


    }

    private void updatePost(MouseEvent e) {
        PostController.updatePost();
    }

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


