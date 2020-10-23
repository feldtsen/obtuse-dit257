package application.view.pages.publish;

import application.view.pages.Page;
import application.view.pages.board.posts.SubmitPostButton;
import javafx.scene.layout.HBox;

import java.util.Set;

// Page for publishing a new post
public class PublishPage extends HBox implements Page, IPublishable {
    // Singleton pattern, since there should only be one
    private static PublishPage instance = null;

    // Module for entering title, description, etc
    private final InputModule inputModule;

    // Module for adding tags, images and post type
    private final MetaModule metaModule;

    private PublishPage() {
        // Set styling
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("padding");

        // Create modules
        inputModule = new InputModule(SubmitPostButton.getInstance());
        metaModule  = new MetaModule(this);

        this.getChildren().addAll(
                inputModule,
                metaModule
        );
    }

    public String getTitleInput() {
        return inputModule.getTitleInputField().getText();
    }

    public String getDescriptionInput() {
       return inputModule.getDescriptionInputArea().getText();
    }

    public String getPostType() {
        return metaModule.getType();
    }

    public void setPostType(String type) {
        metaModule.setType(type);
    }

    public Set<String> getSelectedTags (){ return metaModule.getSelectedTags(); }

    public String getImagePath() {
        return metaModule.getImagePath();
    }

    public MetaModule getMetaModule() {
        return metaModule;
    }

    // Create and return global instance
    public static PublishPage getInstance() {
        if (instance == null) instance = new PublishPage();
        return instance;
    }
}
