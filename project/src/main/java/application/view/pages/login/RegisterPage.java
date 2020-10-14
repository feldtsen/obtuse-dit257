package application.view.pages.login;

import application.view.pages.Page;
import javafx.scene.layout.HBox;

public class RegisterPage extends HBox implements Page {
    private static RegisterPage instance = null;

    private RegisterPage() {
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("padding");

        this.getChildren().addAll(
                LoginModule.getInstance(),
                RegisterModule.getInstance()
        );

    }

    public static RegisterPage getInstance() {
        if (instance == null) instance = new RegisterPage();
        return instance;
    }

}
