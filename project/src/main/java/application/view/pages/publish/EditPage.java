package application.view.pages.publish;

import application.controller.PostController;
import application.model.posts.IPost;
import application.view.pages.Page;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.File;
import java.util.Set;

public class EditPage extends HBox implements Page, IPublishable {
    private static EditPage instance = null;

    Button update = new Button("Update");
    private final InputModule inputModule = new InputModule(update);
    private final MetaModule metaModule = new MetaModule(this);


    private  String uuidField;
    private  String postType;

    public EditPage() {

        // Set id for reference
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

    // Singleton
    public static EditPage getInstance() {
        if (instance == null) instance = new EditPage();
        return instance;
    }

    public void prepareWithOldValues(IPost oldPost) {
        metaModule.removeActive(); // removes the colors for a selected post type button

        inputModule.getTitleInputField().setText(oldPost.getTitle());
        inputModule.getDescriptionInputArea().setText(oldPost.getDescription());

        uuidField = oldPost.getUniqueID();
        postType = oldPost.getType();

        metaModule.getTagChoiceDropdown().setChosenTags(oldPost.getTags());

        if(oldPost.getImagePath() != null && !oldPost.getImagePath().equals("")) {
            metaModule.getImageChooser().setSelectedFile(new File(oldPost.getImagePath()));
            metaModule.getImageChooser().setRelativePath(oldPost.getImagePath());
        } else {
            metaModule.getImageChooser().setSelectedFile(null);
            metaModule.getImageChooser().setRelativePath("");
        }

    }

    public  String getTitleInput () {
        return inputModule.getTitleInputField().getText();
    }

    public  String getDescriptionInput() {
        return inputModule.getDescriptionInputArea().getText();
    }

    public String getUUID() {
        return uuidField;
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


