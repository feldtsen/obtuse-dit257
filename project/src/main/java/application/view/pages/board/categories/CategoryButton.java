package application.view.pages.board.categories;

import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;

public class CategoryButton extends Button implements OnClickAction {
    private CategoryButtonContainer categoryButtonContainer = null;

    public CategoryButton(String text, CategoryButtonContainer categoryButtonContainer) {
        this.setText(text);
        this.setOnMouseClicked(e -> this.action());
        this.setId("inactive");
        this.categoryButtonContainer = categoryButtonContainer;
    }

    public void toggleActiveStatus() {
        if (this.getId().equals("inactive"))
            this.setId("active");
        else
            this.setId("inactive");
    }

    @Override
    public void action() {
        categoryButtonContainer.toggleActiveButtons(this.getText());
        // TODO add functionality
    }
}

