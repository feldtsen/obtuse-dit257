package application.view;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainWindow extends Parent {
    private static MainWindow instance = null;

    private final VBox rootContainer = new VBox();
    private final HBox buttonContainer = new HBox();
    private final ScrollPane scrollPane = new ScrollPane();
    private final VBox contentContainer = new VBox();

    private double PREF_WIDTH = 1200;
    private double PREF_HEIGHT = 800;

    private MainWindow () {
        rootContainer.setPrefWidth(PREF_WIDTH);
        rootContainer.setPrefHeight(PREF_HEIGHT);


        rootContainer.getChildren().addAll(scrollPane, buttonContainer);
        scrollPane.setContent(contentContainer);
    }

    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }
        return instance;
    }

    private void addChild (Node parent, Node child) {

    }

    private void addButton (OnClickAction action) {
        Button button = new Button();
        button.setOnMouseClicked(e -> action.apply());
        buttonContainer.getChildren().add(button);
    }
}
