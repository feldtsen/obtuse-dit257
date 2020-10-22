package application.view.pages.login;

import application.controller.ClientController;
import javafx.scene.control.Button;

// Button for submitting login credentials, i.e trying to log in
public class SubmitLoginButton extends Button  {
    // Singleton pattern
    private static SubmitLoginButton instance = null;

    private SubmitLoginButton() {
        // Set text
        this.setText("Login");

        // Set on click action
        this.setOnMouseClicked(e -> mouseClickAction());
    }

    // Create and return global instance
    public static SubmitLoginButton getInstance() {
        if (instance == null) instance = new SubmitLoginButton();
        return instance;
    }

    // Define on click action. When pressed, the client controller
    // will handle the login attempt.
    private void mouseClickAction () {
        LoginModule loginModule = LoginModule.getInstance();
        ClientController.handleLogin(
                loginModule.getPhoneInput(),
                loginModule.getPasswordInput()
        );
    }
}
