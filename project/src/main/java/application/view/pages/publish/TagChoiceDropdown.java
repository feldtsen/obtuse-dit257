package application.view.pages.publish;

import application.model.client.Client;
import application.model.util.TagParser;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.scene.control.ComboBox;

import java.util.HashSet;
import java.util.Set;

public class TagChoiceDropdown extends ComboBox<String> {
    private final static TagParser tagParser = Client.getInstance().getTagParser();
    private final Set<String> tags = new HashSet<>();

    public TagChoiceDropdown(){
        super(FXCollections.observableArrayList(tagParser.getAllTags()));
        this.getStyleClass().add("tagDropdown");
        this.setOnHidden(this::action);
    }
    private void action(Event e){
        if(!this.getSelectionModel().isEmpty()) {
            tags.add(this.getSelectionModel().getSelectedItem());
            this.getSelectionModel().clearSelection();
        }
    }
    public Set<String> getTags(){
        return tags;
    }
}
