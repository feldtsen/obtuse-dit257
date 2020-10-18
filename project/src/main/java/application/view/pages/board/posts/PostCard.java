package application.view.pages.board.posts;

import application.controller.PostController;
import application.model.client.Client;
import application.model.posts.IPost;
import application.model.users.IUser;
import application.view.pages.util.TagDisplay;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
            Image image = new Image(new File(path).toURI().toString());
            //imageView = new ImageView(image);
            //imageView.fitWidthProperty().bind(this.widthProperty());
            imageView.setImage(image);
            imageView.setFitWidth(300);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setCache(true);

            Rectangle clip = new Rectangle(imageView.getFitWidth(), 1000);
            clip.setArcWidth(10);
            clip.setArcHeight(10);

            imageView.setClip(clip);

            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);

            WritableImage writableImage = imageView.snapshot(parameters, null);
            imageView.setClip(null);
            imageView.setImage(writableImage);

        }

        VBox childrenWithPadding = new VBox();
        Region spaceBetween = new Region();
        VBox.setVgrow(spaceBetween, Priority.ALWAYS);
        VBox.setVgrow(childrenWithPadding, Priority.ALWAYS);

        childrenWithPadding.getChildren().setAll(
                postTypeLabel,
                tagDisplay,
                titleLabel,
                descriptionContainer,
                spaceBetween,
                phoneNumberLabel,
                nameAndAddressLabel,
                new ButtonContainer(buttons)
        );
        childrenWithPadding.getStyleClass().add("padding");
        childrenWithPadding.getStyleClass().add("spacing");
        //Id used for styling and reference
        this.getStyleClass().add("cardBackground");

        //Adds the GUI components to the post
        this.getChildren().setAll(
                imageView,
                childrenWithPadding

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

