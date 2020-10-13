package application.view.pages.board.filter.search;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SearchInput extends TextField {
        TagDropdown tagDropdown;

        public SearchInput(TagDropdown tagDropdown){
                this.tagDropdown = tagDropdown;

                this.getStyleClass().add("tagSearcher");
                this.getStyleClass().add("searchField");

                this.setOnKeyReleased(this::keyTyped);
        }

        private void keyTyped(KeyEvent keyEvent){
                    // Hitting escape results in getText() returning null
                if (this.getText() != null) {
                        tagDropdown.filter(this.getText());
                        tagDropdown.show();
                }
        }

}
