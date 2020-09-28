package application.view.pages;

import application.view.submits.SubmitPostButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class PublishPage extends VBox implements Page {
    private static PublishPage instance = null;
    private final TextField titleInput;
    private final TextField descriptionInput;

    private PublishPage() {
        this.setId("publishPage");
        titleInput = new TextField();
        descriptionInput = new TextField();

        this.getChildren().addAll(
                new Label("Title"),
                titleInput,
                new Label("Description"),
                descriptionInput,
                SubmitPostButton.getInstance()
        );

    }

    public TextField getTitleInput () {
        return titleInput;
    }

    public TextField getDescriptionInput() {
       return descriptionInput;
    }

    public static PublishPage getInstance() {
        if (instance == null) instance = new PublishPage();
        return instance;
    }
}
