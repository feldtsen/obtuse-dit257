package application.view.status;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public class LoginBannerModule extends HBox {

    private static final String NOT_LOGGED_IN_MESSAGE = "Not logged in";
    private static LoginBannerModule instance = null;
   private final Label loginStatus;  //label that shows what user is currently logged in

    private LoginBannerModule() {

        SVGPath svgPath = new SVGPath();
        svgPath.setContent("M224 256c70.7 0 128-57.3 128-128S294.7 0 224 0 96 57.3 96 128s57.3 128 128 128zm89.6 32h-16.7c-22.2 10.2-46.9 16-72.9 16s-50.6-5.8-72.9-16h-16.7C60.2 288 0 348.2 0 422.4V464c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48v-41.6c0-74.2-60.2-134.4-134.4-134.4z");
        svgPath.setScaleX(0.04);
        svgPath.setScaleY(0.04);
        svgPath.setFill(Color.valueOf("#BBBBBB"));

        Group icon = new Group(svgPath);

        loginStatus = new Label(NOT_LOGGED_IN_MESSAGE);

        this.setId("loginBanner");
        HBox.setHgrow(this, Priority.ALWAYS);

        loginStatus.setStyle("-fx-text-fill: #BBBBBB!important;");

        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(
                loginStatus,
                LogoutButton.getInstance(),
                icon
        );
    }

    public static LoginBannerModule getInstance() {
        if(instance == null)
            instance = new LoginBannerModule();
        return instance;
    }

    public void setNotLoggedIn(){
        loginStatus.setText(NOT_LOGGED_IN_MESSAGE);
    };
    /**
     * Set the passed in user as the currently logged in user
     * @param userName the user name
     */
    public void setLoggedInAs(String userName) {
        loginStatus.setText(userName);
    }
}
