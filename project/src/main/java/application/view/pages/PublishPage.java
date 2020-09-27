package application.view.pages;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PublishPage extends VBox implements Page {
    private static PublishPage instance = null;
    private final TextField titleInput;
    private final TextField descriptionInput;

    private PublishPage() {
        this.setId("publishPage");
        titleInput = createTextField();
        descriptionInput = createTextField();

        this.getChildren().addAll(
                createLabel("Title"),
                titleInput,
                createLabel("Description"),
                descriptionInput
        );

    }

    private Label createLabel(String title) {
       return new Label(title) ;
    }

    private TextField createTextField() {
        return new TextField();
    }

    private TextField getTitleInput () {
        return titleInput;
    }

    private TextField getDescriptionInput() {
       return descriptionInput;
    }

    public static PublishPage getInstance() {
        if (instance == null) instance = new PublishPage();
        return instance;
    }
}
