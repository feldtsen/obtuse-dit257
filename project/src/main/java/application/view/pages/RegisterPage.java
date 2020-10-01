package application.view.pages;

import application.view.pages.login.LoginModule;
import application.view.pages.login.LoginStatusModule;
import application.view.pages.login.RegisterModule;
import javafx.scene.layout.HBox;

public class RegisterPage extends HBox implements Page {
    private static RegisterPage instance = null;

    private RegisterPage() {
        this.setId("registerPage");

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
