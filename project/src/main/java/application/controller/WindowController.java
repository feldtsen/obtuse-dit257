package application.controller;

import java.io.IOException;

import application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class WindowController {


    @FXML
    VBox content;

    private void generatePost() throws IOException {

    }

    @FXML
    private void handlePublishButton() throws IOException {
        VBox root = FXMLLoader.load(App.class.getResource("publishSite.fxml"));
        content.getChildren().setAll(root);
    }



    @FXML
    private void handleBoardButton() {
        PostGenerator post = new PostGenerator(content);
        for (int i = 0; i < 100; i++) {
            post.createDonation("I'm going abroad!", "Mammal milk products expires in 3 days! " +
                    "The perfect fatty ingredients you need in your life. I can bring it to your door, " +
                    "just claim it and I'll be there in a heartbeat.");

        }
    }

    @FXML
    private void handleClaimButton(ActionEvent e) {
        Button button = (Button) e.getSource();
        Label title = (Label) button.getParent().lookup("#title");
        title.setText(button.getText() + " claimed!");
        button.setStyle("-fx-background-color: green");
        System.out.println("Claim button " + button.getText() + " pressed");
    }

}
