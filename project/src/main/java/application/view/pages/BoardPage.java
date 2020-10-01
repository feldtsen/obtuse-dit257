package application.view.pages;

import application.view.pages.login.LoginStatusModule;
import javafx.scene.layout.VBox;

public class BoardPage extends VBox implements Page {
    private static BoardPage instance = null;

    private BoardPage () {
        this.setId("boardPage");
        this.getChildren().add(LoginStatusModule.getInstance()); //Shows the logged in user
    }

    public static BoardPage getInstance() {
        if (instance == null) instance = new BoardPage();

        return instance;
    }
}
