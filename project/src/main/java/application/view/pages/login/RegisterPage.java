package application.view.pages.login;

import application.view.pages.Page;
import javafx.scene.layout.VBox;

public class RegisterPage extends VBox implements Page {
    private static RegisterPage instance = null;

    private RegisterPage() {
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("padding");
        this.getStyleClass().add("registerPage");



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
