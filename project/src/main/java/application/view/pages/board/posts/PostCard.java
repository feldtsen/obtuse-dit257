package application.view.pages.board.posts;

import application.controller.PostController;
import application.model.client.Client;
import application.model.posts.IPost;
import application.model.users.IUser;
import application.view.pages.util.TagDisplay;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PostCard extends VBox {



    public PostCard ( IPost post )
    {
        Label postTypeLabel;
        Label titleLabel;
        Label nameAndAddressLabel;
        Label phoneNumberLabel;
        Text descriptionText;
        TextFlow descriptionContainer;
        Button editButton;
        Button deleteButton;
        ImageView imageView;
        List<Button> buttons;
        TagDisplay tagDisplay;

        //The author of the current post
        IUser author = post.getAuthor();

        //Creates the GUI elements
        postTypeLabel          = new Label(post.getType());
        titleLabel             = new Label(post.getTitle());
        nameAndAddressLabel    = new Label(author.getName() + ", " + author.getAddress());
        phoneNumberLabel       = new Label("Contact " + author.getPhoneNumber().getNumber());
        descriptionText        = new Text(post.getDescription());
        descriptionContainer   = new TextFlow(descriptionText);
        editButton             = new Button("Edit");
        deleteButton           = new Button("Delete");

        // Create and initialize container for tags
        tagDisplay = new TagDisplay(post.getTags());

        //List of buttons to be wrapped in a HBox
        buttons = new ArrayList<>();

        //Id used for styling and reference
        this.getStyleClass().add("cardBackground");
        this.getStyleClass().add("spacing");
        this.getStyleClass().add("padding");


        descriptionText.getStyleClass().add("description");

        deleteButton.getStyleClass().add("deleteButton");

        //Connect button clicks with a controller
        editButton.setOnMouseClicked(e-> PostController.editPost(post.getUniqueID()));
        deleteButton.setOnMouseClicked(e-> PostController.deletePost(post.getUniqueID()));

        // No options if no user is logged in
        if(Client.getInstance().getUser() != null) {
            //Only the post author should be able to edit the post, and authors should not be able to claim their own post
            String currentUserPhoneNumber = Client.getInstance().getUser().getPhoneNumber().getNumber();
            if (currentUserPhoneNumber.equals(author.getPhoneNumber().getNumber())) {
                buttons.add(editButton);
                buttons.add(deleteButton);
            }
        }

        // Load image
        imageView = new ImageView();
        if(post.getImagePath() != null) {
            String path = post.getImagePath();
            System.out.println(path);
            Image image = new Image(new File(path).toURI().toString());
            //imageView = new ImageView(image);
            imageView.setImage(image);
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);
        }

        //Adds the GUI components to the post
        this.getChildren().setAll(
                postTypeLabel,
                titleLabel,
                imageView,
                descriptionContainer,
                phoneNumberLabel,
                tagDisplay,
                nameAndAddressLabel,
                new ButtonContainer(buttons)
        );

    }

    public PostCard ()
    {
        //this.setVisible(false);
        this.getChildren().setAll(
              new TagDisplay(Set.of())
        );
    }


}

