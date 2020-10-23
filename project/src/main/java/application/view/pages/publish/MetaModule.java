package application.view.pages.publish;

import application.controller.ImageChooser;
import application.view.pages.board.posts.ButtonContainer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Module for entering additional post-related data, such as
// images, post type, tags, and so on
public class MetaModule extends VBox {
    // Every post starts out as a Donation
    private String type = "Donation";

    // Drop down for picking tags
    private final TagChoiceDropdown tagChoice = new TagChoiceDropdown();

    // Image chooser, if the user wants to include an image
    private final ImageChooser imageChooser = new ImageChooser();

    // Buttons for marking a post as donations/requests
    private final DonationButton donationButton = new DonationButton();
    private final RequestButton requestButton = new RequestButton();

    // The page which is using the meta module
    private final IPublishable publishable;

    public MetaModule(IPublishable publishable) {
        this.publishable = publishable;

        // Set style
        this.getStyleClass().add("spacing");
        this.setMaxWidth(250);

        // Create container for buttons
        List<Button> buttons = new ArrayList<>();
        buttons.add(donationButton);
        buttons.add(requestButton);
        ButtonContainer buttonContainer = new ButtonContainer(buttons);

        // Define actions for mouse click
        donationButton.setOnMouseClicked(this::donationAction);
        requestButton.setOnMouseClicked(this::requestAction);

        this.getChildren().addAll(
                new Label("Select your post type"),
                buttonContainer,
                new Label("Pick relevant tags"),
                tagChoice,
                imageChooser
        );

    }

    public TagChoiceDropdown getTagChoiceDropdown () {
        return tagChoice;
    }

    public ImageChooser getImageChooser () {
        return imageChooser;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public Set<String> getSelectedTags(){
        return tagChoice.getChosenTags();
    }

    public String getImagePath() {
        return imageChooser.getSelectedPath();
    }

    // Set the request button to the active state and disable the active state
    // from the donation button, if it was active
    public void requestAction(MouseEvent e) {
        if (!requestButton.getStyleClass().contains("active")) {
            requestButton.getStyleClass().add("active");
            donationButton.getStyleClass().remove("active");
        }
        // Set post type
        publishable.setPostType("Request");
    }

    // Set the donation button to active state and disable active state
    // from the request button, if it was active
    public void donationAction(MouseEvent e) {
        if (!donationButton.getStyleClass().contains("active")) {
            donationButton.getStyleClass().add("active");
            requestButton.getStyleClass().remove("active");
        }
        // Set post type
        publishable.setPostType("Donation");
    }

    // Remove active states from both buttons
    public void removeActive () {
        donationButton.getStyleClass().remove("active");
        requestButton.getStyleClass().remove("active");
    }
}

