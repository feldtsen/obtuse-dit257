package application.view.pages.board.filter.categories;

import javafx.scene.layout.HBox;

public class CategoryButtonContainer extends HBox {
    CategoryButton donationCategoryButton;
    CategoryButton requestCategoryButton;

    public CategoryButtonContainer() {

        this.donationCategoryButton = new CategoryButton("Donations");
        this.requestCategoryButton = new CategoryButton("Requests");


        this.donationCategoryButton.setOnMouseClicked(e -> this.toggleActiveButtons(donationCategoryButton.getText()));
        this.requestCategoryButton.setOnMouseClicked(e -> this.toggleActiveButtons(requestCategoryButton.getText()));


        this.getChildren().addAll(
                donationCategoryButton,
                requestCategoryButton
        );
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
