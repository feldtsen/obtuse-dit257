package application.view.pages.search;

import application.view.pages.board.posts.TagDropdown;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SearchInput extends TextField {
        public SearchInput(){
                this.setId("searchLabel");
                HBox.setHgrow(this, Priority.ALWAYS);
                this.setOnKeyTyped(e -> this.keyTyped(e));
        }

        private void keyTyped(KeyEvent keyEvent){
                System.out.println(keyEvent.getCharacter());
                TagDropdown.getInstance().show();

        }

}
