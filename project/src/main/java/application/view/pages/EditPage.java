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

        this.getChildren().addAll(
                new Label("New title: "),
                titleInput = new TextField(),
                new Label("New description: "),
                descriptionInput = new TextField(),
                update

        );

        update.setOnMouseClicked(this::updatePost);


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


