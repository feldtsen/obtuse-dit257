package application.view.pages.publish;

import application.ResourceLoader;
import application.model.client.Client;
import application.view.util.SVGHelper;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.HashSet;
import java.util.Set;

public class TagChoiceDropdown extends VBox {
    private Set<String> chosenTags = new HashSet<>();
    private final ComboBox<String> tagChoices;
    private final FlowPane tagDisplay;

    public TagChoiceDropdown(){
        this(Set.of());
    }

    public TagChoiceDropdown(Set<String> initialTags){
        tagChoices = new ComboBox<>(FXCollections.observableArrayList(Client.getInstance().getTagParser().getAllTags()));

        tagChoices.getStyleClass().add("tagDropdown");
        tagChoices.setOnHidden(this::action);

        tagChoices.setMaxWidth(10000000000000000d);

        chosenTags.addAll(initialTags);

        this.tagDisplay = new FlowPane();

        this.getChildren().addAll(tagChoices, tagDisplay);

        updateTags(chosenTags);
    }

    private void updateTags(Set<String> tags) {
        tagDisplay.getChildren().clear();
        tagDisplay.getStyleClass().add("tagContainer");
        tagDisplay.setVgap(10);
        tagDisplay.setHgap(10);

        for(String tag : tags) {
            Button deleteButton = new Button(tag);
            deleteButton.getStyleClass().add("tag");


            deleteButton.setGraphic(SVGHelper.createIcon(ResourceLoader.crossIcon, 0.025));

            tagDisplay.getChildren().add(deleteButton);

            // Delete tag on button press
            deleteButton.setOnAction(e -> {
                tagDisplay.getChildren().remove(deleteButton);
                chosenTags.remove(tag);
            });

        }
    }

    private void action(Event e){
        if(!tagChoices.getSelectionModel().isEmpty()) {
            String tag = tagChoices.getSelectionModel().getSelectedItem();
            chosenTags.add(tag);
            tagChoices.getSelectionModel().clearSelection();
            updateTags(chosenTags);
        }
    }

    public Set<String> getChosenTags(){
        return chosenTags;
    }

    public void setChosenTags(Set<String> tags){
       this.chosenTags = tags;
       updateTags(chosenTags);
    }
}
