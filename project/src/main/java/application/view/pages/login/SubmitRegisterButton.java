package application.view.pages.login;

import application.controller.ClientController;
import javafx.scene.control.Button;

public class SubmitRegisterButton extends Button  {
    private static SubmitRegisterButton instance = null;

    private SubmitRegisterButton() {
        this.setId("submitRegisterButton");

        this.setText("Register");

        this.setOnMouseClicked(e -> mouseClickAction());

    }

    public static SubmitRegisterButton getInstance() {
        if (instance == null) instance = new SubmitRegisterButton();
        return instance;
    }

    private void mouseClickAction () {
        RegisterModule registerModule = RegisterModule.getInstance();
        ClientController.handleRegisterButton(
                registerModule.getNameInput(),
                registerModule.getAddressInput(),
                registerModule.getPhoneInput(),
                registerModule.getPasswordInput()
        );
    }

}
