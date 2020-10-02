package application.view.pages;

import application.model.posts.Request;
import application.view.pages.posttype.DonationButton;
import application.view.pages.posttype.RequestButton;
import application.view.posts.ButtonContainer;
import application.view.submits.SubmitPostButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
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

        Button donationButton = new Button();
        Button requestButton = new Button();

        donationButton.setId("donationButton");
        requestButton.setId("requestButton");

        donationButton.setText("Donation");
        requestButton.setText("Request");

        List<Button> buttons = new ArrayList<>();
        buttons.add(donationButton);
        buttons.add(requestButton);

        donationButton.setOnMouseClicked(e -> this.setPostType("Donation"));
        requestButton.setOnMouseClicked(e -> this.setPostType("Request"));

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
