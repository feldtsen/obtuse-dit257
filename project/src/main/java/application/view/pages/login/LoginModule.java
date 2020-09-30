package application.view.pages.login;

import application.view.pages.Page;
import application.view.submits.SubmitLoginButton;
import application.view.submits.SubmitRegisterButton;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginModule extends VBox implements Page {
    private static LoginModule instance = null;

    private final TextField phoneInput;
    private final PasswordField passwordInput;

    private LoginModule() {
        Label loginLabel = new Label("Log In");
        Label phoneLabel = new Label("Phone Number");
        Label passwordLabel = new Label("Password");

        phoneInput = new TextField();
        passwordInput = new PasswordField();

        this.setId("loginModule");
        loginLabel.setId("loginLabel");
        phoneLabel.setId("phoneLabel");
        passwordLabel.setId("passwordLabel");

        this.getChildren().addAll(
                loginLabel,

                phoneLabel,
                phoneInput,

                passwordLabel,
                passwordInput,

                SubmitLoginButton.getInstance()
        );
    }

    public static LoginModule getInstance() {
        if (instance == null) instance = new LoginModule();

        return instance;
    }

    public String getPhoneInput() {
        return phoneInput.getText();

    }

    public String getPasswordInput() {

        return passwordInput.getText();
    }
}
