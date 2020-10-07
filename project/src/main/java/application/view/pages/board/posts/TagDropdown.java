package application.view.pages.board.posts;

import application.model.client.Client;
import application.model.util.TagParser;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;


public class TagDropdown extends ComboBox<String> {


    private static TagDropdown instance = null;

    private TagDropdown(){
        super(setTags());
    }

    public static TagDropdown getInstance(){
        if (instance == null) instance = new TagDropdown();
        return instance;
    }

    private static ObservableList<String> setTags()  {

        TagParser tagParser = Client.getInstance().getTagParser();
        ObservableList<String> tags = FXCollections.observableArrayList(tagParser.getAllTags()).sorted();


        for (String tag : tags){
            System.out.println(tag);
        }

        return tags;
    }
}
