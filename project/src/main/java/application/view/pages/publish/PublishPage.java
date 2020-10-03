package application.view.pages.publish;

import application.view.pages.Page;
import application.view.pages.board.posts.ButtonContainer;
import application.view.pages.board.posts.SubmitPostButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class PublishPage extends VBox implements Page {
    private static PublishPage instance = null;

    private final TextField titleInput;
    private final TextField descriptionInput;
    private String type = "Donation";

    private PublishPage() {
        this.setId("publishPage");
        titleInput = new TextField();
        descriptionInput = new TextField();


        List<Button> buttons = new ArrayList<>();
        buttons.add(DonationButton.getInstance());
        buttons.add(RequestButton.getInstance());

        ButtonContainer buttonContainer = new ButtonContainer(buttons);
        this.getChildren().addAll(
                new Label("Title"),
                buttonContainer,
                titleInput,
                new Label("Description"),
                descriptionInput,
                SubmitPostButton.getInstance()
        );
    }

    public String getTitleInput () {
        return titleInput.getText();
    }

    public String getDescriptionInput() {
       return descriptionInput.getText();
    }

    public String getPostType() {
        return type;
    }

    public void setPostType(String type) {
        this.type = type;
    }

    public static PublishPage getInstance() {
        if (instance == null) instance = new PublishPage();
        return instance;
    }
}
