package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class WindowController {


    @FXML
    VBox content;

    @FXML
    ScrollPane scrollPane;


    private void generatePost() throws IOException {

    }

    @FXML
    private void handlePublishButton() throws IOException {

        HBox publishSite = FXMLLoader.load(App.class.getResource("publishSite.fxml"));

        content.getChildren().add(publishSite);

    }
}
