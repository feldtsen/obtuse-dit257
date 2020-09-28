package application.view.pages.posts;

import application.model.posts.IPost;
import application.view.pages.BoardPage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class PostCard {
    private final static BoardPage boardPage = BoardPage.getInstance();
    VBox post;

    public PostCard() {
    }

    public void createDonation (IPost post) {
        createPost(post);
    }

    public void createRequest (String title) {
    }

    private void createPost (IPost post) {
        createPostContainer();

        addChild(label(post.getTitle()));
        addChild(descriptionTextFlow(post.getDescription()));
        addChild(label(post.getAuthor().getName()));
        addChild(label(post.getAuthor().getPhoneNumber().toString()));
        addChild(label(post.getAuthor().getAddress()));
        addChild(claimButton());
    }

    private void createPostContainer () {
        post = new VBox();
        boardPage.getChildren().add(post);
    }

    private Label label(String text) {
        return new Label(text);
    }


    private TextFlow descriptionTextFlow (String text) {
        TextFlow textContainer = new TextFlow();
        Text description = new Text(text);

        textContainer.getChildren().add(description);

        return textContainer;
    }

    private Button claimButton () {
        return new Button("Claim");
    }

    private void addChild (Node node) {
        post.getChildren().add(node);
    }

}

