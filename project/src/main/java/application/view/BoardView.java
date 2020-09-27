package application.view;

import javafx.scene.layout.VBox;

public class BoardView extends VBox implements OnClickAction {
    private static BoardView instance = null;

    private BoardView() {
    }

    public static BoardView getInstance() {
        if (instance == null) {
           instance = new BoardView();
        }
        return instance;
    }

    @Override
    public void apply() {
        System.out.println("From BoardView");
    }


}
