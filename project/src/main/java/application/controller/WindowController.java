package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import application.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class WindowController {


    @FXML
    VBox content;

    private void generatePost() throws IOException {

    }

    @FXML
    private void handlePublishButton() throws IOException {

        // TODO: should be when post is being published
        VBox container = FXMLLoader.load(App.class.getResource("boardPost.fxml"));

        Button claimButton = (Button) container.lookup("#claimButton");
        Label title = (Label) container.lookup("#title");


        int rn = (int) Math.round((Math.random() * (100  + 1) + 0));

        claimButton.setId(rn+"");

        claimButton.setText(rn + "");
        title.setText(rn + "");

        content.getChildren().add(container);
    }

    @FXML
    private void handleBoardButton() {
        System.out.println("Board button pressed");
    }

    @FXML
    private void handleClaimButton(ActionEvent e) {
        Button button = (Button) e.getSource();
        Label title = (Label) button.getParent().lookup("#title");
        title.setText(button.getText() + " claimed!");
        //((VBox) button.getParent()).getChildren().remove(button.getParent().lookup("#" + button.getText()));
        button.setStyle("-fx-background-color: green");
        System.out.println("Claim button " + button.getText() + " pressed");
    }

}
