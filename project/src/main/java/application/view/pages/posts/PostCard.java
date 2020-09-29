package application.view.pages.posts;

import application.controller.BoardController;
import application.controller.PostController;
import application.model.posts.IPost;
import application.view.ResourceLoader;
import application.view.pages.BoardPage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PostCard extends VBox {
    private final static BoardPage boardPage = BoardPage.getInstance();

    public PostCard() {
       VBox.setMargin(this, ResourceLoader.margin);
    }

    public void createDonation (IPost post) {
        createPost(post);
    }

    public void createRequest (String title) {
    }

    private void createPost (IPost post) {
        createPostContainer();

        addChild(title(post.getTitle()));
        addChild(text(post.getDescription()));
        addChild(label(
                post.getAuthor().getName() + ", " + post.getAuthor().getAddress()
                ));
        addChild(label(
                post.getAuthor().getPhoneNumber().toString()
        ));
        addChild(claimButton());
        addChild(editButton());
        addChild(idField(post.getUUID()));
    }

    private void createPostContainer () {
        this.setId("postCard");
        boardPage.getChildren().add(this);
    }

    private Label label(String text) {
        return new Label(text);
    }

    private Label title(String title) {
       Label titleLabel = label(title);
       titleLabel.setId("title");
       return titleLabel;
    }

    private Text text(String description) {
        Text text = new Text(description);
        text.setId("description");

        return text;
    }

    private Button claimButton () {
        Button claimButton = new Button("Claim");
        claimButton.setId("claimButton");
        claimButton.setOnMouseClicked(this::onClickClaim);
        return claimButton;
    }

    private Button editButton() {
        Button editButton = new Button("Edit");
        editButton.setId("editButton");
        editButton.setOnMouseClicked(this::onClickEdit);
        return editButton;
    }

    private void onClickClaim(MouseEvent e){
        BoardController.claimButtonHandler(e);
    }

    private void onClickEdit(MouseEvent e){
        PostController.editPost(e);
    }

    private void addChild (Node node) {
        this.getChildren().add(node);
    }

    private Text idField(String id) {
        Text hiddenIdField = new Text(id);
        hiddenIdField.setId("id");
        hiddenIdField.setVisible(false);
        return hiddenIdField;
    }

}

