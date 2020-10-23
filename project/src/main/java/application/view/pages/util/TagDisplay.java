package application.view.pages.util;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.Set;

public class TagDisplay extends FlowPane {
    public TagDisplay(Set<String> tags) {
        setTags(tags);
    }

    public void setTags(Set<String> tags) {
        this.getChildren().clear();
        this.getStyleClass().add("tagContainer");

        this.setVgap(10);
        this.setHgap(10);

        for(String tag : tags) {
            Label tagLabel = new Label(tag);
            tagLabel.getStyleClass().add("tag");
            this.getChildren().add(tagLabel);
        }
    }

}
