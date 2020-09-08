package application.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class WindowController {

    @FXML
    private Canvas canvas;

    @FXML
    private void drawRectangle() throws IOException {
        //App.setRoot("secondary");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(100, 100, 100, 100);
    }
}
