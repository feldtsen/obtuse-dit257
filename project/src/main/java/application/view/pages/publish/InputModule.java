package application.view.pages.publish;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


// Module for entering post-related data such as title and descriptions
public class InputModule extends VBox {
    // Title input field
    private final TextField titleInput = new TextField();

    // Description input area
    private final TextArea descriptionInput = new TextArea();

    public InputModule(Button button){
        // Set style
        this.setSpacing(10);
        HBox.setHgrow(this, Priority.ALWAYS);

        // Set prompts
        titleInput.setPromptText("enter your post title");
        titleInput.setPromptText("enter your post title");
        descriptionInput.setPromptText("enter your post description");

        // Set style
        descriptionInput.setWrapText(true);
        descriptionInput.getStyleClass().add("descriptionInput");

        // add nodes
        this.getChildren().addAll(
                new Label("Title"),
                titleInput,
                new Label("Description"),
                descriptionInput,
                button
        );
    }

    public TextField getTitleInputField() {
        return titleInput;
    }
    public TextArea getDescriptionInputArea() {
        return descriptionInput;
    }
}
