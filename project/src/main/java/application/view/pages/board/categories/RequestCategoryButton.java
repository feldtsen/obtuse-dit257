package application.view.pages.board.categories;

import application.view.navigation.OnClickAction;
import javafx.scene.control.Button;

public class RequestCategoryButton extends Button implements OnClickAction {
    private static RequestCategoryButton instance = null;

    private RequestCategoryButton() {
        this.setText("Donations");
        this.setOnMouseClicked(e -> this.action());
        this.setId("donationCategoryButton");
    }

    public static RequestCategoryButton getInstance(){
        if (instance == null) instance = new RequestCategoryButton();
        return instance;
    }

    @Override
    public void action() {
        // TODO add functionality
    }
}

