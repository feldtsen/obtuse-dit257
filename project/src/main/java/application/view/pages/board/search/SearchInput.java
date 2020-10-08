package application.view.pages.board.search;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SearchInput extends TextField {
        TagDropdown tagDropdown;

        public SearchInput(TagDropdown tagDropdown){
                this.tagDropdown = tagDropdown;

                this.getStyleClass().add("tagSearcher");
                this.getStyleClass().add("searchField");

                this.setOnKeyTyped(this::keyTyped);
        }

        private void keyTyped(KeyEvent keyEvent){
                String character = keyEvent.getCharacter();

                if(character.matches("[A-Za-z\b ]")) tagDropdown.filter(this.getText());
                if(character.matches("\r")) System.out.println("enter");
        }

}
