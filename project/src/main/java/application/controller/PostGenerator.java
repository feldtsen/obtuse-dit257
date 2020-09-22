package application.controller;
import application.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class PostGenerator {
    final VBox container;
    VBox post;
    final static String buttonCssPath = App.class.getResource("/styles/button.css").toString();
    final static String labelCssPath = App.class.getResource("/styles/label.css").toString();
    final static String textFlowCssPath = App.class.getResource("/styles/text-flow.css").toString();

    final static int MAX_WIDTH = 800;

    public PostGenerator(VBox container) {
        // The board where the posts will show up
        this.container = container;
        //clears the container
        container.getChildren().setAll();
    }

    public void createDonation (String title, String description) {
        createPost(title, description);
    }

    public void createRequest (String title) {
    }

    private void createPost (String title, String description) {
        createPostContainer();
        addChild(titleLabel(title));
        addChild(descriptionTextFlow(description));
        addChild(claimButton());
    }

    private void createPostContainer () {
        post = new VBox();
        post.setId("post");
        post.setAlignment(Pos.TOP_CENTER);
        post.setMaxWidth(MAX_WIDTH);
        VBox.setMargin(post, new Insets(20, 0, 0, 0));
        container.getChildren().add(post);
    }

    private Label titleLabel (String text) {
        Label title = new Label(text);
        title.setId("title");
        title.getStylesheets().add(labelCssPath);
        title.setPrefWidth(MAX_WIDTH);
        return title;
    }

    private TextFlow descriptionTextFlow (String text) {
        TextFlow textContainer = new TextFlow();
        Text description = new Text(text);

        textContainer.setId("text-area");
        description.setId("text");

        textContainer.getStylesheets().add(textFlowCssPath);

        textContainer.getChildren().add(description);

        return textContainer;
    }

    private Button claimButton () {
        Button claim= new Button("Claim");
        claim.getStylesheets().add(buttonCssPath);
        claim.setPrefWidth(5000);
        claim.setOnMouseClicked((this::claimClicked));
        return claim;
    }

    private void claimClicked(MouseEvent e) {
        ((Button) e.getSource()).setStyle("-fx-background-color: green");
        System.out.println("clicked");
    }

    private void addChild (Node node) {
        post.getChildren().add(node);
    }

}

