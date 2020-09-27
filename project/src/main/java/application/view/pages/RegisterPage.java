package application.view.pages;

import javafx.scene.layout.VBox;

public class RegisterPage extends VBox implements Page {
    private static RegisterPage instance = null;

    private RegisterPage() {
        this.setId("registerPage");
    }

    public static RegisterPage getInstance() {
        if (instance == null) instance = new RegisterPage();
        return instance;
    }
}
