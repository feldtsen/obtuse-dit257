package application.view.pages.publish;

import application.model.client.Client;
import application.model.util.TagParser;
import application.view.pages.util.TagDisplay;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.util.HashSet;
import java.util.Set;

public class TagChoiceDropdown extends HBox {
    private final static TagParser tagParser = Client.getInstance().getTagParser();
    private final Set<String> tags = new HashSet<>();
    private final ComboBox<String> tagChoices;
    private final TagDisplay tagDisplay;

    public TagChoiceDropdown(){
        tagChoices = new ComboBox<>(FXCollections.observableArrayList(tagParser.getAllTags()));
        tagChoices.getStyleClass().add("tagDropdown");
        tagChoices.setOnHidden(this::action);
        tagDisplay = new TagDisplay(tags);
        this.getChildren().addAll(tagChoices, tagDisplay);
    }
    private void action(Event e){
        if(!tagChoices.getSelectionModel().isEmpty()) {
            tags.add(tagChoices.getSelectionModel().getSelectedItem());
            tagChoices.getSelectionModel().clearSelection();
            tagDisplay.setTags(tags);
        }
    }
    public Set<String> getTags(){
        return tags;
    }
}
