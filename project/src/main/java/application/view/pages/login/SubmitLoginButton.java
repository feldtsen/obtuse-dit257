package application.view.pages.login;

import application.controller.ClientController;
import javafx.scene.control.Button;

public class SubmitLoginButton extends Button  {
    private static SubmitLoginButton instance = null;

    private SubmitLoginButton() {

        this.setText("Log In");

        this.setOnMouseClicked(e -> mouseClickAction());

    }

    public static SubmitLoginButton getInstance() {
        if (instance == null) instance = new SubmitLoginButton();
        return instance;
    }

    private void mouseClickAction () {
        LoginModule loginModule = LoginModule.getInstance();
        ClientController.handleLogin(
                loginModule.getPhoneInput(),
                loginModule.getPasswordInput()
        );
    }
}
