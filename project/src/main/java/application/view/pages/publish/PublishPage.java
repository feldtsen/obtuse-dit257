package application.view.pages.publish;

import application.view.pages.Page;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.Set;

public class PublishPage extends HBox implements Page {
    private static PublishPage instance = null;

    private final InputModule inputModule;
    private final MetaModule metaModule;

    private PublishPage() {
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("padding");

        inputModule = new InputModule();
        metaModule = new MetaModule();

        HBox.setHgrow(inputModule, Priority.ALWAYS);


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

    public static PublishPage getInstance() {
        if (instance == null) instance = new PublishPage();
        return instance;
    }
}
