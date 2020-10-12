package application.view.pages.board.categories;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class CategoryButtonContainer extends GridPane {
    private static CategoryButtonContainer instance = null;
    CategoryButton donationCategoryButton;
    CategoryButton requestCategoryButton;

    private CategoryButtonContainer() {

        this.donationCategoryButton = new CategoryButton("Donations", this);
        this.requestCategoryButton = new CategoryButton("Requests", this);

        GridPane.setConstraints(donationCategoryButton, 0, 0);
        GridPane.setConstraints(donationCategoryButton, 1, 0);

        this.setHgap(10);
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(
                donationCategoryButton,
                requestCategoryButton
        );
    }

    public static CategoryButtonContainer getInstance() {
        if (instance == null) instance = new CategoryButtonContainer();
        return instance;
    }

    public void toggleActiveButtons(String category) {
        if (category.equals("Donations")) {
            this.donationCategoryButton.toggleActiveStatus();
            this.requestCategoryButton.setId("inactive");
        }
        if (category.equals("Requests")) {
            this.requestCategoryButton.toggleActiveStatus();
            this.donationCategoryButton.setId("inactive");
        }
    }
}
