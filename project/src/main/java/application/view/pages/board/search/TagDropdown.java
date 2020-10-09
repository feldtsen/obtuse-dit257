package application.view.pages.board.search;

import application.model.client.Client;
import application.model.util.TagParser;
import application.view.pages.board.search.SearchInput;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.ArrayList;


public class TagDropdown extends ComboBox<String> {
    private final static TagParser tagParser = Client.getInstance().getTagParser();
    private final SearchInput searchInput = new SearchInput(this);
    private final int ROW_COUNT = 11;


    public TagDropdown(){
        super(FXCollections.observableArrayList(tagParser.getAllTags()));
        this.setOnHiding(e -> action(searchInput));


        this.getStyleClass().add("tagDropdown");
    }

    private void action (SearchInput searchInput) {
        searchInput.setText(this.getSelectionModel().getSelectedItem());

    }

    public SearchInput getSearchInputField () {
        return this.searchInput;
    }

    public void updateVisibleRowCount (int nr) {
        this.setVisibleRowCount(nr);
    }

    public void filter(String input) {
        ArrayList<String> filteredTags = new ArrayList<>();

        // Make the dropdown visible

        if (input.equals("")) {
            this.getItems().setAll(tagParser.getAllTags());
            this.show();
            this.updateVisibleRowCount(ROW_COUNT);
            return;
        }
        // If some element in the original list of tags contains the input text, add it to the filtered list
        tagParser.getAllTags().stream().filter(
                tag -> tag.toLowerCase().contains(input.toLowerCase())
        ).forEach(
                filteredTags::add
        );

        // Replace the existing items in the combobox, if there is no items we retrieve the original list
        this.getItems().setAll(filteredTags);
        this.show();
    }
}
