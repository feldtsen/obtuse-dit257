package application.view.pages.board.posts;

import application.controller.PostController;
import javafx.scene.control.Button;

// Button for submitting a post
public class SubmitPostButton extends Button  {
    // Singleton pattern, since there should only be one
    private static SubmitPostButton instance = null;

    private SubmitPostButton() {
        // Set text
        this.setText("Submit post");

        // Define action to be performed on mouse click
        this.setOnMouseClicked(e -> mouseClickAction());
    }

    // Create and return global instance
    public static SubmitPostButton getInstance() {
        if (instance == null) instance = new SubmitPostButton();
        return instance;
    }

    // Create a post using the post controller when the button is pressed
    private void mouseClickAction () {
        PostController.createPost();
    }
}
