package application.view.pages.board.posts;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.List;

// Container for a set of buttons
public class ButtonContainer extends HBox {
    public ButtonContainer(List<Button> buttons){
        // Create spacing between buttons
        this.getStyleClass().add("spacing");

        //Adds all the buttons to the container
        for (Button button : buttons) {
            HBox.setHgrow(button, Priority.ALWAYS);
            this.getChildren().add(button);
        }

    }

}
