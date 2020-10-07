package application.view.pages.board.posts;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class TagDropdown extends ComboBox<String> {

    ObservableList<String> tags;

    private static TagDropdown instance = null;

    private TagDropdown(){
        super();
    }

    public static TagDropdown getInstance(){
        if (instance == null) instance = new TagDropdown();
        return instance;
    }

    private ObservableList<String> initTagList(){
        return null;
    }

}
