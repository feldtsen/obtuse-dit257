package application.view.pages.board.filter.search;

import application.model.client.Client;
import application.model.client.TagParser;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;


public class TagDropdown extends ComboBox<String> {
    private final static TagParser tagParser = Client.getInstance().getTagParser();
    private final SearchInput searchInput = new SearchInput(this);


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

    public void filter(String input) {

        if (input.equals("")) {
            this.getItems().setAll(tagParser.getAllTags());
            return;
        }
        // Make the dropdown visible
        ArrayList<String> filteredTags = new ArrayList<>();

        // If some element in the original list of tags contains the input text, add it to the filtered list
        tagParser.getAllTags().stream().filter(
                tag -> tag.toLowerCase().contains(input.toLowerCase())
        ).forEach(
                filteredTags::add
        );

        // Replace the existing items in the combobox, if there is no items we retrieve the original list
        this.getItems().setAll(filteredTags);
    }
}
