package application.view.navigation;


public class PublishNavigationButton extends NavigationButton {
    private static PublishNavigationButton instance = null;

    private PublishNavigationButton() {
        super();
        this.setText("Publish");
        this.setOnMouseClicked(e -> this.action());

    }

    public static PublishNavigationButton getInstance() {
        if (instance == null) instance = new PublishNavigationButton();
        return instance;
    }

    @Override
    public void action() {
        System.out.println("publish");
    }
}
