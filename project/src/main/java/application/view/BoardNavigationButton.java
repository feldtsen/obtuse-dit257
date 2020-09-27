package application.view;


public class BoardNavigationButton extends NavigationButton {
    private static BoardNavigationButton instance = null;

    private BoardNavigationButton () {
        super();
        this.setText("Board");
        this.setOnMouseClicked(e -> this.apply());

    }

    public static BoardNavigationButton getInstance() {
        if (instance == null) instance = new BoardNavigationButton();
        return instance;
    }

    @Override
    public void apply() {
        System.out.println("board");
    }
}
