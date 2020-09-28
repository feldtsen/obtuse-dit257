package application.view.submits;

import application.controller.ClientController;
import application.view.pages.RegisterPage;
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
        RegisterPage registerPage = RegisterPage.getInstance();
        ClientController.handleSubmitButton (
                registerPage.getNameInput().getText(),
                registerPage.getAddressInput().getText(),
                registerPage.getPhoneInput().getText()
        );
    }

}
