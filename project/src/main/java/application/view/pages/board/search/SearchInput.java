package application.view.pages.board.search;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SearchInput extends TextField {
        TagDropdown tagDropdown;

        public SearchInput(TagDropdown tagDropdown){
                this.tagDropdown = tagDropdown;

                this.getStyleClass().add("tagSearcher");
                this.getStyleClass().add("searchField");

                this.setOnKeyPressed(this::keyTyped);
        }

        private void keyTyped(KeyEvent keyEvent){
                String character = keyEvent.getText();

                System.out.println(keyEvent);
                if(character.matches("[A-Za-z\b ]") || keyEvent.getCode() == KeyCode.DELETE) tagDropdown.filter(this.getText());
                if(character.matches("\r")) {
                        System.out.println("enter");
                }


        }

}
