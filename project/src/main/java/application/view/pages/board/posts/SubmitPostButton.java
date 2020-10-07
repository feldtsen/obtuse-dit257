package application.view.pages.board.posts;

import application.controller.PostController;
import javafx.scene.control.Button;

public class SubmitPostButton extends Button  {
    private static SubmitPostButton instance = null;

    private SubmitPostButton() {
        this.setId("submitPostButton");

        this.setText("Submit post");
        this.setOnMouseClicked(e -> mouseClickAction());
    }

    public static SubmitPostButton getInstance() {
        if (instance == null) instance = new SubmitPostButton();
        return instance;
    }


    private void mouseClickAction () {
        PostController.createPost();
    }

}
