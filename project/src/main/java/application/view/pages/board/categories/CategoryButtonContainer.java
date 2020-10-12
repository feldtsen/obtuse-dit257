package application.view.pages.board.categories;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class CategoryButtonContainer extends GridPane {
    public CategoryButtonContainer() {
        DonationCategoryButton donationCategoryButton = DonationCategoryButton.getInstance();
        RequestCategoryButton requestCategoryButton = RequestCategoryButton.getInstance();

        GridPane.setConstraints(donationCategoryButton, 0, 0);
        GridPane.setConstraints(donationCategoryButton, 1, 0);

        this.setHgap(10);
        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(
                donationCategoryButton,
                requestCategoryButton
        );

    }
}
