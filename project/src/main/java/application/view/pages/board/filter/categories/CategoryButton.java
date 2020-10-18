package application.view.pages.board.filter.categories;

import javafx.scene.control.Button;

public class CategoryButton extends Button {
    public CategoryButton(String text) {
        this.setText(text);
        this.setMinWidth(100);

    }

    public void toggleActiveStatus() {
        if (this.getStyleClass().contains("active")) this.getStyleClass().remove("active");
        else this.getStyleClass().add("active");
    }

}

