package application.view.pages.board.filter.categories;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CategoryButton extends Button {
    public CategoryButton(String text) {
        this.setText(text);
        this.setId("inactive");
    }

    public void toggleActiveStatus() {
        if (this.getId().equals("inactive"))
            this.setId("active");
        else
            this.setId("inactive");
    }

}

