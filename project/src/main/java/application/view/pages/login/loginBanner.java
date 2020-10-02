package application.view.pages.login;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class loginBanner extends HBox {

    private static loginBanner instance = null;
   private Label loginStatus;  //label that shows what user is currently logged in

    private loginBanner() {
        Label loginText = new Label("Logged in as: ");
        loginStatus = new Label("None");

        this.setId("loginBanner");

        loginStatus.setStyle("-fx-text-fill: #BBBBBB!important;");

        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(loginText, loginStatus);
    }

    public static loginBanner getInstance() {
        if(instance == null)
            instance = new loginBanner();
        return instance;
    }

    /**
     * Set the passed in user as the currently logged in user
     * @param userName the user name
     */
    public void setLoggedInAs(String userName) {
        loginStatus.setText(userName);
    }
}
