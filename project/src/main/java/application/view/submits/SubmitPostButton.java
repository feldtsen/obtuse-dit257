package application.view.submits;

import application.controller.PublishController;
import application.view.pages.PublishPage;
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
        PublishController.createPost();
    }

}
