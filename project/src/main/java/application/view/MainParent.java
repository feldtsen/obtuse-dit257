package application.view;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainParent extends VBox {
    private static MainParent instance = null;

    private final HBox buttonContainer = new HBox();
    private final ScrollPane scrollPane = new ScrollPane();
    private final BoardParent boardParent = BoardParent.getInstance();

    private final double PREF_HEIGHT = 800;

    private MainParent(Stage primaryStage) {
        this.setStyle("-fx-background: #202020");
        scrollPane.prefWidthProperty().bind(primaryStage.widthProperty());
        scrollPane.prefHeightProperty().bind(primaryStage.heightProperty());


        this.getChildren().addAll(scrollPane, buttonContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(boardParent);
    }

    public static MainParent getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new MainParent(primaryStage);
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
