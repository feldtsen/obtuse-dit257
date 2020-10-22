package application.view.pages.login;

import application.view.pages.Page;
import javafx.scene.layout.VBox;

// Registration page. This page contains the login module and
// the registration module.
public class RegisterPage extends VBox implements Page {
    // Singleton pattern
    private static RegisterPage instance = null;

    private RegisterPage() {
        // Set styling
        this.getStyleClass().add("spacing");

        // Add login module and register module
        this.getChildren().addAll(
                LoginModule.getInstance(),
                RegisterModule.getInstance()
        );

    }

    // Create and return global instance
    public static RegisterPage getInstance() {
        if (instance == null) instance = new RegisterPage();
        return instance;
    }

}
