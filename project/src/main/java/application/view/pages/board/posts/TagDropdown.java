package application.view.pages.board.posts;

import application.App;
import application.ResourceLoader;
import application.controller.ClientController;
import application.model.client.Client;
import application.model.tags.Tag;
import application.model.util.TagParser;
import javafx.beans.Observable;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.Set;

public class TagDropdown extends ComboBox<String> {


    private static TagDropdown instance = null;

    private TagDropdown(){
        super();
    }

    public static TagDropdown getInstance(){
        if (instance == null) instance = new TagDropdown();
        return instance;
    }

    public ObservableList<String> setTags() throws IOException {

        TagParser tagParser = Client.getInstance().getTagParser();
        //ObservableList<String> tags = new SimpleListProperty<>();
        //tags.setAll(tagParser.getAllTags());

        for (String tag : Client.getInstance().getTagParser().getAllTags()){
            System.out.println(tag);
        }

        return null;
    }
}
