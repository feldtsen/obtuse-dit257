package application.view.pages.board.filter.categories;

import application.controller.BoardController;
import application.model.board.Filter;
import javafx.scene.layout.HBox;

import java.util.Set;

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
        Filter filter = null;
        if (category.equals("Donations")) {
            this.donationCategoryButton.toggleActiveStatus();
            this.requestCategoryButton.setId("inactive");
        }
        if (category.equals("Requests")) {
            this.requestCategoryButton.toggleActiveStatus();
            this.donationCategoryButton.setId("inactive");
        }

        if (donationCategoryButton.getId().equals("active")) {
            filter = new Filter("Donation", Set.of());
            System.out.println("adwadwada");
        } else if (requestCategoryButton.getId().equals("active")) {
            filter = new Filter("Request", Set.of());
            System.out.println("bbbb");
        }

        BoardController.setFilter(filter);
    }
}
