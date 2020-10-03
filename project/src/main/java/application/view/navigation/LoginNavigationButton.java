package application.view.navigation;


import application.view.pages.PageParent;
import application.view.pages.RegisterPage;

public class LoginNavigationButton extends NavigationButton {
    private static LoginNavigationButton instance = null;

    private LoginNavigationButton() {
        super();
        this.setText("Login");
        this.setOnMouseClicked(e->this.action());

    }

    public static LoginNavigationButton getInstance() {
        if (instance == null) instance = new LoginNavigationButton();
        return instance;
    }

    @Override
    public void action() {
        PageParent.loadPage(RegisterPage.getInstance());
    }
}
