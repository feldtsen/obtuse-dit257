package application.view.navigation;


public class RegisterNavigationButton extends NavigationButton {
    private static RegisterNavigationButton instance = null;

    private RegisterNavigationButton() {
        super();
        this.setText("Register");
        this.setOnMouseClicked(e -> this.action());

    }

    public static RegisterNavigationButton getInstance() {
        if (instance == null) instance = new RegisterNavigationButton();
        return instance;
    }

    @Override
    public void action() {
        System.out.println("register");
    }
}
