package application.view.pages.publish;

import application.view.pages.Page;
import application.view.pages.board.posts.SubmitPostButton;
import javafx.scene.layout.HBox;

import java.util.Set;

public class PublishPage extends HBox implements Page, IPublishable {
    private static PublishPage instance = null;

    private final InputModule inputModule;
    private final MetaModule metaModule;

    private PublishPage() {
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("padding");

        inputModule = new InputModule(SubmitPostButton.getInstance());
        metaModule = new MetaModule(this);

        this.getChildren().addAll(
                inputModule,
                metaModule
        );
    }

    public String getTitleInput () {
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

    public static PublishPage getInstance() {
        if (instance == null) instance = new PublishPage();
        return instance;
    }
}
