package application.view.submits;

import application.controller.ClientController;
import application.view.pages.login.LoginModule;
import application.view.pages.login.RegisterModule;
import javafx.scene.control.Button;

public class SubmitLoginButton extends Button  {
    private static SubmitLoginButton instance = null;

    private SubmitLoginButton() {
        this.setId("submitLoginButton");

        this.setText("Log In");

        this.setOnMouseClicked(e -> mouseClickAction());
    }

    public static SubmitLoginButton getInstance() {
        if (instance == null) instance = new SubmitLoginButton();
        return instance;
    }

    private void mouseClickAction () {
        LoginModule loginModule = LoginModule.getInstance();
        ClientController.handleLoginButton (
                loginModule.getPhoneInput(),
                loginModule.getPasswordInput()
        );


    }

}
