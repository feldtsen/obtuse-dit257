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

public class MetaModule extends VBox {
    private String type = "Donation";
    private final TagChoiceDropdown tagChoice = new TagChoiceDropdown();
    private final ImageChooser imageChooser = new ImageChooser();
    private final DonationButton donationButton = new DonationButton();
    private final RequestButton requestButton = new RequestButton();
    private final IPublishable publishable;

    public MetaModule(IPublishable publishable) {
        this.publishable = publishable;

        this.getStyleClass().add("spacing");

        List<Button> buttons = new ArrayList<>();
        buttons.add(donationButton);
        buttons.add(requestButton);
        ButtonContainer buttonContainer = new ButtonContainer(buttons);

        donationButton.setOnMouseClicked(this::donationAction);
        requestButton.setOnMouseClicked(this::requestAction);

        this.setMaxWidth(250);


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

    public void requestAction(MouseEvent e) {
        if (!requestButton.getStyleClass().contains("active")) {
            requestButton.getStyleClass().add("active");
            donationButton.getStyleClass().remove("active");
        }
        publishable.setPostType("Request");
    }
    public void donationAction(MouseEvent e) {
        if (!donationButton.getStyleClass().contains("active")) {
            donationButton.getStyleClass().add("active");
            requestButton.getStyleClass().remove("active");
        }
        publishable.setPostType("Donation");
    }

    public void removeActive () {
        donationButton.getStyleClass().remove("active");
        requestButton.getStyleClass().remove("active");
    }
}

