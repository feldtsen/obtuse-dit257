package application.view.pages.publish;

import application.controller.ImageChooser;
import application.view.pages.board.posts.ButtonContainer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MetaModule extends VBox {
    private String type = "Donation";
    private final TagChoiceDropdown tagChoice = new TagChoiceDropdown();
    private final ImageChooser imageChooser = new ImageChooser();

    public MetaModule() {
        this.getStyleClass().add("spacing");

        List<Button> buttons = new ArrayList<>();
        buttons.add(DonationButton.getInstance());
        buttons.add(RequestButton.getInstance());
        ButtonContainer buttonContainer = new ButtonContainer(buttons);

        this.setMaxWidth(250);


        this.getChildren().addAll(
                new Label("Select your post type"),
                buttonContainer,
                new Label("Pick relevant tags"),
                tagChoice,
                imageChooser
        );

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
        if(imageChooser.isSelected()) {
            return imageChooser.getSelectedPath();
        }
        return null;
    }

}
