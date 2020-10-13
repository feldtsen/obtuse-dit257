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
        this.getStyleClass().add("publishModule");

        List<Button> buttons = new ArrayList<>();
        buttons.add(DonationButton.getInstance());
        buttons.add(RequestButton.getInstance());
        ButtonContainer buttonContainer = new ButtonContainer(buttons);

        this.getChildren().addAll(
                new Label("Post type"),
                buttonContainer,
                new Label("Select image"),
                imageChooser,
                new Label("Tag your post"),
                tagChoice
        );

    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public Set<String> getSelectedTags(){
        return tagChoice.getTags();
    }

    public String getImagePath() {
        if(imageChooser.isSelected()) {
            return imageChooser.getSelectedPath();
        }
        return null;
    }

}
