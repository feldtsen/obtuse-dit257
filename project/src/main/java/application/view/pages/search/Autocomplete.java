package application.view.pages.search;

import java.util.stream.Stream;

import application.view.pages.board.posts.TagDropdown;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Window;

public class Autocomplete {

    private final TagDropdown tagDropdown = TagDropdown.getInstance();
    String filter = "";
    private final ObservableList<String> originalItems = TagDropdown.getInstance().getItems();

    public Autocomplete() {
        tagDropdown.setTooltip(new Tooltip());
        tagDropdown.setOnKeyPressed(this::handleOnKeyPressed);
        tagDropdown.setOnHidden(this::handleOnHiding);
    }

    public void handleOnKeyPressed(KeyEvent e) {
        ObservableList<String> filteredList = FXCollections.observableArrayList();
        KeyCode code = e.getCode();

        if (code.isLetterKey()) {
            filter += e.getText();
        }
        if (code == KeyCode.BACK_SPACE && filter.length() > 0) {
            filter = filter.substring(0, filter.length() - 1);
            tagDropdown.getItems().setAll(originalItems);
        }
        if (code == KeyCode.ESCAPE) {
            filter = "";
        }
        if (filter.length() == 0) {
            filteredList = originalItems;
            tagDropdown.getTooltip().hide();
        } else {
            Stream<String> items = tagDropdown.getItems().stream();
            String txtUsr = filter.toLowerCase();
            items.filter(el -> el.toLowerCase().contains(txtUsr)).forEach(filteredList::add);
            tagDropdown.getTooltip().setText(txtUsr);
            Window stage = tagDropdown.getScene().getWindow();
            double posX = stage.getX() + tagDropdown.getBoundsInParent().getMinX();
            double posY = stage.getY() + tagDropdown.getBoundsInParent().getMinY();
            tagDropdown.getTooltip().show(stage, posX, posY);
            tagDropdown.show();
        }
        tagDropdown.getItems().setAll(filteredList);
    }

    public void handleOnHiding(Event e) {
        filter = "";
        tagDropdown.getTooltip().hide();
        String s = tagDropdown.getSelectionModel().getSelectedItem();
        tagDropdown.getItems().setAll(originalItems);
        tagDropdown.getSelectionModel().select(s);
    }

}