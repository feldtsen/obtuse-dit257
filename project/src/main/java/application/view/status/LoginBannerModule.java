package application.view.status;

import application.ResourceLoader;
import application.view.navigation.RegisterNavigationButton;
import application.view.pages.PageParent;
import application.view.pages.login.RegisterPage;
import application.view.util.SVGHelper;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class LoginBannerModule extends HBox {
    private static LoginBannerModule instance = null;

    private static final String NOT_LOGGED_IN_MESSAGE = "Not logged in "; // Displayed when not logged in
    private final Label loginStatus;  //label that shows what user is currently logged in

    private LoginBannerModule() {
        // Create a button and set the icon
        Group icon = SVGHelper.createIcon(ResourceLoader.avatarIcon, 0.04);
        Button avatar = new Button();
        avatar.setGraphic(icon);
        avatar.getStyleClass().add("avatar");

        // Label for the status
        loginStatus = new Label(NOT_LOGGED_IN_MESSAGE);

        // What happens when you clicked the avatar icon
        avatar.setOnMouseClicked(event -> PageParent.loadPage(RegisterPage.getInstance(), RegisterNavigationButton.getInstance()));

        // Set the position withing the LoginBannerModule
        this.setAlignment(Pos.CENTER_RIGHT);

        // Sets in what order you want the components to be displayed (left to right)
        this.getChildren().addAll(
                loginStatus,
                LogoutButton.getInstance(),
                avatar
        );
    }

    // Singleton
    public static LoginBannerModule getInstance() {
        if(instance == null)
            instance = new LoginBannerModule();
        return instance;
    }

    // When not logged in, change status
    public void setNotLoggedIn(){
        loginStatus.setText(NOT_LOGGED_IN_MESSAGE);
    }

    // Given a userName, update the status to the user's username
    public void setLoggedInAs(String userName) {
        loginStatus.setText(userName);
    }
}
