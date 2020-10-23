package application.view.pages.publish;

import application.controller.PostController;
import application.model.posts.IPost;
import application.view.pages.Page;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.File;
import java.util.Set;

// Page/view for editing an already existing post
public class EditPage extends HBox implements Page, IPublishable {
    // Singleton pattern, since there should only be one
    private static EditPage instance = null;

    // Create update button
    private final Button update = new Button("Update");

    // Create module used for entering post-related data such as title and description
    private final InputModule inputModule = new InputModule(update);

    // Create module for entering additional post data, such as tags, image, etc
    private final MetaModule metaModule = new MetaModule(this);

    // Unique ID of post
    private String uniqueIDField;

    // Type of post
    private String postType;

    public EditPage() {
        // Set styling
        this.getStyleClass().add("padding");
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("descriptionInput");

        // Connect button to controller
        update.setOnMouseClicked(e -> PostController.updatePost());

        this.getChildren().addAll(
                inputModule,
                metaModule
        );
    }

    // Create and return global instance
    public static EditPage getInstance() {
        if (instance == null) instance = new EditPage();
        return instance;
    }

    // Prepare module fields with old post data
    public void prepareWithOldValues(IPost oldPost) {
        // Remove active status from any buttons
        metaModule.removeActive();

        // Set text of input fields
        inputModule.getTitleInputField().setText(oldPost.getTitle());
        inputModule.getDescriptionInputArea().setText(oldPost.getDescription());

        // Set uniqueID and post type
        uniqueIDField = oldPost.getUniqueID();
        postType = oldPost.getType();

        // Set already chosen tags
        metaModule.getTagChoiceDropdown().setChosenTags(oldPost.getTags());

        // Set selected image if one is selected, or reset image chooser if none is selected
        if(oldPost.getImagePath() != null && !oldPost.getImagePath().equals("")) {
            metaModule.getImageChooser().setSelectedFile(new File(oldPost.getImagePath()));
            metaModule.getImageChooser().setRelativePath(oldPost.getImagePath());
        } else {
            metaModule.getImageChooser().setSelectedFile(null);
            metaModule.getImageChooser().setRelativePath("");
        }

    }

    public  String getTitleInput() {
        return inputModule.getTitleInputField().getText();
    }

    public  String getDescriptionInput() {
        return inputModule.getDescriptionInputArea().getText();
    }

    public String getUniqueID() {
        return uniqueIDField;
    }

    public String getPostType(){
        return postType;
    }

    public Set<String> getTags(){
        return metaModule.getTagChoiceDropdown().getChosenTags();
    }

    public String getImagePath() {
        return metaModule.getImageChooser().getSelectedPath();
    }


    @Override
    public void setPostType(String type) {
        this.postType = type;
    }
}


