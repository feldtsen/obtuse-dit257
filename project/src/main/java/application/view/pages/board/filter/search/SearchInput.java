package application.view.pages.board.filter.search;

import application.controller.BoardController;
import application.model.board.Filter;
import application.model.board.IFilter;
import application.view.pages.board.filter.categories.CategoryButtonContainer;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Set;


public class SearchInput extends TextField {
        TagDropdown tagDropdown;

        public SearchInput(TagDropdown tagDropdown){
                this.tagDropdown = tagDropdown;

                this.setOnKeyReleased(this::keyTyped);
        }

        private void keyTyped(KeyEvent keyEvent) {
                KeyCode keyCode = keyEvent.getCode();

                if(this.getText() == null || keyCode.equals(KeyCode.ESCAPE) || keyCode.equals(KeyCode.UP) || keyCode.equals(KeyCode.DOWN)) {
                        tagDropdown.hide();
                        return;
                }

                if(this.getText().equals("")) {
                        BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of()));
                        return;
                }

                if (keyCode.equals(KeyCode.ENTER)){
                        tagDropdown.hide();
                        IFilter f1 = new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), Set.of(this.getText()));
                        BoardController.setFilter(new Filter(CategoryButtonContainer.getCurrentlySelectedCategoryTag(), f1.getTags()));
                        return;
                }

                tagDropdown.show();
                // Hitting escape results in getText() returning null
                tagDropdown.filter(this.getText());

        }

}
