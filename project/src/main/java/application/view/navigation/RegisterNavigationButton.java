package application.view.navigation;


import application.view.pages.PageParent;
import application.view.pages.RegisterPage;
import javafx.scene.input.MouseEvent;

public class RegisterNavigationButton extends NavigationButton {
    private static RegisterNavigationButton instance = null;

    private RegisterNavigationButton() {
        super();
        this.setText("Register");
        this.setOnMouseClicked(this::action);

    }

    public static RegisterNavigationButton getInstance() {
        if (instance == null) instance = new RegisterNavigationButton();
        return instance;
    }

    @Override
    public void action(MouseEvent e) {
        PageParent.loadPage(RegisterPage.getInstance());
    }
}
