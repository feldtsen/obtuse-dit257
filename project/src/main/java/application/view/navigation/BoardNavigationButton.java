package application.view.navigation;


public class BoardNavigationButton extends NavigationButton {
    private static BoardNavigationButton instance = null;

    private BoardNavigationButton () {
        super();
        this.setText("Board");
        this.setOnMouseClicked(e -> this.action());

    }

    public static BoardNavigationButton getInstance() {
        if (instance == null) instance = new BoardNavigationButton();
        return instance;
    }

    @Override
    public void action() {
        System.out.println("board");
    }
}
