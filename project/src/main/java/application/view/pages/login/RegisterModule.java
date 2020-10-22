package application.view.pages.login;

import application.view.pages.Page;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// module for the user to enter registration information
public class RegisterModule extends VBox implements Page {
    // Singleton pattern
    private static RegisterModule instance = null;

    // Input fields for user data
    private final TextField nameInput;
    private final TextField addressInput;
    private final TextField phoneInput;
    private final PasswordField passwordInput;

    private RegisterModule() {
        // Create labels for text indicators
        Label registerLabel = new Label("Create Account");
        Label nameLabel = new Label("Name");
        Label addressLabel = new Label("Address");
        Label phoneLabel = new Label("Phone Number");
        Label passwordLabel = new Label("Password");

        // Create title container and set styling
        HBox titleContainer = new HBox();
        titleContainer.getChildren().setAll(registerLabel);
        titleContainer.setAlignment(Pos.TOP_CENTER);

        // Initialize input fields and prompts
        nameInput = new TextField();
        nameInput.setPromptText("enter your name");

        addressInput = new TextField();
        addressInput.setPromptText("enter your address");

        phoneInput = new TextField();
        phoneInput.setPromptText("enter you phone number");

        passwordInput = new PasswordField();
        passwordInput.setPromptText("enter you password");

        // Set styling
        this.getStyleClass().add("spacing");
        registerLabel.getStyleClass().add("title");


        this.getChildren().addAll(
                titleContainer,

                nameLabel,
                nameInput,

                addressLabel,
                addressInput,

                phoneLabel,
                phoneInput,

                passwordLabel,
                passwordInput,

                SubmitRegisterButton.getInstance()

        );


    }

    // Create and return global instance
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
    public String getPasswordInput() { return passwordInput.getText(); }
}
