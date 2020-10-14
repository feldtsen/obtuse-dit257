package application.view.pages.board.filter.search;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class SearchInput extends TextField {
        TagDropdown tagDropdown;

        public SearchInput(TagDropdown tagDropdown){
                this.tagDropdown = tagDropdown;

                this.getStyleClass().add("tagSearcher");
                this.getStyleClass().add("searchField");

                this.setOnKeyReleased(this::keyTyped);
        }

        private void keyTyped(KeyEvent keyEvent) {
                KeyCode keyCode = keyEvent.getCode();

                if (keyCode.equals(KeyCode.ENTER) || keyCode.equals(KeyCode.ESCAPE)) {
                        tagDropdown.hide();
                } else {
                        tagDropdown.show();
                }

                if(this.getText() == null || keyCode.equals(KeyCode.ESCAPE) || keyCode.equals(KeyCode.UP) || keyCode.equals(KeyCode.DOWN)) {
                        return;
                }

                // Hitting escape results in getText() returning null
                tagDropdown.filter(this.getText());

        }

}
