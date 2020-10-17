package application.view.pages.publish;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class InputModule extends VBox {
    private final TextField titleInput = new TextField();
    private final TextArea descriptionInput = new TextArea();

    public InputModule(Button button){
        this.setSpacing(10);

        titleInput.setPromptText("enter your post title");
        titleInput.setPromptText("enter your post title");
        descriptionInput.setPromptText("enter your post description");

        descriptionInput.setWrapText(true);

        descriptionInput.getStyleClass().add("descriptionInput");

        HBox.setHgrow(this, Priority.ALWAYS);

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
