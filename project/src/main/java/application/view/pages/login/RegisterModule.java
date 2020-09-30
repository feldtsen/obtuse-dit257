package application.view.pages.login;

import application.view.pages.Page;
import application.view.submits.SubmitPostButton;
import application.view.submits.SubmitRegisterButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterModule extends VBox implements Page {
    private static RegisterModule instance = null;

    private final TextField nameInput;
    private final TextField addressInput;
    private final TextField phoneInput;

    private RegisterModule() {
        Label registerLabel = new Label("Register");
        Label nameLabel = new Label("Name");
        Label addressLabel = new Label("Address");
        Label phoneLabel = new Label("Phone Number");

        nameInput = new TextField();
        addressInput = new TextField();
        phoneInput = new TextField();

        this.setId("registerModule");
        registerLabel.setId("registerLabel");
        nameLabel.setId("nameLabel");
        addressLabel.setId("addressLabel");
        phoneLabel.setId("phoneLabel");

        this.getChildren().addAll(
                registerLabel,

                nameLabel,
                nameInput,

                addressLabel,
                addressInput,

                phoneLabel,
                phoneInput,

                SubmitRegisterButton.getInstance()

        );


    }

    public static RegisterModule getInstance() {
        if (instance == null) instance = new RegisterModule();

        return instance;
    }

    public String getNameInput() {
        return nameInput.getText();
    }
    public String getAddressInput() {
        return addressInput.getText();
    }

    public String getPhoneInput() {
        return phoneInput.getText();
    }
}
