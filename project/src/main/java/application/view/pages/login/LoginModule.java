package application.view.pages.login;

import application.view.pages.Page;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// Module for the user to input login credentials to access their
// virtual user (User).
public class LoginModule extends VBox implements Page {
    // Singleton pattern, since there should only be one
    private static LoginModule instance = null;

    // Input fields for user credentials
    private final TextField phoneInput;
    private final PasswordField passwordInput;

    private LoginModule() {
        // Labels used to display text indicators
        Label loginLabel = new Label("Login");
        Label phoneLabel = new Label("Phone Number");
        Label passwordLabel = new Label("Password");

        // Container for the title of the page
        HBox titleContainer = new HBox();
        titleContainer.getChildren().setAll(loginLabel);
        titleContainer.setAlignment(Pos.TOP_CENTER);

        // Create input fields and set prompts
        phoneInput = new TextField();
        passwordInput = new PasswordField();

        phoneInput.setPromptText("enter your phone number");
        passwordInput.setPromptText("enter your password");

        // Set styling
        this.getStyleClass().add("spacing");
        loginLabel.getStyleClass().add("title");

        this.getChildren().addAll(
                titleContainer,

                phoneLabel,
                phoneInput,

                passwordLabel,
                passwordInput,

                SubmitLoginButton.getInstance()
        );
    }

    // Create and return global instance
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
