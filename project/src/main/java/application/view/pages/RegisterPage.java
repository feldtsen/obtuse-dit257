package application.view.pages;

import application.view.submits.SubmitRegisterButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterPage extends VBox implements Page {
    private static RegisterPage instance = null;
    private final TextField nameInput;
    private final TextField addressInput;
    private final TextField phoneInput;

    private RegisterPage() {
        this.setId("registerPage");

        nameInput = new TextField();
        addressInput = new TextField();
        phoneInput = new TextField();

        this.getChildren().addAll(
                new Label("Name"),
                nameInput,
                new Label("Address"),
                addressInput,
                new Label("Phone number"),
                phoneInput,
                SubmitRegisterButton.getInstance()
        );


    }

    public TextField getNameInput () {
        return nameInput;
    }

    public TextField getAddressInput() {
        return addressInput;
    }

    public TextField getPhoneInput() {
        return phoneInput;
    }

    public static RegisterPage getInstance() {
        if (instance == null) instance = new RegisterPage();
        return instance;
    }
}
