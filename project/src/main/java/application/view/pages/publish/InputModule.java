package application.view.pages.publish;

import application.view.pages.board.posts.SubmitPostButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class InputModule extends VBox {
    private final TextField titleInput;
    private final TextArea descriptionInput;

    public InputModule (){
        this.getStyleClass().add("spacing");

        titleInput = new TextField();
        titleInput.setPromptText("enter you post title");
        descriptionInput = new TextArea();
        descriptionInput.setPromptText("enter your description");

        descriptionInput.setWrapText(true);

        descriptionInput.getStyleClass().add("descriptionInput");

        this.getChildren().addAll(
                new Label("Title"),
                titleInput,
                new Label("Description"),
                descriptionInput,
                SubmitPostButton.getInstance()
        );
    }

    public TextField getTitleInputField() {
        return titleInput;
    }
    public TextArea getDescriptionInputArea() {
        return descriptionInput;
    }
}
