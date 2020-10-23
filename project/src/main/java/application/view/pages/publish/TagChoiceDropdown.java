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

// Dropdown view for picking a set of tags to add to a post
public class TagChoiceDropdown extends VBox {
    // The set of chosen tags
    private Set<String> chosenTags = new HashSet<>();

    // The available choices
    private final ComboBox<String> tagChoices;

    // The view for displaying the chosen tags
    private final FlowPane tagDisplay;

    // Initialize with an empty set
    public TagChoiceDropdown(){
        this(Set.of());
    }

    // Initialize with an already existing set of tags
    public TagChoiceDropdown(Set<String> initialTags) {
        // Initialize the combo box with all the available tags (as provided by the tag parser)
        tagChoices = new ComboBox<>(FXCollections.observableArrayList(Client.getInstance().getTagParser().getAllTags()));

        // Set styling
        tagChoices.getStyleClass().add("tagDropdown");
        tagChoices.setOnHidden(this::action);
        tagChoices.setMaxWidth(10000000000000000d);

        // Initialize with initial tags
        chosenTags.addAll(initialTags);

        // Create chosen tag display
        this.tagDisplay = new FlowPane();

        this.getChildren().addAll(tagChoices, tagDisplay);

        // Update the display with the chosen tags
        updateTags(chosenTags);
    }

    // Updates the display with chosen tags
    private void updateTags(Set<String> tags) {
        // Clear the view
        tagDisplay.getChildren().clear();

        // Set styling
        tagDisplay.getStyleClass().add("tagContainer");
        tagDisplay.setVgap(10);
        tagDisplay.setHgap(10);

        // Initialize tag display with all tags
        for(String tag : tags) {
            // Create a button for deleting a chosen tag
            Button deleteButton = new Button(tag);

            // Set styling
            deleteButton.getStyleClass().add("tag");

            // Set icon using SVG
            deleteButton.setGraphic(SVGHelper.createIcon(ResourceLoader.crossIcon, 0.025));

            // Add delete button to display
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
