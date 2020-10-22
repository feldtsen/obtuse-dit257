package application.view.pages.board.filter.categories;

import application.controller.BoardController;
import application.model.board.Filter;
import application.model.client.Client;
import javafx.scene.layout.HBox;

import java.util.Set;

// A container for category buttons, i.e "Donation" or "Request". The container defines a state where
// either no category button is pressed or just one. Two buttons cannot be pressed at once.
public class CategoryButtonContainer extends HBox {
    // Button for donations
    private final CategoryButton donationCategoryButton;

    // Button for requests
    private final CategoryButton requestCategoryButton;

    // String which represents the currently selected type. This is used
    // for creating a filter matching the button container state.
    private static String currentlySelectedPostType = Filter.ALL;

    public CategoryButtonContainer() {
        // Create buttons
        this.donationCategoryButton = new CategoryButton("Donations");
        this.requestCategoryButton = new CategoryButton("Requests");

        // Set actions. The action depends on the text (i.e, the button) which is passed to it
        this.donationCategoryButton.setOnMouseClicked(e -> this.toggleActiveButtons(donationCategoryButton.getText()));
        this.requestCategoryButton.setOnMouseClicked(e -> this.toggleActiveButtons(requestCategoryButton.getText()));

        // Set style
        this.getStyleClass().add("spacing");

        // Add to container (this)
        this.getChildren().addAll(
                donationCategoryButton,
                requestCategoryButton
        );
    }

    // Toggles the state of the buttons depending on the current state and which button is pressed
    public void toggleActiveButtons(String category) {
        // the filter which will be created based on the button press and the previous state
        Filter filter;
        // If the donation button is pressed
        if (category.equals("Donations")) {
            // Toggle the status of the donation button
            this.donationCategoryButton.toggleActiveStatus();
            // If the request category button is active, remove active status (disable)
            this.requestCategoryButton.getStyleClass().remove("active");

            // Set the currently selected post type based on the state of the donations button
            currentlySelectedPostType = currentlySelectedPostType.equals("Donation") ? Filter.ALL : "Donation";
        // If the requests button is pressed
        } else if (category.equals("Requests")) {
            // Toggle the status of the request button
            this.requestCategoryButton.toggleActiveStatus();
            // If the donation category button is active, remove active status (disable)
            this.donationCategoryButton.getStyleClass().remove("active");

            // Set the currently selected post type based on the state of the request button
            currentlySelectedPostType = currentlySelectedPostType.equals("Request") ? Filter.ALL : "Request";
        }

        // If the filter is null, create a new filter
        if (Client.getInstance().getBoard().getFilter() == null ) {
            // Filter is created with the current selected post type and no tags
            filter = new Filter(currentlySelectedPostType, Set.of());
        } else {
            // If the filter is not null, set the currently selected post type and keep the tags of the
            // current filter.
            filter = new Filter(currentlySelectedPostType, Client.getInstance().getBoard().getFilter().getTags());
        }

        // Set the board filter to the new filter
        BoardController.setFilter(filter);
    }

    public static String getCurrentlySelectedCategoryTag(){
        return currentlySelectedPostType;
    }
}
