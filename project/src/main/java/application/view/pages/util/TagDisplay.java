package application.view.pages.util;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.Set;

// Display for showing the tags appended to a certain post
public class TagDisplay extends FlowPane {
    public TagDisplay(Set<String> tags) {
        setTags(tags);
    }

    // Sets the tags of the display
    public void setTags(Set<String> tags) {
        // Set styling
        this.getStyleClass().add("tagContainer");
        this.setVgap(10);
        this.setHgap(10);

        // Clear current tags
        this.getChildren().clear();

        // Add the new tags and add styling
        for(String tag : tags) {
            Label tagLabel = new Label(tag);
            tagLabel.getStyleClass().add("tag");
            this.getChildren().add(tagLabel);
        }
    }

}
