package application.view.pages.login;

import application.view.pages.Page;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class LoginModule extends VBox implements Page {
    private static LoginModule instance = null;

    private final TextField phoneInput;
    private final PasswordField passwordInput;

    private LoginModule() {
        Label loginLabel = new Label("Login");
        Label phoneLabel = new Label("Phone Number");
        Label passwordLabel = new Label("Password");

        HBox titleContainer = new HBox();
        titleContainer.getChildren().setAll(loginLabel);
        titleContainer.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(titleContainer, Priority.ALWAYS);



        phoneInput = new TextField();
        passwordInput = new PasswordField();

        phoneInput.setPromptText("enter your phone number");
        passwordInput.setPromptText("enter your password");

        this.getStyleClass().add("spacing");
        loginLabel.getStyleClass().add("title");

        Region buttonSpacing = new Region();
        VBox.setVgrow(buttonSpacing, Priority.ALWAYS);

        HBox.setHgrow(this, Priority.ALWAYS);

        //Forces the button to the bottom
        //Region spacing = new Region();
        //VBox.setVgrow(spacing, Priority.ALWAYS);

        this.getChildren().addAll(
                titleContainer,

                phoneLabel,
                phoneInput,

                passwordLabel,
                passwordInput,

                SubmitLoginButton.getInstance()

        );

    }

    public static LoginModule getInstance() {
        if (instance == null) instance = new LoginModule();
        return instance;
    }

    public String getPhoneInput() {
        return phoneInput.getText();
    }

    public String getPasswordInput() {
        return passwordInput.getText();
    }
}
