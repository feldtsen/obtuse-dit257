package application.view.status;

import javafx.scene.layout.HBox;

public class StatusBanner extends HBox {
    private static StatusBanner instance = null;

    private StatusBanner() {
        this.setId("statusBanner");

        this.getChildren().addAll(
                LogoutButton.getInstance(),
                LoginBannerModule.getInstance(),
                AlertBannerModule.getInstance()
        );
    }

    public static StatusBanner getInstance() {
        if(instance == null)
            instance = new StatusBanner();
        return instance;
    }

}
