package application.view.pages.publish;

import application.ResourceLoader;
import application.model.client.Client;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
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
            HBox tagBox = new HBox();
            Label tagLabel = new Label(tag);


            Button deleteButton = new Button();
            deleteButton.setGraphic(ResourceLoader.xIconBig);

            tagBox.getChildren().addAll(tagLabel, deleteButton);
            tagBox.getStyleClass().add("tag");

            tagDisplay.getChildren().add(tagBox);

            // Delete tag on button press
            deleteButton.setOnAction(e -> {
                tagDisplay.getChildren().remove(tagBox);
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
