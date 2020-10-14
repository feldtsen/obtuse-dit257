package application.view.pages.board.filter.categories;

import application.controller.BoardController;
import application.model.board.Filter;
import application.model.client.Client;
import javafx.scene.layout.HBox;

public class CategoryButtonContainer extends HBox {
    private final CategoryButton donationCategoryButton;
    private final CategoryButton requestCategoryButton;
    private static String currentlySelectedPostType = Filter.ALL;
    public CategoryButtonContainer() {

        this.donationCategoryButton = new CategoryButton("Donations");
        this.requestCategoryButton = new CategoryButton("Requests");


        this.donationCategoryButton.setOnMouseClicked(e -> this.toggleActiveButtons(donationCategoryButton.getText()));
        this.requestCategoryButton.setOnMouseClicked(e -> this.toggleActiveButtons(requestCategoryButton.getText()));

        this.getStyleClass().add("spacing");


        this.getChildren().addAll(
                donationCategoryButton,
                requestCategoryButton
        );
    }

    public void toggleActiveButtons(String category) {
        Filter filter;
        if (category.equals("Donations")) {
            this.donationCategoryButton.toggleActiveStatus();
            this.requestCategoryButton.setId("inactive");
            currentlySelectedPostType = currentlySelectedPostType.equals("Donation") ? Filter.ALL : "Donation";
        } else if (category.equals("Requests")) {
            this.requestCategoryButton.toggleActiveStatus();
            this.donationCategoryButton.setId("inactive");
            currentlySelectedPostType = currentlySelectedPostType.equals("Request") ? Filter.ALL : "Request";
        }

        filter = new Filter(currentlySelectedPostType, Client.getInstance().getBoard().getFilter().getTags());

        BoardController.setFilter(filter);
    }

    public static String getCurrentlySelectedCategoryTag(){
        return currentlySelectedPostType;
    }
}
