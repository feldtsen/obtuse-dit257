package application.view.pages.board;

import application.controller.PostController;
import application.model.posts.IPost;
import application.view.pages.Page;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class EditPage extends VBox implements Page {
    private static EditPage instance = null;

    private static TextArea descriptionInput;
    private static TextField titleInput;
    private static String uuidField;
    private static String postType;


    public EditPage() {
        // Create the GUI elements
        Label newTitle       = new Label("New title");
        Label newDescription = new Label("New description");
        Button update        = new Button("Update");
        titleInput           = new TextField();
        descriptionInput     = new TextArea();

        // Set id for reference
        this.setId("editPage");
        newTitle.setId("newTitle");
        newDescription.setId("newDescription");
        update.setId("updateButton");

        descriptionInput.setMinHeight(50);
        descriptionInput.setWrapText(true);
        // Connect button to controller
        update.setOnMouseClicked(e -> PostController.updatePost());

        // Add GUI elements to the page
        this.getChildren().addAll(
                newTitle,
                titleInput,
                newDescription,
                descriptionInput,
                update

        );

    }

    // Singleton
    public static EditPage getInstance() {
        if (instance == null) instance = new EditPage();
        return instance;
    }

    public void prepareWithOldValues(IPost oldPost) {
        titleInput.setText(oldPost.getTitle());
        descriptionInput.setText(oldPost.getDescription());
        uuidField = oldPost.getUniqueID();
        postType = oldPost.getType();
    }

    public static String getTitleInput () {
        return titleInput.getText();
    }

    public static String getDescriptionInput() {
        return  descriptionInput.getText();
    }

    public static String getUUID() {
        return uuidField;
    }

    public static String getPostType(){
        return postType;
    }


}


