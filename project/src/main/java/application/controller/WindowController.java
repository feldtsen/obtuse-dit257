package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class WindowController {


    @FXML
    VBox content;

    @FXML
    private void handlePublishButton() throws IOException {
        System.out.println("Published pressed");

        content.getChildren().add(new Button("AAAA"));



    }
}
