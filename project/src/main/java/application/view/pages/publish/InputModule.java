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
        descriptionInput = new TextArea();

        descriptionInput.setMinHeight(100);
        descriptionInput.setWrapText(true);

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
