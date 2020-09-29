package application.view.posts;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.List;

public class ButtonContainer extends HBox {

    public ButtonContainer(List<Button> buttons){
        this.setId("buttonContainer");
        //Adds all the buttons to the container
        for (Button button : buttons) {
            this.getChildren().add(
                button
            );
        }

    }

}
