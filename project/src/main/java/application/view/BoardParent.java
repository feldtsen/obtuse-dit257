package application.view;

import javafx.scene.layout.VBox;

public class BoardParent extends VBox implements OnClickAction {
    private static BoardParent instance = null;

    private BoardParent() {

    }

    public static BoardParent getInstance() {
        if (instance == null) {
           instance = new BoardParent();
        }
        return instance;
    }

    @Override
    public void apply() {
        System.out.println("From BoardView");
    }


}
