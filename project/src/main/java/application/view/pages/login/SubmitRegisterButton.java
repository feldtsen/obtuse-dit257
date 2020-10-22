package application.view.pages.login;

import application.controller.ClientController;
import javafx.scene.control.Button;

// Button for entering registration information and creating a user
public class SubmitRegisterButton extends Button  {
    // Singleton pattern
    private static SubmitRegisterButton instance = null;

    private SubmitRegisterButton() {
        // Set button text
        this.setText("Register");

        // Define click action
        this.setOnMouseClicked(e -> mouseClickAction());
    }

    // Create and return global instance
    public static SubmitRegisterButton getInstance() {
        if (instance == null) instance = new SubmitRegisterButton();
        return instance;
    }

    // Define on click action. When button is pressed, data is fetched
    // from the registration module and a registration attempt performed
    // by the client controller.
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
