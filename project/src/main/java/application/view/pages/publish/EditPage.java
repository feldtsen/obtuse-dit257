package application.view.pages.publish;

import application.controller.ImageChooser;
import application.controller.PostController;
import application.model.posts.IPost;
import application.view.pages.Page;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.Set;

public class EditPage extends HBox implements Page {
    private static EditPage instance = null;

    private static TextArea descriptionInput;
    private static TextField titleInput;
    private static String uuidField;
    private static String postType;

    private static TagChoiceDropdown tagChoiceDropdown;

    private static ImageChooser imageChooser;

    public EditPage() {
        // Create the GUI elements
        Label newTitle       = new Label("New title");
        Label newDescription = new Label("New description");
        Button update        = new Button("Update");
        titleInput           = new TextField();
        titleInput.setPromptText("enter your new post title");
        descriptionInput     = new TextArea();
        descriptionInput.setPromptText("enter your new description");
        tagChoiceDropdown    = new TagChoiceDropdown();
        imageChooser = new ImageChooser();
        // Set id for reference
        this.getStyleClass().add("padding");
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("descriptionInput");

        descriptionInput.setWrapText(true);
        // Connect button to controller
        update.setOnMouseClicked(e -> PostController.updatePost());

        // Add GUI elements to the page
        this.getChildren().addAll(
                newTitle,
                titleInput,
                newDescription,
                descriptionInput,
                tagChoiceDropdown,
                imageChooser,
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
        tagChoiceDropdown.setChosenTags(oldPost.getTags());
        imageChooser.setRelativePath(oldPost.getImagePath());
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

    public static Set<String> getTags(){
        return tagChoiceDropdown.getChosenTags();
    }

    public static String getImagePath() {
        System.out.println(imageChooser.getSelectedPath());
        return imageChooser.getSelectedPath();
    }


}


