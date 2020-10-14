package application.view.pages.util;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.Set;

public class TagDisplay extends HBox {

    public TagDisplay(Set<String> tags) {
        setTags(tags);
    }

    public void setTags(Set<String> tags) {
        this.getChildren().clear();
        // Create and initialize container for tags
        //this.getChildren().add(new Label("Tags: ")); // Initial text
        //int i = 0; // Counter used to determine when last tag is reached

        this.getStyleClass().add("tagContainer");

        for(String tag : tags) {
            // Add delimiter, comma between tags and nothing when the last tag is reached
            //String delimiter = i != tags.size() - 1 ? ", " : "";
            Label tagLabel = new Label(tag);
            tagLabel.getStyleClass().add("tag");
            this.getChildren().add(tagLabel);
            //i++;
        }
    }

}
