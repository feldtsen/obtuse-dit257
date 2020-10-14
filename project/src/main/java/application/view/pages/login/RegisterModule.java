package application.view.pages.login;

import application.view.pages.Page;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class RegisterModule extends VBox implements Page {
    private static RegisterModule instance = null;

    private final TextField nameInput;
    private final TextField addressInput;
    private final TextField phoneInput;
    private final PasswordField passwordInput;

    private RegisterModule() {
        Label registerLabel = new Label("Register");
        Label nameLabel = new Label("Name");
        Label addressLabel = new Label("Address");
        Label phoneLabel = new Label("Phone Number");
        Label passwordLabel = new Label("Password");

        nameInput = new TextField();
        addressInput = new TextField();
        phoneInput = new TextField();
        passwordInput = new PasswordField();

        passwordInput.setPromptText("Enter Password");

        this.getStyleClass().add("padding");
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("cardBackground");

        HBox.setHgrow(this, Priority.ALWAYS);

        //Forces buttons to bottom
        Region spacing = new Region();
        VBox.setVgrow(spacing, Priority.ALWAYS);

        this.getChildren().addAll(
                registerLabel,

                nameLabel,
                nameInput,

                addressLabel,
                addressInput,

                phoneLabel,
                phoneInput,

                passwordLabel,
                passwordInput,

                spacing,
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
    public String getPasswordInput() { return passwordInput.getText();
    }
}
