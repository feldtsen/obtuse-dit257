package application.view.pages.board.filter.categories;

import javafx.scene.control.Button;

// Button representing a specific category of posts, typically "Donation" or "Request"
public class CategoryButton extends Button {
    public CategoryButton(String text) {
        this.setText(text);
        this.setMinWidth(100);
    }

    // Toggle activate status toggles if the button is considered pressed or not
    // The category button has a persistent status, meaning it has to be clicked again to be toggled
    public void toggleActiveStatus() {
        if (this.getStyleClass().contains("active")) this.getStyleClass().remove("active");
        else this.getStyleClass().add("active");
    }

}

